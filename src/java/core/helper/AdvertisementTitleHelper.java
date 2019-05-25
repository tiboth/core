package core.helper;

import core.dto.AdvertisementTitleDto;
import core.entity.Advertisement;
import org.springframework.stereotype.Component;

@Component
public class AdvertisementTitleHelper implements AdvertisementHelper<AdvertisementTitleDto> {
    public AdvertisementTitleDto mapAdvertisement(Advertisement advertisement) {
        return new AdvertisementTitleDto(advertisement.getId(), advertisement.getTitle(), advertisement.getImageUrls().get(0));
    }
}