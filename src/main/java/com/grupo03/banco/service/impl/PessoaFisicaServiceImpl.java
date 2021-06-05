package com.grupo03.banco.service.impl;

import com.grupo03.banco.dao.DaoFactory;
import com.grupo03.banco.dao.PessoaFisicaDAO;
import com.grupo03.banco.model.PessoaFisica;
import com.grupo03.banco.service.PessoaFisicaService;

public class PessoaFisicaServiceImpl implements PessoaFisicaService {

    private PessoaFisicaDAO pessoaFisicaDAO;

    public PessoaFisicaServiceImpl() {
        this.pessoaFisicaDAO = DaoFactory.getPessoaFisicaDAO();
    }

    @Override
    public boolean save(PessoaFisica entity) {
        boolean b = false;

        if (entity != null) {
            b = this.pessoaFisicaDAO.save(entity);
        }

        return b;
    }

    @Override
    public PessoaFisica findByCpf(String cpf) {
        return this.pessoaFisicaDAO.findByCpf(cpf);
    }

}