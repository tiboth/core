package core.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Distributor {
    PROPRIETAR("Proprietar"),
    AGENTIE("Agentie"),
    EMPTY("Empty");

    String distributor;
}
