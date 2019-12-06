package ws.music.gallery.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ws.music.gallery.system.domain.User;
import ws.music.gallery.system.domain.UserPurchase;
import ws.music.gallery.system.domain.dto.ProductDTO;
import ws.music.gallery.system.enums.TypeProductAndBusiness;
import ws.music.gallery.system.exception.NothingToRecommendException;
import ws.music.gallery.system.exception.UserNotFoundException;
import ws.music.gallery.system.repository.UserPurchaseRepository;
import ws.music.gallery.system.repository.UserRepository;
import ws.music.gallery.system.service.ProductService;
import ws.music.gallery.system.service.RecommendationService;

import java.util.*;
import java.util.stream.Collectors;
/*
 * Send stores that user already bought some thing
 * Send products of the same type of user's last purchase
 * Recommend products Already visited*
 * */

@Service
public class RecommendationServiceImpl implements RecommendationService {

    @Autowired
    UserPurchaseRepository userPurchaseRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductService productService;

    @Override
    public List<ProductDTO> recommendProducsSameTypeLastPurchases(String userCPF) throws NothingToRecommendException, UserNotFoundException {

        List<ProductDTO> recommendations = new ArrayList<>(Collections.emptyList());

        User user = userRepository.findByCpfUser(userCPF)
                .orElseThrow(() -> new UserNotFoundException("User was not found."));


        List<UserPurchase> userPurchases = userPurchaseRepository.findTypesForRecommendation(user)
                .orElseThrow(() -> new NothingToRecommendException("Sem recomendações"));

        userPurchases.forEach(System.out::println);
        //List<TypeProductAndBusiness> typesToLookingFor = userPurchases.stream().map(UserPurchase::getProductType).distinct().collect(Collectors.toList());
        Map<TypeProductAndBusiness, Long> recommendationsMap = userPurchases.stream()
                .map(UserPurchase::getProductType)
                .collect(Collectors.groupingBy(type -> type, Collectors.counting()));

        recommendationsMap.forEach((type, qtd) -> System.out.println(type + " " + qtd));

        HashMap<TypeProductAndBusiness, Long> sortedRecoMap = recommendationsMap
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, HashMap::new));

        sortedRecoMap.forEach((a, b) -> System.out.println("a:" + a + "  b:" + b));


        // typesToLookingFor.forEach(type -> recommendations.addAll(productService.getProductsByType(type)));
        sortedRecoMap.entrySet()
                .stream()
                .limit(4)
                .forEach(type -> recommendations.addAll(productService.getProductsByType(type.getKey())));

        recommendations.forEach(System.out::println);

        return recommendations.stream().filter(Objects::nonNull).collect(Collectors.toList());
    }

}
