package ws.music.gallery.system.repository.ontologyrepo.impl;

import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.ResIterator;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.impl.ResourceImpl;
import org.apache.jena.util.iterator.ExtendedIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ws.music.gallery.system.repository.ontologyrepo.MusicGalleryOntologyRepository;
import ws.music.gallery.system.util.OntologyPropertyAndResourceUtils;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MusicGalleryOntologyRepositoryImpl implements MusicGalleryOntologyRepository {

    @Autowired
    OntModel musicGalleryOntologyModel;

    public List<Individual> getAllResources(Resource resource) {
        ArrayList<Individual> indvList = new ArrayList<>();
        ExtendedIterator<Individual> iterator;
        iterator = musicGalleryOntologyModel.listIndividuals(resource);

        iterator.forEachRemaining(individual ->
                indvList.add(individual));
        iterator.forEachRemaining(System.out::println);

        return indvList;
    }

    public List<Resource> getAllResourcesByProperty(Property property, RDFNode value) {
        ArrayList indvList = new ArrayList();

        ResIterator iterator = musicGalleryOntologyModel.listResourcesWithProperty(property, value);
        iterator.forEachRemaining(indv -> indvList.add(indv));
        return indvList;
    }
}
