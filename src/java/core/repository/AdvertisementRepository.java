package core.repository;

import core.entity.Advertisement;
import core.entity.WebsiteName;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdvertisementRepository extends CrudRepository<Advertisement, Long> {
    @Query("select ad " +
            "from Advertisement ad " +
            "inner join ad.website as web " +
            "where web.name = :websiteName")
    List<Advertisement> findAllByWebsiteName(WebsiteName websiteName);

    Optional<Advertisement> findByAdvertisementUrl(String url);

    Optional<Advertisement> findById(Long id);

    List<Advertisement> findAll();

    List<Advertisement> findByPriceBetweenAndDescriptionNumberOfRooms(Float minPrice, Float maxPrice, String numberOfRooms);
}
