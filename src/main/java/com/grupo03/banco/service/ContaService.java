package com.grupo03.banco.service;

import com.grupo03.banco.model.Conta;
import com.grupo03.banco.model.response.RelacaoContasResponse;

import java.sql.SQLException;
import java.util.List;

public interface ContaService {

    boolean save(Conta entity, String fk) throws SQLException;

    Conta findByIdPessoa(String idPessoa);

    List<RelacaoContasResponse> findAllJoinPessoa();

}