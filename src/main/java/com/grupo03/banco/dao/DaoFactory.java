package com.grupo03.banco.dao;

import com.grupo03.banco.dao.impl.ContaDAOImpl;
import com.grupo03.banco.dao.impl.PessoaFisicaDAOImpl;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DaoFactory {

    public static PessoaFisicaDAO getPessoaFisicaDAO() {
        return new PessoaFisicaDAOImpl();
    }

    public static ContaDAO getContaDAO() {
        return new ContaDAOImpl();
    }

}