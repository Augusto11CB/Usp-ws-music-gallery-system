package ws.music.gallery.system.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "PRODUCT", schema = "MUSIC_GALLERY")
@Data
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_USER_PURCHASE", unique = true, nullable = false)
    private long idProduct;

    @Column(name = "PRODUCT_URL", nullable = false)
    private String productURI;

    @Column(name = "AVAILABLE_QUANTITY", nullable = false)
    private int availableQuantity;

}
