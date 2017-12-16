package model.entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Mark IV
 */
@Entity
@ManagedBean(name = "car")
@ViewScoped
public class Carro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_carro;
    @Column(length = 15)
    private String marca;
    @Column(length = 12,nullable = true)
    private String modelo;
    @Column(length = 3,nullable = false,updatable = true)
    private int vagas;
    @Column(length = 7,nullable = false,unique = true)
    private String placa;
    
    @Deprecated
    public Carro() {
    }

    public Carro(String marca, String modelo, int vagas, String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.vagas = vagas;
        this.placa = placa;
    }

    public int getId_carro() {
        return id_carro;
    }

    public void setId_carro(int id_carro) {
        this.id_carro = id_carro;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.id_carro;
        hash = 53 * hash + Objects.hashCode(this.marca);
        hash = 53 * hash + Objects.hashCode(this.modelo);
        hash = 53 * hash + this.vagas;
        hash = 53 * hash + Objects.hashCode(this.placa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carro other = (Carro) obj;
        if (this.id_carro != other.id_carro) {
            return false;
        }
        if (this.vagas != other.vagas) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        if (!Objects.equals(this.placa, other.placa)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Carro{" + "id_carro=" + id_carro + ", marca=" + marca + ", modelo=" + modelo + ", vagas=" + vagas + ", placa=" + placa + '}';
    }

    
}
