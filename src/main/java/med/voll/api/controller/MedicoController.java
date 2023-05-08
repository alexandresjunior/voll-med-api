package med.voll.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.dto.MedicoDTO;
import med.voll.api.dto.MedicoListagemDTO;
import med.voll.api.repository.MedicoRepository;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @PostMapping
    @Transactional
    public void cadastrarMedico(@RequestBody @Valid MedicoDTO medicoDTO) {
        medicoRepository.save(medicoDTO.toModel());
    }

    @GetMapping
    public List<MedicoListagemDTO> listarMedicos() {
        return medicoRepository.findAll().stream().map(
                medico -> medico.toListagemDTO()).toList();
    }

    @Autowired
    private MedicoRepository medicoRepository;

}
