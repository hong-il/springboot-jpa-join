package boot.jpa.join.domain.comment;

import boot.jpa.join.dto.comment.CommentFindAllDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentRepositoryTest {

    @Autowired
    private CommentRepository commentRepository;

    @After
    public void cleanUp() {
        commentRepository.deleteAll();
    }

    @Test
    public void MultipleJoinUserComment() {
        //given : data-h2.sql

        //when
        /** select c from Post p JOIN p.user u JOIN p.comments c WHERE u.name IS NOT NULL*/
        List<CommentFindAllDto> comments = commentRepository.MultipleJoinUserComment().stream()
                .map(CommentFindAllDto::new)
                .collect(Collectors.toList());

        //then
        System.out.println();
        assertThat(comments.size(), is(12));
    }
}
