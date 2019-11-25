package ws.music.gallery.system.converter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.jena.ontology.Individual;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.impl.PropertyImpl;
import org.springframework.beans.factory.annotation.Value;
import ws.music.gallery.system.domain.dto.ProductDTO;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class ProductOntologyEntitiesConverter {

    @Value("${music.gallery.uri}")
    protected String MUSIC_GALLERY_URI;

    //TODO create logic to retrive data from DB in order to keep easy the update of url and names that can change
    private Property name = new PropertyImpl(MUSIC_GALLERY_URI + "name");
    private Property price = new PropertyImpl(MUSIC_GALLERY_URI + "price");
    private Property branch = new PropertyImpl(MUSIC_GALLERY_URI + "branch");
    private Property typeIs = new PropertyImpl(MUSIC_GALLERY_URI + "typeIs");
    private Property soldByStore = new PropertyImpl(MUSIC_GALLERY_URI + "soldByStore");


    private ProductOntologyEntitiesConverter nextProductConverter;

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
                nextProductConverter.checkNextIndvToDto(individual) : Optional.empty();
    }

    protected Optional<Individual> checkNextDtoToIndividual(ProductDTO productDTO) {
        return Objects.nonNull(nextProductConverter) ?
                nextProductConverter.checkNextDtoToIndividual(productDTO) : Optional.empty();
    }

    protected Optional<ProductDTO> checkNextResourceToDto(Resource res) {
        return Objects.nonNull(nextProductConverter) ?
                nextProductConverter.checkNextResourceToDto(res) : Optional.empty();
    }

    protected Optional<Resource> checkNextDtoToResource(ProductDTO productDTO) {
        return Objects.nonNull(nextProductConverter) ?
                nextProductConverter.checkNextDtoToResource(productDTO) : Optional.empty();
    }

}
