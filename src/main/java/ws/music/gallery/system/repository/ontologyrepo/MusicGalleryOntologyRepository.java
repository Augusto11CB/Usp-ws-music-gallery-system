package ws.music.gallery.system.repository.ontologyrepo;

import org.apache.jena.ontology.Individual;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;

import java.util.List;


public interface MusicGalleryOntologyRepository {

    List<Individual> getAllResources(Resource resource);

    List<Resource> getAllResourcesByProperty(Property property, RDFNode value);
}
