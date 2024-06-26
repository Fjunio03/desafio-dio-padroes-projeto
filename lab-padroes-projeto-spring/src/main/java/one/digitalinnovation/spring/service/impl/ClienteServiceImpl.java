package one.digitalinnovation.spring.service.impl;

import one.digitalinnovation.spring.model.Cliente;
import one.digitalinnovation.spring.model.ClienteRepository;
import one.digitalinnovation.spring.model.Endereco;
import one.digitalinnovation.spring.model.EnderecoRepository;
import one.digitalinnovation.spring.service.ClienteService;
import one.digitalinnovation.spring.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional <Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(Long.valueOf(cep)).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);

        clienteRepository.save(cliente);

    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional <Cliente> clienteBD = clienteRepository.findById(id);
        if(clienteBD.isPresent()){
            String cep = cliente.getEndereco().getCep();
            Endereco endereco = enderecoRepository.findById(Long.valueOf(cep)).orElseGet(() -> {
                Endereco novoEndereco = viaCepService.consultarCep(cep);
                enderecoRepository.save(novoEndereco);
                return novoEndereco;
            });
            cliente.setEndereco(endereco);

            clienteRepository.save(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }
}
