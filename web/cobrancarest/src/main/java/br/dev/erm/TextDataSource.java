package br.dev.erm;

import br.dev.erm.common.dto.PessoaDTO;
import br.dev.erm.common.interfaces.CobrancaDataSource;

public class TextDataSource implements CobrancaDataSource {

    private final String filepath;

    public static TextDataSource create(String filePath) {
        return new TextDataSource(filePath);
    }

    private TextDataSource(String filePath) {
        this.filepath = filePath;
    }

    @Override
    public PessoaDTO obterPessoaPorIdentificacao(String identificacao) {
        return null;
    }

    @Override
    public void novaPessoa(PessoaDTO p) {

    }

    @Override
    public void ping() {

    }
}
