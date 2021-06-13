package com.gohorsebrasil.calculadojuroscomposto.Dto;

import java.math.BigDecimal;

public class SimulacaoDto {

    private final BigDecimal aporteInical;
    private final BigDecimal rentabilidadeMensal;
    private final BigDecimal aporteMensal;
    private final int meses;

    public SimulacaoDto(BigDecimal aporteInicial, BigDecimal rentabilidadeMensal, BigDecimal aporteMensal , int meses ) {
        this.aporteInical = aporteInicial;
        this.rentabilidadeMensal = rentabilidadeMensal;
        this.aporteMensal = aporteMensal;
        this.meses = meses;

    }

    public BigDecimal getAporteInical() {
        return aporteInical;
    }

    public BigDecimal getRentabilidadeMensal() {
        return rentabilidadeMensal;
    }

    public BigDecimal getAporteMensal() {
        return aporteMensal;
    }

    public int getMeses() {
        return meses;
    }

    @Override
    public String toString() {
        return "SimulacaoDto{" +
                "aporteInical=" + aporteInical +
                ", rentabilidadeMensal=" + rentabilidadeMensal +
                ", aporteMensal=" + aporteMensal +
                ", meses=" + meses +
                '}';
    }
}
