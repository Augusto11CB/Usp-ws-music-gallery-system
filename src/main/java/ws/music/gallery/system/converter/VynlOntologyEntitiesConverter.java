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
import ws.music.gallery.system.enums.TypeProductAndBusiness;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VynlOntologyEntitiesConverter extends ProductOntologyEntitiesConverter {

    @Autowired
    private OntModel musicGalleryOntologyModel;

    @Value("${music.gallery.uri}")
    private String MUSIC_GALLERY_URI;

    private Property musicalGenre = new PropertyImpl(MUSIC_GALLERY_URI + "musicalGenre");
    private Property releaseYear = new PropertyImpl(MUSIC_GALLERY_URI + "releaseYear");
    private Property band = new PropertyImpl(MUSIC_GALLERY_URI + "band");

    public Individual productDTOToindividual(ProductDTO productDTO) {
        return musicGalleryOntologyModel.getIndividual(productDTO.getURI());
    }

    public ProductDTO individualToProductDTO(Individual productIndividual) {
        return ProductDTO.builder()
                .musicalGenre(productIndividual.getProperty(musicalGenre).getLiteral().getValue().toString())
                .releaseYear(Integer.parseInt(productIndividual.getProperty(releaseYear).getLiteral().getValue().toString()))
                .band(productIndividual.getProperty(band).getLiteral().getValue().toString())
                .build();
    }


    public Resource productDTOToResource(ProductDTO productDTO) {
        return musicGalleryOntologyModel.getIndividual(productDTO.getURI());
    }

    public ProductDTO resourceToProductDTO(Resource productResource) {
        return ProductDTO.builder()
                .musicalGenre(productResource.getProperty(musicalGenre).getLiteral().getValue().toString())
                .releaseYear(Integer.parseInt(productResource.getProperty(releaseYear).getLiteral().getValue().toString()))
                .band(productResource.getProperty(band).getLiteral().getValue().toString())
                .build();
    }


    @Override
    protected Map<String, String> getPropertiesAndTypes() {
        Map<String, String> mapOfPropertiesAndTypes = super.getPropertiesAndTypes();
        mapOfPropertiesAndTypes.put("releaseYear", musicGalleryURI + "releaseYear");
        mapOfPropertiesAndTypes.put("musicalGenre", musicGalleryURI + "musicalGenre");
        mapOfPropertiesAndTypes.put("band", musicGalleryURI + "band");
        return mapOfPropertiesAndTypes;
    }
}
