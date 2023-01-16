package ptit.suwoo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Getter
@Setter
@Table(name = "user_role")
public class UserRole  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private NguoiDung idUser;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_role",referencedColumnName = "id")
    private Role idRole;

    public NguoiDung getIdUser() {
        return idUser;
    }

    public void setIdUser(NguoiDung idUser) {
        this.idUser = idUser;
    }

    public Role getIdRole() {
        return idRole;
    }

    public void setIdRole(Role idRole) {
        this.idRole = idRole;
    }
}
