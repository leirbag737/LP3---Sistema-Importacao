package com.example.sistemaimportacao.services;

import com.example.sistemaimportacao.model.Cliente;
import com.example.sistemaimportacao.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    public List<Cliente> realizaImportacao(String path) {
        return clienteRepository.saveAll(carregaClientes(path));
    }

    // realiza a leitura do arquivo
    // converte cada linha do arquivo em Cliente
    private List<Cliente> carregaClientes(String path) {

        List<Cliente> listaCliente;

        // usa a API NIO 2 para ler o arquivo
        // o resultado é um Stream<String>
        try (var linhasArquivos = Files.lines(Path.of(path));) {

            listaCliente = new ArrayList<>();

            // pega cada linha do arquivo e instancia um Cliente, adicionando-o em uma lista
            linhasArquivos.forEach(linha -> {
                try {
                    listaCliente.add(new Cliente(linha.split(",")));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return listaCliente;
    }
}