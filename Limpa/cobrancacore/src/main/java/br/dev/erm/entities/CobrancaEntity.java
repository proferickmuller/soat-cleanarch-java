package br.dev.erm.entities;

import br.dev.erm.entities.exceptions.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
public class CobrancaEntity {

    public String id;
    public Integer valor;
    public PessoaEntity sacado;
    public PessoaEntity cedente;
    public LocalDate dataRegistro;
    public LocalDate dataVencimento;

    public LocalDate dataPagamento;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (!validarFormatacaoId(id)) {
            throw new CobrancaIdInvalidoException("O formato do ID está inválido.");
        }
        this.id = id;
    }



    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        if (valor < 0) {
            throw new CobrancaValorInvalidoException("O valor deve ser maior que zero.");
        }
        this.valor = valor;
    }

    public PessoaEntity getSacado() {
        return sacado;
    }

    public void setSacado(PessoaEntity sacado) {
        if (sacado == null) {
            throw new CobrancaSacadoInvalidoException("O sacado não pode ser nulo.");
        }
        this.sacado = sacado;
    }

    public PessoaEntity getCedente() {
        return cedente;
    }

    public void setCedente(PessoaEntity cedente) {
        if (cedente == null) {
            throw new CobrancaCedenteInvalidoException("O cedente não pode ser nulo.");
        }
        this.cedente = cedente;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        if (dataRegistro == null) {
            throw new CobrancaDataRegistroInvalidoException("A data de registro não pode ser nula.");
        }
        if (dataRegistro.isBefore(LocalDate.now())) {
            throw new CobrancaDataRegistroInvalidoException("A data de registro não pode ser anterior a data atual.");
        }
        this.dataRegistro = dataRegistro;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        if (dataVencimento == null) {
            throw new CobrancaDataVencimentoInvalidoException("A data de registro não pode ser nula.");
        }
        if (dataVencimento.isBefore(LocalDate.now())) {
            throw new CobrancaDataVencimentoInvalidoException("A data de registro não pode ser anterior a data atual.");
        }
        if (dataVencimento.isBefore(this.dataRegistro)) {
            throw new CobrancaDataVencimentoInvalidoException("A data de vencimento não pode ser " +
                    "anterior a data de registro.");
        }
        this.dataVencimento = dataVencimento;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        if (dataPagamento != null) {
            if (dataPagamento.isBefore(this.dataRegistro)) {
                throw new CobrancaDataPagamentoInvalidoException("A data de pagamento " +
                        "não pode ser anterior a data de registro.");
            }
        }

        this.dataPagamento = dataPagamento;
    }

    /*** VALIDAÇÕES AUXILIARES ***/
    private boolean validarFormatacaoId(String id) {
        if (id.length() != 20) {
            return false;
        }
        // ... outras validações de formatação podem ser adicionadas aqui ...
        return true;
    }
}
