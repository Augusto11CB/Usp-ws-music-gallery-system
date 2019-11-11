package ws.music.gallery.system.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ws.music.gallery.system.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
}
