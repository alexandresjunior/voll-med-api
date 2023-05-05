package med.voll.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import med.voll.api.constants.Especialidade;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicoDTO {

    private String nome;
    private String email;
    private String crm;
    private Especialidade especialidade;
    private EnderecoDTO endereco;

}