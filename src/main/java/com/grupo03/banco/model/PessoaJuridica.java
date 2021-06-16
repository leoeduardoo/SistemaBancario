package com.grupo03.banco.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaJuridica extends Pessoa {
    private Long Pessoa_id;
    private String cnpj;
    private String ie;

    public PessoaJuridica(Long Pessoa_id, String nome, String telefone, String rua, String numeroEndereco, String bairro, String cidade, String estado, String dataNascimento, String sexo, String cnpj, String ie) {
        super(Pessoa_id, nome, telefone, rua, numeroEndereco, bairro, cidade, estado, sexo, dataNascimento);
        this.cnpj = cnpj;
        this.ie = ie;
    }

}