package boot.jpa.join.domain.user;

import boot.jpa.join.dto.comment.CommentFindAllDto;
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
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @After
    public void cleanUp() {
        userRepository.deleteAll();
    }

    @Test
    public void ImplicitInnerJoinUserPost() {
        //given : data-h2.sql

        //when
        /** select u.posts from User u*/
        List<PostFindAllDto> posts = userRepository.findAllPost().stream()
                .map(PostFindAllDto::new)
                .collect(Collectors.toList());

        //then
        assertThat(posts.size(), is(4));
    }

    @Test
    public void ImplicitInnerJoinUserComment() {
        //given : data-h2.sql

        //when
        /** select u.comments from User u*/
        List<CommentFindAllDto> comments = userRepository.findAllComment().stream()
                .map(CommentFindAllDto::new)
                .collect(Collectors.toList());

        //then
        assertThat(comments.size(), is(12));
    }
}