package core.controller;

import core.dto.AdvertisementTitleDto;
import core.dto.SortDto;
import core.entity.Advertisement;
import core.repository.AdvertisementRepository;
import core.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("announcement")
@CrossOrigin(origins = "http://localhost:4200")
public class AdvertisementController {
    private final AdvertisementService advertisementService;
    private final AdvertisementRepository advertisementRepository;

    @Autowired
    public AdvertisementController(AdvertisementService advertisementService, AdvertisementRepository advertisementRepository) {
        this.advertisementService = advertisementService;
        this.advertisementRepository = advertisementRepository;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<AdvertisementTitleDto> getAllUsers() {
        return advertisementService.sortAdvertisements(new SortDto(100F, 1000F, "2", "asdf", "asdf"));
    }

    @GetMapping("/count")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Long countAnnouncements() {
        return advertisementRepository.count();
    }
}
