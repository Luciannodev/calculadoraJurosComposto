package com.gohorsebrasil.calculadojuroscomposto.Model;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;


@Entity(name = "simulacao")
public class Simulacao {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    long Id;
    Integer quantidadeDeMes;
    String mes;
    int anoAtual;
    BigDecimal rendimento;
    BigDecimal acumulado;
    BigDecimal extra;

    public Simulacao() {

    }

    public Simulacao(Integer quantidadeDeMes, String mes, int anoAtual, BigDecimal rendimento, BigDecimal acumulado, BigDecimal extra) {
        this.quantidadeDeMes = quantidadeDeMes;
        this.mes = mes;
        this.anoAtual = anoAtual;
        this.rendimento = rendimento;
        this.acumulado = acumulado;
        this.extra = extra;
    }

    @Override
    public String toString() {
        return "Simulacao{" +
                "quantidadeDeMes=" + quantidadeDeMes +
                ", mes='" + mes + '\'' +
                ", anoAtual=" + anoAtual +
                ", rendimento=" + rendimento +
                ", acumulado=" + acumulado +
                ", extra=" + extra +
                '}';
    }
}
