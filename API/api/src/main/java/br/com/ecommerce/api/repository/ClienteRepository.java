package br.com.ecommerce.api.repository;

import br.com.ecommerce.api.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
