package com.ipn.mx.apiclientes.controller;

import com.ipn.mx.apiclientes.domain.entidades.Cliente;
import com.ipn.mx.apiclientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//Revisar el cross origin
@CrossOrigin (origins = "*")
@RestController
@RequestMapping("/apiClientes")
public class ClienteController {
    @Autowired
    private ClienteService service;

    @GetMapping("/clientes")
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> findAll()
    {
        return service.findAll();
    }

    @GetMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente findById(@PathVariable Long id)
    {
        return service.findById(id);
    }

    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public  Cliente save(@RequestBody Cliente cliente)
    {
        if(cliente.getIdCliente() != null){
            cliente.setIdCliente(null);
        }
        return service.save(cliente);
    }

    @PutMapping("/clientes/{id}")
    public  Cliente update(@RequestBody Cliente cliente, @PathVariable Long id)
    {
        Cliente clienteOriginal = service.findById(id);
        clienteOriginal.setNombre(cliente.getNombre());
        clienteOriginal.setPaterno(cliente.getPaterno());
        clienteOriginal.setMaterno(cliente.getMaterno());
        clienteOriginal.setEmail(cliente.getEmail());
        return service.save(clienteOriginal);

    }

    @DeleteMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id)
    {
        service.deleteById(id);
    }
}
