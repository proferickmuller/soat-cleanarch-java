package br.dev.erm.entities;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PessoaEntity {

    public String nome;
    public String identificacao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }
}
