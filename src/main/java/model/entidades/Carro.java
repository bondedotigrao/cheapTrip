package model.entidades;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Mark IV
 */
@Entity
@Table
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_carro;
    @Column(length = 15)
    private String marca;
    @Column(length = 3,nullable = false,updatable = true)
    private int vagas;
    @Column(length = 7,nullable = false)
    private String placa;
    
    @Deprecated
    public Carro() {
    }

    public Carro(String marca, int vagas, String placa) {
        this.marca = marca;
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
        int hash = 5;
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
        if (!Objects.equals(this.placa, other.placa)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Carro{" + "id_carro=" + id_carro + ", marca=" + marca + ", vagas=" + vagas + ", placa=" + placa + '}';
    }
    
    
}
