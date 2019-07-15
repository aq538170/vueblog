package top.oujq.entity;

import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Proxy(lazy = false)
public class Blog {

    @Id
    @GeneratedValue
    private Integer blogId;

    private String title;

    private String content;

    private Integer authorId;

    public Blog() {
    }

    public Blog(String title, String content, Integer authorId) {
        this.title = title;
        this.content = content;
        this.authorId = authorId;
    }
}
