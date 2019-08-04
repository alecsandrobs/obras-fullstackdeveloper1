package com.alecsandro.obras.model;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "OBRA_ETAPAS")
@SequenceGenerator(name = "OBRA_ETAPAS_SEQ", sequenceName = "OBRA_ETAPAS_SEQ", allocationSize = 1)
public class ObraEtapa implements Entidade {

    @Id
    @Column(name = "ID_ETAPA")
    @GeneratedValue(generator = "OBRA_ETAPAS_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @Column(name = "DESCRICAO")
    @Size(min = 1, max = 255, message = "{ObraEtapa.descricao.size}")
    private String descricao;

    @Column(name = "OBSERVACOES")
    @Size(min = 1, max = 2000, message = "{ObraEtapa.observacoes.size}")
    private String observacoes;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
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
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.descricao);
        hash = 23 * hash + Objects.hashCode(this.observacoes);
        hash = 23 * hash + Objects.hashCode(this.total);
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
        final ObraEtapa other = (ObraEtapa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.observacoes, other.observacoes)) {
            return false;
        }
        if (!Objects.equals(this.total, other.total)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ObraEtapas{" + "id=" + id + ", descricao=" + descricao + ", observacoes=" + observacoes + ", total=" + total + '}';
    }

}
