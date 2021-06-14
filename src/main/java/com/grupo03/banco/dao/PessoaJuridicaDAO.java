package com.grupo03.banco.dao;

import com.grupo03.banco.model.PessoaJuridica;

public interface PessoaJuridicaDAO {

    final String INSERT_PESSOA = "INSERT INTO Pessoa(nome, telefone, rua, numeroEndereco, bairro, cidade, estado, dataNascimento, sexo) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

    final String INSERT_PESSOA_JURIDICA = "INSERT INTO PessoaJuridica(cnpj, ie,  Pessoa_id) VALUES(?, ?, ?)";

    final String FIND_BY_CNPJ = "SELECT p.id, p.nome, p.telefone, p.rua, p.numeroEndereco, p.bairro, p.cidade, p.estado, p.dataNascimento, p.sexo, pj.cnpj, pj.ie "
            + "FROM PessoaJuridica pj "
            + "JOIN Pessoa p ON p.id = pj.Pessoa_id "
            + "WHERE pj.cnpj = ?";

    public PessoaJuridica findByCnpj(String cnpj);

    public boolean save(PessoaJuridica pessoaJuridica);

}