INSERT INTO COUNTRY(name, version)
VALUES ('VIETNAM', 0),
       ('FRANCE', 0),
       ('UNITED STATES', 0),
       ('ARGENTINA', 0),
       ('PORTUGAL', 0),
       ('BRAZIL', 0),
       ('DENMARK', 0),
       ('DOMINICAN REPUBLIC', 0),
       ('JAPAN', 0),
       ('SWITZERLAND', 0);

INSERT INTO PLACE(name, country_id, version)
VALUES ('HO CHI MINH CITY', 1, 0),
    ('HA NOI', 1, 0),
    ('DA NANG', 1, 0),
    ('HUE', 1, 0),
    ('NHA TRANG', 1, 0),
    ('PARIS', 2, 0),
    ('LYON', 2, 0),
    ('BASTILLE', 2, 0),
    ('LA DÉFENSE', 2, 0),
    ('BERCY', 2, 0),
    ('NEW YORK', 3, 0),
    ('LOS ANGELES', 3, 0),
    ('DALLAS', 3, 0),
    ('HOUSTON', 3, 0),
    ('SAN JOSE', 3, 0),
    ('ROSARIO', 4, 0),
    ('BUENOS AIRES', 4, 0),
    ('MENDOZA',4,0),
    ('LA PLATA', 4, 0),
    ('EZEIZA', 4, 0),
    ('LISBON', 5, 0),
    ('PORTO', 5, 0),
    ('BRAGA', 5, 0),
    ('LAGOS', 5, 0),
    ('AVEIRO', 5, 0),
    ('SÃO PAULO', 6, 0),
    ('MANAUS', 6, 0),
    ('RIO DE JANEIRO', 6, 0),
    ('SANTOS', 6, 0),
    ('SALVADOR', 6, 0),
    ('ODENSE', 7, 0),
    ('RANDERS', 7, 0),
    ('ESBJERG', 7, 0),
    ('KOLDING', 7, 0),
    ('HORSENS', 7, 0),
    ('SANTO DOMINGO', 8, 0),
    ('LA ROMANA', 8, 0),
    ('LA VEGA', 8, 0),
    ('PUERTO PLATA', 8, 0),
    ('SANTO DOMINGO ESTE', 8, 0),
    ('TOKYO', 9, 0),
    ('KYOTO', 9, 0),
    ('KAWASAKI', 9, 0),
    ('OSAKA', 9, 0),
    ('KOBE', 9, 0),
    ('ZÜRICH', 10, 0),
    ('GENEVA', 10, 0),
    ('LUGANO', 10, 0),
    ('SION', 10, 0),
    ('BASEL', 10, 0);



INSERT INTO CURRENCY(name, code, version)
VALUES ('Vietnam Dong', 'VND', 0),
       ('United States Dollar', 'USD', 0),
       ('Euro', 'EUR', 0),
       ('Japanese Yen', 'JPY', 0),
       ('Australian Dollar', 'AUD', 0),
       ('Canadian Dollar', 'CAD', 0),
       ('New Zealand Dollar', 'NZD', 0),
       ('Mexican Peso', 'MXN', 0),
       ('Singapore Dollar', 'SGD', 0),
       ('Hong Kong Dollar', 'HKD', 0),
       ('Russian Ruble', 'RUB', 0);


INSERT INTO JOURNEY (name, description, country_id, start_date, end_date, currency_id, amount, days, nights, status, version)
VALUES
    ('Adventure in the Mountains', 'Explore the scenic beauty of the mountains', 1, '2023-01-15', '2023-01-25', 1, 4000, 10, 9, 'FINISHED', 0),
    ('City Lights Tour', 'Experience the vibrant city lights', 2, '2023-02-10', '2023-02-20', 3, 6000, 11, 10, 'IN_PROGRESS', 0),
    ('Tropical Paradise Getaway', 'Relax on the sunny beaches of a tropical paradise', 3, '2023-03-05', '2023-03-15', 2, 8000, 10, 9, 'PLANNING', 0),
    ('Historical Heritage Expedition', 'Discover the rich history of ancient sites', 1, '2023-04-01', '2023-04-10', 4, 7000, 10, 9, 'IN_PROGRESS', 0),
    ('Wine Tasting Journey', 'Indulge in the finest wines of the region', 5, '2023-05-15', '2023-05-25', 5, 9000, 11, 10, 'PLANNING', 0),
    ('Cultural Exploration', 'Immerse yourself in local cultures and traditions', 6, '2023-06-10', '2023-06-20', 6, 7500, 11, 10, 'FINISHED', 0),
    ('Island Hopping Adventure', 'Hop between beautiful islands and enjoy the sun', 1, '2023-07-01', '2023-07-10', 7, 9500, 11, 10, 'IN_PROGRESS', 0),
    ('Mountain Retreat', 'Escape to the serenity of the mountains', 8, '2023-08-15', '2023-08-25', 8, 12000, 10, 9, 'PLANNING', 0),
    ('Culinary Delights Tour', 'Savor the flavors of local cuisines', 4, '2023-09-10', '2023-09-20', 9, 8500, 11, 10, 'FINISHED', 0),
    ('Scuba Diving Expedition', 'Explore the underwater world with scuba diving', 10, '2023-10-05', '2023-10-15', 10, 10000, 10, 9, 'FINISHED', 0),
    ('Safari Adventure', 'Witness wildlife in their natural habitat', 1, '2023-11-01', '2023-11-10', 1, 9000, 10, 9, 'PLANNING', 0),
    ('Festival Expedition', 'Celebrate local festivals and traditions', 4, '2023-12-05', '2023-12-15', 3, 7500, 11, 10, 'IN_PROGRESS', 0),
    ('Beach Retreat', 'Relax and unwind on pristine sandy beaches', 3, '2024-01-01', '2024-01-10', 2, 8000, 10, 9, 'PLANNING', 0),
    ('Mountain Biking Tour', 'Explore scenic trails on a mountain biking adventure', 4, '2024-02-15', '2024-02-25', 4, 7000, 11, 10, 'IN_PROGRESS', 0),
    ('Historical Landmarks Discovery', 'Visit iconic historical landmarks', 5, '2024-03-10', '2024-03-20', 5, 10000, 11, 10, 'PLANNING', 0),
    ('Luxury Cruise Experience', 'Sail on a luxurious cruise ship', 6, '2024-04-05', '2024-04-15', 6, 12000, 10, 9, 'IN_PROGRESS', 0),
    ('Winter Wonderland Escape', 'Experience the magic of a winter wonderland', 7, '2024-05-01', '2024-05-10', 7, 9500, 11, 10, 'PLANNING', 0),
    ('Art and Culture Expedition', 'Immerse yourself in art and cultural experiences', 8, '2024-06-15', '2024-06-25', 8, 11000, 10, 9, 'IN_PROGRESS', 0),
    ('Sunrise Hot Air Balloon Ride', 'Soar above picturesque landscapes at sunrise', 9, '2024-07-01', '2024-07-10', 9, 8500, 11, 10, 'PLANNING', 0),
    ('Mystical Forest Exploration', 'Discover the enchanting secrets of a mystical forest', 1, '2024-09-01', '2024-09-10', 1, 7000, 10, 9, 'PLANNING', 0),
    ('Cultural Festivities Tour', 'Experience local cultural festivals and traditions', 2, '2024-10-15', '2024-10-25', 3, 8500, 11, 10, 'IN_PROGRESS', 0),
    ('Sunset Cruise Adventure', 'Enjoy a serene cruise during the breathtaking sunset', 3, '2024-11-10', '2024-11-20', 2, 6000, 10, 9, 'PLANNING', 0),
    ('Mountain Climbing Expedition', 'Conquer the peaks on a thrilling mountain climbing journey', 4, '2024-12-05', '2024-12-15', 4, 9500, 11, 10, 'IN_PROGRESS', 0),
    ('Architectural Marvels Tour', 'Explore awe-inspiring architectural wonders', 5, '2025-01-01', '2025-01-10', 5, 8000, 10, 9, 'PLANNING', 0),
    ('Luxury Train Experience', 'Embark on a luxurious train journey through scenic landscapes', 6, '2025-02-15', '2025-02-25', 6, 11000, 11, 10, 'IN_PROGRESS', 0),
    ('Coastal Retreat', 'Relax and rejuvenate on tranquil coastal shores', 7, '2025-03-10', '2025-03-20', 7, 9000, 11, 10, 'PLANNING', 0),
    ('Historical City Walk', 'Take a stroll through historical city streets', 8, '2025-04-05', '2025-04-15', 8, 7500, 10, 9, 'IN_PROGRESS', 0),
    ('Hot Air Balloon Safari', 'Experience a safari from the skies in a hot air balloon', 9, '2025-05-01', '2025-05-10', 9, 12000, 11, 10, 'PLANNING', 0),
    ('Underwater Cave Exploration', 'Dive into the depths to explore underwater caves', 10, '2025-06-15', '2025-06-25', 10, 10000, 10, 9, 'IN_PROGRESS', 0),
    ('Mystical Caves Exploration', 'Discover hidden caves and underground wonders', 10, '2024-08-15', '2024-08-25', 10, 9500, 10, 9, 'IN_PROGRESS', 0);

INSERT INTO JOURNEY_PLACE (journey_id, place_id)
VALUES
    (1, 1),
    (1, 2),
    (2, 6),
    (2, 7),
    (3, 11),
    (3, 12),
    (4, 16),
    (4, 17),
    (5, 21),
    (5, 22),
    (6, 26),
    (6, 27),
    (7, 31),
    (7, 32),
    (8, 36),
    (8, 37),
    (9, 41),
    (9, 42),
    (10, 46),
    (10, 47);


CREATE INDEX amount_idx ON JOURNEY(amount);
CREATE INDEX start_date_idx ON JOURNEY(start_date);
CREATE INDEX end_date_idx ON JOURNEY(end_date);
CREATE INDEX country_name_idx ON COUNTRY(name);




