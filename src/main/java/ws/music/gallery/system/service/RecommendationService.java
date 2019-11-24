package ws.music.gallery.system.service;

import ws.music.gallery.system.domain.dto.ProductDTO;

import java.util.List;

public interface RecommendationService {

    List<ProductDTO> recommendProducsSameTypeLastPurchases(String userCPF);
}
