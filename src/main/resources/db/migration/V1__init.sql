CREATE TABLE users
(
    id       SERIAL PRIMARY KEY,
    username VARCHAR(50)  NOT NULL UNIQUE,
    email    VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE orders
(
    order_id SERIAL,
    user_id  INT          NOT NULL,
    product  VARCHAR(100) NOT NULL,
    quantity INT          NOT NULL,
    PRIMARY KEY (order_id, user_id),
    CONSTRAINT fk_orders_users FOREIGN KEY (user_id) REFERENCES users (id)
);