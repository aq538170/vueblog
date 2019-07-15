package top.oujq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.oujq.entity.BlogCategory;

import java.util.List;

@Repository
public interface BlogCategoryRepository extends JpaRepository<BlogCategory, Integer> {

    List<BlogCategory> findBlogCategoriesByBlogId(Integer blogId);

    List<BlogCategory> findBlogCategoriesByCategoryId(Integer categoryId);
}
