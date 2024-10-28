package br.com.math.revisitor.repository;

import br.com.math.revisitor.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}