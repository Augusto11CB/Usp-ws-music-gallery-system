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
import ws.music.gallery.system.domain.dto.VynlDTO;

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

    @Override
    public Individual productDTOToindividual(ProductDTO productDTO) {
        return musicGalleryOntologyModel.getIndividual(productDTO.getURI());
    }

    @Override
    public ProductDTO individualToProductDTO(Individual productIndividual) {
        return VynlDTO.builder()
                .musicalGenre(productIndividual.getProperty(musicalGenre).getLiteral().getValue().toString())
                .releaseYear(Integer.parseInt(productIndividual.getProperty(releaseYear).getLiteral().getValue().toString()))
                .band(productIndividual.getProperty(band).getLiteral().getValue().toString())
                .build();
    }

    @Override
    public Resource productDTOToResource(ProductDTO productDTO) {
        return musicGalleryOntologyModel.getIndividual(productDTO.getURI());
    }

    @Override
    public ProductDTO resourceToProductDTO(Resource productResource) {
        return VynlDTO.builder()
                .musicalGenre(productResource.getProperty(musicalGenre).getLiteral().getValue().toString())
                .releaseYear(Integer.parseInt(productResource.getProperty(releaseYear).getLiteral().getValue().toString()))
                .band(productResource.getProperty(band).getLiteral().getValue().toString())
                .build();
    }
}
