package top.oujq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.oujq.entity.Category;

import java.util.List;
import java.util.Set;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    List<Category> findCategoriesByCategoryIdIn(Set<Integer> categoryIds);


}
