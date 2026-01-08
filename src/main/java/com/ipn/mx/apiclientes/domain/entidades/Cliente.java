package com.ipn.mx.apiclientes.domain.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Cliente")
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;
    @Column(name = "paterno", length = 50, nullable = false)
    private String paterno;
    @Column(name = "materno", length = 50, nullable = false)
    private String materno;
    @Email(message = "Escribe un correo válido")
    @Column( name = "email", length = 150, nullable = false, unique = true)
    private String email;
}
