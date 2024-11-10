package br.com.math.revisitor.DTO;

import br.com.math.revisitor.entity.Endereco;
import br.com.math.revisitor.entity.Especialidade;
import br.com.math.revisitor.entity.Medico;

public record DadosDetalhamentoMedico(Long id, String nome, String email,String telefone, String crm, Especialidade especialidade, Endereco endereco) {

    public DadosDetalhamentoMedico(Medico medico) {
        this(medico.getID(), medico.getNome(), medico.getEmail(), medico.getTelefone(), medico.getCrm(), medico.getEspecialidade(), medico.getEndereco());
    }
}
