package ws.music.gallery.system.converter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.jena.ontology.Individual;
import org.apache.jena.rdf.model.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ws.music.gallery.system.domain.dto.ProductDTO;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public abstract class ProductOntologyEntitiesConverter {

    @Value("${music.gallery.uri}")
    protected String MUSIC_GALLERY_URI;

    protected ProductOntologyEntitiesConverter nextProductConverter = null;

    public ProductOntologyEntitiesConverter linkWith(ProductOntologyEntitiesConverter next) {
        this.nextProductConverter = next;
        return nextProductConverter;
    }


    abstract public Individual productDTOToindividual(ProductDTO productDTO);

    abstract public ProductDTO individualToProductDTO(Individual productIndividual);

    abstract public Resource productDTOToResource(ProductDTO productDTO);

    abstract public ProductDTO resourceToProductDTO(Resource productResource);


    protected Optional<ProductDTO> checkNextIndvToDto(Individual individual) {
        return Objects.nonNull(nextProductConverter) ?
                Optional.ofNullable(nextProductConverter.individualToProductDTO(individual)) : Optional.empty();
    }

/*    protected Optional<Individual> checkNextDtoToIndividual(ProductDTO productDTO) {
        return Objects.nonNull(nextProductConverter) ?
                Optional.ofNullable(nextProductConverter.productDTOToindividual(productDTO)) : Optional.empty();
    }*/

    protected Optional<ProductDTO> checkNextResourceToDto(Resource res) {
        return Objects.nonNull(nextProductConverter) ?
                Optional.ofNullable(nextProductConverter.resourceToProductDTO(res)) : Optional.empty();
    }

/*
    protected Optional<Resource> checkNextDtoToResource(ProductDTO productDTO) {
        return Objects.nonNull(nextProductConverter) ?
                Optional.ofNullable(nextProductConverter.productDTOToResource(productDTO)) : Optional.empty();
    }
*/

    //TODO create logic to retrive data from DB in order to keep easy the update of url and names that can change
    protected Map<String, String> getPropertiesAndTypes() {
        Map<String, String> mapOfPropertiesAndTypes = Collections.emptyMap();
        mapOfPropertiesAndTypes.put("name", MUSIC_GALLERY_URI + "name");
        mapOfPropertiesAndTypes.put("price", MUSIC_GALLERY_URI + "price");
        mapOfPropertiesAndTypes.put("brand", MUSIC_GALLERY_URI + "brand");
        mapOfPropertiesAndTypes.put("typeIs", MUSIC_GALLERY_URI + "typeIs");
        mapOfPropertiesAndTypes.put("soldByStore", MUSIC_GALLERY_URI + "soldByStore");
        //mapOfPropertiesAndTypes.put("boughtByUser", MUSIC_GALLERY_URI + "boughtByUser");

        return mapOfPropertiesAndTypes;
    }
}
