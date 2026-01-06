package br.dev.erm.usecases.exceptions;

public class NovaPessoaIdentificacaoJaExistenteException extends RuntimeException {
    public NovaPessoaIdentificacaoJaExistenteException(String message) {
        super(message);
    }
}
