package core.service;

import core.dto.AdvertisementCommentDto;
import core.entity.AdvertisementComment;
import core.helper.AdvertisementCommentHelper;
import core.repository.AdvertisementCommentRepository;
import core.repository.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class CommentService {
    private final AdvertisementCommentRepository advertisementCommentRepository;
    private final AdvertisementRepository advertisementRepository;
    @Qualifier("advertisementCommentHelper")
    private final AdvertisementCommentHelper advertisementCommentHelper;

    public CommentService(AdvertisementCommentRepository advertisementCommentRepository, AdvertisementRepository advertisementRepository, AdvertisementCommentHelper advertisementCommentHelper) {
        this.advertisementCommentRepository = advertisementCommentRepository;
        this.advertisementRepository = advertisementRepository;
        this.advertisementCommentHelper = advertisementCommentHelper;
    }

    public List<AdvertisementCommentDto> getCommentsForAdvertisement(Long id) {
        return advertisementCommentRepository.findAllByAdvertisementId(id).stream().map(advertisementCommentHelper::mapAdvertisementCommentToAdvertisementCommentDto).collect(Collectors.toList());
    }

    public AdvertisementCommentDto saveCommentForAdvertisement(AdvertisementCommentDto commentDto) {
        AdvertisementComment comment = advertisementCommentHelper.mapAdvertisementCommentDtoToAdvertisementComment(commentDto);
        comment.setAdvertisement(advertisementRepository.findById(commentDto.getAdvertisementId()).orElseThrow(NoSuchElementException::new));
        comment.setDate(LocalDateTime.now());
        return advertisementCommentHelper.mapAdvertisementCommentToAdvertisementCommentDto(advertisementCommentRepository.save(comment));
    }
}
