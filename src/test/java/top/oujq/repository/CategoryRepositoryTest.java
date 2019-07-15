package top.oujq.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.oujq.entity.Category;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository repository;

    @Test
    public void save(){

        Category category = new Category("jQuery");
        Category result = repository.save(category);
        Assert.assertNotNull(result);


    }

    @Test
    public void select(){
        List<Category> list = repository.findAll();
        for (Category ca : list){
            System.out.println(ca.getCategoryId());

        }

        Category category = repository.getOne(7);
        category.setCategoryName("Vue");
        Category result = repository.save(category);
        Assert.assertEquals("Vue", result.getCategoryName());
    }

    @Test
    public void delete(){
        repository.deleteAll();
    }

}