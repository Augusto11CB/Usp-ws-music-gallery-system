package ws.music.gallery.system.repository.ontologyrepo;

import ws.music.gallery.system.domain.User;

public interface UserOntologyRepository {

    void save(String cpf);

    User findByCpfUser(String cpf);
}
