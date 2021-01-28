package com.mejdeddine.ECommerce.backend.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//Since we named the class Order, by default the table named ORDER should be created.Since we named the class Order, by default the table named ORDER should be created. But because that is a reserved SQL word, we added @Table(name = “orders”) to avoid conflicts.
// But because that is a reserved SQL word, we added @Table(name = “orders”) to avoid conflicts.
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateCreated;

    private String status;


    //we have a @OneToMany relation representing the order's details.
    @JsonManagedReference
    @OneToMany(mappedBy = "pk.order")
    @Valid
    private List<OrderProduct> orderProducts = new ArrayList<>();


    // we have two @Transient methods that will return a total amount for that order and the number of products in it.
    // Both represent calculated data, so there is no need to store it in the database.
    @Transient
    public Double getTotalOrderPrice() {
        double sum = 0D;
        List<OrderProduct> orderProducts = getOrderProducts();
        for (OrderProduct op : orderProducts) {
            sum += op.getTotalPrice();
        }
        return sum;
    }
    //Java's transient keyword is used to denote that a field is not to be serialized,
    // whereas JPA's @Transient annotation is used to indicate that a field is not to be persisted
    // in the database, i.e. their semantics are different.
    @Transient
    public int getNumberOfProducts() {
        return this.orderProducts.size();
    }


}
