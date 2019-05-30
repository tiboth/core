package core.helper;

import core.dto.AdvertisementCommentDto;
import core.entity.AdvertisementComment;
import org.springframework.stereotype.Component;

@Component
public class AdvertisementCommentHelper {
    public AdvertisementCommentDto mapAdvertisementCommentToAdvertisementCommentDto(AdvertisementComment advertisementComment) {
        return new AdvertisementCommentDto(advertisementComment.getId(), advertisementComment.getCommentTitle(),
                advertisementComment.getComment(), advertisementComment.getDate());
    }

    public AdvertisementComment mapAdvertisementCommentDtoToAdvertisementComment(AdvertisementCommentDto advertisementCommentDto) {
        return new AdvertisementComment(advertisementCommentDto.getId(), advertisementCommentDto.getCommentTitle(), advertisementCommentDto.getComment());
    }
}
