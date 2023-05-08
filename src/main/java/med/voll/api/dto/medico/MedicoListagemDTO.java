package med.voll.api.dto.medico;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import med.voll.api.constants.Especialidade;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicoListagemDTO {

    private Long id;
    private String nome;
    private String email;
    private String crm;
    private Especialidade especialidade;

}
