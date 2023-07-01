package com.ms.userservice.entity;

import lombok.Data;

@Data
public class Rating {
   private Long ratingId;

   private Long userId;

   private Long hotelId;

   private Integer rating;

   private String feedback;
}
