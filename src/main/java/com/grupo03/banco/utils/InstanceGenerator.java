package com.grupo03.banco.utils;

import com.grupo03.banco.model.Conta;
import com.grupo03.banco.model.PessoaFisica;
import com.grupo03.banco.model.request.ContaRequest;
import com.grupo03.banco.model.request.PessoaFisicaRequest;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
public class InstanceGenerator {

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

    public static Conta getConta(ContaRequest contaRequest) {
        Conta c = new Conta();

        c.setSaldo(BigDecimal.ZERO);
        c.setNumero(String.valueOf((1 + (int) (Math.random() * ((9999999 - 1) + 1)))));
        c.setDataAberturaConta(LocalDate.now().toString());
        c.setTipoConta(contaRequest.getTipoConta());

        return c;
    }

}