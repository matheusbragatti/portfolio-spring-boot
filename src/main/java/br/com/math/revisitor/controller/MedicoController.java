package br.com.math.revisitor.controller;

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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping()
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping()
    @Transactional
    public void postResource(@RequestBody @Valid MedicoDTO resource) {
        Medico result = new Medico(resource);
        medicoRepository.save(result);
    }

    @GetMapping
    public Page<MedicoListResponse> getAllResources(@PageableDefault(size = 10) Pageable pageable) {
        return medicoRepository.findAllByAtivoTrue(pageable).map(MedicoListResponse::new);
    }

    @Transactional
    @PutMapping
    public void updateResource(@RequestBody @Valid MedicoUpdateDTO resource) {
        Medico medico = medicoRepository.getReferenceById(resource.id());
        medico.atualizarInformacoes(resource);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void excluirMedico(@PathVariable Long id) {
        Medico medico = medicoRepository.getReferenceById(id);
        medico.desativar();
    }

}
