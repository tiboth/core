package core.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FilterDto {
    private Float minPrice;
    private Float maxPrice;
    private String numberOfRooms;
    private boolean soldByOwner;
    private boolean soldByAgent;
    private boolean isNew;
    private boolean isOld;
    private Integer from;
    private String sortBy;

    public FilterDto(Float minPrice, Float maxPrice, Integer numberOfRooms, boolean soldByOwner, boolean soldByAgent, boolean isNew, boolean isOld, Integer from, String sortBy) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.soldByOwner = soldByOwner;
        this.soldByAgent = soldByAgent;
        this.isNew = isNew;
        this.isOld = isOld;
        this.from = from;
        this.sortBy = sortBy;
        setNumberOfRooms(numberOfRooms);
    }

    public FilterDto(Float minPrice, Float maxPrice, Integer numberOfRooms, boolean soldByOwner, boolean soldByAgent, boolean isNew, boolean isOld) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.soldByOwner = soldByOwner;
        this.soldByAgent = soldByAgent;
        this.isNew = isNew;
        this.isOld = isOld;
        setNumberOfRooms(numberOfRooms);
    }

    private void setNumberOfRooms(Integer numberOfRooms) {
        if(numberOfRooms < 4)
            this.numberOfRooms = numberOfRooms.toString();
        else
            this.numberOfRooms = "4 sau mai multe";
    }
}
