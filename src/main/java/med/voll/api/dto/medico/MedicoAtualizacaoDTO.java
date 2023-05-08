package med.voll.api.dto.medico;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import med.voll.api.dto.endereco.EnderecoDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicoAtualizacaoDTO {

    @NotNull
    private Long id;
    private String nome;
    private String telefone;
    private EnderecoDTO endereco;

}
