package ws.music.gallery.system.repository;

import org.apache.jena.ontology.Individual;
import org.apache.jena.rdf.model.Resource;

import java.util.List;


public interface MusicGalleryOntologyRepository {

    public List<Individual> getAllResources(Resource resource);
}
