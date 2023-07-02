package com.ms.userservice.client;


import com.ms.userservice.entity.Hotel;
import com.ms.userservice.entity.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("Hotel-Service")
public interface IHotelServiceRestConsumer {

    @GetMapping("/hotel-service/api/hotels/hotel/{hotelId}")
    public ResponseEntity<Hotel> gethotelByHotelId(@PathVariable Long hotelId);
}
