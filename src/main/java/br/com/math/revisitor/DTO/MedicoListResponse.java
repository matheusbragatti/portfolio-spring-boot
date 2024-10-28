package br.com.math.revisitor.DTO;

import br.com.math.revisitor.entity.Especialidade;
import br.com.math.revisitor.entity.Medico;

public record MedicoListResponse(String nome, String email, String crm, Especialidade especialidade) {

    public MedicoListResponse(Medico medico){
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
