package com.grupo03.banco.service;

import com.grupo03.banco.exception.ObjectNotFoundException;
import com.grupo03.banco.exception.SQLException;
import com.grupo03.banco.model.request.ContaRequest;
import com.grupo03.banco.model.request.PessoaFisicaRequest;
import com.grupo03.banco.model.request.PessoaJuridicaRequest;
import com.grupo03.banco.model.request.TransacaoRequest;
import com.grupo03.banco.model.response.ContaResponse;
import com.grupo03.banco.model.response.PessoaFisicaResponse;
import com.grupo03.banco.model.response.PessoaJuridicaResponse;
import com.grupo03.banco.model.response.RelacaoContasResponse;

import java.util.List;

public interface BancoService {

    ContaResponse efetuarTransacao(TransacaoRequest transacaoRequest) throws SQLException, ObjectNotFoundException;

    List<RelacaoContasResponse> extrairRelacaoContas() throws SQLException;

    PessoaFisicaResponse cadastrarPessoaFisica(PessoaFisicaRequest pessoaFisicaRequest) throws SQLException;

    PessoaJuridicaResponse cadastrarPessoaJuridica(PessoaJuridicaRequest pessoaJuridicaRequest) throws SQLException;

    ContaResponse cadastrarConta(ContaRequest contaRequest) throws SQLException, ObjectNotFoundException;

}