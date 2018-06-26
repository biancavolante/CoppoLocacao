/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "pedido")
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p")})
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_pedido")
    private Integer idPedido;
    @Column(name = "data_pedido")
    @Temporal(TemporalType.DATE)
    private Date dataPedido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
    private List<PedidoHasMaquina> pedidoHasMaquinaList;
    @JoinColumn(name = "cliente_rg", referencedColumnName = "rg")
    @ManyToOne(optional = false)
    private Cliente clienteRg;
    @JoinColumn(name = "funcionario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Funcionario funcionarioId;

    public Pedido() {
    }

    public Pedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public List<PedidoHasMaquina> getPedidoHasMaquinaList() {
        return pedidoHasMaquinaList;
    }

    public void setPedidoHasMaquinaList(List<PedidoHasMaquina> pedidoHasMaquinaList) {
        this.pedidoHasMaquinaList = pedidoHasMaquinaList;
    }

    public Cliente getClienteRg() {
        return clienteRg;
    }

    public void setClienteRg(Cliente clienteRg) {
        this.clienteRg = clienteRg;
    }

    public Funcionario getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Funcionario funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedido != null ? idPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.idPedido == null && other.idPedido != null) || (this.idPedido != null && !this.idPedido.equals(other.idPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Pedido[ idPedido=" + idPedido + " ]";
    }
    
}
