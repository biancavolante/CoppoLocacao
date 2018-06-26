/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "pedido_has_maquina")
@NamedQueries({
    @NamedQuery(name = "PedidoHasMaquina.findAll", query = "SELECT p FROM PedidoHasMaquina p")})
public class PedidoHasMaquina implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PedidoHasMaquinaPK pedidoHasMaquinaPK;
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Column(name = "hora_inicio")
    @Temporal(TemporalType.TIME)
    private Date horaInicio;
    @Column(name = "hora_fim")
    @Temporal(TemporalType.TIME)
    private Date horaFim;
    @JoinColumn(name = "maquina_id_maquina", referencedColumnName = "id_maquina", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Maquina maquina;
    @JoinColumn(name = "pedido_id_pedido", referencedColumnName = "id_pedido", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pedido pedido;

    public PedidoHasMaquina() {
    }

    public PedidoHasMaquina(PedidoHasMaquinaPK pedidoHasMaquinaPK) {
        this.pedidoHasMaquinaPK = pedidoHasMaquinaPK;
    }

    public PedidoHasMaquina(int pedidoIdPedido, int maquinaIdMaquina) {
        this.pedidoHasMaquinaPK = new PedidoHasMaquinaPK(pedidoIdPedido, maquinaIdMaquina);
    }

    public PedidoHasMaquinaPK getPedidoHasMaquinaPK() {
        return pedidoHasMaquinaPK;
    }

    public void setPedidoHasMaquinaPK(PedidoHasMaquinaPK pedidoHasMaquinaPK) {
        this.pedidoHasMaquinaPK = pedidoHasMaquinaPK;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(Date horaFim) {
        this.horaFim = horaFim;
    }

    public Maquina getMaquina() {
        return maquina;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pedidoHasMaquinaPK != null ? pedidoHasMaquinaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedidoHasMaquina)) {
            return false;
        }
        PedidoHasMaquina other = (PedidoHasMaquina) object;
        if ((this.pedidoHasMaquinaPK == null && other.pedidoHasMaquinaPK != null) || (this.pedidoHasMaquinaPK != null && !this.pedidoHasMaquinaPK.equals(other.pedidoHasMaquinaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.PedidoHasMaquina[ pedidoHasMaquinaPK=" + pedidoHasMaquinaPK + " ]";
    }
    
}
