package med.voll.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import med.voll.api.model.Endereco;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDTO {

    @NotBlank
    private String logradouro;

    @NotBlank
    private String bairro;

    @NotBlank
    @Pattern(regexp = "\\d{5}-\\d{3}")
    private String cep;

    @NotBlank
    private String cidade;

    @NotBlank
    private String uf;

    private String complemento;
    private String numero;

    public Endereco toModel() {
        Endereco endereco = new Endereco();

        endereco.setLogradouro(this.logradouro);
        endereco.setBairro(this.bairro);
        endereco.setCep(this.cep);
        endereco.setCidade(this.cidade);
        endereco.setUf(this.uf);
        endereco.setComplemento(this.complemento);
        endereco.setNumero(this.numero);

        return endereco;
    }

}
