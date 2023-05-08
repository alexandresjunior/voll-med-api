ALTER TABLE tb_pacientes ADD ativo TINYINT;

UPDATE tb_pacientes SET ativo = 1;