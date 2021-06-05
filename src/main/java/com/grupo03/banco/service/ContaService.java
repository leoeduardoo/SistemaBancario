package com.grupo03.banco.service;

import com.grupo03.banco.model.Conta;

import java.sql.SQLException;

public interface ContaService {

    boolean save(Conta entity, String fk) throws SQLException;

    Conta findByIdPessoa(String idPessoa);

}