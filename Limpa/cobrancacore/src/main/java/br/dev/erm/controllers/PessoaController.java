package br.dev.erm.controllers;

import br.dev.erm.common.interfaces.CobrancaDataSource;
import br.dev.erm.controllers.data.NovaPessoaRequest;
import br.dev.erm.controllers.data.NovaPessoaResponse;
import br.dev.erm.gateways.PessoaGateway;
import br.dev.erm.presenters.PessoaPresenter;
import br.dev.erm.usecases.NovaPessoaUseCase;

public class PessoaController {

    private final CobrancaDataSource dataSource;

    private PessoaController(CobrancaDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static PessoaController create(CobrancaDataSource dataSource) {
        // validar se o banco de dados conecta
        dataSource.ping();
        return new PessoaController(dataSource);
    }

    public NovaPessoaResponse novaPessoa(String nome, String identificacao) {
        NovaPessoaRequest r = new NovaPessoaRequest(nome, identificacao);
        return this.novaPessoa(r);
    }

    public NovaPessoaResponse novaPessoa(NovaPessoaRequest request) {
        PessoaGateway pessoaGateway = new PessoaGateway(this.dataSource);
        NovaPessoaUseCase useCase = new NovaPessoaUseCase(pessoaGateway);
        var novaPessoa = useCase.run(request.nome(), request.identificacao());
        return PessoaPresenter.toResponse(novaPessoa);
    }

}
