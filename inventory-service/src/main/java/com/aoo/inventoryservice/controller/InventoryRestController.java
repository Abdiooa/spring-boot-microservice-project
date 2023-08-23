package com.aoo.inventoryservice.controller;

import com.aoo.inventoryservice.entity.Inventory;
import com.aoo.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventory")
@Slf4j
public class InventoryRestController {
    private final InventoryRepository inventoryRepository;
    @GetMapping("/{skuCode}")
    public Boolean isInStock(@PathVariable("skuCode") String skuCode){
        log.info("Checking stock for product with skucode - " + skuCode);
        Inventory inventory = inventoryRepository.findBySkuCode(skuCode)
                .orElseThrow(()-> new RuntimeException("Cannot Find Product by sku code " + skuCode));
        return inventory.getStock()>0;
    }
}
