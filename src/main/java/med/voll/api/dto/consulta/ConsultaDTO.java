package med.voll.api.dto.consulta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaDTO {

    @NotNull
    private Long idPaciente;

    @NotNull
    private Long idMedico;

    @NotBlank
    @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}")
    private String data;

    @NotBlank
    @Pattern(regexp = "\\d{2}:\\d{2}:\\d{2}")
    private String hora;

}
