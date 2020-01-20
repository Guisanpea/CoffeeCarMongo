package es.uma.ingweb.coffeecar.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;


@Data
public class CommentResponse {
    @Id
    private String id;
    private String date;
    private String body;
    @DBRef
    private User author;
    @DBRef
    private Comment comment;
}
