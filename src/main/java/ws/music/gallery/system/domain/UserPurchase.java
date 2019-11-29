package ws.music.gallery.system.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ws.music.gallery.system.enums.TypeProductAndBusiness;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "USER_PURCHASE", schema = "MUSIC_GALLERY")
public class UserPurchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_USER_PURCHASE", unique = true, nullable = false)
    private Long id;

    @Column(name = "PRODUCT_URL", nullable = false)
    private String productURI;

    @Column(name = "PRODUCT_NAME", nullable = false)
    private String productName;

    @Enumerated(EnumType.STRING)
    @Column(name = "PRODUCT_TYPE", nullable = false)
    private TypeProductAndBusiness productType;

    @Column(name = "PURCHASE_DATE", nullable = false)
    private LocalDate purchaseDate;

    @ManyToOne(optional = false)
    @JoinColumn(name="ID_USER")
    private User user;

}
