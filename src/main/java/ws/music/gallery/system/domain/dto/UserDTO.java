package ws.music.gallery.system.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ws.music.gallery.system.enums.Gender;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    
    private Long idUser;

    private String cpfUser;

    private String password;

    private Gender gender;

    private int age;
}
