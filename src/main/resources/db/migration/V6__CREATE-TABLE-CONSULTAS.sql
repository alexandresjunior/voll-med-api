CREATE TABLE IF NOT EXISTS tb_consultas (
    id BIGINT NOT NULL AUTO_INCREMENT,
    idPaciente BIGINT,
    idMedico BIGINT,
    data DATE,
    hora TIME,
    PRIMARY KEY(id),
    FOREIGN KEY (idPaciente) REFERENCES tb_pacientes(id),
    FOREIGN KEY (idMedico) REFERENCES tb_medicos(id)
);
