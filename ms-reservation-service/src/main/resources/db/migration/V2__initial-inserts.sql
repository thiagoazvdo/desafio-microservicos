INSERT INTO Hotels (name, destination) VALUES
       ('Hotel Sunshine', 'New York'),
       ('Grand View Hotel', 'San Francisco');


INSERT INTO Reservations (reservation_date, check_in_date, check_out_date, hotel_id) VALUES
     ('2024-08-15', '2024-08-20', '2024-08-25', 1),
     ('2024-08-16', '2024-08-22', '2024-08-27', 2);


INSERT INTO Payments (payment_data, amount, payment_status, reservation_id) VALUES
    ('Credit Card', 500.00, 'Paid', 1),
    ('PayPal', 300.00, 'Pending', 2);

