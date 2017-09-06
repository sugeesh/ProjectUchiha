INSERT INTO aduwata.Category (name, description) VALUES ('Vehicle', 'Vehicle Description');
INSERT INTO aduwata.Category (name, description) VALUES ('Electronic', 'Electronic Description');
INSERT INTO aduwata.Category (name, description) VALUES ('Property', 'Property Description');
INSERT INTO aduwata.Category (name, description) VALUES ('Fashion', 'Fashion Description');
INSERT INTO aduwata.Category (name, description) VALUES ('Photograpy', 'Photograpy Description');
INSERT INTO aduwata.Category (name, description) VALUES ('Other', 'Other Description');

INSERT INTO aduwata.SubCategory (name, description,category_id) VALUES ('Car', 'Car Description',1);
INSERT INTO aduwata.SubCategory (name, description,category_id) VALUES ('Van', 'Van Description',1);
INSERT INTO aduwata.SubCategory (name, description,category_id) VALUES ('Bicycle', 'Bicycle Description',1);
INSERT INTO aduwata.SubCategory (name, description,category_id) VALUES ('Pen', 'Pen Description',2);
INSERT INTO aduwata.SubCategory (name, description,category_id) VALUES ('Land with house', 'Land with house',3);
INSERT INTO aduwata.SubCategory (name, description,category_id) VALUES ('House', 'House',3);

-- INSERT INTO aduwata.Advertisement (date, title,description, price,contact,category_id,sub_category_id) VALUES ('2017-04-03 15:52:15', 'Nissan Note Sport (Tida) 2005','Nissan Note Japan Sport Version2005 Manufactured', 2625000 , 07104166336, 1,1);

INSERT INTO aduwata.AdField (name, sub_category_id,type) VALUES ('Brand', 1, 0);
INSERT INTO aduwata.AdField (name, sub_category_id,type) VALUES ('Model', 1,0);
INSERT INTO aduwata.AdField (name, sub_category_id,type) VALUES ('Model Year', 1, 0);
INSERT INTO aduwata.AdField (name, sub_category_id,type,data_list) VALUES ('Condition', 1, 1,'New,Used,Reconditioned');
INSERT INTO aduwata.AdField (name, sub_category_id,type) VALUES ('Mileage(km)', 1, 0);
INSERT INTO aduwata.AdField (name, sub_category_id,type) VALUES ('Engine Capacity(cc)', 1, 0);
INSERT INTO aduwata.AdField (name, sub_category_id,type,data_list) VALUES ('Sale Type', 1, 1,'Sale,Rents');

-- INSERT INTO aduwata.AdDetail (ad_field_id, value, advertisement_id) VALUES (1,'Nissan',1);
-- INSERT INTO aduwata.AdDetail (ad_field_id, value, advertisement_id ) VALUES (2,'2005 Nissan Note',1);
-- INSERT INTO aduwata.AdDetail (ad_field_id, value, advertisement_id) VALUES (3,'2005',1);
-- INSERT INTO aduwata.AdDetail (ad_field_id, value, advertisement_id) VALUES (4,'New',1);
-- INSERT INTO aduwata.AdDetail (ad_field_id, value, advertisement_id ) VALUES (5,'200000',1);
-- INSERT INTO aduwata.AdDetail (ad_field_id, value, advertisement_id) VALUES (6,'1200',1);
-- INSERT INTO aduwata.AdDetail (ad_field_id, value, advertisement_id) VALUES (7,'Sale',1);
