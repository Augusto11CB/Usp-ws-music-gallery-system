package ws.music.gallery.system.repository.impl;

import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import ws.music.gallery.system.repository.ProductOntologyRepository;

import java.util.Iterator;
import java.util.List;

@Repository
public class ProductOntologyRepositoryImpl implements ProductOntologyRepository {

    @Value("${music.gallery.uri}")
    private String MUSIC_GALLERY_URI;

    private OntModel musicGalleryOntologyModel;

    private MusicGalleryOntologyRepositoryImpl musicGalleryOntologyRepository;

    private final Resource productResourceDef;

    private final Property typeIsProp;

    private final Property soldByStoreProp;

    public ProductOntologyRepositoryImpl(OntModel musicGalleryOntologyModel) {

        this.musicGalleryOntologyModel = musicGalleryOntologyModel;
        this.productResourceDef = musicGalleryOntologyModel.createResource(MUSIC_GALLERY_URI + "Product");
        this.typeIsProp = musicGalleryOntologyModel.createProperty(MUSIC_GALLERY_URI + "typeIs");
        this.soldByStoreProp = musicGalleryOntologyModel.createProperty(MUSIC_GALLERY_URI + "soldByStore");
    }

    @Override
    public List<Individual> getAllProducts() {

        return musicGalleryOntologyRepository.getAllResources(productResourceDef);
    }

    @Override
    public List<Resource> getAllProductsByType(Resource typeOfProduct) {
        return musicGalleryOntologyRepository.getAllResourcesByProperty(typeIsProp,typeOfProduct);
    }

    @Override
    public List<Resource> getAllProductsOfStore(Resource store) {
        return musicGalleryOntologyRepository.getAllResourcesByProperty(soldByStoreProp,store);
    }

    /*
    private <T> void printIteratorItens(Iterator<T> ite) {
        while (ite.hasNext()) {
            System.out.println(ite.next());
        }
    }
    */
}
