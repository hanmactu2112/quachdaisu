package ptit.suwoo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "dtbonho")
public class DTBoNho {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "ram")
    private int ram;
    @Column(name = "rom")
    private int rom;
}
