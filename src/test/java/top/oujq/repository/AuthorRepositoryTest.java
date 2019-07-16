package top.oujq.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.oujq.entity.Author;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository repository;

    @Test
    public void save(){
        Author author = new Author("古龙");
        Author result = repository.save(author);
        Assert.assertNotNull(result);

    }

    @Test
    public void select(){
//        List<Author> list = repository.findAll();
//        Assert.assertNotEquals(0,list.size());

        Author author = repository.getOne(33);
        author.setAuthorId(6);
        author.setAuthorName("蝴蝶蓝");
        Author result = repository.save(author);
        Assert.assertEquals("蝴蝶蓝", result.getAuthorName());
    }

    @Test
    public void delete(){
        repository.deleteById(5);
    }

}