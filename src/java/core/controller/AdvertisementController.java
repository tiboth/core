package core.controller;

import core.dto.AdvertisementTitleDto;
import core.dto.SortDto;
import core.repository.AdvertisementRepository;
import core.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("licenta/announcement")
@CrossOrigin(origins = "http://localhost:4200")
public class AdvertisementController {
    private final AdvertisementService advertisementService;
    private final AdvertisementRepository advertisementRepository;

    @Autowired
    public AdvertisementController(AdvertisementService advertisementService, AdvertisementRepository advertisementRepository) {
        this.advertisementService = advertisementService;
        this.advertisementRepository = advertisementRepository;
    }

    @GetMapping("/{minPrice}/{maxPrice}/{nrRooms}/{isNew}/{isOld}/{isOwner}/{isAgent}/{from}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<AdvertisementTitleDto> getAllUsers(@PathVariable(value = "maxPrice") Float maxPrice, @PathVariable(value = "minPrice") Float minPrice,
                                            @PathVariable(value = "nrRooms") Integer nrRooms, @PathVariable(value = "isNew") boolean isNew,
                                            @PathVariable(value = "isOld") boolean isOld, @PathVariable(value = "isOwner") boolean isOwner,
                                            @PathVariable(value = "isAgent") boolean isAgent, @PathVariable(value = "from") Integer from) {
        return advertisementService.sortAdvertisements(new SortDto(minPrice, maxPrice, nrRooms, isOwner, isAgent, isNew, isOld, from));
    }

    @GetMapping("/count/{minPrice}/{maxPrice}/{nrRooms}/{isNew}/{isOld}/{isOwner}/{isAgent}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    int countAnnouncements(@PathVariable(value = "maxPrice") Float maxPrice, @PathVariable(value = "minPrice") Float minPrice,
                            @PathVariable(value = "nrRooms") Integer nrRooms, @PathVariable(value = "isNew") boolean isNew,
                            @PathVariable(value = "isOld") boolean isOld, @PathVariable(value = "isOwner") boolean isOwner,
                            @PathVariable(value = "isAgent") boolean isAgent) {
        return advertisementService.sortAdvertisements(new SortDto(minPrice, maxPrice, nrRooms, isOwner, isAgent, isNew, isOld)).size();
    }
}
