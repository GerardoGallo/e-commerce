package com.gerardo.ecommerce.service;

import com.gerardo.ecommerce.dto.in.ReviewDtoIn;
import com.gerardo.ecommerce.dto.out.ReviewDtoOut;
import com.gerardo.ecommerce.entity.Product;
import com.gerardo.ecommerce.entity.Review;
import com.gerardo.ecommerce.entity.Role;
import com.gerardo.ecommerce.entity.User;
import com.gerardo.ecommerce.mapper.MapperProduct;
import com.gerardo.ecommerce.mapper.MapperReview;
import com.gerardo.ecommerce.mapper.MapperUser;
import com.gerardo.ecommerce.repository.ProductRepository;
import com.gerardo.ecommerce.repository.ReviewRepository;
import com.gerardo.ecommerce.repository.UserRepository;
import com.gerardo.ecommerce.utility.UserUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserUtility userUtility;

    public List<ReviewDtoOut> findByIdProduct(int idProduct) {
        List<Review> listReview = reviewRepository.findByIdProduct(idProduct);
        return MapperReview.listEntityToListDtoOut(listReview);
    }

    public ReviewDtoOut addReview(ReviewDtoIn dtoIn) {
        //un utente potrà aggiungere una review solo per un prodotto che ha acquistato ma per ora non consideriamo questa cosa, che verrà modificata in seguito

        Product product = productRepository.findByCodeItem(dtoIn.getCodeItemProduct())
                .orElseThrow(() -> new RuntimeException(String.format("Prodotto con codice %s non trovato", dtoIn.getCodeItemProduct())));

        User user = userUtility.fetchAuthenticatedUser();

        Review newReview = new Review();
        newReview.setVoto(dtoIn.getVoto());
        newReview.setCommento(dtoIn.getCommento());
        newReview.setData(LocalDateTime.now());
        newReview.setProduct(product);
        newReview.setUser(user);

        product.getReview().add(newReview);
        reviewRepository.save(newReview);
        ReviewDtoOut dtoOut = MapperReview.entityToDtoOut(newReview);
        dtoOut.setProduct(MapperProduct.entityToDtoOut(product));
        return dtoOut;
    }

    public ReviewDtoOut modifyReview(ReviewDtoIn dtoIn, int reviewId) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new RuntimeException(String.format("Review con id %s non trovata", reviewId)));
        User authenticatedUser = userUtility.fetchAuthenticatedUser();
        if (review.getUser() != authenticatedUser) {
            throw new RuntimeException("Non puoi modificare una review non scritta da te");
        }
        review.setVoto(dtoIn.getVoto());
        review.setCommento(dtoIn.getCommento());
        review.setData(LocalDateTime.now());
        reviewRepository.save(review);
        return MapperReview.entityToDtoOut(review);
    }

    public ReviewDtoOut deleteReview(int reviewId) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new RuntimeException(String.format("Review con id %s non trovata", reviewId)));
        User authenticatedUser = userUtility.fetchAuthenticatedUser();
        if (review.getUser() != authenticatedUser && authenticatedUser.getRuolo() != Role.ADMIN) {
            throw new RuntimeException("Non puoi eliminare una review non scritta da te");
        }
        reviewRepository.delete(review);
        return MapperReview.entityToDtoOut(review);
    }
}
