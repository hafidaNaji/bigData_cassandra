package net.naji.tp2_cassandra_bddc.repositories;

import net.naji.tp2_cassandra_bddc.entities.Product;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface ProductRepository extends CassandraRepository<Product, UUID> {

}
