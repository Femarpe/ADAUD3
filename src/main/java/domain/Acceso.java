package domain;

import javax.persistence.*;

@Entity
@Table(name = "Acceso")
public class Acceso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idacceso")
    private int idacceso;
    @Column(name = "idlogin")
    private int idlogin;
    @Column(name = "idficha")
    private int idficha;

    public int getIdacceso() {
        return idacceso;
    }

    public void setIdacceso(int idacceso) {
        this.idacceso = idacceso;
    }

    public int getIdlogin() {
        return idlogin;
    }

    public void setIdlogin(int idlogin) {
        this.idlogin = idlogin;
    }

    public int getIdficha() {
        return idficha;
    }

    public void setIdficha(int idficha) {
        this.idficha = idficha;
    }
}
