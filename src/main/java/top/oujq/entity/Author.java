package top.oujq.entity;

import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@Proxy(lazy = false)
public class Author {

    @Id
    @GeneratedValue
    private Integer authorId;

    private String authorName;

    public Author(){}

    public Author(String authorName){
        this.authorName = authorName;
    }
}
