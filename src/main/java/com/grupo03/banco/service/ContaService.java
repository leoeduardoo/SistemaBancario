package com.grupo03.banco.service;

import com.grupo03.banco.model.Conta;
import com.grupo03.banco.model.response.RelacaoContasResponse;

import java.sql.SQLException;
import java.util.List;

public interface ContaService {

    boolean save(Conta entity, String fk) throws SQLException, com.grupo03.banco.exception.SQLException;

    Conta findByIdPessoa(String idPessoa) throws com.grupo03.banco.exception.SQLException;

    List<RelacaoContasResponse> findAllJoinPessoa() throws com.grupo03.banco.exception.SQLException;

}