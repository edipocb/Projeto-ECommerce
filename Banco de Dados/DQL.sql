-- DQL 
-- PRINCIPAL COMANDO DQL E O SELECT 


SELECT nome_completo, telefone FROM ecommerce.cliente;

SELECT nome, idade, cpf FROM clinica.paciente;

SELECT * FROM ecommerce.produto;

SELECT * FROM clinica.consulta;

--JOIN 
-- Com o JOIN posso juntar tabelas
-- Utilizando a chave estrangeira


-- Listar, data , Valor , Nome medico

SELECT 
	cs.data,
	valor,
	nome
FROM clinica.consulta AS cs     -- Atribui um apelido para diferenciar data de consulta e data de medico caso 
--tenha mais de uma coluna com o mesmo nome
JOIN
	clinica.medico AS med
ON  clinica.consulta.id_medico = clinica.medico.id_medico;


SELECT 
	cs.data,
	valor,
	nome
FROM clinica.consulta AS cs     -- Atribui um apelido para diferenciar data de consulta e data de medico caso 
--tenha mais de uma coluna com o mesmo nome
JOIN
	clinica.medico AS med
ON  cs.id_medico = clinica.medico.id_medico;

-- Exercicio 1
SELECT 
	pedido_id,
	nome_completo
FROM ecommerce.pedido
JOIN ecommerce.cliente
ON	ecommerce.cliente.cliente_id = ecommerce.cliente.cliente_id;

SELECT * FROM ecommerce.pedido;


-- Exercicio 1
SELECT nome_completo, email FROM ecommerce.cliente;

-- Exercicio 2
SELECT * FROM ecommerce.produto
SELECT * FROM ecommerce.produto where preco > 450.00;

-- Exercicio 3

INSERT INTO ecommerce.cliente(nome_completo, email, senha, telefone, data_cadastro) VALUES
('Joao Silva', 'edipocb12@email.com', 'Teste@123', 13963245544, '2025-08-28')
SELECT * FROM ecommerce.cliente WHERE telefone like '%11%';

-- Exercicio 4 
INSERT INTO ecommerce.produto(nome_produto, descricao, preco, estoque_disponivel, imagem_url) VALUES
('Luva', 'Jogo', '350', 70, 'Teste_email')

SELECT * FROM ecommerce.produto
WHERE preco < 500.00 AND estoque_disponivel >= 50;
SELECT * FROM ecommerce.produto

-- Exercicio 5 
SELECT * FROM ecommerce.produto ORDER BY preco ASC;

-- Exercicio 6
SELECT * FROM ecommerce.cliente ORDER BY data_cadastro DESC LIMIT 2;
-- **Exercício:** Mostre os 2 primeiros clientes que se cadastraram no sistema (os mais antigos).
-- **Dica:** Após ordenar com `ORDER BY`, use o comando `LIMIT` para restringir o número de resultados.


SELECT 
	pedido_id,
	nome_completo
FROM ecommerce.pedido
JOIN ecommerce.cliente
ON	ecommerce.cliente.cliente_id = ecommerce.cliente.cliente_id;


