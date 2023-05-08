package med.voll.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import med.voll.api.constants.Especialidade;
import med.voll.api.model.Medico;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicoDTO {

    private String nome;
    private String email;
    private String crm;
    private Especialidade especialidade;
    private EnderecoDTO endereco;

    public Medico toModel() {
        Medico medico = new Medico();

        medico.setNome(this.nome);
        medico.setEmail(this.email);
        medico.setCrm(this.crm);
        medico.setEndereco(this.endereco.toModel());
        medico.setEspecialidade(this.especialidade);

        return medico;
    }

}
