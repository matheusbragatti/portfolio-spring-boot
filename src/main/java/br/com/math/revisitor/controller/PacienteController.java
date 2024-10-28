package br.com.math.revisitor.controller;

import br.com.math.revisitor.DTO.PacienteDTO;
import br.com.math.revisitor.DTO.PacienteListResponse;
import br.com.math.revisitor.entity.Paciente;
import br.com.math.revisitor.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid PacienteDTO dados) {
        repository.save(new Paciente(dados));
    }

    @GetMapping
    public Page<PacienteListResponse> listar(@PageableDefault(page = 0, size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(PacienteListResponse::new);
    }

    @Transactional
    @PutMapping
    public void atualizar(@RequestBody @Valid PacienteDTO dados) {}

}