/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "maquina")
@NamedQueries({
    @NamedQuery(name = "Maquina.findAll", query = "SELECT m FROM Maquina m")})
public class Maquina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_maquina")
    private Integer idMaquina;
    @Column(name = "nome_maquina")
    private String nomeMaquina;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_hora")
    private Double valorHora;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maquina")
    private List<PedidoHasMaquina> pedidoHasMaquinaList;

    public Maquina() {
    }

    public Maquina(Integer idMaquina) {
        this.idMaquina = idMaquina;
    }

    public Integer getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Integer idMaquina) {
        this.idMaquina = idMaquina;
    }

    public String getNomeMaquina() {
        return nomeMaquina;
    }

    public void setNomeMaquina(String nomeMaquina) {
        this.nomeMaquina = nomeMaquina;
    }

    public Double getValorHora() {
        return valorHora;
    }

    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }

    public List<PedidoHasMaquina> getPedidoHasMaquinaList() {
        return pedidoHasMaquinaList;
    }

    public void setPedidoHasMaquinaList(List<PedidoHasMaquina> pedidoHasMaquinaList) {
        this.pedidoHasMaquinaList = pedidoHasMaquinaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMaquina != null ? idMaquina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maquina)) {
            return false;
        }
        Maquina other = (Maquina) object;
        if ((this.idMaquina == null && other.idMaquina != null) || (this.idMaquina != null && !this.idMaquina.equals(other.idMaquina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Maquina[ idMaquina=" + idMaquina + " ]";
    }
    
}
