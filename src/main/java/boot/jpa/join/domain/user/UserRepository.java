package boot.jpa.join.domain.user;

import boot.jpa.join.domain.comment.Comment;
import boot.jpa.join.domain.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u.posts " +
            "from User u ")
    List<Post> findAllPost();

    @Query("select u.comments " +
            "from User u ")
    List<Comment> findAllComment();
}
