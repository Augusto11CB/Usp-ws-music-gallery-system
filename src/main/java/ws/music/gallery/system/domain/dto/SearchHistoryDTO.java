package ws.music.gallery.system.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class SearchHistoryDTO {

    private Long id;
    private UserDTO userDTO;
    private String searchMadeInSearchBar;
    private List<ProductDTO> productsClicked;
}
