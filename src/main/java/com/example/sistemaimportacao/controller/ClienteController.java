package com.example.sistemaimportacao.controller;

import com.example.sistemaimportacao.model.Cliente;
import com.example.sistemaimportacao.services.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> getAll() {
        return clienteService.getAll();
    }

    @PostMapping("/importar")
    public void realizaImportacao(@RequestParam String path) {
        clienteService.realizaImportacao(path);
    }
}