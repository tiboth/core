package core.repository;

import core.entity.Advertisement;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdvertisementRepository extends CrudRepository<Advertisement, Long> {
    Optional<Advertisement> findById(Long id);

    List<Advertisement> findAll();

    List<Advertisement> findByPriceBetweenAndDescriptionNumberOfRoomsAndDescriptionDistributorAndDescriptionConstructionYear
            (Float minPrice, Float maxPrice, String numberOfRooms, String distributor, String constructionYear, Pageable pageable);

    Integer countAdvertisementByPriceBetweenAndDescriptionNumberOfRoomsAndDescriptionDistributorAndDescriptionConstructionYear
            (Float minPrice, Float maxPrice, String numberOfRooms, String distributor, String constructionYear);
}
