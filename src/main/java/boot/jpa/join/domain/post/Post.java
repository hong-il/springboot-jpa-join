package boot.jpa.join.domain.post;

import boot.jpa.join.domain.comment.Comment;
import boot.jpa.join.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@NoArgsConstructor
@Getter
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_POST_USER"))
    private User user;

    @OneToMany(mappedBy = "post", cascade = ALL, fetch = FetchType.EAGER)
    private List<Comment> comments = new ArrayList<>();

    @Builder
    public Post(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }
}