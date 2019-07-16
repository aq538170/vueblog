package top.oujq.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import top.oujq.dto.BlogDTO;
import top.oujq.entity.Author;
import top.oujq.entity.Blog;
import top.oujq.entity.BlogCategory;
import top.oujq.entity.Category;
import top.oujq.repository.AuthorRepository;
import top.oujq.repository.BlogCategoryRepository;
import top.oujq.repository.BlogRepository;
import top.oujq.repository.CategoryRepository;
import top.oujq.service.BlogService;

import javax.transaction.Transactional;
import java.util.*;

@Service("blogService")
@Transactional
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private BlogCategoryRepository blogCategoryRepository;



    @Override
    public BlogDTO findOne(Integer blogId) {

        if (null == blogId){
            return null;
        }

        Blog blog = new Blog();
        Author author = new Author();
        List<Category> categoryList = new ArrayList<>();
        try{
            blog = blogRepository.getOne(blogId);

            System.out.println(blog.getAuthorId());

            if (null != blog.getAuthorId()){
                author = authorRepository.getOne(blog.getAuthorId());
            }

            List<BlogCategory> blogCategoryList = blogCategoryRepository.findBlogCategoriesByBlogId(blogId);
            Set<Integer> set = new HashSet<>();
            if (blogCategoryList.size() != 0){
                for (BlogCategory blogCategory : blogCategoryList){
                    set.add(blogCategory.getCategoryId());
                }
            }

            categoryList = categoryRepository.findCategoriesByCategoryIdIn(set);
        } catch (Exception e){

            e.printStackTrace();

            return null;
        }


        BlogDTO blogDTO = new BlogDTO();
        BeanUtils.copyProperties(blog, blogDTO);
//        blogDTO.setAuthor(author.getAuthorName());
        blogDTO.setAuthor(author);
        blogDTO.setCategories(categoryList);

        return blogDTO;
    }

    @Override
    public Page<BlogDTO> findAll(Pageable pageable) {
        Page<Blog> blogPage = blogRepository.findAll(pageable);
        List<Blog> blogList = blogPage.getContent();
        List<BlogDTO> blogDTOList = new ArrayList<>();

        for (Blog blog : blogList){
            blogDTOList.add(findOne(blog.getBlogId()));
        }

        Page<BlogDTO> blogDTOPage = new PageImpl<BlogDTO>(blogDTOList,pageable,blogPage.getTotalElements());

        return blogDTOPage;
    }

    @Override
    public BlogDTO save(BlogDTO blogDTO) {
        /*
        先存储blog，因为修改的博客会传入 blogId ，而新增的博客没有传入 blogId ，需要在存储的时候取到返回的新 blogId
         */
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogDTO, blog);
        blog.setAuthorId(blogDTO.getAuthor().getAuthorId());
        Blog newblog = blogRepository.save(blog);

        List<Category> categoryList = blogDTO.getCategories();

        Set<BlogCategory> set = new HashSet<>();
        List<BlogCategory> list = new ArrayList<>();
        // 从存储返回的对象取出 blogId
        Integer blogId = newblog.getBlogId();
        for (Category category : categoryList){
            set.add(new BlogCategory(blogId,category.getCategoryId()));
        }
        blogCategoryRepository.saveAll(set);

        return blogDTO;
    }

    @Override
    public void delete(Integer blogId) {
        blogRepository.deleteById(blogId);
        List<BlogCategory> blogCategoryList = blogCategoryRepository.findBlogCategoriesByBlogId(blogId);
//        List<Integer> blogCategoryIdList = new ArrayList<>();
//        for (BlogCategory blogCategory : blogCategoryList){
//            blogCategoryIdList.add(blogCategory.getId());
//        }
        blogCategoryRepository.deleteAll(blogCategoryList);

    }

    @Override
    public Page<BlogDTO> findByAuthorId(Pageable pageable, Integer authorId) {
        return null;
    }

    @Override
    public Page<BlogDTO> findByCategoryId(Pageable pageable, Integer categoryId) {
        return null;
    }
}
