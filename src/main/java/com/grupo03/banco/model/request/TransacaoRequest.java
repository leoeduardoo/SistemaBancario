package com.grupo03.banco.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransacaoRequest {
    private BigDecimal valor;
    private String numero;
    private String tipoTransacao;
}
