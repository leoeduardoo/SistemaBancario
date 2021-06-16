package com.grupo03.banco.service.impl;

import com.grupo03.banco.exception.SQLException;
import com.grupo03.banco.model.Conta;
import com.grupo03.banco.model.PessoaFisica;
import com.grupo03.banco.model.PessoaJuridica;
import com.grupo03.banco.model.request.ContaRequest;
import com.grupo03.banco.model.request.PessoaFisicaRequest;
import com.grupo03.banco.model.request.PessoaJuridicaRequest;
import com.grupo03.banco.model.response.ContaResponse;
import com.grupo03.banco.model.response.PessoaFisicaResponse;
import com.grupo03.banco.model.response.PessoaJuridicaResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BancoServiceImplTest {

    @InjectMocks
    private BancoServiceImpl bancoService;

    private PessoaJuridicaRequest pessoaJuridicaRequest;
    private PessoaFisicaRequest pessoaFisicaRequest;
    private ContaRequest contaRequest;
    private PessoaJuridica pessoaJuridica;
    private PessoaFisica pessoaFisica;

    @BeforeEach
    public void mock() {

        pessoaFisicaRequest = new PessoaFisicaRequest();
        pessoaFisicaRequest.setNome("Fulano PF");
        pessoaFisicaRequest.setTelefone("11 111111111");
        pessoaFisicaRequest.setRua("Rua A");
        pessoaFisicaRequest.setNumeroEndereco("n10");
        pessoaFisicaRequest.setBairro("Bairro A");
        pessoaFisicaRequest.setCidade("Cidade A");
        pessoaFisicaRequest.setEstado("AA");
        pessoaFisicaRequest.setDataNascimento("01/01/1991");
        pessoaFisicaRequest.setSexo("Masculino");
        pessoaFisicaRequest.setCpf("76506741007");
        pessoaFisicaRequest.setRg("361235069");

        pessoaFisica = new PessoaFisica();
        pessoaFisica.setNome("Fulano PF");
        pessoaFisica.setTelefone("11 111111111");
        pessoaFisica.setRua("Rua A");
        pessoaFisica.setNumeroEndereco("n1");
        pessoaFisica.setBairro("Bairro A");
        pessoaFisica.setCidade("Cidade A");
        pessoaFisica.setEstado("AA");
        pessoaFisica.setDataNascimento("01/01/1991");
        pessoaFisica.setSexo("Masculino");
        pessoaFisica.setCpf("76506741007");
        pessoaFisica.setRg("361235069");

        pessoaJuridicaRequest = new PessoaJuridicaRequest();
        pessoaJuridicaRequest.setNome("Fulano PJ");
        pessoaJuridicaRequest.setTelefone("22 22222222");
        pessoaJuridicaRequest.setRua("Rua B");
        pessoaJuridicaRequest.setNumeroEndereco("n2");
        pessoaJuridicaRequest.setBairro("Bairro B");
        pessoaJuridicaRequest.setCidade("Cidade B");
        pessoaJuridicaRequest.setEstado("BB");
        pessoaJuridicaRequest.setDataNascimento("02/02/1992");
        pessoaJuridicaRequest.setSexo("Masculino");
        pessoaJuridicaRequest.setCnpj("42324218000141");
        pessoaJuridicaRequest.setIe("741303306471");

        pessoaJuridica = new PessoaJuridica();
        pessoaJuridica.setNome("Fulano PJ");
        pessoaJuridica.setTelefone("22 22222222");
        pessoaJuridica.setRua("Rua B");
        pessoaJuridica.setNumeroEndereco("n2");
        pessoaJuridica.setBairro("Bairro B");
        pessoaJuridica.setCidade("Cidade B");
        pessoaJuridica.setEstado("BB");
        pessoaJuridica.setDataNascimento("02/02/1992");
        pessoaJuridica.setSexo("Masculino");
        pessoaJuridica.setCnpj("42324218000141");
        pessoaJuridica.setIe("741303306471");

        contaRequest = new ContaRequest();
        contaRequest.setDocumentoCliente("42324218000141");
        contaRequest.setTipoConta("Corrente");

    }

    @Order(1)
    @Test
    public void cadastrarPessoaFisicaTest() throws SQLException {

        PessoaFisicaResponse resultado = bancoService.cadastrarPessoaFisica(pessoaFisicaRequest);

        Assertions.assertNotNull(resultado.getId());
        Assertions.assertEquals(pessoaFisicaRequest.getDataNascimento(), resultado.getDataNascimento());
        Assertions.assertEquals(pessoaFisicaRequest.getNumeroEndereco(), resultado.getNumeroEndereco());
        Assertions.assertEquals(pessoaFisicaRequest.getTelefone(), resultado.getTelefone());
        Assertions.assertEquals(pessoaFisicaRequest.getCidade(), resultado.getCidade());
        Assertions.assertEquals(pessoaFisicaRequest.getBairro(), resultado.getBairro());
        Assertions.assertEquals(pessoaFisicaRequest.getEstado(), resultado.getEstado());
        Assertions.assertEquals(pessoaFisicaRequest.getSexo(), resultado.getSexo());
        Assertions.assertEquals(pessoaFisicaRequest.getNome(), resultado.getNome());
        Assertions.assertEquals(pessoaFisicaRequest.getCpf(), resultado.getCpf());
        Assertions.assertEquals(pessoaFisicaRequest.getRg(), resultado.getRg());
    }

    @Order(2)
    @Test
    public void cadastrarPessoaFisicaDuplicadaTest() throws SQLException {

        PessoaFisicaResponse resultado1 = bancoService.cadastrarPessoaFisica(pessoaFisicaRequest);
        PessoaFisicaResponse resultado2 = bancoService.cadastrarPessoaFisica(pessoaFisicaRequest);

        Assertions.assertNotNull(resultado1.getId());
        Assertions.assertEquals(resultado1.getId(), resultado2.getId());
        Assertions.assertEquals(pessoaFisicaRequest.getDataNascimento(), resultado1.getDataNascimento());
        Assertions.assertEquals(pessoaFisicaRequest.getNumeroEndereco(), resultado1.getNumeroEndereco());
        Assertions.assertEquals(pessoaFisicaRequest.getTelefone(), resultado1.getTelefone());
        Assertions.assertEquals(pessoaFisicaRequest.getCidade(), resultado1.getCidade());
        Assertions.assertEquals(pessoaFisicaRequest.getBairro(), resultado1.getBairro());
        Assertions.assertEquals(pessoaFisicaRequest.getEstado(), resultado1.getEstado());
        Assertions.assertEquals(pessoaFisicaRequest.getSexo(), resultado1.getSexo());
        Assertions.assertEquals(pessoaFisicaRequest.getNome(), resultado1.getNome());
        Assertions.assertEquals(pessoaFisicaRequest.getCpf(), resultado1.getCpf());
        Assertions.assertEquals(pessoaFisicaRequest.getRg(), resultado1.getRg());
        Assertions.assertEquals(resultado1.getDataNascimento(), resultado2.getDataNascimento());
        Assertions.assertEquals(resultado1.getNumeroEndereco(), resultado2.getNumeroEndereco());
        Assertions.assertEquals(resultado1.getTelefone(), resultado2.getTelefone());
        Assertions.assertEquals(resultado1.getCidade(), resultado2.getCidade());
        Assertions.assertEquals(resultado1.getBairro(), resultado2.getBairro());
        Assertions.assertEquals(resultado1.getEstado(), resultado2.getEstado());
        Assertions.assertEquals(resultado1.getSexo(), resultado2.getSexo());
        Assertions.assertEquals(resultado1.getNome(), resultado2.getNome());
        Assertions.assertEquals(resultado1.getCpf(), resultado2.getCpf());
        Assertions.assertEquals(resultado1.getRg(), resultado2.getRg());
    }

    @Order(3)
    @Test
    public void cadastrarPessoaJuridicaTest() throws SQLException {

        PessoaJuridicaResponse resultado = bancoService.cadastrarPessoaJuridica(pessoaJuridicaRequest);

        Assertions.assertNotNull(resultado.getId());
        Assertions.assertEquals(pessoaJuridicaRequest.getDataNascimento(), resultado.getDataNascimento());
        Assertions.assertEquals(pessoaJuridicaRequest.getNumeroEndereco(), resultado.getNumeroEndereco());
        Assertions.assertEquals(pessoaJuridicaRequest.getTelefone(), resultado.getTelefone());
        Assertions.assertEquals(pessoaJuridicaRequest.getCidade(), resultado.getCidade());
        Assertions.assertEquals(pessoaJuridicaRequest.getBairro(), resultado.getBairro());
        Assertions.assertEquals(pessoaJuridicaRequest.getEstado(), resultado.getEstado());
        Assertions.assertEquals(pessoaJuridicaRequest.getSexo(), resultado.getSexo());
        Assertions.assertEquals(pessoaJuridicaRequest.getNome(), resultado.getNome());
        Assertions.assertEquals(pessoaJuridicaRequest.getCnpj(), resultado.getCnpj());
        Assertions.assertEquals(pessoaJuridicaRequest.getIe(), resultado.getIe());
    }

    @Order(4)
    @Test
    public void cadastrarPessoaJuridicaDuplicadaTest() throws SQLException {

        PessoaJuridicaResponse resultado1 = bancoService.cadastrarPessoaJuridica(pessoaJuridicaRequest);
        PessoaJuridicaResponse resultado2 = bancoService.cadastrarPessoaJuridica(pessoaJuridicaRequest);

        Assertions.assertNotNull(resultado1.getId());
        Assertions.assertEquals(resultado1.getId(), resultado2.getId());
        Assertions.assertEquals(pessoaJuridicaRequest.getDataNascimento(), resultado1.getDataNascimento());
        Assertions.assertEquals(pessoaJuridicaRequest.getNumeroEndereco(), resultado1.getNumeroEndereco());
        Assertions.assertEquals(pessoaJuridicaRequest.getTelefone(), resultado1.getTelefone());
        Assertions.assertEquals(pessoaJuridicaRequest.getCidade(), resultado1.getCidade());
        Assertions.assertEquals(pessoaJuridicaRequest.getBairro(), resultado1.getBairro());
        Assertions.assertEquals(pessoaJuridicaRequest.getEstado(), resultado1.getEstado());
        Assertions.assertEquals(pessoaJuridicaRequest.getSexo(), resultado1.getSexo());
        Assertions.assertEquals(pessoaJuridicaRequest.getNome(), resultado1.getNome());
        Assertions.assertEquals(pessoaJuridicaRequest.getCnpj(), resultado1.getCnpj());
        Assertions.assertEquals(pessoaJuridicaRequest.getIe(), resultado1.getIe());
        Assertions.assertEquals(resultado1.getDataNascimento(), resultado2.getDataNascimento());
        Assertions.assertEquals(resultado1.getNumeroEndereco(), resultado2.getNumeroEndereco());
        Assertions.assertEquals(resultado1.getTelefone(), resultado2.getTelefone());
        Assertions.assertEquals(resultado1.getCidade(), resultado2.getCidade());
        Assertions.assertEquals(resultado1.getBairro(), resultado2.getBairro());
        Assertions.assertEquals(resultado1.getEstado(), resultado2.getEstado());
        Assertions.assertEquals(resultado1.getSexo(), resultado2.getSexo());
        Assertions.assertEquals(resultado1.getNome(), resultado2.getNome());
        Assertions.assertEquals(resultado1.getCnpj(), resultado2.getCnpj());
        Assertions.assertEquals(resultado1.getIe(), resultado2.getIe());
    }

    @Order(5)
    @Test
    public void cadastrarContaTest() throws Exception {

        bancoService.cadastrarPessoaJuridica(pessoaJuridicaRequest);
        ContaResponse resultado = bancoService.cadastrarConta(contaRequest);

        Assertions.assertNotNull(resultado.getId());
        Assertions.assertNotNull(resultado.getPessoa_id());
        Assertions.assertEquals(contaRequest.getTipoConta(), resultado.getTipoConta());
        Assertions.assertNotNull(resultado.getDataAberturaConta());
        Assertions.assertNotNull(resultado.getNumero());
        Assertions.assertNotNull(resultado.getSaldo());
    }

    @Order(6)
    @Test
    public void cadastrarContaDuplicadaTest() throws Exception {

        bancoService.cadastrarPessoaJuridica(pessoaJuridicaRequest);

        ContaResponse resultado1 = bancoService.cadastrarConta(contaRequest);
        ContaResponse resultado2 = bancoService.cadastrarConta(contaRequest);

        Assertions.assertNotNull(resultado1.getId());
        Assertions.assertNotNull(resultado1.getPessoa_id());
        Assertions.assertEquals(resultado1.getId(), resultado2.getId());
        Assertions.assertEquals(contaRequest.getTipoConta(), resultado1.getTipoConta());
        Assertions.assertNotNull(resultado1.getDataAberturaConta());
        Assertions.assertNotNull(resultado1.getNumero());
        Assertions.assertNotNull(resultado1.getSaldo());
        Assertions.assertEquals(resultado1.getDataAberturaConta(), resultado2.getDataAberturaConta());
        Assertions.assertEquals(resultado1.getTipoConta(), resultado2.getTipoConta());
        Assertions.assertEquals(resultado1.getNumero(), resultado2.getNumero());
        Assertions.assertEquals(resultado1.getSaldo().compareTo(resultado2.getSaldo()), 0);
        Assertions.assertEquals(contaRequest.getTipoConta(), resultado1.getTipoConta());
        Assertions.assertNotNull(resultado1.getDataAberturaConta());
        Assertions.assertNotNull(resultado1.getNumero());
        Assertions.assertNotNull(resultado1.getSaldo());
    }

}