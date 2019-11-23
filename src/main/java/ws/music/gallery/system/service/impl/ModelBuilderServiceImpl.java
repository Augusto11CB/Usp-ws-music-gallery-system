package ws.music.gallery.system.service.impl;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ws.music.gallery.system.service.ModelBuilderService;

@Service
public class ModelBuilderServiceImpl implements ModelBuilderService {

    @Value("${music.gallery.uri}")
    private String MUSIC_GALLERY_URI;


    @Override
    public void testMethod() {
        System.out.println("ModelBuilderServiceImpl loaded !! OK");
    }

    @Override
    public Model buildMusicGalleryModel() {
        //IDBConnection
        //ModelMaker

        //if ( !maker.hasModel(MODEL_NAME) == true ) {}

       return null;
    }


    public Model buildModel() {
        Model model = ModelFactory.createDefaultModel();

       return null;
    }

    private Model populateModel(Model model){
        return null;
    }

}
