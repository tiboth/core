package core.service;

import core.dto.AdvertisementInfoDto;
import core.dto.AdvertisementTitleDto;
import core.dto.FilterDto;
import core.helper.AdvertisementHelper;
import core.repository.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class AdvertisementService {
    private final AdvertisementRepository advertisementRepository;
    @Qualifier("advertisementTitleHelper")
    private final AdvertisementHelper<AdvertisementTitleDto> advertisementTitleHelper;
    @Qualifier("advertisementTitleHelper")
    private final AdvertisementHelper<AdvertisementInfoDto> advertisementInfoHelper;

    public AdvertisementService(AdvertisementRepository advertisementRepository, AdvertisementHelper<AdvertisementTitleDto> advertisementTitleHelper, AdvertisementHelper<AdvertisementInfoDto> advertisementInfoHelper) {
        this.advertisementRepository = advertisementRepository;
        this.advertisementTitleHelper = advertisementTitleHelper;
        this.advertisementInfoHelper = advertisementInfoHelper;
    }

    public List<AdvertisementTitleDto> filterAdvertisements(FilterDto filterDto) {
        return advertisementRepository.findByPriceBetweenAndDescriptionNumberOfRooms(filterDto.getMinPrice(), filterDto.getMaxPrice(),
                filterDto.getNumberOfRooms()).stream().map(advertisementTitleHelper::mapAdvertisement).collect(Collectors.toList());
    }

    public AdvertisementInfoDto getAdvertisement(Long id) {
        return advertisementRepository.findById(id).map(advertisementInfoHelper::mapAdvertisement).orElseThrow(NoSuchElementException::new);
    }
}
