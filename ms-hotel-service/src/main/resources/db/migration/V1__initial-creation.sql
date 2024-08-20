-- Criação da tabela de hoteis
CREATE TABLE hotels (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        cnpj VARCHAR(20) NOT NULL,
                        price_per_night DECIMAL(10, 2) NOT NULL,
                        destination VARCHAR(255) NOT NULL,
                        occupied_check_in_date DATE NOT NULL,
                        occupied_check_out_date DATE NOT NULL,
                        number_of_rooms INT NOT NULL,
                        number_of_guests INT NOT NULL
);

-- Criação da tabela de quartos
CREATE TABLE rooms (
   id BIGINT AUTO_INCREMENT PRIMARY KEY,
   room_type VARCHAR(255),
   capacity INT,
   hotel_id BIGINT,
   FOREIGN KEY (hotel_id) REFERENCES hotels(id)
);

-- Criação da tabela de avaliacoes
CREATE TABLE reviewers (
   id INT AUTO_INCREMENT PRIMARY KEY,
   reviewer_name VARCHAR(255),
   comment TEXT,
   rating DOUBLE,
   hotel_id BIGINT,
   FOREIGN KEY (hotel_id) REFERENCES hotels(id)
);

