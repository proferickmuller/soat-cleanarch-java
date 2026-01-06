package br.dev.erm.common.interfaces;

import br.dev.erm.common.dto.PessoaDTO;

public interface CobrancaDataSource
{
    PessoaDTO obterPessoaPorIdentificacao(String identificacao);
    void novaPessoa(PessoaDTO p);
}
