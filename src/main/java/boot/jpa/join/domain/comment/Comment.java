package boot.jpa.join.domain.comment;

import boot.jpa.join.domain.post.Post;
import boot.jpa.join.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "post_id", foreignKey = @ForeignKey(name = "FK_COMMENT_POST"))
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_COMMENT_USER"))
    private User user;

    @Builder
    public Comment(String comment, Post post, User user) {
        this.comment = comment;
        this.post = post;
        this.user = user;
    }
}