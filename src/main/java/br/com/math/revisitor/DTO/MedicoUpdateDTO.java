package br.com.math.revisitor.DTO;

import jakarta.validation.constraints.NotNull;

public record MedicoUpdateDTO(@NotNull Long id, String nome, String telefone, EnderecoDTO endereco) {



}
