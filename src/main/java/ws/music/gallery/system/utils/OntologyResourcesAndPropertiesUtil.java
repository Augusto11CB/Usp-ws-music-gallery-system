package ws.music.gallery.system.utils;

import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.springframework.beans.factory.annotation.Value;
import ws.music.gallery.system.enums.TypeProductAndBusiness;

public class PropertiesWrapper {

    @Value("${music.gallery.uri}")
    private String MUSIC_GALLERY_URI;

    static public Resource getBusinessOrProductType(TypeProductAndBusiness type){
        //TODO
        return null;
    }

}
