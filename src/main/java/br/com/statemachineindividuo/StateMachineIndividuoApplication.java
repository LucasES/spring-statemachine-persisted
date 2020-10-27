package br.com.statemachineindividuo;

import br.com.statemachineindividuo.enums.IndividualEvents;
import br.com.statemachineindividuo.enums.IndividualStates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;

@SpringBootApplication
public class StateMachineIndividuoApplication implements CommandLineRunner {
	@Autowired
	private StateMachine<IndividualStates, IndividualEvents> stateMachine;

	public static void main(String[] args) {
		SpringApplication.run(StateMachineIndividuoApplication.class, args);
	}
	@Override
	public void run(String... args) {
		System.out.println("Iniciando máquina de estados...");
		stateMachine.sendEvent(IndividualEvents.COLLECT_DOCUMENTS);
		stateMachine.sendEvent(IndividualEvents.CONFIRMED_DOCUMENTS);
		System.out.println("Máquina de estados finalizada");
	}
}