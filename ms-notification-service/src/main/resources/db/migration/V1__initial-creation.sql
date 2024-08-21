CREATE TABLE reservation_notifications (
                                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                           hotel_id BIGINT NOT NULL,
                                           check_in_date DATE NOT NULL,
                                           check_out_date DATE NOT NULL,
                                           reservation_date DATE NOT NULL,
                                           customer_id BIGINT NOT NULL,
                                           number_of_rooms INT NOT NULL,
                                           payment_date DATE,
                                           amount DECIMAL(10, 2),
                                           payment_status VARCHAR(50)
);
