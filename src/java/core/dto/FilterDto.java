package core.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FilterDto {
    private Float minPrice;
    private Float maxPrice;
    private String numberOfRooms;
    private ConstructionYear constructionYear;
    private Distributor distributor;
    private Integer from;
    private String sortBy;

    public FilterDto(Float minPrice, Float maxPrice, Integer numberOfRooms, ConstructionYear constructionYear, Distributor distributor, Integer from, String sortBy) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.constructionYear = constructionYear;
        this.distributor = distributor;
        this.from = from;
        this.sortBy = sortBy;
        setNumberOfRooms(numberOfRooms);
    }

    public FilterDto(Float minPrice, Float maxPrice, Integer numberOfRooms, ConstructionYear constructionYear, Distributor distributor) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.constructionYear = constructionYear;
        this.distributor = distributor;
        setNumberOfRooms(numberOfRooms);
    }

    private void setNumberOfRooms(Integer numberOfRooms) {
        if(numberOfRooms < 4)
            this.numberOfRooms = numberOfRooms.toString();
        else
            this.numberOfRooms = "4 sau mai multe";
    }
}
