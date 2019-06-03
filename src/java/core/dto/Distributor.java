package core.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum Distributor {
    PROPRIETAR("Proprietar"),
    AGENTIE("Agentie"),
    EMPTY("Empty");

    String distributor;

    public String getDistributor() {
        return distributor;
    }

    private static final Map<String, Distributor> lookup = new HashMap<>();

    static
    {
        for(Distributor distr : Distributor.values())
        {
            lookup.put(distr.getDistributor(), distr);
        }
    }

    public static Distributor get(String url)
    {
        return lookup.get(url);
    }
}
