package ws.music.gallery.system.converter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.impl.PropertyImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import ws.music.gallery.system.domain.dto.ProductDTO;
import ws.music.gallery.system.domain.dto.StoreDTO;
import ws.music.gallery.system.enums.ClothSize;
import ws.music.gallery.system.enums.Gender;
import ws.music.gallery.system.enums.TypeProductAndBusiness;

import java.util.Map;

@Data

public class TShirtOntologyEntitiesConverter extends ProductOntologyEntitiesConverter {

    @Autowired
    OntModel musicGalleryOntologyModel;

    @Value("${music.gallery.uri}")
    private String MUSIC_GALLERY_URI;

    private Property size = new PropertyImpl(MUSIC_GALLERY_URI + "size");
    private Property mainColor = new PropertyImpl(MUSIC_GALLERY_URI + "mainColor");
    private Property typeOfFiber = new PropertyImpl(MUSIC_GALLERY_URI + "typeOfFiber");
    private Property designatedGender = new PropertyImpl(MUSIC_GALLERY_URI + "designatedGender");


    public Individual productDTOToindividual(ProductDTO productDTO) {
        return musicGalleryOntologyModel.getIndividual(productDTO.getURI());
    }

    public ProductDTO individualToProductDTO(Individual productIndividual) {
        return ProductDTO.builder()
                .size(ClothSize.valueOf(productIndividual.getProperty(size).getResource().getLocalName()))
                .mainColor(productIndividual.getProperty(mainColor).getLiteral().getValue().toString())
                .typeOfFiber(productIndividual.getProperty(typeOfFiber).getLiteral().getValue().toString())
                .designatedGender(Gender.valueOf(productIndividual.getProperty(designatedGender).getResource().getLocalName()))
                .build();
    }


    public Resource productDTOToResource(ProductDTO productDTO) {
        return musicGalleryOntologyModel.getResource(productDTO.getURI());
    }

    public ProductDTO resourceToProductDTO(Resource productResource) {
        return ProductDTO.builder()
                .size(ClothSize.valueOf(productResource.getProperty(size).getResource().getLocalName()))
                .mainColor(productResource.getProperty(mainColor).getLiteral().getValue().toString())
                .typeOfFiber(productResource.getProperty(typeOfFiber).getLiteral().getValue().toString())
                .designatedGender(Gender.valueOf(productResource.getProperty(designatedGender).getResource().getLocalName()))
                .build();
    }

    @Override
    protected Map<String, String> getPropertiesAndTypes() {
        Map<String, String> mapOfPropertiesAndTypes = super.getPropertiesAndTypes();
        mapOfPropertiesAndTypes.put("gender", musicGalleryURI + "gender");
        mapOfPropertiesAndTypes.put("clothSize", musicGalleryURI + "clothSize");
        mapOfPropertiesAndTypes.put("typeOfFiber", musicGalleryURI + "typeOfFiber");
        mapOfPropertiesAndTypes.put("mainColor", musicGalleryURI + "mainColor");

        return mapOfPropertiesAndTypes;
    }
}
