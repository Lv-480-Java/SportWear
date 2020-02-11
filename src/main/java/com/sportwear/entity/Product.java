package com.sportwear.entity;

public class Product {

    private Long id;
    private String name;
    private String model;
    private String sex;
    private Byte size;
    private Long color_id;
    private Double price;
    private Long category_id;
    private Long brand_id;

    public Product() {
    }

    public Product(Long id, String name, String model, String sex,
                   Byte size, Long color_id, Double price, Long category_id, Long brand_id) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.sex = sex;
        this.size = size;
        this.color_id = color_id;
        this.price = price;
        this.category_id = category_id;
        this.brand_id = brand_id;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Byte getSize() {
        return size;
    }

    public void setSize(Byte size) {
        this.size = size;
    }

    public Long getColor_id() {
        return color_id;
    }

    public void setColor_id(Long color_id) {
        this.color_id = color_id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public Long getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Long brand_id) {
        this.brand_id = brand_id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", sex='" + sex + '\'' +
                ", size=" + size +
                ", color_id=" + color_id +
                ", price=" + price +
                ", category_id=" + category_id +
                ", brand_id=" + brand_id +
                '}';
    }
}
