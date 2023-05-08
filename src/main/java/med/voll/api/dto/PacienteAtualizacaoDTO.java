package med.voll.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacienteAtualizacaoDTO {

    private Long id;
    private String nome;
    private String telefone;
    private EnderecoDTO endereco;

}
