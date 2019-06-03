package core.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum ConstructionYear {
    BEFORE("Before"),
    AFTER("After"),
    EMPTY("Empty");

    String constructionYear;

    public String getConstructionYear() {
        return constructionYear;
    }

    private static final Map<String, ConstructionYear> lookup = new HashMap<>();

    static
    {
        for(ConstructionYear constr : ConstructionYear.values())
        {
            lookup.put(constr.getConstructionYear(), constr);
        }
    }

    public static ConstructionYear get(String url)
    {
        return lookup.get(url);
    }
}
