package com.grupo03.banco.service;

import com.grupo03.banco.model.PessoaFisica;

public interface PessoaFisicaService {

    boolean save(PessoaFisica entity);

    PessoaFisica findByNome(String nome);

}