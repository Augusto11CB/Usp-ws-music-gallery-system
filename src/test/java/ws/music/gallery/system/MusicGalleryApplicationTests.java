package ws.music.gallery.system;

import com.google.gson.Gson;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.*;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;
import ws.music.gallery.system.domain.dto.BandTShirtDTO;
import ws.music.gallery.system.domain.dto.ProductDTO;
import ws.music.gallery.system.domain.dto.RecordPlayerDTO;
import ws.music.gallery.system.domain.dto.StoreDTO;
import ws.music.gallery.system.enums.ClothSize;
import ws.music.gallery.system.enums.Gender;
import ws.music.gallery.system.enums.TypeProductAndBusiness;
import ws.music.gallery.system.repository.ontologyrepo.MusicGalleryOntologyRepository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

@SpringBootTest
class MusicGalleryApplicationTests {


    private static final Logger LOGGER = Logger.getLogger(MusicGalleryApplicationTests.class);

    @Value("${music.gallery.uri}")
    private String MUSIC_GALLERY_URI;

    @Autowired
    private MusicGalleryOntologyRepository musicGalleryOntologyRepository;

    @Autowired
    private OntModel musicGalleryOntologyModel;

    private Model model;
    private Resource resource;
    private Property property;


    @BeforeEach
    public void init() {
        model = ModelFactory.createDefaultModel();
        InfModel inferredModel = ModelFactory.createRDFSModel(model);
        Property nameProperty = model.createProperty("Rock-And-Roll-Planet");
        Statement statement = null;
        RDFNode rdfNode;
        resource = musicGalleryOntologyModel.createResource(MUSIC_GALLERY_URI + "Product");


    }

    @Test
    void MusicGalleryRepositoryTest() {
        musicGalleryOntologyRepository.getAllResources(resource);
    }

    @Test
    void contextLoads() {

        try {

            OntModel ontoModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, null);

            ClassLoader classLoader = getClass().getClassLoader();
            File file = ResourceUtils.getFile("C:\\Users\\AsusAugusto\\Desktop\\USP\\8 - SEMESTRE\\WS\\Project\\Usp-ws-music-gallery-system\\ws-music-gallery-system\\src\\RockAndRollGaleria.owl");
            //File file = new File(classLoader.getResource("OntologyRepository/RockAndRollGaleria.owl").getFile());
            if (Objects.nonNull(file)) {

                InputStream in = new FileInputStream(file);
                ontoModel.read(in, null);

                iterateThrough(ontoModel);
            }

            LOGGER.info("Ontology " + ontoModel + " loaded.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void iterateThrough(OntModel ontoModel) {
        Iterator<Resource> iterator = ontoModel.listSubjects();
        while (iterator.hasNext()) {

            Resource resource = iterator.next();
            System.out.println("Resource: " + resource);

            Iterator<Statement> iteratorResource = resource.listProperties();
            while (iteratorResource.hasNext()) {
                Statement statement = iteratorResource.next();
                System.out.println("Print1" + statement.getPredicate().getLocalName());
                System.out.println("Print2" + statement.getSubject().getLocalName());
            }
        }
    }

    @Test
    void readingOwlFile() throws FileNotFoundException {

        String basePath = new File("").getAbsolutePath();
        String basePath2 = new File("").getPath();
        System.out.println(basePath);
        System.out.println(basePath2);

        String path = new File("src/main/resources/OntologyRepository/RockAndRollGaleria.owl")
                .getAbsolutePath();
        System.out.println(path);

        OntModel ontoModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, null);
        URL resource = MusicGalleryApplicationTests.class.getClassLoader().getResource("src/main/resources/OntologyRepository/RockAndRollGaleria.owl");

        File file = new File("src/main/resources/OntologyRepository/RockAndRollGaleria.owl");

        InputStream in = new FileInputStream(file);
        ontoModel.read(in, null);
        iterateThrough(ontoModel);
    }

    @ParameterizedTest
    @ValueSource(strings = {"store1", "store2"})
    void createResourceStore(String storeURI) {

        resource = model.createResource(storeURI);

        System.out.println(resource);

    }

    @Test
    public void testGetProducts() {
        Gson gson = new Gson();
        StoreDTO pierreInstrumentosMusicais = StoreDTO.builder()
                .name("All Rock TShirts")
                .typeBusiness(TypeProductAndBusiness.CLOTHING)
                .build();

        StoreDTO allRockTshirts = StoreDTO.builder()
                .name("Pierre Instrumentos Musicais")
                .typeBusiness(TypeProductAndBusiness.CLOTHING)
                .build();

        BandTShirtDTO bandTShirtDTO = BandTShirtDTO.builder()
                .band("Scorpions")
                .musicalGenre("rock")
                .size(ClothSize.P)
                .designatedGender(Gender.MALE)
                .mainColor("white")
                .typeOfFiber("Jeans")
                .name("Tshirt scorpinos nice")
                .typeProductAndBusiness(TypeProductAndBusiness.CLOTHING)
                .branch("scorpions")
                .price(120)
                .soldByStore(pierreInstrumentosMusicais)
                .build();

        RecordPlayerDTO recordPlayerDTO = RecordPlayerDTO.builder()
                .hasRadio(true)
                .hasRadio(false)
                .voltage(120)
                .typeProductAndBusiness(TypeProductAndBusiness.MUSICAL_EQUIPMENT)
                .branch("Phillips")
                .price(601)
                .soldByStore(allRockTshirts)
                .build();

        ArrayList<ProductDTO> products = new ArrayList<ProductDTO>(
                Arrays.asList(bandTShirtDTO,recordPlayerDTO));
        System.out.println(gson.toJson(products));

    }

}
