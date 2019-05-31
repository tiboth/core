package core.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdvertisementCommentDto {
    private Long id;
    private Long advertisementId;
    private String commentTitle;
    private String comment;
    private LocalDateTime date;

    public AdvertisementCommentDto(Long id, String commentTitle, String comment, LocalDateTime date) {
        this.id = id;
        this.commentTitle = commentTitle;
        this.comment = comment;
        this.date = date;
    }
}
