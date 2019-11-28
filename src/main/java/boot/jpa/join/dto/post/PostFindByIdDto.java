package boot.jpa.join.dto.post;

import boot.jpa.join.domain.post.Post;
import boot.jpa.join.dto.comment.CommentFindAllDto;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PostFindByIdDto {

    private Long id;
    private String title;
    private String content;
    private Long user_id;
    private List<CommentFindAllDto> comments;

    public PostFindByIdDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.user_id = post.getUser().getId();
        this.comments = post.getComments().stream()
                .map(CommentFindAllDto::new)
                .collect(Collectors.toList());
    }
}