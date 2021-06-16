package com.grupo03.banco.service.impl;

import com.grupo03.banco.exception.SQLException;
import com.grupo03.banco.utils.DaoFactory;
import com.grupo03.banco.dao.PessoaFisicaDAO;
import com.grupo03.banco.model.PessoaFisica;
import com.grupo03.banco.service.PessoaFisicaService;
import org.springframework.stereotype.Service;

@Service
public class PessoaFisicaServiceImpl implements PessoaFisicaService {

    private PessoaFisicaDAO pessoaFisicaDAO;

    public PessoaFisicaServiceImpl() {
        this.pessoaFisicaDAO = DaoFactory.getPessoaFisicaDAO();
    }

    @Override
    public boolean save(PessoaFisica entity) throws SQLException {
        boolean b = false;

        if (entity != null) {
            b = this.pessoaFisicaDAO.save(entity);
        }

        return b;
    }

    @Override
    public PessoaFisica findByCpf(String cpf) throws SQLException {
        return this.pessoaFisicaDAO.findByCpf(cpf);
    }

}