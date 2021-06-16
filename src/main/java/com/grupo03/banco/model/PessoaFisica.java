package com.grupo03.banco.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PessoaFisica extends Pessoa {
    private Long Pessoa_id;
    private String cpf;
    private String rg;

    public PessoaFisica(Long Pessoa_id, String nome, String telefone, String rua, String numeroEndereco, String bairro, String cidade, String estado, String dataNascimento, String sexo, String cpf, String rg) {
        super(Pessoa_id, nome, telefone, rua, numeroEndereco, bairro, cidade, estado, sexo, dataNascimento);
        this.cpf = cpf;
        this.rg = rg;
    }

}