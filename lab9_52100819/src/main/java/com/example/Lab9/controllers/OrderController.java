package com.example.Lab9.controllers;

import com.example.Lab9.dto.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Lab9.config.WebSecurityConfig;
import com.example.Lab9.dto.ResDTO;
import com.example.Lab9.models.Order;
import com.example.Lab9.models.Product;
import com.example.Lab9.services.OrderService;
import com.example.Lab9.services.ProductService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final ProductService productService;
    @GetMapping
    public ResponseEntity<?> getAllOrders(){
        return ResponseEntity.ok(
                new ResDTO(
                        "Orders fetched successfully",
                        true,
                        orderService.getAllOrders()
                )
        );
    }

    @PostMapping
    public ResponseEntity<?> addOrder(@RequestBody OrderDTO order){
        Order object = new Order();
        object.setTotal(order.getTotal());

        List<Product> products = new ArrayList<>();

        order.getProductIds().forEach(id -> {
            products.add(productService.getProductById(id));
        });

        object.setProducts(products);

        return ResponseEntity.ok(
            new ResDTO(
                    "Orders fetched successfully",
                    true,
                    orderService.addOrder(object)
            )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderId(@PathVariable long id){
        return ResponseEntity.ok(
                new ResDTO(
                        "Order fetched successfully",
                        true,
                        orderService.getById(id)
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrder(@PathVariable long id, @RequestBody OrderDTO order){
        Order object = new Order();
        object.setOrderNumber(id);
        object.setTotal(order.getTotal());

        List<Product> products = new ArrayList<>();

        order.getProductIds().forEach(pId -> {
            products.add(productService.getProductById(pId));
        });

        object.setProducts(products);

        orderService.updateOrder(object);

        return ResponseEntity.ok(
                new ResDTO(
                        "Order updated successfully",
                        true,
                        null
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable long id){
        orderService.deleteOrder(id);
        return ResponseEntity.ok(
                new ResDTO(
                        "Order deleted successfully",
                        true,
                        null
                )
        );
    }



}
