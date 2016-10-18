INSERT INTO "position" VALUES
  (1, 'Manager'),
  (2, 'Chef'),
  (3, 'Waiter');

INSERT INTO employee VALUES
  (1, 'Mr. Stivens', '1985-08-11', '+380111111111', 2, 12000),
  (2, 'Mr. Black', '1995-01-02', '+380156594411', 3, 8000),
  (3, 'Ms. Morgan', '1999-06-03', '+380124594410', 3, 7500),
  (4, 'Mr. Grant', '1965-06-03', '+380194594410', 1, 20000);

INSERT INTO ingredient VALUES
  (1, 'Milk'),
  (2, 'Potato'),
  (3, 'Sugar'),
  (4, 'Salt'),
  (5, 'Pork'),
  (6, 'Onion'),
  (7, 'Lemon'),
  (8, 'Garlic'),
  (9, 'Buckwheat'),
  (10, 'Porridge');

INSERT INTO dish VALUES
  (1, 'Buckwheat breakfast', 'snack', 25.0, 250.0),
  (2, 'Pork&Potato', 'main course', 48.50, 350.0),
  (3, 'Quick lunch', 'snack', 30.50, 150.0),
  (4, 'British soup', 'liquid snack', 27.50, 170.0),
  (5, 'Porridge supper', 'main course', 39.0, 325.0);

INSERT INTO dish_ingredient VALUES
  (1, 1),
  (1, 3),
  (1, 9),
  (2, 2),
  (2, 5),
  (2, 6),
  (3, 2),
  (3, 6),
  (3, 8),
  (4, 2),
  (4, 4),
  (4, 6),
  (4, 10),
  (5, 7),
  (5, 10);

INSERT INTO "order" VALUES
  (1, false, '2016-08-11 08:22:12', 15, 2),
  (2, false, '2016-08-11 08:39:48', 11, 3),
  (3, false, '2016-08-11 08:45:19', 13, 3),
  (4, false, '2016-08-11 12:30:12', 3, 2),
  (5, false, '2016-08-11 12:33:33', 7, 3),
  (6, false, '2016-08-11 12:36:39', 1, 2),
  (7, false, '2016-08-11 12:42:03', 9, 3),
  (8, false, '2016-08-11 12:55:26', 14, 2),
  (9, false, '2016-08-11 17:31:18', 13, 2),
  (10, false, '2016-08-11 17:36:23', 11, 3);

INSERT INTO order_dish VALUES
  (1, 1),
  (1, 1),
  (2, 1),
  (3, 2),
  (4, 3),
  (5, 4),
  (6, 3),
  (7, 4),
  (8, 5),
  (9, 4),
  (9, 5),
  (10, 5);

INSERT INTO menu VALUES
  (1, 'Meat'),
  (2, 'Light'),
  (3, 'Quick');

INSERT INTO menu_structure VALUES
  (1, 2),
  (2, 1),
  (2, 5),
  (3, 3),
  (3, 4);

INSERT INTO store_house VALUES
  (1, '25 L'),
  (2, '36 Kg'),
  (3, '99 Kg'),
  (4, '13 Kg'),
  (5, '23 Kg'),
  (6, '11 Kg'),
  (7, '33 Kg'),
  (8, '14 Kg'),
  (9, '9 Kg'),
  (10, '7 Kg');

INSERT INTO prepared_dishes VALUES
  (1, '2016-08-11 08:29:12', 1, 1, 1),
  (2, '2016-08-11 08:44:48', 1, 1, 2),
  (3, '2016-08-11 08:56:19', 1, 1, 3),
  (4, '2016-08-11 12:40:12', 2, 1, 4),
  (5, '2016-08-11 12:36:33', 3, 1, 5),
  (6, '2016-08-11 12:52:39', 4, 1, 6),
  (7, '2016-08-11 12:53:03', 3, 1, 7),
  (8, '2016-08-11 12:59:26', 4, 1, 8),
  (9, '2016-08-11 17:45:18', 5, 1, 9),
  (10, '2016-08-11 17:46:23', 5, 1,10);


