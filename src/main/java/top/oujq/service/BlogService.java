package top.oujq.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import top.oujq.dto.BlogDTO;

public interface BlogService {

    BlogDTO findOne(Integer blogId);

    Page<BlogDTO> findAll(Pageable pageable);

    BlogDTO save(BlogDTO blogDTO);

    void delete(Integer blogId);

    Page<BlogDTO> findByAuthorId(Pageable pageable, Integer authorId);

    Page<BlogDTO> findByCategoryId(Pageable pageable, Integer categoryId);
}
