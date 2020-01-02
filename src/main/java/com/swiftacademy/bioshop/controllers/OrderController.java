package com.swiftacademy.bioshop.controllers;

import com.swiftacademy.bioshop.DTO.UserRegistrationDto;
import com.swiftacademy.bioshop.enums.OrderStatus;
import com.swiftacademy.bioshop.model.Item;
import com.swiftacademy.bioshop.model.Order;
import com.swiftacademy.bioshop.model.User;
import com.swiftacademy.bioshop.repositories.OrderRepository;
import com.swiftacademy.bioshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("order/")
public class OrderController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    // Get Current Cart
    @GetMapping(path = "/cart/user/{userId}")
    public Order getCart(@PathVariable Integer userId) {
        User user = userRepository.getOne(userId);

        // Find Order with OrderStatus Cart
        Order cart = user.getOrders().stream()
                .filter(order -> OrderStatus.CART.equals(order.getOrderStatus()))
                .findFirst().get();

        // If such Order exist then return it
        if (cart != null) {
            return cart;
        }

        // Otherwise crete new Order with OrderStatus Cart and return it
        cart = new Order();
        cart.setOrderStatus(OrderStatus.CART);

        return orderRepository.save(cart);
    }

    @PutMapping(path = "/remove-product/user/{userId}/product/{productId}")
    public void removeProductFromCart(@PathVariable Integer userId, @PathVariable Integer productId) {
        User user = userRepository.getOne(userId);
        Order cart = user.getOrders().stream()
                .filter(order -> OrderStatus.CART.equals(order.getOrderStatus()))
                .findFirst().get();
        // Find cart for user with given ID and remove product/item from cart with given Id;

        Set<Item> filteredItems = cart.getItems().stream()
                .filter(item -> !item.getProduct().getId().equals(productId))
                .collect(Collectors.toSet());
        cart.setItems(filteredItems);

        orderRepository.save(cart);
    }

    //TODO: Add Mapping for Adding Product to Cart
    @PutMapping(path = "/add-product")
    private Order addProduct(@RequestBody Integer userId, @RequestBody Integer productId) {

        return null;
    }

    // Update Order
    @PutMapping(path = "/order/{orderId}/status/{orderStatus}/user/{userId}")
    public Order updateOrderStatus(@PathVariable Integer orderId, @PathVariable String orderStatus,
                                   @PathVariable Integer userId) {
        // Find order with given Id and set status to be received orderStatus

        return null;// Remove this when logic above is done
    }

    // Get All Passed Orders
    @GetMapping(path = "/past-purchases/user/{userId}")
    public List<Order> getPastPurchases(@PathVariable Integer userId) {
        // Find all purchases with status different from Cart


        return null;// Remove this when logic above is done
    }
}
