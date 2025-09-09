--INSERT INTO clinica.medico(nome, especialidade, crm) VALUES
--('Edipo', 'Ortopedia', '123456'),
--('Cristiano', 'Cardiologista', '654321')



INSERT INTO ecommerce.cliente(nome_completo, email, senha, telefone, data_cadastro) VALUES
('Cristiano Batista', 'edipocb123@email.com', 'Teste@123', 11963245544, '2025-08-28')

SELECT * FROM ecommerce.cliente;


INSERT INTO ecommerce.produto(nome_produto, descricao, preco, estoque_disponivel, imagem_url)
VALUES ('Tenis', 'Basquete', 700.00, 50, 'www.pdv/tenis')

SELECT * FROM ecommerce.produto;

INSERT INTO ecommerce.pedido(data_pedido, valor_total, status, cliente_id)
VALUES ('2025-05-20', 500.00, 'Pago', 1)
SElECT * FROM ecommerce.pedido;


INSERT INTO ecommerce.pagamento(status, data_pagamento, pedido_id)
VALUES ('Criado', '2025-09-09', 1);
select * from ecommerce.pagamento;






