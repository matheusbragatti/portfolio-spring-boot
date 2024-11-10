package br.com.math.revisitor.controller;

import br.com.math.revisitor.DTO.DadosDetalhamentoMedico;
import br.com.math.revisitor.DTO.MedicoDTO;
import br.com.math.revisitor.DTO.MedicoListResponse;
import br.com.math.revisitor.DTO.MedicoUpdateDTO;
import br.com.math.revisitor.entity.Medico;
import br.com.math.revisitor.repository.MedicoRepository;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping()
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping()
    @Transactional
    public ResponseEntity postResource(@RequestBody @Valid MedicoDTO resource, UriComponentsBuilder uriBuilder) {
        Medico result = new Medico(resource);
        medicoRepository.save(result);

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(result.getID()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(result));
    }

    @GetMapping
    public ResponseEntity<Page<MedicoListResponse>> getAllResources(@PageableDefault(size = 10) Pageable pageable) {
        var page = medicoRepository.findAllByAtivoTrue(pageable).map(MedicoListResponse::new);
        return ResponseEntity.ok(page);
    }

    @Transactional
    @PutMapping
    public ResponseEntity updateResource(@RequestBody @Valid MedicoUpdateDTO resource) {
        Medico medico = medicoRepository.getReferenceById(resource.id());
        medico.atualizarInformacoes(resource);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity excluirMedico(@PathVariable Long id) {
        Medico medico = medicoRepository.getReferenceById(id);
        medico.desativar();
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity getMedico(@PathVariable Long id) {
        Medico medico = medicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

}
