package com.gerardo.ecommerce.mapper;

import com.gerardo.ecommerce.dto.out.ReviewDtoOut;
import com.gerardo.ecommerce.entity.Review;

import java.util.List;
import java.util.stream.Collectors;

public class MapperReview {

    public static ReviewDtoOut entityToDtoOut(Review review) {
        ReviewDtoOut dtoOut = new ReviewDtoOut();
        dtoOut.setVoto(review.getVoto());
        dtoOut.setCommento(review.getCommento());
        dtoOut.setData(review.getData());
        dtoOut.setProduct(MapperProduct.entityToDtoOut(review.getProduct()));
        dtoOut.setUser(MapperUser.entityToDtoOut(review.getUser()));
        return dtoOut;
    }

    public static List<ReviewDtoOut> entityToDtoOut(List<Review> listReview){
        return listReview.stream().map(MapperReview::entityToDtoOut).collect(Collectors.toList());
    }
}
