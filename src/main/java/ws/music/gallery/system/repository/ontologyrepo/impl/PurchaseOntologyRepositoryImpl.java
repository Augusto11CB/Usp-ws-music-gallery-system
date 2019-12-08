package ws.music.gallery.system.repository.ontologyrepo.impl;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ws.music.gallery.system.exception.UserNotFoundException;
import ws.music.gallery.system.repository.ontologyrepo.PurchaseOntologyRepository;
import ws.music.gallery.system.util.OntologyPropertyAndResourceUtils;

@Repository
public class PurchaseOntologyRepositoryImpl implements PurchaseOntologyRepository {


    @Autowired
    OntModel musicGalleryOntologyModel;

    @Override
    public void performPurchase(String productURI, String userURI) throws UserNotFoundException {
        try {
            Resource product = musicGalleryOntologyModel.listSubjectsWithProperty(OntologyPropertyAndResourceUtils.cpf).nextResource();
            Resource user = musicGalleryOntologyModel.getResource(userURI);
            product.addProperty(OntologyPropertyAndResourceUtils.boughtByUser, user);
        } catch (Exception e) {
            throw new UserNotFoundException("User not found");
        }
    }
}
