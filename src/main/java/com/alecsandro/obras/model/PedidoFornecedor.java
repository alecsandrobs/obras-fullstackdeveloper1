package com.alecsandro.obras.model;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "PEDIDOS_FORNECEDOR")
@SequenceGenerator(name = "PEDIDOS_FORNECEDOR_SEQ", sequenceName = "PEDIDOS_FORNECEDOR_SEQ", allocationSize = 1)
public class PedidoFornecedor implements Entidade {

    @Id
    @Column(name = "ID_PEDIDO_FORNECEDOR")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PEDIDOS_FORNECEDOR_SEQ")
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ID_FORNECEDOR")
    private Fornecedor fornecedor;

    @NotNull
    @Column(name = "DT_EMISSAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date emissao;

    @Column(name = "DT_APROVACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date aprovacao;

    @JoinColumn(name = "ID_PEDIDO_FORNECEDOR")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PedidoFornecedorItem> itens;

    @NotNull
    @Digits(integer = 10, fraction = 5)
    @Column(name = "VL_TOTAL", precision = 15, scale = 5)
    private BigDecimal valorTotal;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Date getEmissao() {
        return emissao;
    }

    public void setEmissao(Date emissao) {
        this.emissao = emissao;
    }

    public Date getAprovacao() {
        return aprovacao;
    }

    public void setAprovacao(Date aprovacao) {
        this.aprovacao = aprovacao;
    }

    public List<PedidoFornecedorItem> getItens() {
        return itens;
    }

    public void setItens(List<PedidoFornecedorItem> itens) {
        this.itens = itens;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.fornecedor);
        hash = 67 * hash + Objects.hashCode(this.emissao);
        hash = 67 * hash + Objects.hashCode(this.aprovacao);
        hash = 67 * hash + Objects.hashCode(this.itens);
        return 67 * hash + Objects.hashCode(this.valorTotal);
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
        final PedidoFornecedor other = (PedidoFornecedor) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.fornecedor, other.fornecedor)) {
            return false;
        }
        if (!Objects.equals(this.emissao, other.emissao)) {
            return false;
        }
        if (!Objects.equals(this.aprovacao, other.aprovacao)) {
            return false;
        }
        if (!Objects.equals(this.itens, other.itens)) {
            return false;
        }
        return Objects.equals(this.valorTotal, other.valorTotal);
    }

    @Override
    public String toString() {
        return "PedidoFornecedor{" + "id=" + id + ", fornecedor=" + fornecedor + ", emissao=" + emissao + ", aprovacao=" + aprovacao + ", itens=" + itens + ", valorTotal=" + valorTotal + "}";
    }
}
