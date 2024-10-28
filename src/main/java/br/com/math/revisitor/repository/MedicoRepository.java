package br.com.math.revisitor.repository;

import br.com.math.revisitor.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
