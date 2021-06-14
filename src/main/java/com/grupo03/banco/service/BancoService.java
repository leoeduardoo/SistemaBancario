package com.grupo03.banco.service;

import com.grupo03.banco.exception.ObjectNotFoundException;
import com.grupo03.banco.model.Conta;
import com.grupo03.banco.model.PessoaFisica;
import com.grupo03.banco.model.PessoaJuridica;
import com.grupo03.banco.model.request.ContaRequest;
import com.grupo03.banco.model.request.PessoaFisicaRequest;
import com.grupo03.banco.model.request.PessoaJuridicaRequest;
import com.grupo03.banco.model.response.ContaResponse;
import com.grupo03.banco.model.response.PessoaFisicaResponse;
import com.grupo03.banco.model.response.PessoaJuridicaResponse;
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
        PessoaFisica f = fs.findByCpf(pessoaFisicaRequest.getCpf());

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

    public PessoaJuridicaResponse cadastrarPessoaJuridica(PessoaJuridicaRequest pessoaJuridicaRequest) {

        PessoaJuridicaService js = ServiceFactory.getPessoaJuridicaService();

        /*
         * Consulta uma pessoa juridica pelo cnpj
         */
        PessoaJuridica j = js.findByCnpj(pessoaJuridicaRequest.getCnpj());

        if (j == null) {

            /*
             * Gera uma instância a ser persistida
             */
            PessoaJuridica juridica = InstanceGenerator.getPessoaJuridica(pessoaJuridicaRequest);

            /*
             * Persiste o objeto no banco de dados
             */
            if (js.save(juridica)) {
                return Mapper.INSTANCE.pessoaJuridicaToResponse(juridica);
            }
        }

        return Mapper.INSTANCE.pessoaJuridicaToResponse(j);
    }

    public ContaResponse cadastrarConta(ContaRequest contaRequest) throws Exception {

        PessoaFisicaService fs = ServiceFactory.getPessoaFisicaService();
        PessoaJuridicaService js = ServiceFactory.getPessoaJuridicaService();

        /*
         * Consulta uma pessoa pelo cpf ou cnpj
         */
        PessoaFisica f = fs.findByCpf(contaRequest.getDocumentoCliente());
        PessoaJuridica j = js.findByCnpj(contaRequest.getDocumentoCliente());
        //todo consultar tbm pelo cnpj, mas pra isso implementar a parte de juridica

        if (f == null && j == null) {
            throw new ObjectNotFoundException("Cliente");
        }

        ContaService cs = ServiceFactory.getContaService();

        /*
         * Consulta uma conta pelo id do cliente
         */
        Conta c = cs.findByIdPessoa(f != null ? f.getPessoa_id().toString() : j.getPessoa_id().toString());

        if (c == null) {

            /*
             * Gera uma instância a ser persistida
             */
            Conta conta = InstanceGenerator.getConta(contaRequest);

            /*
             * Persiste o objeto no banco de dados
             */
            if (cs.save(conta, f != null ? f.getPessoa_id().toString() : j.getPessoa_id().toString())) {
                return Mapper.INSTANCE.contaToResponse(conta);
            }
        }

        return Mapper.INSTANCE.contaToResponse(c);
    }

}