package ws.music.gallery.system.config;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.ModelFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;

import java.io.*;

@Configuration
//@PropertySource("classpath:application.properties")
public class OntModelLoaderConfig {

    @Value("${music.gallery.ontology.file}")
    private String ONTOLOGY_FILE_PATH;

    @Value("${music.gallery.ontology.name}")
    private String ONTOLOGY_NAME;

    @Value("${music.gallery.uri}")
    private String MODEL_URI;




    @Bean(name = "musicGalleryOntologyModel")
    public OntModel loadOntologyModel() {
        OntModel ontoModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, null);
        try {

            Resource resource = new ClassPathResource(ONTOLOGY_FILE_PATH);
            ontoModel.read(resource.getInputStream(), null);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ontoModel;
    }
}
