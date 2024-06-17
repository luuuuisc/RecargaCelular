-- Inserindo dados na tabela de clientes
INSERT INTO tb_client (name, phone_number, balance) VALUES ('Alice Alves', '(34) 9996202304', 100.00);
INSERT INTO tb_client (name, phone_number, balance) VALUES ('Bob Borges', '(34) 9997202405', 150.00);
INSERT INTO tb_client (name, phone_number, balance) VALUES ('Carlos Costa', '(34) 9998202506', 200.00);

-- Inserindo dados na tabela de recargas
INSERT INTO tb_recharge (amount, phone_number, status, client_id) VALUES (50.00, '(34) 9996202304', 'PENDING', 1);
INSERT INTO tb_recharge (amount, phone_number, status, client_id) VALUES (30.00, '(34) 9997202405', 'COMPLETED', 2);
INSERT INTO tb_recharge (amount, phone_number, status, client_id) VALUES (20.00, '(34) 9998202506', 'FAILED', 3);

