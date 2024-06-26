package one.digitalinnovation.gof.src.one.digitalinnovation.gof.facade;

import one.digitalinnovation.gof.src.subsistema.crm.CrmService;
import one.digitalinnovation.gof.src.subsistema2.cep.CepApi;

public class Facade {
    public void migrarCliente(String nome, String cep){
        String cidade = CepApi.getInstancia().recuperarCidade(cep);
        String estado = CepApi.getInstancia().recuperarEstado(cep);

        CrmService.gravarCliente(nome, cep, cidade, estado);
    }
}
