package ws.music.gallery.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ws.music.gallery.system.domain.User;
import ws.music.gallery.system.domain.UserPurchase;
import ws.music.gallery.system.domain.dto.ProductDTO;
import ws.music.gallery.system.enums.TypeProductAndBusiness;
import ws.music.gallery.system.exception.UserNotFoundException;
import ws.music.gallery.system.repository.UserPurchaseRepository;
import ws.music.gallery.system.repository.UserRepository;
import ws.music.gallery.system.service.ProductService;
import ws.music.gallery.system.service.RecommendationService;

import java.util.Collections;
import java.util.List;
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
    public List<ProductDTO> recommendProducsSameTypeLastPurchases(String userCPF) {

        List<ProductDTO> recommendations = Collections.emptyList();

        User user = userRepository.findByCpfUser(userCPF)
                .orElseThrow(() -> new UserNotFoundException("User was not found."));

        Pageable pageable = PageRequest.of(0, 3);
        List<UserPurchase> userPurchases = userPurchaseRepository.findTypesForRecommendation(user, pageable);

        List<TypeProductAndBusiness> typesToLookingFor = userPurchases.stream().map(purchase -> purchase.getProductType()).collect(Collectors.toList());
        typesToLookingFor.stream().forEach(type -> recommendations.addAll(productService.getProductsByType(type)));

        return recommendations;
    }

}
