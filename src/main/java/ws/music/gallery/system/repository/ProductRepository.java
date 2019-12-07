package ws.music.gallery.system.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ws.music.gallery.system.domain.Product;

import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    Optional<Product> findByProductURI(String productURI);


}
