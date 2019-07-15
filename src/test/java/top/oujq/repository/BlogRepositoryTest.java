package top.oujq.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.oujq.entity.Blog;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogRepositoryTest {

    @Autowired
    private BlogRepository repository;

    @Test
    public void save(){
        Blog blog = new Blog();
        blog.setTitle("标题3");
        blog.setContent("内容3");
        blog.setAuthorId(6);

        Blog result = repository.save(blog);
        Assert.assertNotNull(result);
    }

    @Test
    public void select(){
        Blog blog = repository.getOne(3);
        blog.setContent("自增id可以修改吗");
        Blog result = repository.save(blog);
        Assert.assertEquals("自增id可以修改吗",result.getTitle());
    }

    @Test
    public void delete(){
        repository.deleteById(3);
    }

}