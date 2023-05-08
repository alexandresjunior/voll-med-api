package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<MedicoListagemDTO> listarMedicos(Pageable paginacao) {
        return medicoRepository.findAll(paginacao).map(medico -> medico.toListagemDTO());
    }

    @Autowired
    private MedicoRepository medicoRepository;

}
