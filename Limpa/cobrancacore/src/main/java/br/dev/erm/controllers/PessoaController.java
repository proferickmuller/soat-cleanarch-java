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

    public PessoaController create(CobrancaDataSource dataSource) {
        return new PessoaController(dataSource);
    }

    public NovaPessoaResponse novaPessoa(NovaPessoaRequest request) {
        PessoaGateway gateway = new PessoaGateway(dataSource);
        NovaPessoaUseCase useCase = new NovaPessoaUseCase(gateway);
        var novaPessoa = useCase.run(request.nome(), request.identificacao());
        return PessoaPresenter.toResponse(novaPessoa);
    }

}
