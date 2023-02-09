package ptit.suwoo.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@AllArgsConstructor

@NoArgsConstructor
@Data
@ToString
@Table(name = "slider")
public class Slider implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "url")
    private String url;
    @Column(name = "content")
    private String content;

    @Column(name = "ngayTao")
    private Timestamp ngayTao;

}
