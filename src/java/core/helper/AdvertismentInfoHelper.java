package core.helper;

import core.dto.AdvertisementInfoDto;
import core.entity.Advertisement;
import org.springframework.stereotype.Component;

@Component
public class AdvertismentInfoHelper implements AdvertisementHelper<AdvertisementInfoDto> {
    @Override
    public AdvertisementInfoDto mapAdvertisement(Advertisement advertisement) {
        return new AdvertisementInfoDto(advertisement.getId(), advertisement.getTitle(), advertisement.getPrice(),
                advertisement.getDescription().getDescription(), advertisement.getImageUrls(),
                advertisement.getAdvertisementUrl());
    }
}
