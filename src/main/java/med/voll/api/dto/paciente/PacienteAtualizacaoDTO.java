package med.voll.api.dto.paciente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import med.voll.api.dto.endereco.EnderecoDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacienteAtualizacaoDTO {

    private Long id;
    private String nome;
    private String telefone;
    private EnderecoDTO endereco;

}
