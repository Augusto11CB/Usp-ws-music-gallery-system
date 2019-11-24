package ws.music.gallery.system.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ws.music.gallery.system.domain.User;
import ws.music.gallery.system.domain.UserPurchase;
import ws.music.gallery.system.enums.TypeProductAndBusiness;

import java.util.List;

@Repository
public interface UserPurchaseRepository extends CrudRepository<UserPurchase, Long> {

    List<UserPurchase> findByProductNameLike(String name);

    List<UserPurchase> findByProductType(TypeProductAndBusiness typeProduct, Pageable pageable);

    List<UserPurchase> findByUser(User user);

    @Query(value = "SELECT up FROM UserPurchase up WHERE up.user = ?1 ORDER BY up.purchaseDate")
    List<UserPurchase> findTypesForRecommendation(@Param("user") User user);


}
