package core.repository;

import core.entity.AdvertisementComment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertisementCommentRepository extends CrudRepository<AdvertisementComment, Long> {
    List<AdvertisementComment> findAllByAdvertisementId(Long id);
}
