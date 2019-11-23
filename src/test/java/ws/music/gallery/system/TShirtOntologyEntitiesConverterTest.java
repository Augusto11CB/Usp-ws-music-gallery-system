package ws.music.gallery.system;

import com.google.gson.Gson;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.*;
import org.apache.jena.rdf.model.impl.PropertyImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TShirtOntologyEntitiesConverterTest {


    @Value("${music.gallery.uri}")
    private String MUSIC_GALLERY_URI;

    @Autowired
    private OntModel musicGalleryOntologyModel;


    private Gson gson;
    private Property typeIs;
    private Property boughtByUser;
    private Literal name;
    private Property nameResource;
    private Resource product;
    private Resource clothing;


    @BeforeEach
    public void init() {

        gson = new Gson();
        //musicGalleryOntologyModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, null);

        typeIs = musicGalleryOntologyModel.createProperty(MUSIC_GALLERY_URI + "typeIs");
        boughtByUser = musicGalleryOntologyModel.createProperty(MUSIC_GALLERY_URI + "boughtByUser");
        product = musicGalleryOntologyModel.createResource(MUSIC_GALLERY_URI + "Product");

        clothing = musicGalleryOntologyModel.createResource(MUSIC_GALLERY_URI + "Clothing");
        nameResource = musicGalleryOntologyModel.createProperty(MUSIC_GALLERY_URI + "name");


    }

    @Test
    public void testGetTShirtDTOGivenAResource() {
        Resource myStoreInstance = musicGalleryOntologyModel.createResource(MUSIC_GALLERY_URI + "ComfortableTShirt");
        StmtIterator it = myStoreInstance.listProperties();
        System.out.println(myStoreInstance);
        while (it.hasNext()) {
            Statement prop = it.next();

            if (prop.getObject().isLiteral()) {
                System.out.println("it is literal");
                System.out.println(prop.getPredicate() + " : " + prop.getLiteral().getValue());
                System.out.println(prop.getLiteral().getValue());
            } else if (prop.getObject().isResource()) {

                System.out.println("it is resource");
                System.out.println(prop.getPredicate() + " : " + prop.getResource());
                System.out.println(prop.getResource().getLocalName());//it return the string name of the property value
                System.out.println(prop.getResource().getNameSpace());
                System.out.println("0000000");
                System.out.println(prop.getPredicate().getNameSpace());
                System.out.println(prop.getPredicate().getLocalName());// it returns the string name of the property
            }
        }


    }

    @Test
    public void testGetTShirtDTOGivenAResourceV2() {
        Resource myStoreInstance = musicGalleryOntologyModel.createResource(MUSIC_GALLERY_URI + "ComfortableTShirt");
        StmtIterator it = myStoreInstance.listProperties();
        System.out.println(myStoreInstance);
        Property boughtByUser2 = new PropertyImpl(MUSIC_GALLERY_URI + "boughtByUser");
        System.out.println(boughtByUser2);


/*        System.out.println(myStoreInstance.getPropertyResourceValue(boughtByUser).getLocalName());
        System.out.println(myStoreInstance.getProperty(boughtByUser).getResource().getLocalName());
        System.out.println(myStoreInstance.getRequiredProperty(boughtByUser).getResource().getLocalName());*/


        System.out.println(myStoreInstance.getProperty(nameResource).getLiteral().getValue());
        System.out.println(myStoreInstance.getProperty(boughtByUser2).getResource().getLocalName());


    }

    @Test
    public void getTShirtResource() {
        Resource resource = musicGalleryOntologyModel.getResource(MUSIC_GALLERY_URI + "BeeGeesTshirt");

        resource.listProperties().forEachRemaining(stat -> System.out.println(stat));
        System.out.println();
    }

    private String getValueOfLiteral(Statement statement) {
        return null;
    }
}
