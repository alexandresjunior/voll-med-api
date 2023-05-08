package med.voll.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacienteListagemDTO {

    private Long id;
    private String nome;
    private String email;
    private String cpf;

}
