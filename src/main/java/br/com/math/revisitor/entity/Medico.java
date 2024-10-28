package br.com.math.revisitor.entity;

import br.com.math.revisitor.DTO.MedicoDTO;
import jakarta.persistence.*;
import lombok.*;

@Table(name="medico")
@Entity(name="medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "ID")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public Medico(MedicoDTO resource) {
        this.nome = resource.nome();
        this.email = resource.email();
        this.telefone = resource.telefone();
        this.crm = resource.crm();
        this.endereco = new Endereco(resource.endereco());
        this.especialidade = resource.especialidade();
    }
}
