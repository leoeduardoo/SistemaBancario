package com.grupo03.banco.service;

import com.grupo03.banco.exception.SQLException;
import com.grupo03.banco.model.PessoaJuridica;

public interface PessoaJuridicaService {

    boolean save(PessoaJuridica entity) throws SQLException;

    PessoaJuridica findByCnpj(String cnpj) throws SQLException;

}