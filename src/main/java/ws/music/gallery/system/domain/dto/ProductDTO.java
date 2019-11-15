package ws.music.gallery.system.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private String name;
    private String typeProduct; //TODO Enum?
    private double price;
    private UserDTO boughtByUser;
    private StoreDTO soldByStore;
    //private int availableStock; // TODO Maybe create a extra table to controll stock and keep the db normalized
}
