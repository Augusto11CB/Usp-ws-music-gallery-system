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
public class UserPurchaseDTO {

    private Long id;

    private String productURI;

    private String productName;

    private TypeProductAndBusiness productType;

    private UserDTO userDTO;
}
