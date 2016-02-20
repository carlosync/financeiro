package com.financeiro.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.Past;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "lancamento")
public class Lancamento implements Serializable{
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer id;
    
    @NotEmpty
    @Column(name = "descricao")
    private String descricao;
    
    @Column(name = "valor")
    private BigDecimal valor;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "data_vencimento")
    private Date dataVencimento;
    
    @Column(name = "pago")
    private boolean pago;
    
    //@Past(message = "Data de Pagamento não pode ser uma data futura")
    @Temporal(TemporalType.DATE)
    @Column(name = "data_pagamento")
    private Date dataPagamento;
    
    @ManyToOne
    @JoinColumn(name = "cod_pessoa", nullable = false)
    private Pessoa pessoa;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_lancamento")
    private TipoLancamento tipoLancamento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public TipoLancamento getTipoLancamento() {
        return tipoLancamento;
    }

    public void setTipoLancamento(TipoLancamento tipoLancamento) {
        this.tipoLancamento = tipoLancamento;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final Lancamento other = (Lancamento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
   
}
