package br.com.ecommerce.main;

import br.com.ecommerce.model.CalculadoraFrete;
import br.com.ecommerce.model.FreteMotoboy;
import br.com.ecommerce.model.FretePac;
import br.com.ecommerce.model.FreteSedex;
import br.com.ecommerce.exception.TipoFreteInvalidoException;

public class MainTeste {

    public static void main(String[] args) {

        CalculadoraFrete calculadora = new CalculadoraFrete();

        try {

            double sedex = calculadora.processarFrete(
                    100.00,
                    new FreteSedex()
            );

            System.out.println("Frete Sedex: R$ " + sedex);

            double pac = calculadora.processarFrete(
                    100.00,
                    new FretePac()
            );

            System.out.println("Frete PAC: R$ " + pac);

            double motoboy = calculadora.processarFrete(
                    100.00,
                    new FreteMotoboy()
            );

            System.out.println("Frete Motoboy: R$ " + motoboy);

            calculadora.processarFrete(100.00, null);

        } catch (TipoFreteInvalidoException e) {

            System.out.println(e.getMessage());
        }
    }
}
