drop table if exists entrega;
CREATE TABLE `entrega` (`id` bigint(20) NOT NULL AUTO_INCREMENT, `data_para_busca` date NOT NULL, `endereco_destino` varchar(500) NOT NULL, `endereco_origem` varchar(500) NOT NULL, `pedido_id` bigint(20) NOT NULL, `previsao_para_entrega` date NOT NULL,  PRIMARY KEY (`id`)) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;