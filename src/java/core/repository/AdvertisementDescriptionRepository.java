package core.repository;

import core.entity.AdvertisementDescription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertisementDescriptionRepository extends CrudRepository<AdvertisementDescription, Long> {
}
