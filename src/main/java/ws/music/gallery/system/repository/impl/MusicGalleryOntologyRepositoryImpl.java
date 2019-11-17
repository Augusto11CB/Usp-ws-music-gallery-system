package ws.music.gallery.system.repository.impl;

import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.ResIterator;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.util.iterator.ExtendedIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class MusicGalleryOntologyRepositoryImpl {

    @Autowired
    OntModel musicGalleryOntologyModel = null;

    public List<Individual> getAllResources(Resource resource) {
        List<Individual> indvList = Collections.emptyList();
        ExtendedIterator<Individual> iterator;
        iterator = musicGalleryOntologyModel.listIndividuals(resource);

        iterator.forEachRemaining(individual ->
                indvList.add(individual));


        return indvList;
    }

    public List<Resource> getAllResourcesByProperty(Property property, RDFNode value) {
        List<Resource> indvList = Collections.emptyList();

        ResIterator iterator = musicGalleryOntologyModel.listResourcesWithProperty(property, value);
        iterator.forEachRemaining(indv -> indvList.add(indv));
        return indvList;
    }
}
