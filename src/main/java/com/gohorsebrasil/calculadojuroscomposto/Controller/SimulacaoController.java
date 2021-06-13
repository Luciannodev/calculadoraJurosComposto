package com.gohorsebrasil.calculadojuroscomposto.Controller;

import com.gohorsebrasil.calculadojuroscomposto.Form.AporteForm;
import com.gohorsebrasil.calculadojuroscomposto.Form.SimulacaoForm;
import com.gohorsebrasil.calculadojuroscomposto.Model.Calculadora;
import com.gohorsebrasil.calculadojuroscomposto.Model.Simulacao;
import com.gohorsebrasil.calculadojuroscomposto.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;


@RestController
@RequestMapping("/simulacao")
public class SimulacaoController {

    @Autowired
    private Repository repository;
    private Calculadora calculadora = new Calculadora();
    @PostMapping("/normal")
    public void Simular(@RequestBody SimulacaoForm simulacaoForm) {
        calculadora.Rotina(simulacaoForm.getMeses(), new BigDecimal(0), simulacaoForm.getRentabilidadeMensal(), new BigDecimal(0), simulacaoForm.getAporteMensal(), simulacaoForm.getAporteInicial());
        var simulacaoArray = calculadora.armazenar();
        for (var mes : simulacaoArray)
          repository.save(mes);

    }
    @DeleteMapping
    public void Deletar(){
        repository.deleteAll();
        calculadora = new Calculadora();
    }
    @PostMapping("/aporte")
    public void aporte(@RequestBody AporteForm aporteForm ){
       calculadora.AporteExtra(aporteForm.getMeses()-1,aporteForm.getValor());
       var simulacaoArray = calculadora.armazenar();
       repository.deleteAll();
       for(var mes: simulacaoArray){
           repository.save(mes);
       }

    }

}
