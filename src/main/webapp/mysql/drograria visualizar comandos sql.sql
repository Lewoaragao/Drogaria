use drogaria;
-- ver toda tabela
SELECT * FROM fabricante;
-- deletar linha específica
DELETE FROM fabricante WHERE codigo = 4;
-- reiniciar auto_increment
ALTER TABLE fabricante AUTO_INCREMENT = 1;