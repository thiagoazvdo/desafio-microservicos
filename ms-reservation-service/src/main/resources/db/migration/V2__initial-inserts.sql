INSERT INTO Hotels (name, destination) VALUES
   ('Grand Plaza', 'Paris'),
   ('Hilton Garden Inn', 'New York'),
   ('Ritz-Carlton', 'London'),
   ('Holiday Inn', 'Tokyo'),
   ('Marriott Marquis', 'Dubai'),
   ('Shangri-La', 'Hong Kong'),
   ('Four Seasons', 'Rome'),
   ('The Langham', 'Sydney'),
   ('InterContinental', 'Istanbul'),
   ('Waldorf Astoria', 'Los Angeles');

INSERT INTO Customers (name, contact) VALUES
  ('John Doe', 'john.doe@example.com'),
  ('Jane Smith', 'jane.smith@example.com'),
  ('Robert Brown', 'robert.brown@example.com'),
  ('Emily Davis', 'emily.davis@example.com'),
  ('Michael Wilson', 'michael.wilson@example.com'),
  ('Olivia Johnson', 'olivia.johnson@example.com'),
  ('William Martinez', 'william.martinez@example.com'),
  ('Sophia Garcia', 'sophia.garcia@example.com'),
  ('James Anderson', 'james.anderson@example.com'),
  ('Isabella Taylor', 'isabella.taylor@example.com');

INSERT INTO Reservations (reservation_date, check_in_date, check_out_date, hotel_id, customer_id, number_of_rooms) VALUES
   ('2024-01-10', '2024-02-01', '2024-02-07', 1, 1, 2),
   ('2024-01-11', '2024-03-15', '2024-03-20', 2, 2, 1),
   ('2024-01-12', '2024-04-05', '2024-04-10', 3, 3, 3),
   ('2024-01-13', '2024-05-01', '2024-05-07', 4, 4, 2),
   ('2024-01-14', '2024-06-10', '2024-06-15', 5, 5, 1),
   ('2024-01-15', '2024-07-01', '2024-07-10', 6, 6, 2),
   ('2024-01-16', '2024-08-05', '2024-08-10', 7, 7, 1),
   ('2024-01-17', '2024-09-01', '2024-09-07', 8, 8, 3),
   ('2024-01-18', '2024-10-15', '2024-10-20', 9, 9, 2),
   ('2024-01-19', '2024-11-01', '2024-11-07', 10, 10, 1);

INSERT INTO Payments (payment_data, amount, payment_status, reservation_id) VALUES
    ('2024-01-10', 500.00, 'Completed', 1),
    ('2024-01-11', 200.00, 'Completed', 2),
    ('2024-01-12', 750.00, 'Completed', 3),
    ('2024-01-13', 300.00, 'Pending', 4),
    ('2024-01-14', 150.00, 'Completed', 5),
    ('2024-01-15', 400.00, 'Completed', 6),
    ('2024-01-16', 250.00, 'Completed', 7),
    ('2024-01-17', 600.00, 'Pending', 8),
    ('2024-01-18', 350.00, 'Completed', 9),
    ('2024-01-19', 200.00, 'Completed', 10);
