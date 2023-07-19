-- Table: users
CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       user_id UUID DEFAULT gen_random_uuid(),
                       name VARCHAR(255) UNIQUE NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       email VARCHAR(255) UNIQUE NOT NULL,
                       create_date TIMESTAMP DEFAULT CURRENT_DATE,
                       update_date TIMESTAMP,
                       delete_date TIMESTAMP,
                       role VARCHAR(255) NOT NULL CHECK (role IN ('ROLE_USER', 'ROLE_ADMIN', '')),
--                        is_admin BOOLEAN NOT NULL
);
-- insert user default
INSERT INTO users (name, password, email, role)
VALUES ('admin', '$2a$12$z4zBiKdEKXIg2P8pzUN4MelT1EphgMSQNE4n.4G0sP2SxqRw4I/jq', 'admin@gmail.com.com', 'ROLE_ADMIN');


-- TABLE Role
CREATE TABLE role (
                      role_id INT AUTO_INCREMENT PRIMARY KEY ,
                      role_name varchar(250)
);


INSERT INTO role (role_name)
VALUES
    ('ACADEMY'),
    ('ACCOUNTANT'),
    ('ADMIN'),
    ('DEAN'),
    ('LECTURER'),
    ('LIBRARIAN'),
    ('PARENTS'),
    ('READ'),
    ('RECEPTIONIST'),
    ('STUDENT');


CREATE TABLE users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(255) UNIQUE NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       email VARCHAR(255) UNIQUE NOT NULL,
                       create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       update_date DATETIME,
                       delete_date DATETIME,
                       role_id INT,
                       FOREIGN KEY (role_id) REFERENCES role(role_id)
)

-- insert user default
    INSERT INTO users (name, password, email, role_id)
VALUES ('admin', '$2a$12$z4zBiKdEKXIg2P8pzUN4MelT1EphgMSQNE4n.4G0sP2SxqRw4I/jq', 'admin@gmail.com.com', '10');