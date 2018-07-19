INSERT INTO serv_table (tableId, tableName,seats,isTakeOut,occupied, createdAt, updatedAt) VALUES(1, '#1',4,False,False,  CURTIME(), CURTIME());
INSERT INTO serv_table (tableId, tableName,seats,isTakeOut,occupied, createdAt, updatedAt) VALUES(2, '#2',4,False,False, CURTIME(), CURTIME());
INSERT INTO serv_table (tableId, tableName,seats,isTakeOut,occupied, createdAt, updatedAt) VALUES(3, '#3',6,False,False, CURTIME(), CURTIME());
INSERT INTO serv_table (tableId, tableName,seats,isTakeOut,occupied, createdAt, updatedAt) VALUES(4, '#4',6,False,False, CURTIME(), CURTIME());
INSERT INTO serv_table (tableId, tableName,seats,isTakeOut,occupied, createdAt, updatedAt) VALUES(5, '#5',6,False,False, CURTIME(), CURTIME());
INSERT INTO serv_table (tableId, tableName,seats,isTakeOut,occupied, createdAt, updatedAt) VALUES(6, '#6',6,False,False, CURTIME(), CURTIME());
INSERT INTO serv_table (tableId, tableName,seats,isTakeOut,occupied, createdAt, updatedAt) VALUES(7, '#7',2,False,False, CURTIME(), CURTIME());
INSERT INTO serv_table (tableId, tableName,seats,isTakeOut,occupied, createdAt, updatedAt) VALUES(8, '#8',2,False,False, CURTIME(), CURTIME());
INSERT INTO serv_table (tableId, tableName,isTakeOut, createdAt, updatedAt) VALUES(100, 'TakeOut',True, CURTIME(), CURTIME());


INSERT INTO employee (userId, userName, createdAt, updatedAt) VALUES('dina', 'Dina', CURTIME(), CURTIME());
INSERT INTO employee (userId, userName, createdAt, updatedAt) VALUES('thomas', 'Thomas', CURTIME(), CURTIME());
INSERT INTO employee (userId, userName, createdAt, updatedAt) VALUES('anna', 'Anna', CURTIME(), CURTIME());

INSERT INTO category (categoryId, name, needToCook ,createdAt, updatedAt) VALUES(1, 'beverages', False, CURTIME(), CURTIME());
INSERT INTO category (categoryId, name, needToCook ,createdAt, updatedAt) VALUES(2, 'main', True, CURTIME(), CURTIME());
INSERT INTO category (categoryId, name, needToCook ,createdAt, updatedAt) VALUES(3, 'appetizers', True, CURTIME(), CURTIME());


INSERT INTO product (productId, name, price, imageFile, categoryId,  createdAt, updatedAt) 
	VALUES ('drink1', 'Oolong Tea', 1.00, 'https://s3.ca-central-1.amazonaws.com/coska-restaurant-pos/200x200/Drinks-item+images.001.png' , 1, CURTIME(), CURTIME());
INSERT INTO product (productId, name, price, imageFile, categoryId,  createdAt, updatedAt) 
	VALUES ('drink2', 'Green Tea', 1.00, 'https://s3.ca-central-1.amazonaws.com/coska-restaurant-pos/200x200/Drinks-item+images.002.png' , 1, CURTIME(), CURTIME());
INSERT INTO product (productId, name, price, imageFile, categoryId,  createdAt, updatedAt) 
	VALUES ('drink3', 'Black Tea', 1.00, 'https://s3.ca-central-1.amazonaws.com/coska-restaurant-pos/200x200/Drinks-item+images.003.png' , 1, CURTIME(), CURTIME());
INSERT INTO product (productId, name, price, imageFile, categoryId,  createdAt, updatedAt) 
	VALUES ('drink4', 'Coffee', 2.00, 'https://s3.ca-central-1.amazonaws.com/coska-restaurant-pos/200x200/Drinks-item+images.004.png' , 1, CURTIME(), CURTIME());
INSERT INTO product (productId, name, price, imageFile, categoryId,  createdAt, updatedAt) 
	VALUES ('drink5', 'California Sake', 20.00, 'https://s3.ca-central-1.amazonaws.com/coska-restaurant-pos/200x200/Drinks-item+images.005.png' , 1, CURTIME(), CURTIME());
INSERT INTO product (productId, name, price, imageFile, categoryId,  createdAt, updatedAt) 
	VALUES ('drink6', 'Gekkeinkan Sake', 24.00, 'https://s3.ca-central-1.amazonaws.com/coska-restaurant-pos/200x200/Drinks-item+images.006.png' , 1, CURTIME(), CURTIME());
INSERT INTO product (productId, name, price, imageFile, categoryId,  createdAt, updatedAt) 
	VALUES ('drink7', 'Margarita', 6.00, 'https://s3.ca-central-1.amazonaws.com/coska-restaurant-pos/200x200/Drinks-item+images.007.png' , 1, CURTIME(), CURTIME());
INSERT INTO product (productId, name, price, imageFile, categoryId,  createdAt, updatedAt) 
	VALUES ('drink8', 'Screwdriver', 6.00, 'https://s3.ca-central-1.amazonaws.com/coska-restaurant-pos/200x200/Drinks-item+images.008.png' , 1, CURTIME(), CURTIME());
INSERT INTO product (productId, name, price, imageFile, categoryId,  createdAt, updatedAt) 
	VALUES ('drink9', 'Kirin Beer', 8.00, 'https://s3.ca-central-1.amazonaws.com/coska-restaurant-pos/200x200/Drinks-item+images.009.png' , 1, CURTIME(), CURTIME());
INSERT INTO product (productId, name, price, imageFile, categoryId,  createdAt, updatedAt) 
	VALUES ('drink10', 'Yebisu Beer', 7.00, 'https://s3.ca-central-1.amazonaws.com/coska-restaurant-pos/200x200/Drinks-item+images.010.png' , 1, CURTIME(), CURTIME());
INSERT INTO product (productId, name, price, imageFile, categoryId,  createdAt, updatedAt) 
	VALUES ('drink11', 'Whit Russian', 7.00, 'https://s3.ca-central-1.amazonaws.com/coska-restaurant-pos/200x200/Drinks-item+images.011.png' , 1, CURTIME(), CURTIME());
INSERT INTO product (productId, name, price, imageFile, categoryId,  createdAt, updatedAt) 
	VALUES ('drink12', 'Whiskey Sour', 6.00, 'https://s3.ca-central-1.amazonaws.com/coska-restaurant-pos/200x200/Drinks-item+images.012.png' , 1, CURTIME(), CURTIME());
INSERT INTO product (productId, name, price, imageFile, categoryId,  createdAt, updatedAt) 
	VALUES ('drink13', 'Asahi Beer', 8.00, 'https://s3.ca-central-1.amazonaws.com/coska-restaurant-pos/200x200/Drinks-item+images.013.png' , 1, CURTIME(), CURTIME());
INSERT INTO product (productId, name, price, imageFile, categoryId,  createdAt, updatedAt) 
	VALUES ('drink14', 'Sapporo Beer', 8.00, 'https://s3.ca-central-1.amazonaws.com/coska-restaurant-pos/200x200/Drinks-item+images.014.png' , 1, CURTIME(), CURTIME());


INSERT INTO product (productId, name, price, imageFile, categoryId, createdAt, updatedAt) 
	VALUES ('main1', 'Spicy Tuna Roll', 15.00, 'https://s3.ca-central-1.amazonaws.com/coska-restaurant-pos/200x200/main-item+images.001.png' , 2, CURTIME(), CURTIME());
INSERT INTO product (productId, name, price, imageFile, categoryId, createdAt, updatedAt) 
	VALUES ('main2', 'Avocado Roll', 14.00, 'https://s3.ca-central-1.amazonaws.com/coska-restaurant-pos/200x200/main-item+images.002.png' , 2, CURTIME(), CURTIME());
INSERT INTO product (productId, name, price, imageFile, categoryId, createdAt, updatedAt) 
	VALUES ('main3', 'Beff Teriyaki', 25.00, 'https://s3.ca-central-1.amazonaws.com/coska-restaurant-pos/200x200/main-item+images.003.png' , 2, CURTIME(), CURTIME());
INSERT INTO product (productId, name, price, imageFile, categoryId, createdAt, updatedAt) 
	VALUES ('main4', 'Salmon Roll', 14.00, 'https://s3.ca-central-1.amazonaws.com/coska-restaurant-pos/200x200/main-item+images.004.png' , 2, CURTIME(), CURTIME());
INSERT INTO product (productId, name, price, imageFile, categoryId, createdAt, updatedAt) 
	VALUES ('main5', 'Dynamite Roll', 14.00, 'https://s3.ca-central-1.amazonaws.com/coska-restaurant-pos/200x200/main-item+images.005.png' , 2, CURTIME(), CURTIME());
INSERT INTO product (productId, name, price, imageFile, categoryId, createdAt, updatedAt) 
	VALUES ('main6', 'Bento Set A', 14.00, 'https://s3.ca-central-1.amazonaws.com/coska-restaurant-pos/200x200/main-item+images.006.png' , 2, CURTIME(), CURTIME());
INSERT INTO product (productId, name, price, imageFile, categoryId, createdAt, updatedAt) 
	VALUES ('main7', 'Maki', 14.00, 'https://s3.ca-central-1.amazonaws.com/coska-restaurant-pos/200x200/main-item+images.007.png' , 2, CURTIME(), CURTIME());
INSERT INTO product (productId, name, price, imageFile, categoryId, createdAt, updatedAt) 
	VALUES ('main8', 'Poke bowl', 14.00, 'https://s3.ca-central-1.amazonaws.com/coska-restaurant-pos/200x200/main-item+images.008.png' , 2, CURTIME(), CURTIME());
INSERT INTO product (productId, name, price, imageFile, categoryId, createdAt, updatedAt) 
	VALUES ('main9', 'California Roll', 17.00, 'https://s3.ca-central-1.amazonaws.com/coska-restaurant-pos/200x200/main-item+images.009.png' , 2, CURTIME(), CURTIME());
INSERT INTO product (productId, name, price, imageFile, categoryId, createdAt, updatedAt) 
	VALUES ('main10', 'Sushi Combo', 14.00, 'https://s3.ca-central-1.amazonaws.com/coska-restaurant-pos/200x200/main-item+images.010.png' , 2, CURTIME(), CURTIME());
INSERT INTO product (productId, name, price, imageFile, categoryId, createdAt, updatedAt) 
	VALUES ('main11', 'Lunch Set A', 20.00, 'https://s3.ca-central-1.amazonaws.com/coska-restaurant-pos/200x200/main-item+images.011.png' , 2, CURTIME(), CURTIME());
INSERT INTO product (productId, name, price, imageFile, categoryId, createdAt, updatedAt) 
	VALUES ('main12', 'Lunch Set B', 18.00, 'https://s3.ca-central-1.amazonaws.com/coska-restaurant-pos/200x200/main-item+images.012.png' , 2, CURTIME(), CURTIME());
INSERT INTO product (productId, name, price, imageFile, categoryId, createdAt, updatedAt) 
	VALUES ('main13', 'Smoked Salmon Roll', 15.00, 'https://s3.ca-central-1.amazonaws.com/coska-restaurant-pos/200x200/main-item+images.013.png' , 2, CURTIME(), CURTIME());
INSERT INTO product (productId, name, price, imageFile, categoryId, createdAt, updatedAt) 
	VALUES ('main14', 'Vegetable Roll', 10.00, 'https://s3.ca-central-1.amazonaws.com/coska-restaurant-pos/200x200/main-item+images.014.png' , 2, CURTIME(), CURTIME());
	
INSERT INTO product (productId, name, price, imageFile, categoryId, createdAt, updatedAt) 
	VALUES ('appetizer1', 'Cucumber Salad', 6.00, 'https://s3.ca-central-1.amazonaws.com/coska-restaurant-pos/200x200/Appetizer-item+images.001.png' , 3, CURTIME(), CURTIME());
INSERT INTO product (productId, name, price, imageFile, categoryId, createdAt, updatedAt) 
	VALUES ('appetizer2', 'Yaki Onigiri', 7.00, 'https://s3.ca-central-1.amazonaws.com/coska-restaurant-pos/200x200/Appetizer-item+images.002.png' , 3, CURTIME(), CURTIME());
INSERT INTO product (productId, name, price, imageFile, categoryId, createdAt, updatedAt) 
	VALUES ('appetizer3', 'Fired Tofu', 8.00, 'https://s3.ca-central-1.amazonaws.com/coska-restaurant-pos/200x200/Appetizer-item+images.003.png' , 3, CURTIME(), CURTIME());
INSERT INTO product (productId, name, price, imageFile, categoryId, createdAt, updatedAt) 
	VALUES ('appetizer4', 'Kinpira Gobo', 7.00, 'https://s3.ca-central-1.amazonaws.com/coska-restaurant-pos/200x200/Appetizer-item+images.004.png' , 3, CURTIME(), CURTIME());
INSERT INTO product (productId, name, price, imageFile, categoryId, createdAt, updatedAt) 
	VALUES ('appetizer5', 'Eggplant with Sesame Sauce', 10.00, 'https://s3.ca-central-1.amazonaws.com/coska-restaurant-pos/200x200/Appetizer-item+images.005.png' , 3, CURTIME(), CURTIME());
INSERT INTO product (productId, name, price, imageFile, categoryId, createdAt, updatedAt) 
	VALUES ('appetizer6', 'Pickled Cucumber', 5.00, 'https://s3.ca-central-1.amazonaws.com/coska-restaurant-pos/200x200/Appetizer-item+images.006.png' , 3, CURTIME(), CURTIME());
INSERT INTO product (productId, name, price, imageFile, categoryId, createdAt, updatedAt) 
	VALUES ('appetizer7', 'Simmered Kabocha', 8.00, 'https://s3.ca-central-1.amazonaws.com/coska-restaurant-pos/200x200/Appetizer-item+images.007.png' , 3, CURTIME(), CURTIME());
INSERT INTO product (productId, name, price, imageFile, categoryId, createdAt, updatedAt) 
	VALUES ('appetizer8', 'Green Bean', 8.00, 'https://s3.ca-central-1.amazonaws.com/coska-restaurant-pos/200x200/Appetizer-item+images.008.png' , 3, CURTIME(), CURTIME());
INSERT INTO product (productId, name, price, imageFile, categoryId, createdAt, updatedAt) 
	VALUES ('appetizer9', 'Fried Lotus Root with Port', 10.00, 'https://s3.ca-central-1.amazonaws.com/coska-restaurant-pos/200x200/Appetizer-item+images.009.png' , 3, CURTIME(), CURTIME());
INSERT INTO product (productId, name, price, imageFile, categoryId, createdAt, updatedAt) 
	VALUES ('appetizer10', 'Miso Onigiri', 7.00, 'https://s3.ca-central-1.amazonaws.com/coska-restaurant-pos/200x200/Appetizer-item+images.010.png' , 3, CURTIME(), CURTIME());
INSERT INTO product (productId, name, price, imageFile, categoryId, createdAt, updatedAt) 
	VALUES ('appetizer11', 'Takoyaki', 8.00, 'https://s3.ca-central-1.amazonaws.com/coska-restaurant-pos/200x200/Appetizer-item+images.011.png' , 3, CURTIME(), CURTIME());
INSERT INTO product (productId, name, price, imageFile, categoryId, createdAt, updatedAt) 
	VALUES ('appetizer12', 'Grilled Oysters with Ponzu Sauce', 10.00, 'https://s3.ca-central-1.amazonaws.com/coska-restaurant-pos/200x200/Appetizer-item+images.012.png' , 3, CURTIME(), CURTIME());
	