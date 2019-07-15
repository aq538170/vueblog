package top.oujq.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.oujq.entity.BlogCategory;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogCategoryRepositoryTest {

    @Autowired
    private BlogCategoryRepository repository;

    @Test
    public void save(){
        BlogCategory blogCategory = new BlogCategory(4,8);
        BlogCategory result = repository.save(blogCategory);
        Assert.assertNotNull(result);
    }

    @Test
    public void select(){
        BlogCategory blogCategory = repository.getOne(9);
        System.out.println(blogCategory.toString());
        blogCategory.setCategoryId(1);
        repository.save(blogCategory);

//        Assert.assertEquals("9",blogCategory.getId());
    }

}