package ws.music.gallery.system.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class RecordPlayerDTO extends ProductDTO {

    private boolean hasRadio;
    private boolean hasUSBPort;
    private int voltage;
}
