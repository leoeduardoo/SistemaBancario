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
public class RelacaoContasResponse {
    private String numero;
    private String tipoConta;
    private BigDecimal saldo;
    private String titular;
    private String telefone;
}