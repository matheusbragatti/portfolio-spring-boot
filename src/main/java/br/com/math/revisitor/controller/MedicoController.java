package br.com.math.revisitor.controller;

import br.com.math.revisitor.DTO.MedicoDTO;
import br.com.math.revisitor.DTO.MedicoListResponse;
import br.com.math.revisitor.entity.Medico;
import br.com.math.revisitor.repository.MedicoRepository;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<MedicoListResponse> getAllResources() {
        return medicoRepository.findAll().stream().map(MedicoListResponse::new).toList();
    }
}
