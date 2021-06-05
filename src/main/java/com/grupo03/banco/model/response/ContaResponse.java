package com.grupo03.banco.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContaResponse {
    private Long id;
    private String tipoConta;
    private BigDecimal saldo;
    private String numero;
    private String dataAberturaConta;
    private Long Pessoa_id;
}
