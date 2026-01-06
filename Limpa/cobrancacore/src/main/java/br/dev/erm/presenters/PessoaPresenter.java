package br.dev.erm.presenters;

import br.dev.erm.common.dto.PessoaDTO;
import br.dev.erm.controllers.data.NovaPessoaResponse;
import br.dev.erm.entities.PessoaEntity;

public class PessoaPresenter {
    public static NovaPessoaResponse toResponse(PessoaEntity pe) {
        return new NovaPessoaResponse(pe.getNome(), pe.getIdentificacao());
    }

    public static PessoaDTO toDto(PessoaEntity pe) {
        return new PessoaDTO(pe.getNome(), pe.getIdentificacao());
    }
}
