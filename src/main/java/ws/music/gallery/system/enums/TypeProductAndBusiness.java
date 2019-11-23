package ws.music.gallery.system.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TypeProductAndBusiness
{
    MUSICAL_EQUIPMENT("EQUIPAMENTO MUSICAL"),
    MUSICAL_MEDIA("MEDIA MUSICAL"),
    CLOTHING("VESTUARIO");

    private String value;
}