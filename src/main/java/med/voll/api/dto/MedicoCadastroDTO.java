package med.voll.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import med.voll.api.constants.Especialidade;
import med.voll.api.model.Medico;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicoCadastroDTO {

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Pattern(regexp = "\\d{2}-\\d{4,5}-\\d{4}")
    private String telefone;

    @NotBlank
    @Pattern(regexp = "\\d{4,6}")
    private String crm;

    @NotNull
    private Especialidade especialidade;

    @NotNull
    @Valid
    private EnderecoDTO endereco;

    public Medico toModel() {
        Medico medico = new Medico();

        medico.setNome(this.nome);
        medico.setEmail(this.email);
        medico.setTelefone(this.telefone);
        medico.setCrm(this.crm);
        medico.setEndereco(this.endereco.toModel());
        medico.setEspecialidade(this.especialidade);
        medico.setAtivo(true);

        return medico;
    }

}
