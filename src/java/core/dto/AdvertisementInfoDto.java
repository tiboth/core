package core.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdvertisementInfoDto implements Serializable {
    private Long id;
    private String title;
    private Float price;
    private String description;
    private List<String> imageUrls;
    private String link;
}
