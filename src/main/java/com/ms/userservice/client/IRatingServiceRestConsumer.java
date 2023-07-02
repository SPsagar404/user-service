package com.ms.userservice.client;


import com.ms.userservice.entity.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("Rating-Service")
public interface IRatingServiceRestConsumer {

    @GetMapping("/rating-service/api/ratings/user/{userId}")
    public ResponseEntity<List<Rating>> ratingsByUserId(@PathVariable Long userId);

}
