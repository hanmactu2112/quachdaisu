package ptit.suwoo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "mota")
    private String mota;
    @Column(name = "urlimg")
    private String urlImg;
    @ManyToOne
    @JoinColumn(name = "sanpham_id")
    private SanPham sanPham;

}
