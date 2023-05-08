package med.voll.api.model;

import java.util.Objects;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import med.voll.api.dto.EnderecoDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String complemento;
    private String numero;

    public void updateModelFromDTO(EnderecoDTO dto) {
        if (Objects.nonNull(dto.getLogradouro())) {
            this.logradouro = dto.getLogradouro();
        }

        if (Objects.nonNull(dto.getBairro())) {
            this.bairro = dto.getBairro();
        }

        if (Objects.nonNull(dto.getCep())) {
            this.cep = dto.getCep();
        }

        if (Objects.nonNull(dto.getCidade())) {
            this.cidade = dto.getCidade();
        }

        if (Objects.nonNull(dto.getUf())) {
            this.uf = dto.getUf();
        }

        if (Objects.nonNull(dto.getNumero())) {
            this.numero = dto.getNumero();
        }

        if (Objects.nonNull(dto.getComplemento())) {
            this.complemento = dto.getComplemento();
        }
    }

}
