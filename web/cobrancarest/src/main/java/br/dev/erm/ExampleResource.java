package br.dev.erm;

import br.dev.erm.controllers.PessoaController;
import br.dev.erm.controllers.data.NovaPessoaRequest;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class ExampleResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        var greeter = new br.dev.erm.common.HelloGreeter();
        return greeter.greet();
    }

    @POST("/pessoa")
    @Produces(MediaType.APPLICATION_JSON)
    public NovaPessoaOutput novaPessoa(NovaPessoaInput npi) {

        TextDataSource tds = TextDataSource.create("pessoas.txt");
        PessoaController pc = PessoaController.create(tds);
        var p = new NovaPessoaRequest(npi.nome(), npi.identificacao());
        var pessoaRetorno = pc.novaPessoa(p);
        return new NovaPessoaOutput(pessoaRetorno.nome(), pessoaRetorno.identificacao());

    }
}
