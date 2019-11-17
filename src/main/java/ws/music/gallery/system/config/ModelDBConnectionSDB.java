/*
package ws.music.gallery.system.config;


import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.sdb.SDBFactory;
import org.apache.jena.sdb.Store;
import org.apache.jena.sdb.StoreDesc;
import org.apache.jena.sdb.sql.JDBC;
import org.apache.jena.sdb.sql.SDBConnection;
import org.apache.jena.sdb.store.DatabaseType;
import org.apache.jena.sdb.store.LayoutType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Caused by: java.lang.ClassNotFoundException: org.apache.derby.jdbc.EmbeddedDriver

@Configuration
public class ModelDBConnectionSDB {

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
        OntModel ontModel = null;

        StoreDesc storeDesc = new StoreDesc(LayoutType.LayoutTripleNodesHash,
                DatabaseType.MySQL);
        JDBC.loadDriverDerby();
        String jdbcURL = "jdbc:h2:file:~/h2/music_gallery_db";
        SDBConnection conn = new SDBConnection(jdbcURL, "admin", null);
        Store store = SDBFactory.connectStore(conn, storeDesc);

        Model model = SDBFactory.connectDefaultModel(store);

        ontModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_RULE_INF, model);

        return ontModel;
    }

}

 */