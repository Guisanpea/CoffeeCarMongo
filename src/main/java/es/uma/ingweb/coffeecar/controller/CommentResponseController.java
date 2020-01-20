package es.uma.ingweb.coffeecar.controller;

import es.uma.ingweb.coffeecar.entities.CommentResponse;
import es.uma.ingweb.coffeecar.repositories.CommentResponseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/commentResponse")
public class CommentResponseController {
    private final CommentResponseRepository commentResponseRepository;

    public CommentResponseController(CommentResponseRepository commentResponseRepository) {
        this.commentResponseRepository = commentResponseRepository;
    }

    @GetMapping("/{id}")
    public List<CommentResponse> getCommentFromAnnounce(@PathVariable String id){
        return commentResponseRepository.findCommentResponseByCommentOrderByDate(id);
    }

    @PostMapping
    public CommentResponse create(@RequestBody CommentResponse comment) {
        return commentResponseRepository.save(comment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        commentResponseRepository.findById(id)
                .ifPresentOrElse(
                        commentResponseRepository::delete,
                        () -> {throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment not found");}
                );
    }

}
