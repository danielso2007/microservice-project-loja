INSERT INTO fornecedor (endereco, estado, nome) VALUES('Travessa Coronel João Teixeira, 718, Conselheiro Paulino, Nova Friburgo', 'RJ', 'Renato e Sophia Publicidade e Propaganda ME');
INSERT INTO fornecedor (endereco, estado, nome) VALUES('Praça Samuel Mac Dowell, 403, Taquara, Rio de Janeiro', 'RJ', 'Nathan e Emilly Alimentos ME');
INSERT INTO fornecedor (endereco, estado, nome) VALUES('Rua Francisco Dantas, 671, Freguesia (Jacarepaguá)', 'RJ', 'Marcos Vinicius e Kevin Gráfica Ltda');
INSERT INTO fornecedor (endereco, estado, nome) VALUES('Rua Venceslau Brás, 538, Parque Regina', 'RJ', 'Bernardo e Enrico Marketing Ltda');
INSERT INTO fornecedor (endereco, estado, nome) VALUES('Rua Getúlio das Neves, 269, Jardim Botânico', 'RJ', 'Giovanni e Pedro Henrique Marketing Ltda');
INSERT INTO fornecedor (endereco, estado, nome) VALUES('Rua João Bernardino de Souza, 143, Parque da Cidadania, São José do Rio Preto', 'SP', 'Martin e Renato Ferragens ME');
INSERT INTO fornecedor (endereco, estado, nome) VALUES('Rua Jayme Fingerman, 847, Parque Santo Antônio', 'SP', 'Jennifer e Iago Pizzaria Delivery Ltda');
INSERT INTO fornecedor (endereco, estado, nome) VALUES('Rua B-14, 983, Jardim Progresso, Ribeirão Preto', 'SP', 'Bárbara e Renan Telecom ME');
INSERT INTO fornecedor (endereco, estado, nome) VALUES('Rua do Bosque, 224, Caputera, Arujá', 'SP', 'Diogo e Hadassa Casa Noturna Ltda');
INSERT INTO fornecedor (endereco, estado, nome) VALUES('Rua Violeta, 724, São João, João Monlevade', 'MG', 'Sueli e Lucas Marcenaria ME');
INSERT INTO fornecedor (endereco, estado, nome) VALUES('Rua Bela Vista, 744, Vila Paiva, Varginha', 'MG', 'Emily e Marina Telas Ltda');
INSERT INTO fornecedor (endereco, estado, nome) VALUES('Rua José Maria de Magalhães, 231, Centro, Coronel Fabriciano', 'MG', 'Vinicius e Mariane Lavanderia Ltda');

INSERT INTO produto(estado, nome, preco, descricao)VALUES('RJ', 'Lorem', 200.98, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.');
INSERT INTO produto(estado, nome, preco, descricao)VALUES('RJ', 'Etiam', 1100.66, 'Etiam id arcu sed libero auctor luctus id ullamcorper ex.');
INSERT INTO produto(estado, nome, preco, descricao)VALUES('RJ', 'Proin', 434.52, 'Proin id sem maximus, tempor risus vitae, condimentum tellus.');
INSERT INTO produto(estado, nome, preco, descricao)VALUES('RJ', 'Suspendisse', 785.12, 'Suspendisse sed convallis odio. Etiam rutrum elit a ante bibendum, vel efficitur leo ornare. In gravida cursus tempus.');
INSERT INTO produto(estado, nome, preco, descricao)VALUES('RJ', 'Vivamus', 2145.87, 'Vivamus vel tincidunt sapien, sit amet condimentum metus.');

INSERT INTO produto(estado, nome, preco, descricao)VALUES('SP', 'Class', 0, 'Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. ');
INSERT INTO produto(estado, nome, preco, descricao)VALUES('SP', 'Nam', 0, 'Nam at nunc ut eros elementum ultrices id eu quam. Aenean ut metus tortor.');
INSERT INTO produto(estado, nome, preco, descricao)VALUES('SP', 'Vestibulum', 0, 'Vestibulum sollicitudin a massa ut placerat. Maecenas in lectus iaculis, fermentum arcu non, luctus lacus.');
INSERT INTO produto(estado, nome, preco, descricao)VALUES('SP', 'Lacinia', 0, 'Proin lacinia metus quis odio condimentum, quis feugiat nisl pellentesque. Vivamus consectetur erat neque, et tempor libero rutrum sed.');

INSERT INTO produto(estado, nome, preco, descricao)VALUES('MG', 'Praesent', 0, 'Praesent eget convallis est, at tempor neque. Curabitur eu elit ut lectus elementum porttitor nec in ante.');
INSERT INTO produto(estado, nome, preco, descricao)VALUES('MG', 'Nunc', 0, 'Nunc condimentum a purus id malesuada. Mauris aliquet, orci at aliquet lobortis, nisi sapien posuere lacus, et convallis elit tortor eget augue.');
INSERT INTO produto(estado, nome, preco, descricao)VALUES('MG', 'Duis', 0, 'Duis purus enim, sollicitudin ac venenatis ut, luctus nec eros. Praesent vehicula consequat lacus a ornare.');
INSERT INTO produto(estado, nome, preco, descricao)VALUES('MG', 'Pellentesque', 0, 'Pellentesque mauris est, sodales a nisl sit amet, egestas pharetra tellus. Nunc at fermentum odio.');

INSERT INTO pedido(status, tempo_de_preparo)VALUES('RECEBIDO', 80);
INSERT INTO pedido(status, tempo_de_preparo)VALUES('PRONTO', 160);
INSERT INTO pedido(status, tempo_de_preparo)VALUES('PRONTO', 80);
INSERT INTO pedido(status, tempo_de_preparo)VALUES('ENVIADO', 80);
INSERT INTO pedido(status, tempo_de_preparo)VALUES('RECEBIDO', 80);
INSERT INTO pedido(status, tempo_de_preparo)VALUES('RECEBIDO', 160);
INSERT INTO pedido(status, tempo_de_preparo)VALUES('ENVIADO', 40);
INSERT INTO pedido(status, tempo_de_preparo)VALUES('PRONTO', 60);

INSERT INTO pedido_item(quantidade, produto_id, pedido_id)VALUES(5, 1, 1);
INSERT INTO pedido_item(quantidade, produto_id, pedido_id)VALUES(2, 2, 2);
INSERT INTO pedido_item(quantidade, produto_id, pedido_id)VALUES(1, 3, 3);
INSERT INTO pedido_item(quantidade, produto_id, pedido_id)VALUES(1, 4, 4);
INSERT INTO pedido_item(quantidade, produto_id, pedido_id)VALUES(2, 5, 5);
INSERT INTO pedido_item(quantidade, produto_id, pedido_id)VALUES(3, 6, 1);
INSERT INTO pedido_item(quantidade, produto_id, pedido_id)VALUES(10, 7, 2);
INSERT INTO pedido_item(quantidade, produto_id, pedido_id)VALUES(8, 8, 3);
INSERT INTO pedido_item(quantidade, produto_id, pedido_id)VALUES(7, 9, 4);
INSERT INTO pedido_item(quantidade, produto_id, pedido_id)VALUES(7, 8, 5);
