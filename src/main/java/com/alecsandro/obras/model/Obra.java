package com.alecsandro.obras.model;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "OBRAS")
@SequenceGenerator(name = "OBRAS_SEQ", sequenceName = "OBRAS_SEQ", allocationSize = 1)
public class Obra implements Entidade {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OBRAS_SEQ")
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente cliente;

    @NotNull
    @Column(name = "DATA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inicio;

    @Column(name = "DATA_TERMINO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date termino;

    @Column(name = "DESCRICAO")
    @Size(min = 1, max = 255, message = "{Obra.descricao.size}")
    private String descricao;

    @JoinColumn(name = "ID")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ObraEtapa> etapas;

    @NotNull
    @Digits(integer = 10, fraction = 5)
    @Column(name = "TOTAL", precision = 15, scale = 5)
    private BigDecimal total;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getTermino() {
        return termino;
    }

    public void setTermino(Date termino) {
        this.termino = termino;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<ObraEtapa> getEtapas() {
        return etapas;
    }

    public void setEtapas(List<ObraEtapa> etapas) {
        this.etapas = etapas;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.cliente);
        hash = 67 * hash + Objects.hashCode(this.inicio);
        hash = 67 * hash + Objects.hashCode(this.termino);
        hash = 67 * hash + Objects.hashCode(this.descricao);
        hash = 67 * hash + Objects.hashCode(this.etapas);
        return 67 * hash + Objects.hashCode(this.total);
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
        final Obra other = (Obra) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.inicio, other.inicio)) {
            return false;
        }
        if (!Objects.equals(this.termino, other.termino)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.etapas, other.etapas)) {
            return false;
        }
        if (!Objects.equals(this.total, other.total)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Obra{" + "id=" + id + ", cliente=" + cliente + ", inicio=" + inicio + ", termino=" + termino + ", descricao=" + descricao + ", etapas=" + etapas + ", total=" + total + '}';
    }
}
