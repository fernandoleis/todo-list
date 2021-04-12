INSERT INTO USER(ID, EMAIL, NAME, PASSWORD) VALUES(1, 'admin@admin.com', 'Usuário Admin', '$2a$10$xVLJc/h2DEBLBKS/dfVYbekn82InJI3nAVfFFswMrbx2/ESD2ieSS');
INSERT INTO USER(ID, EMAIL, NAME, PASSWORD) VALUES(2, 'fulano@fulano.com', 'Usuário Fulano', '$2a$10$vn0ijDzQ.LJ1/qOmtluAlu8utwiBo3PnCrVwYLYzuHfC339ooOJ2.');
INSERT INTO USER(ID, EMAIL, NAME, PASSWORD) VALUES(3, 'ciclano@ciclano.com', 'Usuário Ciclano', '$2a$10$hsIEt.qlkZHIh1dYo.bdEegdmN3nZ1uBtGSltMj7oob1Uz15FbnWm');

INSERT INTO ROLE(ID, NAME) VALUES(1, 'ROLE_ADMIN');
INSERT INTO ROLE(ID, NAME) VALUES(2, 'ROLE_DEFAULT');

INSERT INTO USER_ROLE(USER_ID, ROLE_ID) VALUES(1, 1);
INSERT INTO USER_ROLE(USER_ID, ROLE_ID) VALUES(2, 2);
INSERT INTO USER_ROLE(USER_ID, ROLE_ID) VALUES(3, 2);

INSERT INTO TASK(ID, SUMMARY, DESCRIPTION, STATUS, DATE, USER_ID) VALUES(1, 'Mussum Ipsum, cacilds vidis litro abertis. Todo mundo vê os porris que eu tomo, mas ninguém vê os tombis que eu levo! Per aumento de cachacis, eu reclamis. Em pé sem cair, deitado sem dormir, sentado sem cochilar e fazendo pose.','Pagar conta de luz', 'PENDING', localtime, 1 );
INSERT INTO TASK(ID, SUMMARY, DESCRIPTION, STATUS, DATE, USER_ID) VALUES(2, 'Mussum Ipsum, cacilds vidis litro abertis. Todo mundo vê os porris que eu tomo, mas ninguém vê os tombis que eu levo! Per aumento de cachacis, eu reclamis. Em pé sem cair, deitado sem dormir, sentado sem cochilar e fazendo pose.','Fazem compras', 'COMPLETED', '2020-02-02 09:20:20', 2 );
INSERT INTO TASK(ID, SUMMARY, DESCRIPTION, STATUS, DATE, USER_ID) VALUES(3, 'Mussum Ipsum, cacilds vidis litro abertis. Todo mundo vê os porris que eu tomo, mas ninguém vê os tombis que eu levo! Per aumento de cachacis, eu reclamis. Em pé sem cair, deitado sem dormir, sentado sem cochilar e fazendo pose.','Reunião de trabalho', 'PENDING', '2021-07-10 23:38:40', 3 );
INSERT INTO TASK(ID, SUMMARY, DESCRIPTION, STATUS, DATE, USER_ID) VALUES(4, 'Mussum Ipsum, cacilds vidis litro abertis. Todo mundo vê os porris que eu tomo, mas ninguém vê os tombis que eu levo! Per aumento de cachacis, eu reclamis. Em pé sem cair, deitado sem dormir, sentado sem cochilar e fazendo pose.','Renovar seguro de vida', 'COMPLETED', '2021-04-01 10:00:00', 1 );
INSERT INTO TASK(ID, SUMMARY, DESCRIPTION, STATUS, DATE, USER_ID) VALUES(5, 'Casamentiss faiz malandris se pirulitá. Admodum accumsan disputationi eu sit.','Levar veículo ao mecânico', 'PENDING', '2021-06-09 21:00:40', 2 );
INSERT INTO TASK(ID, SUMMARY, DESCRIPTION, STATUS, DATE, USER_ID) VALUES(6, 'Casamentiss faiz malandris se pirulitá. Admodum accumsan disputationi eu sit.','Terminar projeto', 'COMPLETED', '2020-12-25 12:25:40', 3 );
INSERT INTO TASK(ID, SUMMARY, DESCRIPTION, STATUS, DATE, USER_ID) VALUES(7, 'Casamentiss faiz malandris se pirulitá. Admodum accumsan disputationi eu sit.','Tomar vacina', 'PENDING', '2021-08-10 09:38:40', 1 );
INSERT INTO TASK(ID, SUMMARY, DESCRIPTION, STATUS, DATE, USER_ID) VALUES(8, 'Casamentiss faiz malandris se pirulitá. Admodum accumsan disputationi eu sit.','Entrevistar pessoas', 'COMPLETED', '2021-04-04 07:10:15' , 2 );
INSERT INTO TASK(ID, SUMMARY, DESCRIPTION, STATUS, DATE, USER_ID) VALUES(9, 'Casamentiss faiz malandris se pirulitá. Admodum accumsan disputationi eu sit.','Cadastrar Fornecedor', 'COMPLETED', '2021-01-28 17:18:09', 3 );