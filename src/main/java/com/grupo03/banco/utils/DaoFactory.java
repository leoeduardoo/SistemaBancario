package com.grupo03.banco.utils;

import com.grupo03.banco.dao.ContaDAO;
import com.grupo03.banco.dao.PessoaFisicaDAO;
import com.grupo03.banco.dao.PessoaJuridicaDAO;
import com.grupo03.banco.dao.impl.ContaDAOImpl;
import com.grupo03.banco.dao.impl.PessoaFisicaDAOImpl;
import com.grupo03.banco.dao.impl.PessoaJuridicaDAOImpl;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DaoFactory {

    public static PessoaJuridicaDAO getPessoaJuridicaDAO() {
        return new PessoaJuridicaDAOImpl();
    }

    public static PessoaFisicaDAO getPessoaFisicaDAO() {
        return new PessoaFisicaDAOImpl();
    }

    public static ContaDAO getContaDAO() {
        return new ContaDAOImpl();
    }

}