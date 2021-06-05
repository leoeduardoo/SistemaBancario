package com.grupo03.banco.service.impl;

import com.grupo03.banco.dao.ContaDAO;
import com.grupo03.banco.dao.DaoFactory;
import com.grupo03.banco.model.Conta;
import com.grupo03.banco.service.ContaService;

import java.sql.Connection;
import java.sql.SQLException;

public class ContaServiceImpl implements ContaService {

    private ContaDAO contaDAO;

    public ContaServiceImpl() {
        this.contaDAO = DaoFactory.getContaDAO();
    }

    @Override
    public boolean save(Conta entity, String fk) throws SQLException {
        boolean b = false;

        if (entity != null) {
            b = this.contaDAO.save(entity, fk);
        }

        return b;
    }

    @Override
    public Conta findByIdPessoa(String idPessoa) {
        return this.contaDAO.findByIdPessoa(idPessoa);
    }

}