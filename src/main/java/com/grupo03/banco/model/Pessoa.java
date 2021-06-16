package com.grupo03.banco.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Pessoa {
    private Long id;
    private String nome;
    private String telefone;
    private String rua;
    private String numeroEndereco;
    private String bairro;
    private String cidade;
    private String estado;
    private String dataNascimento;
    private String sexo;
}