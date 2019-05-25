package core.helper;

import core.entity.Advertisement;
import org.springframework.stereotype.Service;

@Service
public interface AdvertisementHelper <T>{
    T mapAdvertisement(Advertisement advertisement);
}
