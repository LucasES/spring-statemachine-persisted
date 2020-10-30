package br.com.statemachineindividuo.config;

import br.com.statemachineindividuo.enums.IndividualEvents;
import br.com.statemachineindividuo.enums.IndividualStates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachine;

@Configuration
public class EntityPersistHandlerConfig {

    @Autowired
    private StateMachine<IndividualStates, IndividualEvents> stateMachine;

}
