package ws.music.gallery.system.repository.ontologyrepo;

import org.apache.jena.ontology.Individual;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;

import java.util.List;

public interface ProductOntologyRepository {

    public List<Individual> getAllProducts();

    public List<Resource> getAllProductsByType(Resource type);

    public List<Resource> getAllProductsOfStore(Resource store);

    public void setStockQuantity(String URI, int quantity);
}
