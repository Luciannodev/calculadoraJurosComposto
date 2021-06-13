package com.gohorsebrasil.calculadojuroscomposto.Form;

import java.math.BigDecimal;

public class SimulacaoForm {
    BigDecimal aporteInicial;
    BigDecimal aporteMensal;
    BigDecimal rentabilidadeMensal;
    int meses;


    public BigDecimal getAporteInicial() {
        return aporteInicial;
    }

    public BigDecimal getAporteMensal() {
        return aporteMensal;
    }

    public BigDecimal getRentabilidadeMensal() {
        return rentabilidadeMensal;
    }

    public int getMeses() {
        return meses;
    }

    @Override
    public String toString() {
        return "SimulacaoForm{" +
                "aporteInical=" + aporteInicial +
                ", aporteMensal=" + aporteMensal +
                ", rentabilidadeMensal=" + rentabilidadeMensal +
                ", meses=" + meses +
                '}';
    }
}
