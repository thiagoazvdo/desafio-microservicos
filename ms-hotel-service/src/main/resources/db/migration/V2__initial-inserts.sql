
INSERT INTO hotels (name, cnpj, price_per_night, destination, check_in_date, check_out_date, number_of_rooms, number_of_guests)
VALUES
    ('Hotel Lux', '12345678000195', 150.00, 'Paris', '2024-08-01', '2024-08-15', 20, 40),
    ('Hotel Comfort', '12345678000196', 180.00, 'New York', '2024-08-05', '2024-08-20', 15, 30),
    ('Hotel Cozy', '12345678000197', 120.00, 'London', '2024-08-10', '2024-08-25', 10, 25),
    ('Hotel Relax', '12345678000198', 200.00, 'Tokyo', '2024-08-01', '2024-08-30', 25, 50),
    ('Hotel Budget', '12345678000199', 90.00, 'Berlin', '2024-08-01', '2024-08-10', 30, 60),
    ('Hotel Grand', '12345678000200', 250.00, 'Dubai', '2024-09-01', '2024-09-15', 50, 100),
    ('Hotel Suite', '12345678000201', 300.00, 'Rome', '2024-09-10', '2024-09-20', 30, 60),
    ('Hotel Premium', '12345678000202', 350.00, 'Sydney', '2024-10-01', '2024-10-15', 40, 80),
    ('Hotel Classic', '12345678000203', 110.00, 'Madrid', '2024-10-05', '2024-10-12', 25, 50),
    ('Hotel Elite', '12345678000204', 400.00, 'Los Angeles', '2024-11-01', '2024-11-10', 35, 70);


INSERT INTO rooms (room_type, capacity, hotel_id) VALUES
      ('Suite Luxo', 2, 1),
      ('Quarto Standard', 2, 1),
      ('Suíte Superior', 3, 2),
      ('Quarto Executivo', 2, 3),
      ('Quarto Familiar', 4, 4),
      ('Suíte Presidencial', 2, 5);


INSERT INTO reviewers (reviewer_name, comment, rating, hotel_id) VALUES
     ('Maria Silva', 'Excelente hotel, com uma vista maravilhosa para o mar.', 5.0, 1),
     ('João Oliveira', 'Ótima localização e atendimento, mas o preço é um pouco alto.', 4.0, 1),
     ('Ana Costa', 'Hotel muito confortável e bem localizado, recomendo.', 4.5, 2),
     ('Carlos Almeida', 'Bom hotel, mas poderia melhorar o café da manhã.', 3.5, 3),
     ('Fernanda Souza', 'Excelente experiência, hotel de luxo com um serviço impecável.', 5.0, 4),
     ('Ricardo Santos', 'A suite presidencial é espetacular, mas o preço é muito alto.', 4.8, 5);
