--  v2: MigrationS para adicionar a coluna de rank na tabela de cadastros

ALTER TABLE tb_cadastro
ADD COLUMN rank VARCHAR(255);