package ws.music.gallery.system.utils.wrapper;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.impl.PropertyImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import ws.music.gallery.system.enums.PropertyType;

import java.util.Collections;
import java.util.Map;

/*
 * transfer the data inside this class to a db and access these data using repositories
 * */

public abstract class PropertiesWrapper {

    @Value("${music.gallery.uri}")
    private static String MUSIC_GALLERY_URI;

    @Autowired
    OntModel musicGalleryOntologyModel;

    public static Map<Property, PropertyType> getStoreProperties() {

        Map<Property, PropertyType> storeProperties = Collections.emptyMap();

        storeProperties.put(new PropertyImpl(MUSIC_GALLERY_URI + "typeBusiness"), PropertyType.OBJECT_PROPERTY);
        storeProperties.put(new PropertyImpl(MUSIC_GALLERY_URI + "name"), PropertyType.LITERAL);
        
        return storeProperties;
    }
}
