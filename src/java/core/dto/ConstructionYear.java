package core.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ConstructionYear {
    BEFORE("Before"),
    AFTER("After"),
    EMPTY("Empty");

    String constructionYear;
}
