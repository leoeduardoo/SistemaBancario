package com.grupo03.banco.service;

import com.grupo03.banco.model.PessoaFisica;
import com.grupo03.banco.model.request.PessoaFisicaRequest;
import com.grupo03.banco.model.response.PessoaFisicaResponse;
import com.grupo03.banco.utils.InstanceGenerator;
import com.grupo03.banco.utils.Mapper;
import org.springframework.stereotype.Service;

@Service
public class BancoService {

    public PessoaFisicaResponse cadastrarPessoaFisica(PessoaFisicaRequest pessoaFisicaRequest) {

        PessoaFisicaService fs = ServiceFactory.getPessoaFisicaService();

        /*
         * Consulta uma pessoa física pelo cpf
         */
        PessoaFisica f = fs.findByNome(pessoaFisicaRequest.getNome());

        if (f == null) {

            /*
             * Gera uma instância a ser persistida
             */
            PessoaFisica fisica = InstanceGenerator.getPessoaFisica(pessoaFisicaRequest);

            /*
             * Persiste o objeto no banco de dados
             */
            if (fs.save(fisica)) {
                return Mapper.INSTANCE.pessoaFisicaToResponse(fisica);
            }

        }

        return Mapper.INSTANCE.pessoaFisicaToResponse(f);

    }
}
