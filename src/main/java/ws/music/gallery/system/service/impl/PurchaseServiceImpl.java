package ws.music.gallery.system.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ws.music.gallery.system.domain.Product;
import ws.music.gallery.system.domain.User;
import ws.music.gallery.system.domain.UserPurchase;
import ws.music.gallery.system.domain.dto.ProductDTO;
import ws.music.gallery.system.enums.Gender;
import ws.music.gallery.system.exception.UserNotFoundException;
import ws.music.gallery.system.repository.ProductRepository;
import ws.music.gallery.system.repository.UserPurchaseRepository;
import ws.music.gallery.system.repository.UserRepository;
import ws.music.gallery.system.service.PurchaseService;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserPurchaseRepository userPurchaseRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void performPurchase(List<ProductDTO> purchasedProducts, String cpf, Gender gender, int age)
            throws UserNotFoundException {

        System.out.println(userRepository.findByCpfUser(cpf).isPresent());
        if (!userRepository.findByCpfUser(cpf).isPresent()) {
            userRepository.save(getUser(cpf, gender, age));
        }
        User user = userRepository.findByCpfUser(cpf).get();

        System.out.println(user);
        purchasedProducts.forEach(productDTO -> this.buyProductAndChangeQtd(productDTO, user));
    }

    private User getUser(String cpf, Gender gender, int age) {
        int newAge = Objects.nonNull(age) ? age : 0;
        return User.builder()
                .cpfUser(cpf)
                .age(newAge)
                .gender(gender)
                .build();
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

    private void buyProductAndChangeQtd(ProductDTO productDTO, User user) {
        this.persistPurchase(productDTO, user);
        Product product = productRepository.findByProductURI(productDTO.getURI()).get();
        product.setAvailableQuantity(productDTO.getAvailableQuantity());
        productRepository.save(product);
    }
}
