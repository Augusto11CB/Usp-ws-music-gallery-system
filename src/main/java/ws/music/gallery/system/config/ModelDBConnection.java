/*
package ws.music.gallery.system.config;

import com.hp.hpl.jena.db.DBConnection;
import com.hp.hpl.jena.db.IDBConnection;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.ModelMaker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@Configuration
public class ModelDBConnection {

    @Value("${DRIVER_DB}")
    private static String DB_DRIVER;

    @Value("${DB_URL}")
    private static String DB_URL;

    @Value("${DB_USER}")
    private static String DB_USER;

    @Value("${DB_PASSWD}")
    private static String DB_PASSWD;

    @Value("${DB_TYPE}")
    private static String DB_TYPE;

    @Value("${music.gallery.ontology.file}")
    private static String ONTOLOGY_FILE;

    @Value("${music.gallery.ontology.name}")
    private static String ONTOLOGY_NAME;

    @Value("${music.gallery.uri}")
    private static String MODEL_URI;


    @Bean
    public OntModel loadOntologyModel() {

        IDBConnection conn = null;
        ModelMaker maker = null;
        OntModel ontModel = null;
        Model baseModel = null;


        try {

            Class.forName("org.h2.Driver");
            conn = new DBConnection("jdbc:h2:file:~/h2/music_gallery_db;MODE=MySQL;DATABASE_TO_LOWER=TRUE", "admin", "", "MySQL");
//            conn = new DBConnection(DB_URL, DB_USER, DB_PASSWD, DB_TYPE);
            maker = ModelFactory.createModelRDBMaker(conn);

            if (!maker.hasModel(ONTOLOGY_NAME) == true) {

                File file = new File("src/main/resources/OntologyRepository/" + "MusicGallery.owl");
//                File file = new File("src/main/resources/OntologyRepository/" + ONTOLOGY_FILE);
                InputStream in = new FileInputStream(file);

                baseModel = maker.createModel(MODEL_URI);
                ontModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_RULE_INF, baseModel);
                ontModel.read(in, null);
                //FileManager.get().readModel(model, RDF_FILE);

            } else {
                baseModel = maker.getModel(ONTOLOGY_NAME);
                ontModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_RULE_INF, baseModel);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ontModel;
    }
}

*/