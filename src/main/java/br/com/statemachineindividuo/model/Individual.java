package br.com.statemachineindividuo.model;

import br.com.statemachineindividuo.enums.IndividualStates;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Table(name = "Individual")
@Data
@NoArgsConstructor
@Entity
public class Individual {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "state")
    @Enumerated(value = EnumType.STRING)
    private IndividualStates state;
}
