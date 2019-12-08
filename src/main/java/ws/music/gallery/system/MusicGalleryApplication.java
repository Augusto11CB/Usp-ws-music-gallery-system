package ws.music.gallery.system;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

@SpringBootApplication
public class MusicGalleryApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicGalleryApplication.class, args);
    }

    @Bean
    public ModelMapper initializeModelMapper() {
        return new ModelMapper();
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
