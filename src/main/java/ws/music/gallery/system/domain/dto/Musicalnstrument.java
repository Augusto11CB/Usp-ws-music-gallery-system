package ws.music.gallery.system.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Musicalnstrument extends ProductDTO{
    private String typeOfInstrument; //TODO Enum?
    private boolean isSecondHand;
}
