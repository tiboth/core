package core.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SortDto {
   private Float minPrice;
   private Float maxPrice;
   private String numberOfRooms;
   private String soldByOwner;
   private String soldByAgent;
}
