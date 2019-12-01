package ws.music.gallery.system;

import com.google.gson.Gson;
import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.*;
import org.apache.jena.util.iterator.ExtendedIterator;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

@SpringBootTest
public class LoadAndReadOwlFileTest {

    private static final Logger LOGGER = Logger.getLogger(LoadAndReadOwlFileTest.class);

    @Value("${music.gallery.uri}")
    private String MUSIC_GALLERY_URI;

    @Autowired
    private OntModel musicGalleryOntologyModel;


    Gson gson;

    

    private Property typeBusiness;
    private Property typeIs;
    private Property boughtByUser;
    private Resource store;
    private Resource product;
    private Resource augustoUser;
    private Resource comfortableTshirt;
    private Resource clothing;
    private Literal cpf;


    @Before
    public void init() {
        gson = new Gson();
        //musicGalleryOntologyModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, null);

        typeBusiness = musicGalleryOntologyModel.createProperty(MUSIC_GALLERY_URI + "typeBusiness");
        typeIs = musicGalleryOntologyModel.createProperty(MUSIC_GALLERY_URI + "typeIs");
        boughtByUser = musicGalleryOntologyModel.createProperty(MUSIC_GALLERY_URI + "boughtByUser");

        store = musicGalleryOntologyModel.createResource(MUSIC_GALLERY_URI + "Store");
        product = musicGalleryOntologyModel.createResource(MUSIC_GALLERY_URI + "Product");
        augustoUser = musicGalleryOntologyModel.createResource(MUSIC_GALLERY_URI + "Augusto");
        comfortableTshirt = musicGalleryOntologyModel.createResource(MUSIC_GALLERY_URI + "ElectricGuitar");
        clothing = musicGalleryOntologyModel.createResource(MUSIC_GALLERY_URI + "Clothing");
    }

    @Test
    void readingOwlFile() throws FileNotFoundException {
        File file = new File("src/main/resources/OntologyRepository/MusicGallery.owl");
        InputStream in = new FileInputStream(file);
        musicGalleryOntologyModel.read(in, null);
        getAllResourceOf(store);
    }

    @Test
    void readingOwlFileByBeanDefinition() throws FileNotFoundException {
        getProdutDTO(augustoUser);
    }


    private void getAllProductsUsingBeanOntology(Resource resource) {
        ExtendedIterator<Individual> iterator = musicGalleryOntologyModel.listIndividuals(store);
        iterator.forEachRemaining(statement -> System.out.println(statement));

        while (iterator.hasNext()) {
            Individual Individual = iterator.next();
            System.out.println(Individual);
        }
    }

    private void getAllStoresByType() {
        ResIterator iterator = musicGalleryOntologyModel.listResourcesWithProperty(typeBusiness, clothing);
        iterator.forEachRemaining(System.out::println);
    }


    private void getAllResourceOf(Resource resource) {
        ExtendedIterator<Individual> iterator = musicGalleryOntologyModel.listIndividuals(resource);
        iterator.forEachRemaining(statement -> System.out.println(statement));
        iterator.forEachRemaining(individual -> buildProduct(individual));

        while (iterator.hasNext()) {
            Individual Individual = iterator.next();
            System.out.println(Individual);
        }
    }

    private void getProdutDTO(Resource resource) {
        StmtIterator it = resource.listProperties();
        ExtendedIterator<Individual> iterator = musicGalleryOntologyModel.listIndividuals(resource);
        iterator.forEachRemaining(statement -> System.out.println(statement));
        iterator.forEachRemaining(individual -> buildProduct(individual));

        while (it.hasNext()) {
            Statement prop = it.next();
            System.out.println(prop.getPredicate());
            System.out.println(prop.getObject().isLiteral());
            System.out.println(prop.getResource().getURI());
            System.out.println(prop.getResource().getNameSpace());
        }
    }

    private void getAllItensBought() {
        Iterator<Statement> iterator = musicGalleryOntologyModel.listStatements(null, boughtByUser, (Resource) null);
        iterator.forEachRemaining(statement -> System.out.println(statement));

        while (iterator.hasNext()) {
            Statement statement = iterator.next();
            System.out.println(statement);
        }
    }

    private void getAllItensBoughtByUser(Resource user) {
        Iterator<Statement> iterator = musicGalleryOntologyModel.listStatements(null, boughtByUser, user);
        iterator.forEachRemaining(statement -> System.out.println(statement));

        while (iterator.hasNext()) {

            Statement statement = iterator.next();
            System.out.println(statement);
        }
    }

    private void buildProduct(Individual individual) {
        getPropertiesAndTypes().forEach((name, url) -> System.out.println("individual:" + individual.getLocalName()));
        individual.listProperties().forEachRemaining(ind -> System.out.println("***:" + ind.getResource().getLocalName()));
    }

    protected Map<String, String> getPropertiesAndTypes() {
        Map<String, String> mapOfPropertiesAndTypes = Collections.emptyMap();
        mapOfPropertiesAndTypes.put("name", MUSIC_GALLERY_URI + "name");

        mapOfPropertiesAndTypes.put("price", MUSIC_GALLERY_URI + "price");
        mapOfPropertiesAndTypes.put("brand", MUSIC_GALLERY_URI + "brand");
        mapOfPropertiesAndTypes.put("typeIs", MUSIC_GALLERY_URI + "typeIs");
        mapOfPropertiesAndTypes.put("soldByStore", MUSIC_GALLERY_URI + "soldByStore");
        mapOfPropertiesAndTypes.put("boughtByUser", MUSIC_GALLERY_URI + "boughtByUser");

        return mapOfPropertiesAndTypes;
    }

    private void iterateThrough(OntModel musicGalleryOntologyModel) {


        Iterator<Resource> iterator = musicGalleryOntologyModel.listSubjects();
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
