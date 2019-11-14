import com.funtl.itoken.service.admin.ServiceAdminApplication;
import com.funtl.itoken.service.admin.domain.Comment;
import com.funtl.itoken.service.admin.mapper.CommentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ServiceAdminApplication.class)
public class AdminServiceTest {

    @Autowired
    CommentMapper commentMapper;

    @Test
    public void register(){

    }

    @Test
    public void login(){

       List<Comment> list =commentMapper.selectAll();

        for (Comment comment : list) {
            System.out.println(comment);
        }
        System.out.println("111111111111111");
    }
}
