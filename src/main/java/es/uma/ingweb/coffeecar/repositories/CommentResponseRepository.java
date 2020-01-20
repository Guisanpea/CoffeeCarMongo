package es.uma.ingweb.coffeecar.repositories;

import es.uma.ingweb.coffeecar.entities.CommentResponse;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentResponseRepository extends MongoRepository<CommentResponse, String> {
    List<CommentResponse> findCommentResponseByCommentOrderByDate(String commentId);
}
