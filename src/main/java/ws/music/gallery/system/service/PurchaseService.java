package ws.music.gallery.system.service;

import ws.music.gallery.system.domain.dto.ProductDTO;
import ws.music.gallery.system.enums.Gender;

import java.util.List;

public interface PurchaseService {

    void performPurchase(List<ProductDTO> purchasedProducts, String cpf, Gender gender, int age);
}
