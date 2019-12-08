package ws.music.gallery.system.repository.ontologyrepo.impl;

import org.apache.jena.datatypes.xsd.XSDDatatype;
import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import ws.music.gallery.system.repository.ontologyrepo.MusicGalleryOntologyRepository;
import ws.music.gallery.system.repository.ontologyrepo.ProductOntologyRepository;
import ws.music.gallery.system.util.OntologyPropertyAndResourceUtils;

import java.util.List;

@Repository
public class ProductOntologyRepositoryImpl implements ProductOntologyRepository {


    public static String MUSIC_GALLERY_URI;

    private OntModel musicGalleryOntologyModel;

    private MusicGalleryOntologyRepository musicGalleryOntologyRepository;

    private Resource productResourceDef; // = musicGalleryOntologyModel.createResource(MUSIC_GALLERY_URI + "Product");

    private Property typeIsProp; // =  musicGalleryOntologyModel.createProperty(MUSIC_GALLERY_URI + "typeIs");

    private Property soldByStoreProp; //= musicGalleryOntologyModel.createProperty(MUSIC_GALLERY_URI + "soldByStore");

    public ProductOntologyRepositoryImpl(OntModel musicGalleryOntologyModel, MusicGalleryOntologyRepository musicGalleryOntologyRepository) {
        this.musicGalleryOntologyRepository = musicGalleryOntologyRepository;
        this.musicGalleryOntologyModel = musicGalleryOntologyModel;



    }

    @Override
    public List<Individual> getAllProducts() {
        this.productResourceDef = musicGalleryOntologyModel.createResource(MUSIC_GALLERY_URI + "Product");
        return musicGalleryOntologyRepository.getAllResources(productResourceDef);
    }

    @Override
    public List<Resource> getAllProductsByType(Resource typeOfProduct) {
        this.typeIsProp = musicGalleryOntologyModel.createProperty(MUSIC_GALLERY_URI + "typeIs");

        return musicGalleryOntologyRepository.getAllResourcesByProperty(typeIsProp, typeOfProduct);
    }

    @Override
    public List<Resource> getAllProductsOfStore(Resource store) {
        this.soldByStoreProp = musicGalleryOntologyModel.createProperty(MUSIC_GALLERY_URI + "soldByStore");
        return musicGalleryOntologyRepository.getAllResourcesByProperty(soldByStoreProp, store);
    }

    @Override
    public void setStockQuantity(String URI, int quantity) {
        Resource product = musicGalleryOntologyModel.getResource(URI);
        Statement setStockQuantity = product.getProperty(OntologyPropertyAndResourceUtils.productQuantity);
        product.removeAll(OntologyPropertyAndResourceUtils.productQuantity);
        product.addProperty(OntologyPropertyAndResourceUtils.productQuantity,String.valueOf(quantity), XSDDatatype.XSDunsignedInt);
    }

    /*
    private <T> void printIteratorItens(Iterator<T> ite) {
        while (ite.hasNext()) {
            System.out.println(ite.next());
        }
    }
    */

    @Value("${music.gallery.uri}")
    public void setPrivateName(String privateName) {
        MUSIC_GALLERY_URI = privateName;
    }
}
