package br.dev.erm.gateways;

import br.dev.erm.common.dto.PessoaDTO;
import br.dev.erm.common.interfaces.CobrancaDataSource;
import br.dev.erm.entities.PessoaEntity;
import br.dev.erm.gateways.exceptions.PessoaGatewayError;

public class PessoaGateway {

    private final CobrancaDataSource dataSource;

    public PessoaGateway(CobrancaDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public PessoaEntity porIdentificacao(String identificacao) throws PessoaGatewayError {
        PessoaDTO pessoaDTO = dataSource.obterPessoaPorIdentificacao(identificacao);
        if (pessoaDTO == null) {
            return null;
        }
        PessoaEntity pessoaEntity = new PessoaEntity();
        pessoaEntity.setNome(pessoaDTO.nome());
        pessoaEntity.setIdentificacao(pessoaDTO.identificacao());

        return pessoaEntity;
    }

    public void registrar(PessoaEntity novaPessoa) throws PessoaGatewayError {
        PessoaDTO p = new PessoaDTO(
                novaPessoa.getNome(),
                novaPessoa.getIdentificacao()
        );
        dataSource.novaPessoa(p);
    }
}
