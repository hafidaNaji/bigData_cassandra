package net.naji.tp2_cassandra_bddc.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;
@Table("products")
@NoArgsConstructor @AllArgsConstructor @Data
public class Product {
    @PrimaryKey
    private UUID id;
    private String name;
    private double price;
    private int quantity;

}
