package core.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdvertisementComment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Advertisement advertisement;

    @Column
    private String commentTitle;

    @Column
    private String comment;

    @Column
    private LocalDateTime date;

    public AdvertisementComment(Long id, String commentTitle, String comment) {
        this.id = id;
        this.commentTitle = commentTitle;
        this.comment = comment;
    }
}
