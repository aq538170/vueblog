package top.oujq.entity;

import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@Proxy(lazy = false)
public class BlogCategory {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer blogId;

    private Integer categoryId;

    public BlogCategory(){

    }

    public BlogCategory (Integer blogId, Integer categoryId){
        this.blogId = blogId;
        this.categoryId = categoryId;
    }
}
