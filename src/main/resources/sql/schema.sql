CREATE TABLE "position" (
  id SERIAL NOT NULL,
  title VARCHAR(50) NOT NULL UNIQUE,
  PRIMARY KEY (id));

CREATE TABLE employee (
  id SERIAL NOT NULL,
  name VARCHAR(50) NOT NULL,
  dob DATE,
  phone VARCHAR (20) UNIQUE,
  position_id INT NOT NULL,
  salary REAl,
  PRIMARY KEY (id),
  FOREIGN KEY (position_id)
  REFERENCES "position" (id));

CREATE TABLE ingredient (
  id SERIAL NOT NULL,
  ingredient_name VARCHAR(50) NOT NULL UNIQUE,
  PRIMARY KEY (id));

CREATE TABLE dish (
  id SERIAL NOT NULL,
  dish_name VARCHAR(50) NOT NULL UNIQUE,
  category VARCHAR (50) NOT NULL,
  price REAL NOT NULL,
  weight REAL NOT NULL,
  PRIMARY KEY (id));

CREATE TABLE dish_ingredient (
  dish_id INT NOT NULL,
  ingredient_id INT NOT NULL,
  quantity REAL NOT NULL,
  FOREIGN KEY (dish_id)
  REFERENCES "dish" (id),
  FOREIGN KEY (ingredient_id)
  REFERENCES "ingredient" (id));

CREATE TABLE "order" (
  id SERIAL NOT NULL,
  is_opened BOOLEAN NOT NULL,
  order_date TIMESTAMP NOT NULL,
  table_number int,
  employee_id int NOT NULL,
  dish_id int NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (employee_id)
  REFERENCES "employee" (id),
  FOREIGN KEY (dish_id)
  REFERENCES "dish" (id)
  );

  CREATE TABLE order_dish (
  order_id INT NOT NULL,
  dish_id INT NOT NULL,
  FOREIGN KEY (order_id)
  REFERENCES "order" (id),
  FOREIGN KEY (dish_id)
  REFERENCES "dish" (id));

CREATE TABLE menu (
  id SERIAL NOT NULL,
  menu_name VARCHAR(50) NOT NULL UNIQUE,
  PRIMARY KEY (id));

CREATE TABLE menu_structure (
  menu_id INT NOT NULL,
  dish_id INT NOT NULL,
  FOREIGN KEY (menu_id)
  REFERENCES "menu" (id),
  FOREIGN KEY (dish_id)
  REFERENCES "dish" (id));

CREATE TABLE store_house (
  ingredient_id int NOT NULL,
  quantity char(30) NOT NULL,
  PRIMARY KEY (ingredient_id),
  FOREIGN KEY (ingredient_id)
  REFERENCES "ingredient" (id));

CREATE TABLE prepared_dishes (
  id SERIAL NOT NULL,
  when_prepared TIMESTAMP NOT NULL,
  dish_id int NOT NULL,
  employee_id int NOT NULL,
  order_id int NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (dish_id)
  REFERENCES "dish" (id),
  FOREIGN KEY (employee_id)
  REFERENCES "employee" (id),
  FOREIGN KEY (order_id)
  REFERENCES "order" (id));