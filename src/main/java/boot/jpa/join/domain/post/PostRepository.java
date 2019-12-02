package boot.jpa.join.domain.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("select DISTINCT p " +
            "from Post p " +
            "LEFT JOIN p.comments c")
    List<Post> LeftOuterJoinPostComment();

    @Query("select p " +
            "from Comment c, Post p " +
            "WHERE c.post = p")
    List<Post> JoinWhereClausePostComment();

    @Query("select p " +
            "from Comment c, Post p")
    List<Post> CartesianProductPostComment();
}
