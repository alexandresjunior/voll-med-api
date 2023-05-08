package med.voll.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import med.voll.api.model.Paciente;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacienteCadastroDTO {

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Pattern(regexp = "\\d{2}-\\d{4,5}-\\d{4}")
    private String telefone;

    @NotBlank
    @Pattern(regexp = "\\d{3}.\\d{3}.\\d{3}-\\d{2}")
    private String cpf;

    @NotNull
    @Valid
    private EnderecoDTO endereco;

    public Paciente toModel() {
        Paciente paciente = new Paciente();

        paciente.setNome(this.nome);
        paciente.setEmail(this.email);
        paciente.setTelefone(this.telefone);
        paciente.setCpf(this.cpf);
        paciente.setEndereco(this.endereco.toModel());

        return paciente;
    }

}
