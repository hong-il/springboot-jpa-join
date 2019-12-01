package boot.jpa.join.domain.user;

import boot.jpa.join.domain.comment.Comment;
import boot.jpa.join.domain.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u.posts " +
            "from User u ")
    List<Post> ImplicitInnerJoinUserPost();

    @Query("select u.comments " +
            "from User u ")
    List<Comment> ImplicitInnerJoinUserComment();

    @Query("select p " +
            "from Post p " +
            "INNER JOIN p.user u")
    List<Post> ExplicitInnerJoinUserPost();

    @Query("select c " +
            "from Comment c " +
            "INNER JOIN c.user u")
    List<Comment> ExplicitInnerJoinUserComment();
}
