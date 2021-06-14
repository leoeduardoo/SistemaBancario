package com.grupo03.banco.utils;

import com.grupo03.banco.model.Conta;
import com.grupo03.banco.model.PessoaFisica;
import com.grupo03.banco.model.PessoaJuridica;
import com.grupo03.banco.model.response.ContaResponse;
import com.grupo03.banco.model.response.PessoaFisicaResponse;
import com.grupo03.banco.model.response.PessoaJuridicaResponse;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@org.mapstruct.Mapper
public interface Mapper {

    Mapper INSTANCE = Mappers.getMapper(Mapper.class);

    @Mapping(source = "pessoaFisica.pessoa_id", target = "id")
    PessoaFisicaResponse pessoaFisicaToResponse(PessoaFisica pessoaFisica);

    @Mapping(source = "pessoaJuridica.pessoa_id", target = "id")
    PessoaJuridicaResponse pessoaJuridicaToResponse(PessoaJuridica pessoaJuridica);

    @Mappings({
            @Mapping(source = "conta.id", target = "id"),
            @Mapping(source = "conta.tipoConta", target = "tipoConta"),
            @Mapping(source = "conta.saldo", target = "saldo"),
            @Mapping(source = "conta.numero", target = "numero"),
            @Mapping(source = "conta.dataAberturaConta", target = "dataAberturaConta"),
            @Mapping(source = "conta.pessoa_id", target = "pessoa_id")
    })
    ContaResponse contaToResponse(Conta conta);

}