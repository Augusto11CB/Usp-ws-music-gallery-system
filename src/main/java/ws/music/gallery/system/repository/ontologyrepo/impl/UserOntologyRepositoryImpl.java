package ws.music.gallery.system.repository.ontologyrepo.impl;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import ws.music.gallery.system.domain.User;
import ws.music.gallery.system.exception.UserNotFoundException;
import ws.music.gallery.system.repository.ontologyrepo.UserOntologyRepository;
import ws.music.gallery.system.util.OntologyPropertyAndResourceUtils;

public class UserOntologyRepositoryImpl implements UserOntologyRepository {

    @Autowired
    private OntModel musicGalleryOntologyModel;

    @Override
    public void save(String cpf) {

        Resource user = musicGalleryOntologyModel.createResource(cpf);

        user.addProperty(OntologyPropertyAndResourceUtils.cpf, cpf);

    }

    @Override
    public User findByCpfUser(String cpf) throws UserNotFoundException {
        try {
            Resource userResource = musicGalleryOntologyModel.getResource(cpf);
            User user = new User();
            user.setCpfUser(userResource.getProperty(OntologyPropertyAndResourceUtils.cpf).getLiteral().getValue().toString());
            return user;
        } catch (Exception e) {
            throw new UserNotFoundException("User not found CPF: " + cpf);
        }
    }
}
