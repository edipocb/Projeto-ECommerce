-- DML
--INSERT (CADASTRAR)
--UPDATE (ATUALIZAR)
--DELETE (APAGAR)

-- OPCIONAL
-- SET serach_path TO clinicaç
-- clinica.paciente altera para paciente


-- INSERT INTO <SCHEMA>.<TABELA>(<COLUNAS>) VALUES



INSERT INTO clinica.medico(nome, especialidade, crm) VALUES
('Edipo', 'Ortopedia', '123456'),
('Cristiano', 'Cardiologista', '654321')

INSERT INTO clinica.paciente(nome, idade, data_nascimento) values
('Maria', 30, '2002-07-20')

INSERT INTO clinica.clinica(nome, descricao, endereco) VALUES
('TestClinic', 'Clinica Teste', 'Rua sem numero')

INSERT INTO clinica.consulta(data, valor, id_medico, id_clinica, id_paciente) VALUES
('2003-09-25 ', 150.50, 1, 1, 3)

-- UPDATE
UPDATE clinica.consulta SET valor = 100.30, id_medico = 2 WHERE id_medico = 1;
UPDATE clinica.consulta SET VALOR > 500 AND valor < 1000;
UPDATE clinica.consulta SET VALOR > 500 OR valor < 1000;
UPDATE clinica.consulta SET valor = 530.00 WHERE valor > 500;

DELETE FROM clinica.medico WHERE nome = `Edipo`;
DELETE FROM clinica.medico WHERE id_medico = 7;

--COMANDOS DQL
-- SELECT <QUAIS_COLUNAS> FROM <SCHEMA>.<TABELA>
SELECT id_medico, nome FROM clinica.medico
SELECT * FROM clinica.medico
SELECT * FROM clinica.paciente
SELECT * FROM clinica.clinica
SELECT * FROM clinica.consulta

















