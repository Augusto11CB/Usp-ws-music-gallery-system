package ws.music.gallery.system.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class MusicalnstrumentDTO extends ProductDTO{
    private String typeOfInstrument; //TODO Enum?
    private boolean isSecondHand;
}
