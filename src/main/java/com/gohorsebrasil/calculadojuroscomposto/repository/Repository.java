package com.gohorsebrasil.calculadojuroscomposto.repository;

import com.gohorsebrasil.calculadojuroscomposto.Model.Simulacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Simulacao,Integer> {

}
