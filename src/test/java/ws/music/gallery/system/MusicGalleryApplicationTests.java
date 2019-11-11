package ws.music.gallery.system;

import org.apache.jena.rdf.model.Model;


import org.apache.jena.rdf.model.ModelFactory;


import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MusicGalleryApplicationTests {

    private Model model;
    private Resource resource;
    private Property property;


    @BeforeEach
    public void init() {
        model = ModelFactory.createDefaultModel();
    }

    @Test
    void contextLoads() {

    }

    @ParameterizedTest
    @ValueSource(strings = {"store1","store2"})
    void createResourceStore(String storeURI) {

        resource = model.createResource(storeURI);

        System.out.println(resource);

    }

}
