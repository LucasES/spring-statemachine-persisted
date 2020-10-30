package br.com.statemachineindividuo.repository;

import br.com.statemachineindividuo.model.Individual;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndividualRepository extends JpaRepository<Individual, Long> {
}
