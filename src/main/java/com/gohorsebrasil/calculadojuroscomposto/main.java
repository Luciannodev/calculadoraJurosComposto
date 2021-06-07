package com.gohorsebrasil.calculadojuroscomposto;
import java.math.BigDecimal;

public class main {
    BigDecimal resultadoMes;
    public static void main(String[] args) {
        BigDecimal aporteMensal,acumulado,extras,lucroJuros,rentabilidadeMensal ;
        int meses, ano;
        String nomeclatura;
        extras = new BigDecimal(0);
        meses = 36;
        aporteMensal = new BigDecimal(730);
        acumulado =  new BigDecimal(730);
        BigDecimal aporteInicial = new BigDecimal(730);
        rentabilidadeMensal = new BigDecimal( 0.0050);
        Calculadora calculadora = new Calculadora();
        //calculadora.calculoDeJuros(aporteInicial,rentabilidadeMensal);
        calculadora.Rotina(meses,new BigDecimal(0),rentabilidadeMensal,new BigDecimal(0),aporteMensal,aporteInicial);
        System.out.println("---------------------------------//------------------------------");
        calculadora.AporteExtra(9,new BigDecimal(5000));
        System.out.println("----------------------//----------------------------------------");

   }



    }
