package com.estsoft.spring_project.abc.comment.controller;


import com.estsoft.spring_project.abc.comment.dto.CommentRequest;
import com.estsoft.spring_project.abc.comment.dto.CommentResponse;
import com.estsoft.spring_project.abc.comment.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    //외부 API 가져오기
    @GetMapping("/api/comment/external")
    public ResponseEntity<String> getComment() {
        commentService.saveComment();

        return ResponseEntity.ok("외부 API 가져오기 성공");
    }

    // 댓글 생성
    @PostMapping("/api/articles/{articleId}/comments")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CommentResponse> createComment(@PathVariable Long articleId, @RequestBody CommentRequest Request) {
        CommentResponse response = commentService.createComment(articleId, Request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // 댓글 단건 조회
    @GetMapping("/api/comments/{commentId}")
    public ResponseEntity<CommentResponse> getComment(@PathVariable Long commentId) {
        CommentResponse response = commentService.getCommentById(commentId);
        return ResponseEntity.ok(response);
    }

    //댓글 수정
    @PutMapping("/api/comments/{commentId}")
    public ResponseEntity<CommentResponse> updateComment(@PathVariable Long commentId, @RequestBody CommentRequest request) {
        CommentResponse response = commentService.updateComment(commentId, request.getBody());
        return ResponseEntity.ok(response);
    }

    //댓글 삭제
    @DeleteMapping("/api/comments/{commentID}")
    public ResponseEntity<CommentResponse> deleteComment(@PathVariable Long commentID) {
        CommentResponse commentResponse = commentService.deleteComment(commentID);
        return ResponseEntity.ok(commentResponse);
    }

    //게시글 해당하는 전체 댓글 조회
    @GetMapping("/api/articles/{articleId}/comments")
    public ResponseEntity<List<CommentResponse>> getComments(@PathVariable Long articleId) {
        List<CommentResponse> responses = commentService.getCommentsByArticleId(articleId);
        return ResponseEntity.ok(responses);
    }

}
