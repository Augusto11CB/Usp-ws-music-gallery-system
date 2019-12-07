package ws.music.gallery.system.service.impl;

import org.apache.jena.ontology.Individual;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.impl.ResourceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ws.music.gallery.system.converter.*;
import ws.music.gallery.system.domain.Product;
import ws.music.gallery.system.domain.dto.ProductDTO;
import ws.music.gallery.system.enums.TypeProductAndBusiness;
import ws.music.gallery.system.exception.ProductNotFoundException;
import ws.music.gallery.system.repository.ProductRepository;
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

    @Autowired
    private ModelMapper modelMapper;

    private ProductRepository productRepository;
    private StoreOntologyRepository storeOntologyRepository;
    private ProductOntologyRepository productOntologyRepository;
    private ProductOntologyEntitiesConverter productConverter;
    private VynlOntologyEntitiesConverter vynlOntologyEntitiesConverter;
    private TShirtOntologyEntitiesConverter tShirtOntologyEntitiesConverter;
    private MusicalInstrumentOntologyEntitiesConverter musicalInstrumentOntologyEntitiesConverter;
    private RecordPlayerOntologyEntitiesConverter recordPlayerOntologyEntitiesConverter;


    public ProductServiceImpl(
            ProductRepository productRepository,
            StoreOntologyRepository storeOntologyRepository,
            ProductOntologyRepository productOntologyRepository,
            VynlOntologyEntitiesConverter vynlOntologyEntitiesConverter,
            TShirtOntologyEntitiesConverter tShirtOntologyEntitiesConverter,
            MusicalInstrumentOntologyEntitiesConverter musicalInstrumentOntologyEntitiesConverter,
            RecordPlayerOntologyEntitiesConverter recordPlayerOntologyEntitiesConverter

    ) {
        this.productRepository = productRepository;
        this.storeOntologyRepository = storeOntologyRepository;
        this.productOntologyRepository = productOntologyRepository;
        this.vynlOntologyEntitiesConverter = vynlOntologyEntitiesConverter;
        this.tShirtOntologyEntitiesConverter = tShirtOntologyEntitiesConverter;
        this.musicalInstrumentOntologyEntitiesConverter = musicalInstrumentOntologyEntitiesConverter;
        this.recordPlayerOntologyEntitiesConverter = recordPlayerOntologyEntitiesConverter;
        this.productConverter = this.buildChainOfConversion();

        //TODO verify why we couldn't read values from applications.properties from the constructor
    }

    @Override
    public ProductDTO getProduct(String productURI) {
        Product product = productRepository.findByProductURI(productURI)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));

        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);

        return productDTO;
    }


    @Override
    public List<ProductDTO> getAllProducts() {

        List<Individual> indvList = productOntologyRepository.getAllProducts();
        List<ProductDTO> productDTOList = indvList.stream()
                .map(indv -> productConverter.resourceToProductDTO(indv))
                .map(resource -> this.setQuantity(resource))
                .collect(Collectors.toList());

        return productDTOList;
    }

    @Override
    public List<ProductDTO> getAllProductsOfStore(String storeName) {

        Resource store = storeOntologyRepository.getStore(storeName);
        List<Resource> indvList = productOntologyRepository.getAllProductsOfStore(store);
        List<ProductDTO> productDTOList = indvList.stream()
                .map(indv -> productConverter.resourceToProductDTO(indv))
                .map(resource -> this.setQuantity(resource))
                .collect(Collectors.toList());

        return productDTOList;
    }

    @Override
    public List<ProductDTO> getProductsByType(TypeProductAndBusiness type) {
        System.out.println(type);
        Resource productType = new ResourceImpl(MUSIC_GALLERY_URI + type.getValue());

        List<Resource> indvList = productOntologyRepository.getAllProductsByType(productType);
        indvList.forEach(System.out::println);// TODO Until here works fine!!

        List<ProductDTO> productDTOList = indvList.stream()
                .map(indv -> productConverter.resourceToProductDTO(indv))
                .map(resource -> this.setQuantity(resource))
                .collect(Collectors.toList());

        return productDTOList;
    }

    @Override
    public Map<TypeProductAndBusiness, List<ProductDTO>> getAllProductsByType() {
        //TODO implement getAllProductsByType
        return null;
    }

    private ProductOntologyEntitiesConverter buildChainOfConversion() {
        tShirtOntologyEntitiesConverter
                .linkWith(musicalInstrumentOntologyEntitiesConverter)
                .linkWith(recordPlayerOntologyEntitiesConverter)
                .linkWith(vynlOntologyEntitiesConverter);
        return tShirtOntologyEntitiesConverter;
    }

    private ProductDTO setQuantity(ProductDTO productDTO) {
        productRepository.findByProductURI(productDTO.getURI())
                .ifPresent(p -> productDTO.setAvailableQuantity(p.getAvailableQuantity()));

        return productDTO;
    }
}
