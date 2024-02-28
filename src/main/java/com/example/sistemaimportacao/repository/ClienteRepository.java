package com.example.sistemaimportacao.repository;

import com.example.sistemaimportacao.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
