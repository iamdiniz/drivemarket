-- Como criamos a tabela Fabricante, precisamos inserir primeiro o fabricante e depois o Carro.
-- Para que assim possa funcionar o relacionamento, OBS: Especificar o id do relacionamento!! fabricante_id

INSERT INTO Fabricante (nome, pais_origem, ano_fundacao) VALUES ('Nissan', 'Japão', 1933);
INSERT INTO Fabricante (nome, pais_origem, ano_fundacao) VALUES ('Toyota Motor Corporation', 'Japão', 1937);
INSERT INTO Fabricante (nome, pais_origem, ano_fundacao) VALUES ('Mitsubishi Motors', 'Japão', 1870);
INSERT INTO Fabricante (nome, pais_origem, ano_fundacao) VALUES ('Honda Motor Company', 'Japão', 1946);

INSERT INTO Carro (modelo, ano, preco, potencia, cor, carroceria, combustivel, cambio, placa, numero_chassi, descricao, fabricante_id) VALUES ('Toyota Corolla', 2022, 35000.00, 2.0, 'Prata', 'Sedã', 'Gasolina', 'Automático', 'ABC123', '1234567890', 'Carro confortável para viagens longas.', 2);
INSERT INTO Carro (modelo, ano, preco, potencia, cor, carroceria, combustivel, cambio, placa, numero_chassi, descricao, fabricante_id) VALUES ('Nissan GT-R34', 2002, 65000.00, 2.6, 'Prata', 'Coupé', 'Gasolina', 'Automático', 'NIS34GT', '9876543210', 'Um lendário esportivo japonês, conhecido por sua velocidade e desempenho impressionantes.', 1);
INSERT INTO Carro (modelo, ano, preco, potencia, cor, carroceria, combustivel, cambio, placa, numero_chassi, descricao, fabricante_id) VALUES ('Toyota Supra', 2022, 72000.00, 3.0, 'Vermelho', 'Coupé', 'Gasolina', 'Automático', 'SUP123', '1111111111', 'Um lendário esportivo japonês conhecido por sua potência e estilo.', 2);
INSERT INTO Carro (modelo, ano, preco, potencia, cor, carroceria, combustivel, cambio, placa, numero_chassi, descricao, fabricante_id) VALUES ('Mitsubishi Lancer', 2022, 35000.00, 2.0, 'Branco', 'Sedã', 'Gasolina', 'Automático', 'LAN456', '2222222222', 'Um sedan confiável e econômico.', 3);
INSERT INTO Carro (modelo, ano, preco, potencia, cor, carroceria, combustivel, cambio, placa, numero_chassi, descricao, fabricante_id) VALUES ('Nissan Silvia S15', 2000, 48000.00, 2.0, 'Azul', 'Coupé', 'Gasolina', 'Manual', 'SIL777', '3333333333', 'Um carro esportivo icônico, muito apreciado por entusiastas do automobilismo.', 1);
INSERT INTO Carro (modelo, ano, preco, potencia, cor, carroceria, combustivel, cambio, placa, numero_chassi, descricao, fabricante_id) VALUES ('Honda Civic', 2022, 32000.00, 2.0, 'Preto', 'Sedã', 'Gasolina', 'Automático', 'XYZ789', '0987654321', 'Design moderno e econômico.', 4);
