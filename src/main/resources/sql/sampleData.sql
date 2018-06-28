INSERT INTO serv_table (tableId, tableName,seats,isTakeOut,occupied, createdAt, updatedAt) VALUES(1, 'test01',4,False,True,  CURTIME(), CURTIME());

INSERT INTO serv_table (tableId, tableName,seats,isTakeOut,occupied, createdAt, updatedAt) VALUES(2, 'test02',5 ,False,True, CURTIME(), CURTIME());

INSERT INTO serv_table (tableId, tableName,seats,isTakeOut,occupied, createdAt, updatedAt) VALUES(3, 'TakeOutTable',2,True,False, CURTIME(), CURTIME());

INSERT INTO serv_table (tableId, tableName,isTakeOut, createdAt, updatedAt) VALUES(100, 'TakeOutTable2',True, CURTIME(), CURTIME());


INSERT INTO employee (userId, userName, createdAt, updatedAt) VALUES('123', 'name1', CURTIME(), CURTIME());

INSERT INTO employee (userId, userName, createdAt, updatedAt) VALUES('124', 'name2', CURTIME(), CURTIME());

INSERT INTO employee (userId, userName, createdAt, updatedAt) VALUES('125', 'name3', CURTIME(), CURTIME());

INSERT INTO category (categoryId, name, needToCook ,createdAt, updatedAt) VALUES(1, 'Beer1', False, CURTIME(), CURTIME());

INSERT INTO category (categoryId, name, needToCook ,createdAt, updatedAt) VALUES(2, 'food1', True, CURTIME(), CURTIME());

INSERT INTO category (categoryId, name, needToCook ,createdAt, updatedAt) VALUES(3, 'food2', True, CURTIME(), CURTIME());

INSERT INTO category (categoryId, name, needToCook ,createdAt, updatedAt) VALUES(4, 'food3', True, CURTIME(), CURTIME());

INSERT INTO category (categoryId, name, needToCook ,createdAt, updatedAt) VALUES(5, 'food4', True, CURTIME(), CURTIME());

INSERT INTO product (productId, name, price, imageFile, categoryId,  createdAt, updatedAt) VALUES ('1', 'what', 100.01, 'test1.jpg' , 4, CURTIME(), CURTIME());

INSERT INTO product (productId, name, price, imageFile, categoryId, createdAt, updatedAt) VALUES ('2', 'what2', 10.01, 'test2.jpg' , 3, CURTIME(), CURTIME());

INSERT INTO product (productId, name, price, imageFile, categoryId, createdAt, updatedAt) VALUES ('3', 'what3', 18.71, 'test3.jpg' , 2, CURTIME(), CURTIME());

INSERT INTO product (productId, name, price, imageFile, categoryId, createdAt, updatedAt) VALUES ('5', 'what5', 11.71, 'test4.jpg' , 5, CURTIME(), CURTIME());

INSERT INTO orders(orderId, status,userId,tableId, createdAT, updatedAt) VALUES('d290f1ee-6c54-4b01-90e6-d701748f0851','NEW','123',1,CURTIME(), CURTIME());

INSERT INTO orders(orderId, status,userId,tableId, createdAT, updatedAt) VALUES('d290f1ee-6c54-4b01-90e6-d701748f0852','NEW','124',2,CURTIME(), CURTIME());

INSERT INTO orders(orderId, status,userId,tableId, createdAT, updatedAt) VALUES('d290f1ee-6c54-4b01-90e6-d701748f0853','COOKING','123',3,CURTIME(), CURTIME());

INSERT INTO orders(orderId, status,userId,tableId, createdAT, updatedAt) VALUES('d290f1ee-6c54-4b01-90e6-d701748f0854','COOKING','123',100,CURTIME(), CURTIME());

insert into orderitem(orderitemId,quantity,productId,orderId) values(300,'2','d290f1ee-6c54-4b01-90e6-d701748f0852');
insert into orderitem(orderitemId,quantity,productId,orderId) values(200,10,'3','d290f1ee-6c54-4b01-90e6-d701748f0852');

insert into orderitem(orderitemId,quantity,productId,orderId) values(301,10,'3','d290f1ee-6c54-4b01-90e6-d701748f0851');
insert into orderitem(orderitemId,quantity,productId,orderId) values(401,4,'2','d290f1ee-6c54-4b01-90e6-d701748f0851');

insert into orderitem(orderitemId,quantity,productId,orderId) values(501,1,'3','d290f1ee-6c54-4b01-90e6-d701748f0853');
insert into orderitem(orderitemId,quantity,productId,orderId) values(601,2,'2','d290f1ee-6c54-4b01-90e6-d701748f0853');
insert into orderitem(orderitemId,quantity,productId,orderId) values(701,4,'1','d290f1ee-6c54-4b01-90e6-d701748f0853');


insert into orderitem(orderitemId,quantity,productId,orderId) values(801,2,'5','d290f1ee-6c54-4b01-90e6-d701748f0854');