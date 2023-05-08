package med.voll.api.model;

import java.util.Objects;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import med.voll.api.dto.PacienteAtualizacaoDTO;
import med.voll.api.dto.PacienteListagemDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "tb_pacientes")
@Entity(name = "Paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    @Embedded
    private Endereco endereco;

    public PacienteListagemDTO toListagemDTO() {
        PacienteListagemDTO dto = new PacienteListagemDTO();

        dto.setId(this.id);
        dto.setNome(this.nome);
        dto.setEmail(this.email);
        dto.setCpf(this.cpf);

        return dto;
    }

    public void updateModelFromDTO(PacienteAtualizacaoDTO dto) {
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
