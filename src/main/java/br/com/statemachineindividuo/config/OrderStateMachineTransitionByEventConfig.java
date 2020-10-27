package br.com.statemachineindividuo.config;

import br.com.statemachineindividuo.enums.IndividualEvents;
import br.com.statemachineindividuo.enums.IndividualStates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

import java.util.EnumSet;

@Configuration
@EnableStateMachine
public class OrderStateMachineTransitionByEventConfig extends EnumStateMachineConfigurerAdapter<IndividualStates, IndividualEvents> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Bean
    public StateMachineListener<IndividualStates, IndividualEvents> listener() {
        return new StateMachineListenerAdapter<>() {
            @Override
            public void stateChanged(State<IndividualStates, IndividualEvents> from, State<IndividualStates, IndividualEvents> to) {
                if(from != null && to != null)
                    System.out.println("Status change from " + from.getId() + " to " + to.getId());
            }
        };
    }

    @Override
    public void configure(StateMachineStateConfigurer<IndividualStates, IndividualEvents> states) throws Exception {
        states
                .withStates()
                .initial(IndividualStates.CREATED)
                .states(EnumSet.allOf(IndividualStates.class))
                .end(IndividualStates.APPROVED);
    }

    @Override
    public void configure(StateMachineConfigurationConfigurer<IndividualStates, IndividualEvents> config) throws Exception {
        config
                .withConfiguration()
                .autoStartup(true)
                .listener(listener());
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<IndividualStates, IndividualEvents> transitions) throws Exception {
        transitions
                .withExternal()
                .source(IndividualStates.CREATED).target(IndividualStates.PENDING_DOCUMENTATION)
                .event(IndividualEvents.COLLECT_DOCUMENTS)
                .and().withExternal()
                .source(IndividualStates.PENDING_DOCUMENTATION).target(IndividualStates.ERROR)
                .event(IndividualEvents.ERROR_DOCUMENTS)
                .and().withExternal()
                .source(IndividualStates.PENDING_DOCUMENTATION).target(IndividualStates.APPROVED)
                .event(IndividualEvents.CONFIRMED_DOCUMENTS);
    }

}
