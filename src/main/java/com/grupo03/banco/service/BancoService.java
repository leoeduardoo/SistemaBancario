package com.grupo03.banco.service;

import com.grupo03.banco.exception.SQLException;
import com.grupo03.banco.model.request.ContaRequest;
import com.grupo03.banco.model.request.PessoaFisicaRequest;
import com.grupo03.banco.model.request.PessoaJuridicaRequest;
import com.grupo03.banco.model.response.ContaResponse;
import com.grupo03.banco.model.response.PessoaFisicaResponse;
import com.grupo03.banco.model.response.PessoaJuridicaResponse;
import com.grupo03.banco.model.response.RelacaoContasResponse;

import java.util.List;

public interface BancoService {

    public List<RelacaoContasResponse> extrairRelacaoContas() throws SQLException;

    public PessoaFisicaResponse cadastrarPessoaFisica(PessoaFisicaRequest pessoaFisicaRequest) throws SQLException;

    public PessoaJuridicaResponse cadastrarPessoaJuridica(PessoaJuridicaRequest pessoaJuridicaRequest) throws SQLException;

    public ContaResponse cadastrarConta(ContaRequest contaRequest) throws Exception;

}