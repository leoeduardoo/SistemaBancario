package com.grupo03.banco.service.impl;

import com.grupo03.banco.dao.PessoaJuridicaDAO;
import com.grupo03.banco.exception.SQLException;
import com.grupo03.banco.model.PessoaJuridica;
import com.grupo03.banco.service.PessoaJuridicaService;
import com.grupo03.banco.utils.DaoFactory;
import org.springframework.stereotype.Service;

@Service
public class PessoaJuridicaServiceImpl implements PessoaJuridicaService {

    private PessoaJuridicaDAO pessoaJuridicaDAO;

    public PessoaJuridicaServiceImpl() {
        this.pessoaJuridicaDAO = DaoFactory.getPessoaJuridicaDAO();
    }

    @Override
    public boolean save(PessoaJuridica entity) throws SQLException {
        boolean b = false;

        if (entity != null) {
            b = this.pessoaJuridicaDAO.save(entity);
        }

        return b;
    }

    @Override
    public PessoaJuridica findByCnpj(String cnpj) throws SQLException {
        return this.pessoaJuridicaDAO.findByCnpj(cnpj);
    }

}