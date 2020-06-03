DROP TABLE IF EXISTS pedido_item;
DROP TABLE IF EXISTS pedido;
DROP TABLE IF EXISTS produto;
DROP TABLE IF EXISTS fornecedor;
CREATE TABLE `fornecedor` (`id` bigint(20) NOT NULL AUTO_INCREMENT, `endereco` varchar(500) NOT NULL, `estado` varchar(2) NOT NULL, `nome` varchar(255) NOT NULL, PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `pedido` (`id` bigint(20) NOT NULL AUTO_INCREMENT, `status` varchar(50) NOT NULL, `tempo_de_preparo` int(11) DEFAULT NULL, PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `produto` (`id` bigint(20) NOT NULL AUTO_INCREMENT, `descricao` varchar(500) NOT NULL, `estado` varchar(2) NOT NULL, `nome` varchar(255) NOT NULL, `preco` decimal(19,2) DEFAULT NULL, PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `pedido_item` (`id` bigint(20) NOT NULL AUTO_INCREMENT, `quantidade` int(11) DEFAULT NULL, `produto_id` bigint(20) DEFAULT NULL, `pedido_id` bigint(20) DEFAULT NULL, PRIMARY KEY (`id`), KEY `FK8eyfr31j751fjws2y012awmpg` (`produto_id`), KEY `FKeyouxfvoi291lpo5168e6wpej` (`pedido_id`), CONSTRAINT `FK8eyfr31j751fjws2y012awmpg` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`), CONSTRAINT `FKeyouxfvoi291lpo5168e6wpej` FOREIGN KEY (`pedido_id`) REFERENCES `pedido` (`id`)) ENGINE=InnoDB DEFAULT CHARSET=latin1;