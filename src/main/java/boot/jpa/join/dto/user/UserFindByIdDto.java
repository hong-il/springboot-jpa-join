package boot.jpa.join.dto.user;

import boot.jpa.join.domain.user.User;
import boot.jpa.join.dto.comment.CommentFindAllDto;
import boot.jpa.join.dto.post.PostFindAllDto;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class UserFindByIdDto {

    private Long id;
    private String name;
    private String email;
    private List<PostFindAllDto> posts;
    private List<CommentFindAllDto> comments;

    public UserFindByIdDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.posts = user.getPosts().stream()
                .map(PostFindAllDto::new)
                .collect(Collectors.toList());
        this.comments = user.getComments().stream()
                .map(CommentFindAllDto::new)
                .collect(Collectors.toList());
    }
}