package domain;

import javax.persistence.*;

@Entity
@Table(name = "fichasper")
public class Ficha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpersonaje")
    private int idpersonaje;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "nivel")
    private int nivel;
    @Column(name = "clase")
    private String clase;
    @Column(name = "raza")
    private String raza;
    @Column(name = "alin")
    private String alin;
    @Column(name = "transfondo")
    private String transfondo;

    /**
     @OneToOne(mappedBy = "Tramite", cascade = CascadeType.REMOVE)
     private Presupuesto presupuesto;
     m*/

    public int getIdpersonaje() {
        return idpersonaje;
    }

    public void setIdpersonaje(int idpersonaje) {
        this.idpersonaje = idpersonaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getAlin() {
        return alin;
    }

    public void setAlin(String alin) {
        this.alin = alin;
    }

    public String getTransfondo() {
        return transfondo;
    }

    public void setTransfondo(String transfondo) {
        this.transfondo = transfondo;
    }
}
