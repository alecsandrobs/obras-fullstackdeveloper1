package com.alecsandro.obras.model;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "PEDIDOS_FORNECEDOR_ITENS")
@SequenceGenerator(name = "PEDIDOS_FORNECEDOR_ITENS_SEQ", sequenceName = "PEDIDOS_FORNECEDOR_ITENS_SEQ", allocationSize = 1)
public class PedidoFornecedorItem implements Entidade {
    
    @Id
    @Column(name = "ID_PEDIDO_FORNECEDOR_ITEM")
    @GeneratedValue(generator = "PEDIDOS_FORNECEDOR_ITENS_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "ID_PRODUTO")
    private Produto produto;
    
    @NotNull
    @Digits(integer = 10, fraction = 5)
    @Column(name = "VL_UNITARIO", precision = 15, scale = 5)
    private BigDecimal valorUnitario;
    
    @NotNull
    @Digits(integer = 10, fraction = 5)
    @Column(name = "QUANTIDADE", precision = 15, scale = 5)
    private BigDecimal quantidade;
    
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

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
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
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.produto);
        hash = 23 * hash + Objects.hashCode(this.valorUnitario);
        hash = 23 * hash + Objects.hashCode(this.quantidade);
        hash = 23 * hash + Objects.hashCode(this.valorTotal);
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
        final PedidoFornecedorItem other = (PedidoFornecedorItem) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        if (!Objects.equals(this.valorUnitario, other.valorUnitario)) {
            return false;
        }
        if (!Objects.equals(this.quantidade, other.quantidade)) {
            return false;
        }
        if (!Objects.equals(this.valorTotal, other.valorTotal)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PedidoFornecedorItem{" + "id=" + id + ", produto=" + produto + ", valorUnitario=" + valorUnitario + ", quantidade=" + quantidade + ", valorTotal=" + valorTotal + '}';
    }
    
}
