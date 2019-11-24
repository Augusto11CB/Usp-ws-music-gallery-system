package ws.music.gallery.system.service;

import ws.music.gallery.system.domain.dto.ProductDTO;

import java.util.List;

public interface PurchaseService {

    void performPurchase(List<ProductDTO> purchasedProducts, String userCPF);
}
