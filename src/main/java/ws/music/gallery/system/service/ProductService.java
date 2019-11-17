package ws.music.gallery.system.service;

import ws.music.gallery.system.domain.dto.ProductDTO;
import ws.music.gallery.system.domain.dto.StoreDTO;
import ws.music.gallery.system.enums.TypeProductAndBusiness;

import java.util.List;
import java.util.Map;

public interface ProductService {

    List<ProductDTO> getAllProducts();

    List<ProductDTO> getAllProductsOfStore(String productName);

    List<ProductDTO> getProductsByType(TypeProductAndBusiness type);

    Map<TypeProductAndBusiness, List<ProductDTO>> getAllProductsByType();
}
