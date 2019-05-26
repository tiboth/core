package core.service;

import core.dto.AdvertisementTitleDto;
import core.dto.SortDto;
import core.helper.AdvertisementHelper;
import core.repository.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdvertisementService {
    private final AdvertisementRepository advertisementRepository;
    @Qualifier("advertisementTitleHelper")
    private final AdvertisementHelper<AdvertisementTitleDto> advertisementHelper;

    public AdvertisementService(AdvertisementRepository advertisementRepository, AdvertisementHelper<AdvertisementTitleDto> advertisementHelper) {
        this.advertisementRepository = advertisementRepository;
        this.advertisementHelper = advertisementHelper;
    }

    public List<AdvertisementTitleDto> sortAdvertisements(SortDto sortDto) {
        return advertisementRepository.findByPriceBetweenAndDescriptionNumberOfRooms(sortDto.getMinPrice(), sortDto.getMaxPrice(),
                sortDto.getNumberOfRooms()).stream().map(advertisementHelper::mapAdvertisement).collect(Collectors.toList());
    }
}
