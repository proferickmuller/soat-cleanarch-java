package br.dev.erm.usecases;

import br.dev.erm.entities.PessoaEntity;
import br.dev.erm.gateways.PessoaGateway;
import br.dev.erm.gateways.exceptions.PessoaGatewayError;
import br.dev.erm.usecases.exceptions.NovaPessoaIdentificacaoJaExistenteException;
import br.dev.erm.usecases.exceptions.NovaPessoaOperationException;

public class NovaPessoaUseCase {
    PessoaGateway pessoaGateway;

    public NovaPessoaUseCase(PessoaGateway pessoaGateway) {
        this.pessoaGateway = pessoaGateway;
    }

    public PessoaEntity run(
            String nome,
            String identificacao
    ) {
        PessoaEntity pessoa = pessoaGateway.porIdentificacao(identificacao);
        if (pessoa != null) {
            throw new NovaPessoaIdentificacaoJaExistenteException(
                    "Identificação já existente: " + identificacao
            );
        }

        PessoaEntity novaPessoa = new PessoaEntity();
        novaPessoa.setNome(nome);
        novaPessoa.setIdentificacao(identificacao);

        try {
            pessoaGateway.registrar(novaPessoa);
        }
        catch (PessoaGatewayError e) {
            // gravar o erro no log aqui se necessário
            throw new NovaPessoaOperationException("Erro ao salvar nova pessoa: " + e.getMessage());
        }

        return novaPessoa;
    }
}