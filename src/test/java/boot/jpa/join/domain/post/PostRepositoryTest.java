package boot.jpa.join.domain.post;

import boot.jpa.join.dto.post.PostFindAllDto;
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
public class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @After
    public void cleanUp() {
        postRepository.deleteAll();
    }

    @Test
    public void LeftOuterJoinPostComment() {
        //given : data-h2.sql

        //when
        /** select DISTINCT p from Post p LEFT JOIN p.comments c*/
        List<PostFindAllDto> posts = postRepository.LeftOuterJoinPostComment().stream()
                .map(PostFindAllDto::new)
                .collect(Collectors.toList());

        //then
        assertThat(posts.size(), is(4));
    }

    @Test
    public void JoinWhereClausePostComment() {
        //given : data-h2.sql

        //when
        /** select p from Comment c, Post p WHERE c.post = p*/
        List<PostFindAllDto> posts = postRepository.JoinWhereClausePostComment().stream()
                .map(PostFindAllDto::new)
                .collect(Collectors.toList());

        //then
        assertThat(posts.size(), is(12));
    }
}
