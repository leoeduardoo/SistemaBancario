package com.grupo03.banco.service;

import com.grupo03.banco.service.impl.PessoaFisicaServiceImpl;

public class ServiceFactory {

    private ServiceFactory() {

    }

    public static PessoaFisicaService getPessoaFisicaService() {
        return new PessoaFisicaServiceImpl();
    }

}