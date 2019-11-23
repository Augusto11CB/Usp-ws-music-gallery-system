package ws.music.gallery.system.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ws.music.gallery.system.enums.TypeProductAndBusiness;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private String name;
    private TypeProductAndBusiness typeProductAndBusiness;
    private String branch;
    private double price;
    private UserDTO boughtByUser;
    private StoreDTO soldByStore;
    private String URI;
    //private int availableStock; // TODO Maybe create a extra table to controll stock and keep the db normalized
}
