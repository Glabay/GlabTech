package xyz.glabaystudios.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.glabaystudios.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}