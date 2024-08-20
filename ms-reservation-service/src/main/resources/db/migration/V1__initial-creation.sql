CREATE TABLE Hotels (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        destination VARCHAR(255) NOT NULL
);


CREATE TABLE Customers (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       contact VARCHAR(255) NOT NULL
);


CREATE TABLE Reservations (
                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                              reservation_date DATE NOT NULL,
                              check_in_date DATE NOT NULL,
                              check_out_date DATE NOT NULL,
                              hotel_id BIGINT,
                              customer_id BIGINT,
                              number_of_rooms BIGINT,
                              FOREIGN KEY (hotel_id) REFERENCES Hotels(id)
);


CREATE TABLE Payments (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          payment_data VARCHAR(255),
                          amount DECIMAL(10, 2),
                          payment_status VARCHAR(50),
                          reservation_id BIGINT,
                          FOREIGN KEY (reservation_id) REFERENCES Reservations(id)
);


