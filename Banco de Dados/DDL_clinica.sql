-- comentario
/*
Comentario de multiplas linhas
*/
-- Criar grupo de schemas
-- DDL - Criar  - create(serve para schema, tablea)

CREATE SCHEMA clinica;

-- CREATE TABLE <SCHEMA>.<NOME_DA_TABELA>

CREATE TABLE clinica.medico (
-- Informar colunas
-- nome_da_coluna tipo_de_dado
--PRIMARY KEY - CHAVE PRIMARIA
-- GENERATE ALWAYS AS IDENTITY - A CHEVA E CRIADA AUTOMATICAMENTE
id_medico INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
nome TEXT NOT NULL,
especialidade TEXT NOT NULL

);


CREATE TABLE clinica.paciente (

id_paciente INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
nome TEXT NOT NULL,
idade INT NOT NULL,
data_nascimento DATE NOT NULL
);


CREATE TABLE clinica.clinica (
  id_clinica INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
nome TEXT NOT NULL,
descricao TEXT NOT NULL,
endereco TEXT

);


CREATE TABLE clinica.consulta (
id_consulta INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
data TIMESTAMPTZ NOT NULL,
valor NUMERIC (10, 4),
-- mandeira extensa
id_medico INT NOT NULL,
FOREIGN KEY (id_medico) REFERENCES clinica.medico(id_medico),
-- mandeira abreviada
id_clinica INT NOT NULL REFERENCES clinica.clinica(id_clinica),
id_paciente INT NOT NULL REFERENCES clinica.paciente(id_paciente)
);

-- ALTER 

ALTER TABLE clinica.paciente
ADD COLUMN cpf VARCHAR(14) UNIQUE;

-- Apagar coluna 
-- ALTER TABLE clinica.paciente 
DROP COLUMN cpf;


--Renomear tabela  
ALTER TABLE clinica.paciente
RENAME TO novopaciente

--UNIQUE significa que cada cpf deve ser unico
-- impede que seja cadastrado algo que ja existe


-- TRUNCATE - Limpa a tabela (Somenta tabela )
-- TRUNCATE TABEL clinica.consulta RESTART IDENTITY
-- RESTART IDENTITY REINICIA A SEQUENCIA
-- Apagar tabela - DROP
-- apagar primeiro a chave estrangeira (apagar de dentro pra fora)
/*
DROP TABLE clinica.consulta;
DROP TABLE clinica.clinica;
DROP TABLE clinica.paciente;
DROP TABLE clinica.medico;
*/

-- DROP SCHEMA 