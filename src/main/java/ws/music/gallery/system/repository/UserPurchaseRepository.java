package ws.music.gallery.system.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ws.music.gallery.system.domain.User;
import ws.music.gallery.system.domain.UserPurchase;
import ws.music.gallery.system.enums.TypeProductAndBusiness;

import java.util.List;

@Repository
public interface UserPurchaseRepository extends CrudRepository<UserPurchase, Long> {

    List<UserPurchase> findByProductNameLike(String name);

    List<UserPurchase> findByProductType(TypeProductAndBusiness typeProduct);

    List<UserPurchase> findByUser(User user);

}
