package com.gerardo.ecommerce.mapper;

import com.gerardo.ecommerce.dto.out.ReviewDtoOut;
import com.gerardo.ecommerce.entity.Review;
import org.apache.catalina.mapper.Mapper;

import java.util.List;
import java.util.stream.Collectors;

public class MapperReview {

    public static ReviewDtoOut entityToDtoOut(Review review) {
        ReviewDtoOut dtoOut = new ReviewDtoOut();
        dtoOut.setVoto(review.getVoto());
        dtoOut.setCommento(review.getCommento());
        dtoOut.setData(review.getData());
        if (review.getProduct() != null) {
            dtoOut.setProduct(MapperProduct.entityToDtoOut(review.getProduct()));

        }
        if (review.getUser() != null) {
            dtoOut.setUser(MapperUser.entityToDtoOut(review.getUser()));

        }
        return dtoOut;
    }

    public static List<ReviewDtoOut> listEntityToListDtoOut(List<Review> listReview) {
        return listReview.stream().map(MapperReview::entityToDtoOut).collect(Collectors.toList());
    }

    public static Review dtoOutToEntity(ReviewDtoOut dtoOut) {
        Review entity = new Review();
        entity.setVoto(dtoOut.getVoto());
        entity.setCommento(dtoOut.getCommento());
        entity.setData(dtoOut.getData());
        entity.setUser(MapperUser.dtoOutToEntity(dtoOut.getUser()));
        entity.setProduct(MapperProduct.dtoOutToEntity(dtoOut.getProduct()));
        return entity;
    }

    public static List<Review> ListDtoOutToListEntity(List<ReviewDtoOut> listReviewDtoOut) {
        return listReviewDtoOut.stream().map(MapperReview::dtoOutToEntity).collect(Collectors.toList());
    }
}
