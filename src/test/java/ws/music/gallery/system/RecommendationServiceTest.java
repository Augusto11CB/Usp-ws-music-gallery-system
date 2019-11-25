package ws.music.gallery.system;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ws.music.gallery.system.domain.User;
import ws.music.gallery.system.domain.UserPurchase;
import ws.music.gallery.system.enums.Gender;
import ws.music.gallery.system.enums.TypeProductAndBusiness;
import ws.music.gallery.system.repository.UserPurchaseRepository;
import ws.music.gallery.system.repository.UserRepository;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;


@SpringBootTest
public class RecommendationServiceTest {

    private static final Logger LOGGER = Logger.getLogger(RecommendationServiceTest.class);

    @Autowired
    UserPurchaseRepository userPurchaseRepository;

    @Autowired
    UserRepository userRepository;

    private User user;

<<<<<<< HEAD
    @Before
=======
    @BeforeEach
>>>>>>> 683327632fe494c72a299e14a54ad2fd9ae29f33
    void init() {
        this.user = User.builder()
                .cpfUser("42745689323")
                .age(23)
                .gender(Gender.MALE)
                .password("123456")
                .build();
        this.user = userRepository.save(this.user);

        createUserPurchase(this.user).forEach(purchase -> userPurchaseRepository.save(purchase));
    }

    @Test
    void findByUserDistinctByProductTypeAndOrderByPurchaseDateTest() {

        userPurchaseRepository.findAll().iterator().forEachRemaining(System.out::println);

        List<UserPurchase> userPurchase = userPurchaseRepository.findByUser(this.user);

        userPurchase.forEach(System.out::println);

        List<UserPurchase> purchasesToUseInRecommendation = userPurchaseRepository.findTypesForRecommendation(this.user);

        purchasesToUseInRecommendation.forEach(System.out::println);
    }

    private List<UserPurchase> createUserPurchase(User user) {

        List<UserPurchase> purchases = Collections.emptyList();

        UserPurchase purchaseOne = UserPurchase.builder()
                .purchaseDate(LocalDate.now())
                .productType(TypeProductAndBusiness.CLOTHING)
                .productName("Camiseta")
                .productURI("URI")
                .user(user)
                .build();

        purchases.add(purchaseOne);

        UserPurchase purchaseTwo = UserPurchase.builder()
                .purchaseDate(LocalDate.now())
                .productType(TypeProductAndBusiness.MUSICAL_EQUIPMENT)
                .productName("Guitar")
                .productURI("URI")
                .user(user)
                .build();

        purchases.add(purchaseTwo);

        UserPurchase purchaseTree = UserPurchase.builder()
                .purchaseDate(LocalDate.now())
                .productType(TypeProductAndBusiness.MUSICAL_EQUIPMENT)
                .productName("Guitar")
                .productURI("URI")
                .user(user)
                .build();

        purchases.add(purchaseTree);

        return purchases;
    }

}
