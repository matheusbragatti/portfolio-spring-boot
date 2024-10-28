package br.com.math.revisitor.DTO;

import br.com.math.revisitor.entity.Paciente;

public record PacienteListResponse(String nome, String email, String cpf) {
    public PacienteListResponse(Paciente paciente) {
        this(paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}