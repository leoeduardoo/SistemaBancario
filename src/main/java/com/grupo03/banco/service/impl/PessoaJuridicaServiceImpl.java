package com.grupo03.banco.service.impl;

import com.grupo03.banco.dao.DaoFactory;
import com.grupo03.banco.dao.PessoaJuridicaDAO;
import com.grupo03.banco.model.PessoaFisica;
import com.grupo03.banco.model.PessoaJuridica;
import com.grupo03.banco.service.PessoaJuridicaService;

public class PessoaJuridicaServiceImpl implements PessoaJuridicaService {

    private PessoaJuridicaDAO pessoaJuridicaDAO;

    public PessoaJuridicaServiceImpl() {
        this.pessoaJuridicaDAO = DaoFactory.getPessoaJuridicaDAO();
    }

    @Override
    public boolean save(PessoaJuridica entity) {
        boolean b = false;

        if (entity != null) {
            b = this.pessoaJuridicaDAO.save(entity);
        }

        return b;
    }

    @Override
    public PessoaJuridica findByCnpj(String cnpj) {
        return this.pessoaJuridicaDAO.findByCnpj(cnpj);
    }

}