package ws.music.gallery.system.repository;

import org.apache.jena.ontology.Individual;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;

import java.util.List;

public interface StoreOntologyRepository {

    public List<Individual> getAllStores();

    public List<Individual> getAllStoresOrderByName();

    public List<Resource> getAllStoresByBusinessType(Property type);
}
