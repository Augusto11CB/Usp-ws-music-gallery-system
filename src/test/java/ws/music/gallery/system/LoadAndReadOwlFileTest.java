package ws.music.gallery.system;

import com.google.gson.Gson;
import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.*;
import org.apache.jena.util.iterator.ExtendedIterator;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Iterator;

@SpringBootTest
public class LoadAndReadOwlFileTest {

    private static final Logger LOGGER = Logger.getLogger(LoadAndReadOwlFileTest.class);

    @Value("${music.gallery.uri}")
    private String MUSIC_GALLERY_URI;

    Gson gson;

    private OntModel ontoModel;

    private Property typeBusiness;
    private Property boughtByUser;
    private Resource store;
    private Resource product;
    private Resource augustoUser;
    private Literal cpf;


    @BeforeEach
    public void init() {
        gson = new Gson();
        ontoModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, null);

        typeBusiness = ontoModel.createProperty(MUSIC_GALLERY_URI + "typeBusiness");
        boughtByUser = ontoModel.createProperty(MUSIC_GALLERY_URI + "boughtByUser");

        store = ontoModel.createResource(MUSIC_GALLERY_URI + "Store");
        product = ontoModel.createResource(MUSIC_GALLERY_URI + "Product");
        augustoUser = ontoModel.createResource(MUSIC_GALLERY_URI + "Augusto");
    }

    @Test
    void readingOwlFile() throws FileNotFoundException {
        File file = new File("src/main/resources/OntologyRepository/MusicGallery.owl");
        InputStream in = new FileInputStream(file);
        ontoModel.read(in, null);
        getAllResourceOf(store);
    }

    private void getAllProducts(OntModel ontoModel) {

    }


    private void getAllResourceOf(Resource resource) {
        ExtendedIterator<Individual> iterator = ontoModel.listIndividuals(resource);
        iterator.forEachRemaining(statement -> System.out.println(statement));

        while (iterator.hasNext()) {
            Individual Individual = iterator.next();
            System.out.println(Individual);
        }
    }

    private void getAllItensBought() {
        Iterator<Statement> iterator = ontoModel.listStatements(null, boughtByUser, (Resource) null);
        iterator.forEachRemaining(statement -> System.out.println(statement));

        while (iterator.hasNext()) {
            Statement statement = iterator.next();
            System.out.println(statement);
        }
    }

    private void getAllItensBoughtByUser(Resource user) {
        Iterator<Statement> iterator = ontoModel.listStatements(null, boughtByUser, user);
        iterator.forEachRemaining(statement -> System.out.println(statement));

        while (iterator.hasNext()) {
            Statement statement = iterator.next();
            System.out.println(statement);
        }
    }

    private void iterateThrough(OntModel ontoModel) {


        Iterator<Resource> iterator = ontoModel.listSubjects();
        while (iterator.hasNext()) {

            Resource resource = iterator.next();
            LOGGER.info("Resource: " + resource);
            System.out.println(resource);

            Iterator<Statement> iteratorResource = resource.listProperties();
            while (iteratorResource.hasNext()) {
                Statement statement = iteratorResource.next();
                LOGGER.info("Statement: " + statement.getResource().toString());

                System.out.println(statement);


            }
        }
    }

}
