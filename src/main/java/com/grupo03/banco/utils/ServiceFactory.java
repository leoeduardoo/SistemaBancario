package com.grupo03.banco.utils;

import com.grupo03.banco.service.ContaService;
import com.grupo03.banco.service.PessoaFisicaService;
import com.grupo03.banco.service.PessoaJuridicaService;
import com.grupo03.banco.service.impl.ContaServiceImpl;
import com.grupo03.banco.service.impl.PessoaFisicaServiceImpl;
import com.grupo03.banco.service.impl.PessoaJuridicaServiceImpl;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ServiceFactory {

    public static PessoaJuridicaService getPessoaJuridicaService() {
        return new PessoaJuridicaServiceImpl();
    }

    public static PessoaFisicaService getPessoaFisicaService() {
        return new PessoaFisicaServiceImpl();
    }

    public static ContaService getContaService() {
        return new ContaServiceImpl();
    }

}