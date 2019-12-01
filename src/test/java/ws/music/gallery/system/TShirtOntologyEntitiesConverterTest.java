package ws.music.gallery.system;

import com.google.gson.Gson;
import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.rdf.model.impl.PropertyImpl;
import org.apache.jena.rdf.model.impl.ResourceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import ws.music.gallery.system.converter.TShirtOntologyEntitiesConverter;

@SpringBootTest
public class TShirtOntologyEntitiesConverterTest {


    @Value("${music.gallery.uri}")
    private String MUSIC_GALLERY_URI;

    @Autowired
    private OntModel musicGalleryOntologyModel;

    @Autowired
    private TShirtOntologyEntitiesConverter tShirtOntologyEntitiesConverter;


    private Gson gson;
    private Property nameResource;
    private Resource product;
    private Resource clothing;
    private Property name;
    private Property price;
    private Property brand;
    private Property typeIs;
    private Property soldByStore;
    private Property size;
    private Property mainColor;
    private Property typeOfFiber;
    private Property designatedGender;

    @Before
    public void init() {

        name = new PropertyImpl(MUSIC_GALLERY_URI + "name");
        price = new PropertyImpl(MUSIC_GALLERY_URI + "price");
        brand = new PropertyImpl(MUSIC_GALLERY_URI + "brand");
        typeIs = new PropertyImpl(MUSIC_GALLERY_URI + "typeIs");
        soldByStore = new PropertyImpl(MUSIC_GALLERY_URI + "soldByStore");
        size = new PropertyImpl(MUSIC_GALLERY_URI + "size");
        mainColor = new PropertyImpl(MUSIC_GALLERY_URI + "mainColor");
        typeOfFiber = new PropertyImpl(MUSIC_GALLERY_URI + "typeOfFiber");
        gson = new Gson();
        designatedGender = new PropertyImpl(MUSIC_GALLERY_URI + "designatedGender");//musicGalleryOntologyModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, null);
        product = new ResourceImpl(MUSIC_GALLERY_URI + "Product");
        clothing = new ResourceImpl(MUSIC_GALLERY_URI + "Clothing");
        nameResource = new PropertyImpl(MUSIC_GALLERY_URI + "name");


    }

    @Test
    public void testTshirtConverterIndividualToProductDTO() {
        Individual indv = musicGalleryOntologyModel.getIndividual(MUSIC_GALLERY_URI + "ComfortableTShirt");
        System.out.println(tShirtOntologyEntitiesConverter.individualToProductDTO(indv));
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
