DROP TABLE IF EXISTS  Buyer_Account;
DROP TABLE IF EXISTS  Shop_Item;
DROP TABLE IF EXISTS  Cart_Item;

CREATE TABLE Buyer_Account(
    User_Id int NOT NULL PRIMARY KEY auto_increment,
    User_Email varchar(100),
    User_Password varchar(100) NOT NULL,
    Security_Question varchar(200) NOT NULL,
    Security_Answer varchar(200) NOT NULL
);

CREATE TABLE Shop_Item(
    Item_Id int NOT NULL PRIMARY KEY auto_increment,
    Item_Name varchar(100) NOT NULL,
    Item_Price decimal(10,2) NOT NULL,
    Item_Picture varchar(300) NOT NULL,
    Item_Description varchar(300) NOT NULL
);

CREATE TABLE Cart_Item(
    Cart_Id int NOT NULL PRIMARY KEY auto_increment,
    User_Id int NOT NULL,
    Item_Id int NOT NULL,
    Item_Name varchar(100) NOT NULL,
    Item_Quantity int NOT NULL,
    FOREIGN KEY(User_Id) references Buyer_Account(User_Id),
    FOREIGN KEY(Item_Id) references Shop_Item(Item_Id)
);

INSERT INTO Buyer_Account(User_Email, User_Password, Security_Question, Security_Answer) VALUES('zach@gmail.com', 'password', 'what is?', 'dunno');
INSERT INTO Buyer_Account(User_Email, User_Password, Security_Question, Security_Answer) VALUES('bob@gmail.com', 'password', 'what is?', 'dunno');
INSERT INTO Buyer_Account(User_Email, User_Password, Security_Question, Security_Answer) VALUES('yeah@gmail.com', 'password', 'what is?', 'dunno');


INSERT INTO Shop_Item(Item_Name, Item_Price, Item_Picture, Item_Description) VALUES('Sony Playstation 5 Gaming Console', 499.99, 'https://i5.walmartimages.com/seo/Sony-PlayStation-5-Gaming-Console_02021359-c4bb-410e-940a-12930acbfd57.4d050069b07b687682d48144eb9d9032.jpeg?odnHeight=768&odnWidth=768&odnBg=FFFFFF', 'This is a Playstation 5.      TAGS: Tech, Gaming');
INSERT INTO Shop_Item(Item_Name, Item_Price, Item_Picture, Item_Description) VALUES('iPhone 15 Pro Max 256GB Black Titanium', 1199.00, 'https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/iphone-15-pro-finish-select-202309-6-7inch-blacktitanium?wid=5120&hei=2880&fmt=p-jpg&qlt=80&.v=1692845694698', 'This is an Apple Iphone.     TAGS: Tech, Mobile');
INSERT INTO Shop_Item(Item_Name, Item_Price, Item_Picture, Item_Description) VALUES('Orange', 100.00, 'https://thecoconutmama.com/wp-content/uploads/2023/06/oranges-scaled.webp', 'This is an orange, one of the greatest earthen delicacies.     TAGS: Grocery');
INSERT INTO Shop_Item(Item_Name, Item_Price, Item_Picture, Item_Description) VALUES('Orange Shirt', 5.00, 'https://cdn.nexternal.com/safedepot/images/5000%20orange%20front%20300.jpg', 'This is a basic tshirt that is the color orange.    TAGS: Clothing');
INSERT INTO Shop_Item(Item_Name, Item_Price, Item_Picture, Item_Description) VALUES('LG OLED evo G3 77 inch Class 4k OLED TV 2023', 3499.99, 'https://media.us.lg.com/transform/ecomm-PDPGallery-1100x730/e64bb88d-49a1-4f54-a9dc-de6dd1b33714/md08003935-DZ-07-jpg', 'This is a 4k tv from LG.     TAGS: Tech');
INSERT INTO Shop_Item(Item_Name, Item_Price, Item_Picture, Item_Description) VALUES('Samsung Galaxy S23 Ultra 5G SM-S918B/DS 256GB 12GB Ram Dual (Global) Unlocked GSM Phantom Black', 949.00, 'https://i5.walmartimages.com/seo/Samsung-Galaxy-S23-Ultra-5G-SM-S918B-DS-256GB-12GB-RAM-DUAL-SIM-Global-Model-Factory-Unlocked-GSM-Phantom-Black_a77b9342-adda-4ed0-a9bd-2a3a80c29e21.9b9469de053b4157eb544c0267dbbca2.jpeg?odnHeight=640&odnWidth=640&odnBg=FFFFFF', 'This is a Samsung smartphone     TAGS: Tech, Mobile');
INSERT INTO Shop_Item(Item_Name, Item_Price, Item_Picture, Item_Description) VALUES('Jogal Men’s Flower Casual Hawaiian Shirt', 25.99, 'https://www.hollywoodreporter.com/wp-content/uploads/2021/05/jogal-flower-hawaiian-shirt.jpg?w=769', 'This is a Hawaiian shirt.     TAGS: Clothing');
INSERT INTO Shop_Item(Item_Name, Item_Price, Item_Picture, Item_Description) VALUES('Goldfish Cheddar Cheese Crackers, Baked Snack Crackers, 6.6 oz Bag', 2.64, 'https://i5.walmartimages.com/seo/Goldfish-Cheddar-Cheese-Crackers-Baked-Snack-Crackers-6-6-oz-Bag_9ac3804e-cb62-4d60-a321-685e8044e431.d6f5c29414d1f57c797946bd21057d2f.jpeg?odnHeight=640&odnWidth=640&odnBg=FFFFFF', 'This is a bag of cheddar flavor goldfish crackers.     TAGS: Grocery');
INSERT INTO Shop_Item(Item_Name, Item_Price, Item_Picture, Item_Description) VALUES('Sony 43 inch Class X77L LED 4k UHD Smart Google TV KD43X77L', 399.99, 'https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6544/6544136_sd.jpg', 'This is a Sony 4k Tv.     TAGS: Tech');
--INSERT INTO Shop_Item(Item_Name, Item_Price, Item_Picture, Item_Description) VALUES('', 5.00, '', '');
INSERT INTO Shop_Item(Item_Name, Item_Price, Item_Picture, Item_Description) VALUES('LG 65 inch Class C3 Series OLED 4k UHD Smart webOS TV OLED65C3PUA', 1599.99, 'https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6535/6535929_bd.jpg', 'This is a 4k tv from LG.     TAGS: Tech');
INSERT INTO Shop_Item(Item_Name, Item_Price, Item_Picture, Item_Description) VALUES('Samsung 65 inch Class Q60C QLED 4K UHD Smart Tizen TV QN65Q60CAFXZA', 749.99, 'https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6537/6537375cv13d.jpg', 'This is a 4k tv from Samsung    TAGS: Tech');
--INSERT INTO Shop_Item(Item_Name, Item_Price, Item_Picture, Item_Description) VALUES('', 5.00, '', '');