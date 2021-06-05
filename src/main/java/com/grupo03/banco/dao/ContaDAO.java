package com.grupo03.banco.dao;

import com.grupo03.banco.model.Conta;

import java.sql.SQLException;

public interface ContaDAO {

    final String INSERT_CONTA = "INSERT INTO Conta(saldo, numero, dataAberturaConta, tipoConta, Pessoa_id) VALUES(?, ?, ?, ?, ?)";

    final String FIND_BY_ID_PESSOA = "SELECT c.id, c.saldo, c.numero, c.dataAberturaConta, c.tipoConta "
            + "FROM conta c "
            + "WHERE c.Pessoa_id = ?";

    public boolean save(Conta conta, String fk) throws SQLException;

    public Conta findByIdPessoa(String idPessoa);

}