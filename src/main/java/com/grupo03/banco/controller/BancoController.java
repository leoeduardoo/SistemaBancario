package com.grupo03.banco.controller;

import com.grupo03.banco.model.request.ContaRequest;
import com.grupo03.banco.model.request.PessoaFisicaRequest;
import com.grupo03.banco.model.request.PessoaJuridicaRequest;
import com.grupo03.banco.model.response.ContaResponse;
import com.grupo03.banco.model.response.PessoaFisicaResponse;
import com.grupo03.banco.model.response.PessoaJuridicaResponse;
import com.grupo03.banco.service.BancoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "banco", produces = "application/json")
public class BancoController {

    @Autowired
    private BancoService bancoService;

    @PostMapping("cadastrarPessoaFisica")
    public ResponseEntity<PessoaFisicaResponse> cadastrarPessoaFisica(@RequestBody PessoaFisicaRequest pessoaFisicaRequest) {
        return ResponseEntity.ok(bancoService.cadastrarPessoaFisica(pessoaFisicaRequest));
    }

    @PostMapping("cadastrarPessoaJuridica")
    public ResponseEntity<PessoaJuridicaResponse> cadastrarPessoaJuridica(@RequestBody PessoaJuridicaRequest pessoaJuridicaRequest) {
        return ResponseEntity.ok(bancoService.cadastrarPessoaJuridica(pessoaJuridicaRequest));
    }

    @PostMapping("cadastrarConta")
    public ResponseEntity<ContaResponse> cadastrarConta(@RequestBody ContaRequest contaRequest) throws Exception {
        return ResponseEntity.ok(bancoService.cadastrarConta(contaRequest));
    }

}