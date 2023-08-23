package com.aoo.orderservice.controller;

import com.aoo.orderservice.client.InventoryClient;
import com.aoo.orderservice.dto.OrderDto;
import com.aoo.orderservice.entity.Order;
import com.aoo.orderservice.entity.OrderLineItems;
import com.aoo.orderservice.repository.OrderRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreaker;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.function.Supplier;

@RestController
@RequestMapping("/api/order")
@Slf4j
@RequiredArgsConstructor
public class OrderController {
    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;
    private final Resilience4JCircuitBreakerFactory circuitBreakerFactory;


    @PostMapping("")
    @CircuitBreaker(name = "service_A", fallbackMethod = "customFallBack")
    public String placeOrder(@RequestBody OrderDto orderDto){

        boolean productsInStock = orderDto.getOrderLineItemsList().stream().allMatch(
                lineItem -> inventoryClient.checkStock(lineItem.getSkuCode())
                    );
        if(productsInStock){
            Order order = new Order();
            order.setOrderLineItems(orderDto.getOrderLineItemsList());
            order.setOrderNumber(UUID.randomUUID().toString());
            log.info("Sending Order Details with Order Id {} to Notification Service", order.getId());
            orderRepository.save(order);
            return "Order Placed Successfully";
        }else{
            return "Order Failed - One of the Products in your Order is out of stock";
        }
    }
    private String customFallBack(Exception e){
        return "some product items of your order are not in the stock";
    }
    private Boolean handleErrorCase() {
        return false;
    }
}
