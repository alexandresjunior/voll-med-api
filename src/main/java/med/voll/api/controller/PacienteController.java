package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.dto.PacienteCadastroDTO;
import med.voll.api.dto.PacienteListagemDTO;
import med.voll.api.repository.PacienteRepository;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @PostMapping
    @Transactional
    public void cadastrarPaciente(@RequestBody @Valid PacienteCadastroDTO pacienteDTO) {
        pacienteRepository.save(pacienteDTO.toModel());
    }

    @GetMapping
    public Page<PacienteListagemDTO> listarPacientes(
            @PageableDefault(size = 10, page = 0, sort = { "nome" }, direction = Direction.ASC) Pageable paginacao) {
        return pacienteRepository.findAll(paginacao).map(paciente -> paciente.toListagemDTO());
    }

    @Autowired
    private PacienteRepository pacienteRepository;

}
