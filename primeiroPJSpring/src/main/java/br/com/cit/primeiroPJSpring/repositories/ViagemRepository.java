package br.com.cit.primeiroPJSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.cit.primeiroPJSpring.entities.Viagem;

@Repository
public interface ViagemRepository extends JpaRepository<Viagem, Long> {

	Viagem findByLocalDeDestino(String localDeDestino);

}