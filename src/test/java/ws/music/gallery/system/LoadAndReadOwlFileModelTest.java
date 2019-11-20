/*
package ws.music.gallery.system;

import com.google.gson.Gson;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.ModelMaker;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.util.FileManager;
import com.hp.hpl.jena.util.PrintUtil;

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
public class LoadAndReadOwlFileModelTest {

    private static final Logger LOGGER = Logger.getLogger(LoadAndReadOwlFileModelTest.class);

    @Value("${music.gallery.uri}")
    private String MUSIC_GALLERY_URI;

    Gson gson;

    private OntModel ontoModel;
    private Model model;

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
    void testConnection(){

    }

    @Test
    void readingOwlFileOntModelVersion() throws FileNotFoundException {
        File file = new File("src/main/resources/OntologyRepository/MusicGallery.owl");
        InputStream in = new FileInputStream(file);
        ontoModel.read(in, null);
        getAllResourceOf(store);
    }


    @Test
    void readingOwlFileModelVersion() throws FileNotFoundException {
        File file = new File("src/main/resources/OntologyRepository/MusicGallery.owl");
        InputStream in = new FileInputStream(file);
        model.read(in, null);
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
*/
