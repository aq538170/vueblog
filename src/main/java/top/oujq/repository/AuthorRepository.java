package top.oujq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.oujq.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
