package ptit.suwoo.model;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name = "sanpham")
@Inheritance(strategy = InheritanceType.JOINED)
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "masp",nullable = false,unique = true)
    private String masp;
    @Column(name = "tensp")
    private String tenSp;
    @Column(name = "gia")
    private Double gia;
    @Column(name = "sl")
    private int soLuong;
    @Column(name = "hang")
    private String hang;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "sanpham_id")
    private List<Image> images;
    @Column(name="color")
    private String color;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;
    @Column(name = "ngayramat")
    private String ngayRaMat;
    @Column(name = "chatlieu")
    private String chatLieu;
    @Column(name = "mota")
    private String moTa;
    @Column(name = "active")
    private boolean active;
    @Column(name = "ngayDangSP")
    private Date ngayDangSP;
}
