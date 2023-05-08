package med.voll.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.dto.MedicoAtualizacaoDTO;
import med.voll.api.dto.MedicoCadastroDTO;
import med.voll.api.dto.MedicoListagemDTO;
import med.voll.api.model.Medico;
import med.voll.api.repository.MedicoRepository;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @PostMapping
    @Transactional
    public void cadastrarMedico(@RequestBody @Valid MedicoCadastroDTO medicoDTO) {
        medicoRepository.save(medicoDTO.toModel());
    }

    @GetMapping
    public Page<MedicoListagemDTO> listarMedicos(
            @PageableDefault(size = 10, page = 0, sort = { "nome" }, direction = Direction.ASC) Pageable paginacao) {
        return medicoRepository.findAll(paginacao).map(medico -> medico.toListagemDTO());
    }

    @PutMapping
    @Transactional
    public void atualizarMedico(@RequestBody @Valid MedicoAtualizacaoDTO medicoDTO) {
        Optional<Medico> medico = medicoRepository.findById(medicoDTO.getId());

        if (medico.isPresent()) {
            medico.get().updateModelFromDTO(medicoDTO);
        }
    }

    @Autowired
    private MedicoRepository medicoRepository;

}
