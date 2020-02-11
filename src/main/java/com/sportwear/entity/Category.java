package com.sportwear.entity;

public class Category {

    private Long id;
    private String name;
    private Long category_id;

    public Category() {
    }

    public Category(Long id, String name, Long category_id) {
        this.id = id;
        this.name = name;
        this.category_id = category_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category_id=" + category_id +
                '}';
    }
}
