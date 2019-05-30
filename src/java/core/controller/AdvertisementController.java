package core.controller;

import core.dto.AdvertisementCommentDto;
import core.dto.AdvertisementInfoDto;
import core.dto.AdvertisementTitleDto;
import core.dto.FilterDto;
import core.repository.AdvertisementRepository;
import core.service.AdvertisementService;
import core.service.CommentService;
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
    private final CommentService commentService;

    @Autowired
    public AdvertisementController(AdvertisementService advertisementService, CommentService commentService) {
        this.advertisementService = advertisementService;
        this.commentService = commentService;
    }

    @GetMapping("/{minPrice}/{maxPrice}/{nrRooms}/{isNew}/{isOld}/{isOwner}/{isAgent}/{from}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<AdvertisementTitleDto> getAllUsers(@PathVariable(value = "maxPrice") Float maxPrice, @PathVariable(value = "minPrice") Float minPrice,
                                            @PathVariable(value = "nrRooms") Integer nrRooms, @PathVariable(value = "isNew") boolean isNew,
                                            @PathVariable(value = "isOld") boolean isOld, @PathVariable(value = "isOwner") boolean isOwner,
                                            @PathVariable(value = "isAgent") boolean isAgent, @PathVariable(value = "from") Integer from) {
        return advertisementService.filterAdvertisements(new FilterDto(minPrice, maxPrice, nrRooms, isOwner, isAgent, isNew, isOld, from));
    }

    @GetMapping("/count/{minPrice}/{maxPrice}/{nrRooms}/{isNew}/{isOld}/{isOwner}/{isAgent}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    int countAnnouncements(@PathVariable(value = "maxPrice") Float maxPrice, @PathVariable(value = "minPrice") Float minPrice,
                            @PathVariable(value = "nrRooms") Integer nrRooms, @PathVariable(value = "isNew") boolean isNew,
                            @PathVariable(value = "isOld") boolean isOld, @PathVariable(value = "isOwner") boolean isOwner,
                            @PathVariable(value = "isAgent") boolean isAgent) {
        return advertisementService.filterAdvertisements(new FilterDto(minPrice, maxPrice, nrRooms, isOwner, isAgent, isNew, isOld)).size();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    AdvertisementInfoDto getAdvertisement(@PathVariable(value = "id") Long id) {
        return advertisementService.getAdvertisement(id);
    }

    @GetMapping("{id}/comment")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<AdvertisementCommentDto> getCommentsForAdvertisement(@PathVariable(value = "id") Long id) {
        return commentService.getCommentsForAdvertiesement(id);
    }

    @PostMapping("{id}/comment")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    AdvertisementCommentDto saveCommentForAdvertisement(@PathVariable(value = "id") Long id, @RequestBody AdvertisementCommentDto comment) {
        comment.setAdvertisementId(id);
        return commentService.saveCommentForAdvertisement(comment);
    }
}
