package ws.music.gallery.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ws.music.gallery.system.domain.User;
import ws.music.gallery.system.domain.UserPurchase;
import ws.music.gallery.system.domain.dto.ProductDTO;
import ws.music.gallery.system.exception.UserNotFoundException;
import ws.music.gallery.system.repository.UserPurchaseRepository;
import ws.music.gallery.system.repository.UserRepository;
import ws.music.gallery.system.service.PurchaseService;

import java.time.LocalDate;
import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserPurchaseRepository userPurchaseRepository;


    @Override
    public void performPurchase(List<ProductDTO> purchasedProducts, String userCPF) throws UserNotFoundException {
        User user = userRepository.findByCpfUser(userCPF)
                .orElseThrow(() -> new UserNotFoundException("User did not found. Purchase was not Performed"));

        purchasedProducts.forEach(productDTO -> this.persistPurchase(productDTO, user));
    }

    private void persistPurchase(ProductDTO productDTO, User user) {

        UserPurchase purchase = UserPurchase.builder()
                .productName(productDTO.getName())
                .productType(productDTO.getTypeProductAndBusiness())
                .productURI(productDTO.getURI())
                .purchaseDate(LocalDate.now())
                .user(user)
                .build();

        userPurchaseRepository.save(purchase);
    }


}
