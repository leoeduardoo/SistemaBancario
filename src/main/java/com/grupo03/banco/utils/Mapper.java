package com.grupo03.banco.utils;

import com.grupo03.banco.model.PessoaFisica;
import com.grupo03.banco.model.response.PessoaFisicaResponse;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@org.mapstruct.Mapper
public interface Mapper {

    Mapper INSTANCE = Mappers.getMapper(Mapper.class);

    @Mapping(source = "pessoaFisica.pessoa_id", target = "id")
    PessoaFisicaResponse pessoaFisicaToResponse(PessoaFisica pessoaFisica);

}