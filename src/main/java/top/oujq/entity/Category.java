package top.oujq.entity;


import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@Proxy(lazy = false)
public class Category {

    @Id
    @GeneratedValue
    private Integer categoryId;

    private String categoryName;

    public Category(){}

    public Category(String categoryName){
        this.categoryName = categoryName;
    }
}
