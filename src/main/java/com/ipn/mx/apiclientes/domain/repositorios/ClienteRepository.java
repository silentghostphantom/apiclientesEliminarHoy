package com.ipn.mx.apiclientes.domain.repositorios;

import com.ipn.mx.apiclientes.domain.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
