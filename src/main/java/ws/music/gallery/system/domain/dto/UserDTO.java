package ws.music.gallery.system.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ws.music.gallery.system.enums.Gender;

@Data
@Builder
@AllArgsConstructor
public class UserDTO {
    
    private Long idUser;

    private String cpfUser;

    private String password;

    private Gender gender;
}
