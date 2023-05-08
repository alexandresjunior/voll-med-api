package med.voll.api.model;

import java.util.Objects;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import med.voll.api.constants.Especialidade;
import med.voll.api.dto.MedicoAtualizacaoDTO;
import med.voll.api.dto.MedicoListagemDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "tb_medicos")
@Entity(name = "Medico")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public MedicoListagemDTO toListagemDTO() {
        MedicoListagemDTO dto = new MedicoListagemDTO();

        dto.setId(this.id);
        dto.setNome(this.nome);
        dto.setEmail(this.email);
        dto.setCrm(this.crm);
        dto.setEspecialidade(this.especialidade);

        return dto;
    }

    public void updateModelFromDTO(MedicoAtualizacaoDTO dto) {
        if (Objects.nonNull(dto.getNome())) {
            this.nome = dto.getNome();
        }

        if (Objects.nonNull(dto.getTelefone())) {
            this.telefone = dto.getTelefone();
        }

        if (Objects.nonNull(dto.getEndereco())) {
            this.endereco.updateModelFromDTO(dto.getEndereco());
        }
    }

}
