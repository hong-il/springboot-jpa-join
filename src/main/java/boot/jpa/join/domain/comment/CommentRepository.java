package boot.jpa.join.domain.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("select c " +
            "from Post p " +
            "JOIN p.user u " +
            "JOIN p.comments c " +
            "WHERE u.name IS NOT NULL")
    List<Comment> MultipleJoinUserComment();
}
