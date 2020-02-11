package com.sportwear.entity;

import java.time.LocalDate;

public class Order {

    private Long id;
    private LocalDate localDate;
    private Long count;
    private Long user_id;
    private Boolean is_buy;

    public Order() {
    }

    public Order(Long id, LocalDate localDate, Long count, Long user_id, Boolean is_buy) {
        this.id = id;
        this.localDate = localDate;
        this.count = count;
        this.user_id = user_id;
        this.is_buy = is_buy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Boolean getIs_buy() {
        return is_buy;
    }

    public void setIs_buy(Boolean is_buy) {
        this.is_buy = is_buy;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", localDate=" + localDate +
                ", count=" + count +
                ", user_id=" + user_id +
                ", is_buy=" + is_buy +
                '}';
    }
}
