package com.grupo03.banco.service.impl;

import com.grupo03.banco.exception.ObjectNotFoundException;
import com.grupo03.banco.exception.SQLException;
import com.grupo03.banco.model.Conta;
import com.grupo03.banco.model.PessoaFisica;
import com.grupo03.banco.model.PessoaJuridica;
import com.grupo03.banco.model.request.ContaRequest;
import com.grupo03.banco.model.request.PessoaFisicaRequest;
import com.grupo03.banco.model.request.PessoaJuridicaRequest;
import com.grupo03.banco.model.request.TransacaoRequest;
import com.grupo03.banco.model.response.ContaResponse;
import com.grupo03.banco.model.response.PessoaFisicaResponse;
import com.grupo03.banco.model.response.PessoaJuridicaResponse;
import com.grupo03.banco.model.response.RelacaoContasResponse;
import com.grupo03.banco.service.BancoService;
import com.grupo03.banco.service.ContaService;
import com.grupo03.banco.service.PessoaFisicaService;
import com.grupo03.banco.service.PessoaJuridicaService;
import com.grupo03.banco.utils.InstanceGenerator;
import com.grupo03.banco.utils.Mapper;
import com.grupo03.banco.utils.ServiceFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BancoServiceImpl implements BancoService {

    @Override
    public ContaResponse efetuarTransacao(TransacaoRequest transacaoRequest) throws SQLException, ObjectNotFoundException {

        ContaService cs = ServiceFactory.getContaService();

        /*
         * Consulta uma conta pelo numero
         */
        Conta c = cs.findByNumero(transacaoRequest.getNumero());

        if (c == null) {
            throw new ObjectNotFoundException("Conta");
        }

        if (transacaoRequest.getTipoTransacao().contains("Saque")) {
            c.setSaldo(c.getSaldo().subtract(transacaoRequest.getValor()));
        } else {
            c.setSaldo(c.getSaldo().add(transacaoRequest.getValor()));
        }

        cs.update(c);

        return Mapper.INSTANCE.contaToResponse(c);
    }

    @Override
    public List<RelacaoContasResponse> extrairRelacaoContas() throws SQLException {

        ContaService cs = ServiceFactory.getContaService();

        /*
         * Retorna todas as contas com dados do cliente
         */
        List<RelacaoContasResponse> relacao = cs.findAllJoinPessoa();

        return relacao;
    }

    @Override
    public PessoaFisicaResponse cadastrarPessoaFisica(PessoaFisicaRequest pessoaFisicaRequest) throws SQLException {

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

    @Override
    public PessoaJuridicaResponse cadastrarPessoaJuridica(PessoaJuridicaRequest pessoaJuridicaRequest) throws SQLException {

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

    @Override
    public ContaResponse cadastrarConta(ContaRequest contaRequest) throws SQLException, ObjectNotFoundException {

        PessoaFisicaService fs = ServiceFactory.getPessoaFisicaService();
        PessoaJuridicaService js = ServiceFactory.getPessoaJuridicaService();

        /*
         * Consulta uma pessoa pelo cpf ou cnpj
         */
        PessoaFisica f = fs.findByCpf(contaRequest.getDocumentoCliente());
        PessoaJuridica j = js.findByCnpj(contaRequest.getDocumentoCliente());

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