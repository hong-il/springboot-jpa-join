package boot.jpa.join.dto.comment;

import boot.jpa.join.domain.comment.Comment;
import lombok.Getter;

@Getter
public class CommentFindByIdDto {

    private Long id;
    private String comment;
    private Long user_id;
    private Long post_id;

    public CommentFindByIdDto(Comment comment) {
        this.id = comment.getId();
        this.comment = comment.getComment();
        this.user_id = comment.getUser().getId();
        this.post_id = comment.getPost().getId();
    }
}