package com.grupo03.banco.dao;

import com.grupo03.banco.exception.SQLException;
import com.grupo03.banco.model.PessoaFisica;

public interface PessoaFisicaDAO {

    final String INSERT_PESSOA = "INSERT INTO Pessoa(nome, telefone, rua, numeroEndereco, bairro, cidade, estado, dataNascimento, sexo) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

    final String INSERT_PESSOA_FISICA = "INSERT INTO PessoaFisica(cpf, rg,  Pessoa_id) VALUES(?, ?, ?)";

    final String FIND_BY_CPF = "SELECT p.id, p.nome, p.telefone, p.rua, p.numeroEndereco, p.bairro, p.cidade, p.estado, p.dataNascimento, p.sexo, pf.cpf, pf.rg "
            + "FROM PessoaFisica pf "
            + "JOIN Pessoa p ON p.id = pf.Pessoa_id "
            + "WHERE pf.cpf = ?";

    public PessoaFisica findByCpf(String cpf) throws SQLException;

    public boolean save(PessoaFisica pessoaFisica) throws SQLException;

}