package com.grupo03.banco.service;

import com.grupo03.banco.exception.SQLException;
import com.grupo03.banco.model.Conta;
import com.grupo03.banco.model.response.RelacaoContasResponse;

import java.util.List;

public interface ContaService {

    boolean save(Conta entity, String fk) throws SQLException;

    boolean update(Conta entity) throws SQLException;

    Conta findByIdPessoa(String idPessoa) throws SQLException;

    Conta findByNumero(String numero) throws SQLException;

    List<RelacaoContasResponse> findAllJoinPessoa() throws SQLException;

}