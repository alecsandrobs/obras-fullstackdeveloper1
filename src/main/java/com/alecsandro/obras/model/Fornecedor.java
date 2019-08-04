package com.alecsandro.obras.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "FORNECEDORES")
@SequenceGenerator(name = "FORNECEDORES_SEQ", sequenceName = "FORNECEDORES_SEQ", allocationSize = 1)
public class Fornecedor implements Entidade {

    @Id
    @Column(name = "ID_FORNECEDOR")
    @GeneratedValue(generator = "FORNECEDORES_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "NOME")
    @NotNull(message = "{Fornecedor.nome.NotNull}")
    @Size(min = 5, max = 250, message = "{Fornecedor.nome.Size}")
    private String nome;

    @Column(name = "TELEFONE")
    @Size(min = 9, max = 20, message = "{Fornecedor.telefone.Size}")
    private String telefone;

    @Column(name = "EMAIL")
    @Size(max = 150, message = "{Fornecedor.email.Size}")
    private String email;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.nome);
        hash = 83 * hash + Objects.hashCode(this.telefone);
        hash = 83 * hash + Objects.hashCode(this.email);
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
        final Fornecedor other = (Fornecedor) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fornecedor{" + "id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email + '}';
    }
}
