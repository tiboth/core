package core.repository;

import core.entity.AdvertisementComment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertisementCommentRepository extends CrudRepository<AdvertisementComment, Long> {
}
