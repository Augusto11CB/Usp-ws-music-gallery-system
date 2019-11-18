package ws.music.gallery.system.repository.ontologyrepo;

import org.apache.jena.ontology.Individual;
import org.apache.jena.rdf.model.Resource;

import java.util.List;

public interface StoreOntologyRepository {

    Resource getStore(String storeName);

    List<Individual> getAllStores();

    List<Individual> getAllStoresOrderByName();

    List<Resource> getAllStoresByBusinessType(Resource type);
}
