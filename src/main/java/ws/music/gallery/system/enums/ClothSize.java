package ws.music.gallery.system.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ClothSize {

    SMALL("PEQUENO"),
    MEDIUM("MÉDIO"),
    LARGE("GRANDE"),
    EXTRALARGE("EXTRA GRANDE");

    private String value;
}