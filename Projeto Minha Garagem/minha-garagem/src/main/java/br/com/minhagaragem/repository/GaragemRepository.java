package br.com.minhagaragem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.minhagaragem.entities.Carro;

@Repository
public interface GaragemRepository extends JpaRepository<Carro, Integer> {

}
