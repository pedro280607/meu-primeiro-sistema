package br.com.ecommerce.model;

import br.com.ecommerce.exception.TipoFreteInvalidoException;

public class CalculadoraFrete {

    public double processarFrete(double valorPedido, EstrategiaFrete estrategia) {

        if (estrategia == null) {
            throw new TipoFreteInvalidoException("Tipo de frete inválido");
        }

        return estrategia.calcular(valorPedido);
    }
}