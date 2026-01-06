package br.dev.erm.gateways.exceptions;

public class PessoaGatewayError extends RuntimeException {
    public PessoaGatewayError(String message) {
        super(message);
    }
}
