package med.voll.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import med.voll.api.model.Endereco;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDTO {

    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
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
