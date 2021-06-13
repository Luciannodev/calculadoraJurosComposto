package com.gohorsebrasil.calculadojuroscomposto.Model;



import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;



public class Calculadora {
    private BigDecimal resultadoMes, lucroJuros;
    private ArrayList<BigDecimal> valorMensal = new ArrayList<>();
    private ArrayList<Integer> mesAno = new ArrayList<>();
    private ArrayList<BigDecimal> extras = new ArrayList<>();
    private ArrayList<BigDecimal> lucroMensal = new ArrayList<>();
    private int ano;
    private int anoAtual = Calendar.getInstance().getWeekYear();
    private int meses;
    private BigDecimal rentabilidadeMensal;
    private BigDecimal aporteMensal;
    private BigDecimal extra;
    private int extracount = 0;


    public BigDecimal calculoDeJuros(BigDecimal aporte, BigDecimal rentabilidadeMensal) {
        if (aporte.equals(new BigDecimal(0))) {
            lucroMensal.add(new BigDecimal(0.00));
            return new BigDecimal(0);
        } else {
            BigDecimal resultado = aporte.multiply(rentabilidadeMensal);
            lucroMensal.add(resultado.setScale(2, RoundingMode.HALF_UP));
            return resultado;
        }
    }

    private static BigDecimal calculoAcumulado(BigDecimal aporteInicial,
                                                 BigDecimal lucroAnterior, BigDecimal aporteMensal, BigDecimal extra) {
        BigDecimal resultado = lucroAnterior.add(aporteMensal);
        resultado = resultado.add(aporteInicial);
        resultado = resultado.add(extra);
        return resultado;
    }

    public ArrayList<BigDecimal> Rotina(int mesesInicial, BigDecimal acumulado, BigDecimal rentabilidadeMensalInserida,
                                           BigDecimal extrasinserido, BigDecimal aporteMensalInserido, BigDecimal aporteInicial) {

        this.meses = mesesInicial;
        this.rentabilidadeMensal = rentabilidadeMensalInserida;
        this.aporteMensal = aporteMensalInserido;
        this.resultadoMes = acumulado;
        BigDecimal lucroJuros = calculoDeJuros(aporteInicial, rentabilidadeMensalInserida);
        armazenaValor(aporteInicial, extrasinserido);
        this.resultadoMes = calculoAcumulado(aporteInicial, lucroJuros, aporteMensalInserido, extrasinserido);
        armazenaValor(resultadoMes, extrasinserido);
        RotinadeMeses(rentabilidadeMensalInserida, extrasinserido, aporteMensalInserido);
        Exibicao();
        return valorMensal;
    }

    public void Exibicao() {

        int countLimit = 0;
        for (BigDecimal valorRendido : valorMensal) {
            System.out.println("Ano: " + mesAno.get(countLimit) + " | Mês : " + (meses + 1) + " | ValorTotalMês : " + valorRendido + " | Lucro do Mes: " + lucroMensal.get(countLimit) + " | Extras: " + extras.get(extracount));
            meses++;
            this.extracount++;
            countLimit++;

        }
    }

    public ArrayList<Simulacao> armazenar() {
        ArrayList simulacaoArray = new ArrayList();
        SimpleDateFormat mes = new SimpleDateFormat("MMMM");
        int contagemMes = 0;
        String [] mesLiteral = {"janeiro", "fevereiro", "março", "abril","maio", "junho", "julho", "agosto", "setembro", "outubro", "novembro", "dezembro"};
        for (var i= 0 ; i<meses;i++){
            Simulacao simulacao = new Simulacao(i+1,mesLiteral[contagemMes],mesAno.get(i), lucroMensal.get(i),valorMensal.get(i),extras.get(i));
            simulacaoArray.add(simulacao);
            contagemMes++;
            if(contagemMes >= 12){
                contagemMes=0;
            }
        }
        return simulacaoArray;
    }



    private void RotinadeMeses(BigDecimal rentabilidadeMensal, BigDecimal extrasInserido, BigDecimal aporteMensal) {
        this.extra = extrasInserido;
        while (0 < meses) {
            lucroJuros = calculoDeJuros(resultadoMes, rentabilidadeMensal);
            this.resultadoMes = calculoAcumulado(this.resultadoMes, lucroJuros, aporteMensal, extra);
            armazenaValor(resultadoMes, extra);
        }
        lucroJuros = calculoDeJuros(resultadoMes, rentabilidadeMensal);
    }

    private void armazenaValor(BigDecimal valor, BigDecimal extra) {
        valorMensal.add(valor.setScale(2, RoundingMode.HALF_UP));
        this.meses--;
        this.ano++;
        extras.add(extra);
        this.extra = new BigDecimal(0);
        mesAno.add(anoAtual);
        if (ano == 12) {
            anoAtual++;
            ano = 0;
        }

    }

    public void AporteExtra(int mes, BigDecimal extraInserido) {
        ArrayList<BigDecimal> valorMensalNovo = new ArrayList<>();
        ArrayList<BigDecimal> extrasNovo = new ArrayList<>();
        ArrayList<BigDecimal> lucroMensalNovo = new ArrayList<>();
        for (int i = 0; i < mes; i++) {
            valorMensalNovo.add(valorMensal.get(i));
            extrasNovo.add(extras.get(i));
            lucroMensalNovo.add(lucroMensal.get(i));
        }
        extracount = 0;
        meses -= mes;
        lucroMensal = lucroMensalNovo;
        extras = extrasNovo;
        valorMensal = valorMensalNovo;
        resultadoMes = valorMensal.get(valorMensal.size() - 1);
        anoAtual = Calendar.getInstance().getWeekYear();
        RotinadeMeses(rentabilidadeMensal, extraInserido, aporteMensal);
        Exibicao();
    }


}
