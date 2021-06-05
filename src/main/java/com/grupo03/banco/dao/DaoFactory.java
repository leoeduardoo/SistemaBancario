package com.grupo03.banco.dao;

import com.grupo03.banco.dao.impl.PessoaFisicaDAOImpl;

public class DaoFactory {

    private DaoFactory() {
    }

    public static PessoaFisicaDAO getPessoaFisicaDAO() {
        return new PessoaFisicaDAOImpl();
    }

}