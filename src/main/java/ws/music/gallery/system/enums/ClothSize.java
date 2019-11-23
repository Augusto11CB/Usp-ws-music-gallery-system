package ws.music.gallery.system.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ClothSize {

    P("PEQUENO"),
    M("MÉDIO"),
    G("GRANDE"),
    XG("EXTRA GRANDE");

    private String value;
}