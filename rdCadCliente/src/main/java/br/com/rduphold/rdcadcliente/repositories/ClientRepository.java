package br.com.rduphold.rdcadcliente.repositories;

import br.com.rduphold.rdcadcliente.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
