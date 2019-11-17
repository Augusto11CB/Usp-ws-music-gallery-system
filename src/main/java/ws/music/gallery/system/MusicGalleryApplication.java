package ws.music.gallery.system;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.ModelFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootApplication
public class MusicGalleryApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicGalleryApplication.class, args);
    }

/*    @Bean
    public OntModel loadOntologyModel() {
        OntModel ontoModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, null);
        try {

            File file = new File("src/main/resources/OntologyRepository/MusicGallery.owl");
            InputStream in = new FileInputStream(file);
            ontoModel.read(in, null);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return ontoModel;
    }*/
}
