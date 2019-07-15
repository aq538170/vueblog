package top.oujq.dto;

import lombok.Data;
import top.oujq.entity.Author;
import top.oujq.entity.Category;

import java.util.List;

@Data
public class BlogDTO {

    private Integer blogId;

    private String title;

    private String content;

    private Author author;

    private List<Category> categories;

}
