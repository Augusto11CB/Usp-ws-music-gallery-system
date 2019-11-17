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

import java.sql.Connection;
import java.sql.DriverManager;

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

        try {
            //Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();

            //Class.forName("org.h2.Driver");
            StoreDesc storeDesc = new StoreDesc(LayoutType.LayoutTripleNodesHash,
                    DatabaseType.Derby);
            JDBC.loadDriverDerby();
            String jdbcURL = "jdbc:derby:music_gallery_db;create=true;user=admin;password=";
            //SDBConnection conn = new SDBConnection(jdbcURL, "admin", "");
            Connection conn = DriverManager.getConnection(jdbcURL);
            Store store = SDBFactory.connectStore(conn, storeDesc);

            Model model = SDBFactory.connectDefaultModel(store);

            ontModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_RULE_INF, model);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ontModel;
    }

}

*/