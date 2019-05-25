package core.repository;

import core.entity.Website;
import core.entity.WebsiteName;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WebsiteRepository extends CrudRepository<Website, Long> {
    Optional<Website> findByName(WebsiteName name);
}
