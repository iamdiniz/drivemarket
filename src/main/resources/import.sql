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




INSERT INTO Cliente (nome, email, cpf, estado, pais, cidade, endereco, telefone) VALUES ('João Silva', 'joao@email.com', '123.456.789-01', 'SP', 'Brasil', 'São Paulo', 'Rua A, 123', '123456789');

INSERT INTO Cliente (nome, email, cpf, estado, pais, cidade, endereco, telefone) VALUES ('Maria Oliveira', 'maria@email.com', '987.654.321-09', 'RJ', 'Brasil', 'Rio de Janeiro', 'Avenida B, 456', '987654321');

INSERT INTO Cliente (nome, email, cpf, estado, pais, cidade, endereco, telefone) VALUES ('Carlos Santos', 'carlos@email.com', '111.222.333-44', 'MG', 'Brasil', 'Belo Horizonte', 'Travessa C, 789', '111222333');

INSERT INTO Cliente (nome, email, cpf, estado, pais, cidade, endereco, telefone) VALUES ('Ana Pereira', 'ana@email.com', '555.666.777-88', 'RS', 'Brasil', 'Porto Alegre', 'Rua D, 987', '555666777');

INSERT INTO Cliente (nome, email, cpf, estado, pais, cidade, endereco, telefone) VALUES ('Lucas Souza', 'lucas@email.com', '999.888.777-66', 'BA', 'Brasil', 'Salvador', 'Avenida E, 543', '999888777');




INSERT INTO Vendedor (nome, email, cpf, telefone, cargo) VALUES ('Fernanda Silva', 'fernanda@email.com', '123.456.789-01', '123456789', 'Gerente de Vendas');

INSERT INTO Vendedor (nome, email, cpf, telefone, cargo) VALUES ('Ricardo Oliveira', 'ricardo@email.com', '987.654.321-09', '987654321', 'Vendedor Sênior');

INSERT INTO Vendedor (nome, email, cpf, telefone, cargo) VALUES ('Juliana Santos', 'juliana@email.com', '111.222.333-44', '111222333', 'Vendedor Júnior');

INSERT INTO Vendedor (nome, email, cpf, telefone, cargo) VALUES ('Marcos Pereira', 'marcos@email.com', '555.666.777-88', '555666777', 'Supervisor de Vendas');

INSERT INTO Vendedor (nome, email, cpf, telefone, cargo) VALUES ('Luana Souza', 'luana@email.com', '999.888.777-66', '999888777', 'Vendedor Trainee');




INSERT INTO Venda (valor, carro_id, cliente_id, vendedor_id) VALUES (15000.00, 1, 1, 1);

INSERT INTO Venda (valor, carro_id, cliente_id, vendedor_id) VALUES (20000.00, 2, 2, 2);

INSERT INTO Venda (valor, carro_id, cliente_id, vendedor_id) VALUES (18000.00, 3, 3, 3);

INSERT INTO Venda (valor, carro_id, cliente_id, vendedor_id) VALUES (22000.00, 4, 4, 4);

INSERT INTO Venda (valor, carro_id, cliente_id, vendedor_id) VALUES (16000.00, 5, 1, 5);




INSERT INTO Concessionaria (nome, endereco, cidade, pais, telefone) VALUES ('AutoCenter ABC', 'Av. Principal, 123', 'São Paulo', 'Brasil', '123456789');

INSERT INTO Concessionaria (nome, endereco, cidade, pais, telefone) VALUES ('Carros Top Ltda.', 'Rua Comercial, 456', 'Rio de Janeiro', 'Brasil', '987654321');

INSERT INTO Concessionaria (nome, endereco, cidade, pais, telefone) VALUES ('MegaCar Center', 'Avenida Principal, 789', 'Belo Horizonte', 'Brasil', '111222333');

INSERT INTO Concessionaria (nome, endereco, cidade, pais, telefone) VALUES ('Speed Motors', 'Rua Veloz, 101', 'Porto Alegre', 'Brasil', '555666777');

INSERT INTO Concessionaria (nome, endereco, cidade, pais, telefone) VALUES ('TopCar Showroom', 'Avenida Luxo, 543', 'Salvador', 'Brasil', '999888777');
