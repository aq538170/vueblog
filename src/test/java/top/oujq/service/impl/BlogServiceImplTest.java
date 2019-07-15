package top.oujq.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.test.context.junit4.SpringRunner;
import top.oujq.dto.BlogDTO;
import top.oujq.entity.Author;
import top.oujq.entity.Blog;
import top.oujq.entity.Category;
import top.oujq.repository.AuthorRepository;
import top.oujq.repository.CategoryRepository;
import top.oujq.service.BlogService;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogServiceImplTest {

    @Autowired
    private BlogService service;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void findOne() {
        BlogDTO blogDTO = service.findOne(4);
        System.out.println(blogDTO.toString());
    }

    @Test
    public void findAll() {
        PageRequest request = PageRequest.of(0,10);
        Page<BlogDTO> result = service.findAll(request);
        List<BlogDTO> blogDTOList = result.getContent();

        for (BlogDTO blogDTO : blogDTOList){
            System.out.println(blogDTO.toString());
        }

        System.out.println(result.getTotalElements());
        System.out.println(result.getTotalPages());

        System.out.println(request);
    }

    @Test
    public void save() {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(8);
        List<Category> categoryList = categoryRepository.findCategoriesByCategoryIdIn(set);
        Author author = authorRepository.getOne(6);
        BlogDTO blogDTO = new BlogDTO();


        double random = Math.random();
//        blogDTO.setBlogId(13);
        blogDTO.setTitle("测试" + random);
        blogDTO.setContent("务要成功");

        blogDTO.setAuthor(author);
        blogDTO.setCategories(categoryList);

        service.save(blogDTO);

    }

    @Test
    public void delete() {

//        service.delete(30);

    }

    @Test
    public void findByAuthorId() {
    }

    @Test
    public void findByCategoryId() {
    }
}