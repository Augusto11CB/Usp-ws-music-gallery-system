package ws.music.gallery.system;

import com.google.gson.Gson;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StoreOntologyEntitiesConverterTest {

    @Value("${music.gallery.uri}")
    private String MUSIC_GALLERY_URI;

    @Autowired
    private OntModel musicGalleryOntologyModel;


    private Gson gson;
    private Property typeBusiness;
    private Literal name;
    private Resource store;
    private Resource clothing;


    @BeforeEach
    public void init() {
        gson = new Gson();
        //musicGalleryOntologyModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, null);

        typeBusiness = musicGalleryOntologyModel.createProperty(MUSIC_GALLERY_URI + "typeBusiness");
        store = musicGalleryOntologyModel.createResource(MUSIC_GALLERY_URI + "Store");

        clothing = musicGalleryOntologyModel.createResource(MUSIC_GALLERY_URI + "Clothing");
        name = musicGalleryOntologyModel.createLiteral(MUSIC_GALLERY_URI + "name");


    }

    @Test
    public void testGetStoreDTOGivenAResource() {
        Resource myStoreInstance = musicGalleryOntologyModel.createResource(MUSIC_GALLERY_URI + "PierreInstrumentosMusicais");
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

    private String getValueOfLiteral(Statement statement) {
        return null;
    }


}
