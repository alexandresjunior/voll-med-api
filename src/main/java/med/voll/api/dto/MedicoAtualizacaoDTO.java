package med.voll.api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
