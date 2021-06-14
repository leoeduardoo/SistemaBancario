package com.grupo03.banco.service;

import com.grupo03.banco.model.PessoaJuridica;

public interface PessoaJuridicaService {

    boolean save(PessoaJuridica entity);

    PessoaJuridica findByCnpj(String cnpj);

}