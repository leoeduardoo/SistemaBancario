package com.grupo03.banco.utils;

import com.grupo03.banco.model.PessoaFisica;
import com.grupo03.banco.model.request.PessoaFisicaRequest;

public class InstanceGenerator {

    private InstanceGenerator() {
    }

    public static PessoaFisica getPessoaFisica(PessoaFisicaRequest pessoaFisicaRequest) {
        PessoaFisica f = new PessoaFisica();

        f.setNome(pessoaFisicaRequest.getNome());
        f.setTelefone(pessoaFisicaRequest.getTelefone());
        f.setRua(pessoaFisicaRequest.getRua());
        f.setNumeroEndereco(pessoaFisicaRequest.getNumeroEndereco());
        f.setBairro(pessoaFisicaRequest.getBairro());
        f.setCidade(pessoaFisicaRequest.getCidade());
        f.setEstado(pessoaFisicaRequest.getEstado());
        f.setDataNascimento(pessoaFisicaRequest.getDataNascimento());
        f.setSexo(pessoaFisicaRequest.getSexo());
        f.setCpf(pessoaFisicaRequest.getCpf());
        f.setRg(pessoaFisicaRequest.getRg());

        return f;
    }

}