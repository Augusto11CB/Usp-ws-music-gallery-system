package ws.music.gallery.system.service.impl;

import org.apache.jena.ontology.Individual;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.impl.ResourceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ws.music.gallery.system.converter.*;
import ws.music.gallery.system.domain.dto.ProductDTO;
import ws.music.gallery.system.enums.TypeProductAndBusiness;
import ws.music.gallery.system.repository.ontologyrepo.ProductOntologyRepository;
import ws.music.gallery.system.repository.ontologyrepo.StoreOntologyRepository;
import ws.music.gallery.system.service.ProductService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class ProductServiceImpl implements ProductService {

    @Value("${music.gallery.uri}")
    private String MUSIC_GALLERY_URI;

    private StoreOntologyRepository storeOntologyRepository;


    private ProductOntologyRepository productOntologyRepository;


    private ProductOntologyEntitiesConverter productConverter;


    public ProductServiceImpl(
            StoreOntologyRepository storeOntologyRepository,
            ProductOntologyRepository productOntologyRepository
    ) {
        this.storeOntologyRepository = storeOntologyRepository;
        this.productOntologyRepository = productOntologyRepository;
        this.productConverter = this.buildChainOfConversion();
    }


    @Override
    public List<ProductDTO> getAllProducts() {

        List<Individual> indvList = productOntologyRepository.getAllProducts();
        List<ProductDTO> productDTOList = indvList.stream().map(indv ->
                productConverter.individualToProductDTO(indv)).collect(Collectors.toList());

        return productDTOList;
    }

    @Override
    public List<ProductDTO> getAllProductsOfStore(String storeName) {

        Resource store = storeOntologyRepository.getStore(storeName);
        List<Resource> indvList = productOntologyRepository.getAllProductsOfStore(store);
        List<ProductDTO> productDTOList = indvList.stream().map(indv ->
                productConverter.resourceToProductDTO(indv)).collect(Collectors.toList());

        return productDTOList;
    }

    @Override
    public List<ProductDTO> getProductsByType(TypeProductAndBusiness type) {

        Resource productType = new ResourceImpl(MUSIC_GALLERY_URI + type.getValue());

        List<Resource> indvList = productOntologyRepository.getAllProductsOfStore(productType);
        List<ProductDTO> productDTOList = indvList.stream().map(indv ->
                productConverter.resourceToProductDTO(indv)).collect(Collectors.toList());

        return productDTOList;
    }

    @Override
    public Map<TypeProductAndBusiness, List<ProductDTO>> getAllProductsByType() {
        //TODO implement getAllProductsByType
        return null;
    }

    private ProductOntologyEntitiesConverter buildChainOfConversion() {
        return new TShirtOntologyEntitiesConverter()
                .linkWith(new MusicalInstrumentOntologyEntitiesConverter()
                        .linkWith(new RecordPlayerOntologyEntitiesConverter()
                                .linkWith(new VynlOntologyEntitiesConverter())));
    }
}
