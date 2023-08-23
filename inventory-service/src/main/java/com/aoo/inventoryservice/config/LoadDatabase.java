package com.aoo.inventoryservice.config;

import com.aoo.inventoryservice.entity.Inventory;
import com.aoo.inventoryservice.repository.InventoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    @Bean
    public CommandLineRunner initDatabase(InventoryRepository inventoryRepository){
        Inventory inventory1 = Inventory.builder()
                .skuCode("IPHONE_12_RED")
                .stock(100).build();
        Inventory inventory2 = Inventory.builder()
                .skuCode("IPHONE_12_GREY")
                .stock(100).build();
        return args -> {
            log.info(" Preloading "+inventoryRepository.save(inventory1));
            log.info(" Preloading "+inventoryRepository.save(inventory2));
        };
    }
}
