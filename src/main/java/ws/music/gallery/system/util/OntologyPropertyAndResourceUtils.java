package ws.music.gallery.system.util;

import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.impl.PropertyImpl;


public class OntologyPropertyAndResourceUtils {


    public static String MUSIC_GALLERY_URI = "http://www.musicgallery/";

    public static Property name = new PropertyImpl(MUSIC_GALLERY_URI + "name");
    public static Property price = new PropertyImpl(MUSIC_GALLERY_URI + "price");
    public static Property brand = new PropertyImpl(MUSIC_GALLERY_URI + "brand");
    public static Property typeIs = new PropertyImpl(MUSIC_GALLERY_URI + "typeIs");
    public static Property soldByStore = new PropertyImpl(MUSIC_GALLERY_URI + "soldByStore");
    public static Property boughtByUser = new PropertyImpl(MUSIC_GALLERY_URI + "boughtByUser");

    public static Property productQuantity = new PropertyImpl(MUSIC_GALLERY_URI + "productQuantity");

    public static Property mainColor = new PropertyImpl(MUSIC_GALLERY_URI + "mainColor");
    public static Property size = new PropertyImpl(MUSIC_GALLERY_URI + "clothSize");
    public static Property typeOfFiber = new PropertyImpl(MUSIC_GALLERY_URI + "typeOfFiber");
    public static Property designatedGender = new PropertyImpl(MUSIC_GALLERY_URI + "gender");

    public static Property band = new PropertyImpl(MUSIC_GALLERY_URI + "band");

    public static Property musicalGenre = new PropertyImpl(MUSIC_GALLERY_URI + "musicalGenre");
    public static Property releaseYear = new PropertyImpl(MUSIC_GALLERY_URI + "releaseYear");

    public static Property typeBusiness = new PropertyImpl(MUSIC_GALLERY_URI + "typeBusiness");

    public static Property hasRadio = new PropertyImpl(MUSIC_GALLERY_URI + "hasRadio");
    public static Property hasUSBPort = new PropertyImpl(MUSIC_GALLERY_URI + "hasUSBPort");
    public static Property voltage = new PropertyImpl(MUSIC_GALLERY_URI + "voltage");

    public static Property typeOfInstrument = new PropertyImpl(MUSIC_GALLERY_URI + "typeOfInstrument");
    public static Property isSecondHand = new PropertyImpl(MUSIC_GALLERY_URI + "isSecondHand");

    public static Property cpf = new PropertyImpl(MUSIC_GALLERY_URI + "cpf");

    public static String tshirtClass =  MUSIC_GALLERY_URI +  "TShirt";
    public static String bandTshirtClass =  MUSIC_GALLERY_URI +  "BandTShirt";
    public static String recordPlayer = MUSIC_GALLERY_URI +  "RecordPlayer";
    public static String musicalInstrument = MUSIC_GALLERY_URI +  "MusicalInstrument";
    public static String vynl = MUSIC_GALLERY_URI +  "Vynl";
    public static String store = MUSIC_GALLERY_URI +  "Store";

}