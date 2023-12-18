INSERT INTO COUNTRY(name, version)
VALUES ('VIETNAM', 0),
       ('FRANCE', 0),
       ('FINLAND', 0),
       ('ARGENTINA', 0),
       ('PORTUGAL', 0),
       ('BRAZIL', 0),
       ('DENMARK', 0),
       ('CANADA', 0),
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
       ('HELSINKI', 3, 0),
       ('TURKU', 3, 0),
       ('TAMPERE', 3, 0),
       ('KUOPIO', 3, 0),
       ('OULU', 3, 0),
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
       ('QUÉBEC CITY', 8, 0),
       ('TORONTO', 8, 0),
       ('VANCOUVER', 8, 0),
       ('OTTAWA', 8, 0),
       ('CALGARY', 8, 0),
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
VALUES ('VIETNAM DONG', 'VND', 0),
       ('UNITED STATES DOLLAR', 'USD', 0),
       ('EURO', 'EUR', 0),
       ('JAPANESE YEN', 'JPY', 0),
       ('AUSTRALIAN DOLLAR', 'AUD', 0),
       ('CANADIAN DOLLAR', 'CAD', 0),
       ('NEW ZEALAND DOLLAR', 'NZD', 0),
       ('ARGENTINA PESO', 'ARS', 0),
       ('SWISS FRANC', 'CHF', 0),
       ('BRAZILIAN REAL', 'BRL', 0),
       ('DANISH KRONE', 'DKK', 0);


INSERT INTO JOURNEY (name, description, country_id, start_date, end_date, currency_id, amount, days, nights, status, version)
VALUES
    ('Vietnam Adventure', 'Exploring the vibrant culture and landscapes of Vietnam', 1, '2023-04-01', '2023-04-10', 1, 3000, 10, 9, 'PLANNING', 0),
    ('Romantic Parisian Getaway', 'Experiencing the romance of Paris', 2, '2023-05-15', '2023-05-25', 3, 5000, 11, 10, 'IN_PROGRESS', 0),
    ('Finnish Winter Wonderland', 'Embracing the winter magic in Finland', 3, '2023-02-10', '2023-02-20', 3, 4000, 11, 10, 'FINISHED', 0),
    ('Tango Nights in Argentina', 'Immersing in the passionate dance culture of Argentina', 4, '2023-06-20', '2023-06-30', 8, 4500, 11, 10, 'PLANNING', 0),
    ('Portuguese Coastal Escape', 'Enjoying the scenic coasts of Portugal', 5, '2023-07-10', '2023-07-20', 3, 4800, 11, 10, 'IN_PROGRESS', 0),
    ('Brazilian Carnival Extravaganza', 'Celebrating the vibrant Brazilian carnival', 6, '2023-03-01', '2023-03-10', 10, 5500, 11, 10, 'FINISHED', 0),
    ('Scenic Denmark Tour', 'Exploring the beauty of Denmark', 7, '2023-08-15', '2023-08-25', 11, 4200, 11, 10, 'PLANNING', 0),
    ('Canadian Rockies Adventure', 'Hiking through the stunning Canadian Rockies', 8, '2023-09-05', '2023-09-15', 6, 6000, 11, 10, 'IN_PROGRESS', 0),
    ('Cherry Blossom in Japan', 'Witnessing the breathtaking cherry blossoms in Japan', 9, '2023-04-15', '2023-04-25', 4, 5500, 11, 10, 'FINISHED', 0),
    ('Swiss Alpine Retreat', 'Skiing and relaxing in the Swiss Alps', 10, '2023-01-25', '2023-02-05', 9, 7000, 11, 10, 'PLANNING', 0),
    ('Swiss Adventure', 'Exploring the beauty of Switzerland', 10, '2023-08-01', '2023-08-10', 9, 6000, 10, 9, 'PLANNING', 0),
    ('Northern Lights in Finland', 'Chasing the mesmerizing Northern Lights', 3, '2023-09-15', '2023-09-25', 2, 4500, 11, 10, 'IN_PROGRESS', 0),
    ('Historic Tour in Japan', 'Discovering the rich history of Japan', 9, '2023-07-10', '2023-07-20', 4, 5500, 11, 10, 'FINISHED', 0),
    ('Brazilian Beach Retreat', 'Relaxing on the beautiful beaches of Brazil', 6, '2023-06-01', '2023-06-10', 10, 4000, 10, 9, 'PLANNING', 0),
    ('Portuguese Wine Tasting', 'Indulging in the finest wines of Portugal', 5, '2023-10-15', '2023-10-25', 3, 4800, 11, 10, 'IN_PROGRESS', 0),
    ('Canadian Rockies Expedition', 'Adventuring through the stunning Canadian Rockies', 8, '2023-11-01', '2023-11-10', 6, 6500, 10, 9, 'PLANNING', 0),
    ('Japanese Sakura Festival', 'Experiencing the beauty of Sakura Festival in Japan', 9, '2023-04-01', '2023-04-10', 4, 5000, 10, 9, 'IN_PROGRESS', 0),
    ('Parisian Culinary Delight', 'Savoring the flavors of French cuisine in Paris', 2, '2023-05-20', '2023-05-30', 3, 5500, 11, 10, 'FINISHED', 0),
    ('Danish Coastal Retreat', 'Relaxing on the serene coasts of Denmark', 7, '2023-03-15', '2023-03-25', 11, 4200, 11, 10, 'PLANNING', 0),
    ('Argentinian Tango Tour', 'Immersing in the passion of Tango in Argentina', 4, '2023-02-01', '2023-02-10', 8, 5000, 10, 9, 'IN_PROGRESS', 0),
    ('Sunny Beach Retreat in Porto', 'Enjoying the sun and sand in Porto', 5, '2023-06-05', '2023-06-15', 3, 3800, 11, 10, 'IN_PROGRESS', 0),
    ('Scenic Road Trip in Canada', 'Exploring the picturesque landscapes of Canada', 8, '2023-08-20', '2023-09-02', 6, 5500, 14, 13, 'PLANNING', 0),
    ('Tokyo Adventure', 'Diving into the vibrant culture of Tokyo', 9, '2023-03-01', '2023-03-10', 4, 4600, 10, 9, 'FINISHED', 0),
    ('Brazilian Carnival Experience', 'Participating in the electrifying Brazilian Carnival', 6, '2023-02-21', '2023-02-28', 10, 5000, 8, 7, 'IN_PROGRESS', 0),
    ('Swiss Chocolate Tour', 'Indulging in the finest Swiss chocolates', 10, '2023-05-10', '2023-05-20', 9, 4200, 11, 10, 'PLANNING', 0),
    ('Historical Quebec City', 'Immersing in the rich history of Quebec City', 8, '2023-09-15', '2023-09-25', 6, 4800, 11, 10, 'PLANNING', 0),
    ('Kyoto Sakura Festival', 'Witnessing the mesmerizing Sakura Festival in Kyoto', 9, '2023-04-01', '2023-04-10', 4, 5000, 10, 9, 'IN_PROGRESS', 0),
    ('Brazilian Amazon Expedition', 'Exploring the wonders of the Amazon rainforest in Brazil', 6, '2023-07-01', '2023-07-10', 10, 6000, 10, 9, 'PLANNING', 0),
    ('Winter Wonderland in Helsinki', 'Experiencing the enchanting winter in Helsinki', 3, '2023-12-01', '2023-12-10', 3, 4500, 10, 9, 'PLANNING', 0),
    ('Canadian Maritime Adventure', 'Discovering the beauty of Canada Maritime provinces', 8, '2023-10-15', '2023-10-25', 6, 5200, 11, 10, 'IN_PROGRESS', 0),
    ('Enchanting Hanoi Getaway', 'Exploring the rich history and culture of Hanoi', 1, '2023-07-10', '2023-07-20', 1, 3000, 11, 10, 'PLANNING', 0),
    ('Summer in Lyon', 'Savoring the culinary delights of Lyon in the summertime', 2, '2023-06-15', '2023-06-25', 3, 3500, 11, 10, 'IN_PROGRESS', 0),
    ('Winter Retreat in Lapland', 'Experiencing the magic of Lapland in winter', 3, '2023-12-15', '2023-12-25',3, 4200, 11, 10, 'PLANNING', 0),
    ('Scenic Beauty of Halong Bay', 'Cruising through the breathtaking Halong Bay', 1, '2023-08-10', '2023-08-15', 1, 1800, 6, 5, 'IN_PROGRESS', 0),
    ('Provence Lavender Fields Tour', 'Exploring the picturesque lavender fields of Provence', 2, '2023-07-20', '2023-07-28', 3, 2500, 9, 8, 'PLANNING', 0),
    ('Northern Lights Adventure', 'Chasing the Northern Lights in Lapland', 3, '2023-12-01', '2023-12-07', 3, 3000, 7, 6, 'PLANNING', 0),
    ('Tango and Wine in Mendoza', 'Indulging in tango and wine experiences in Mendoza', 4, '2023-09-25', '2023-10-02', 8, 2800, 8, 7, 'IN_PROGRESS', 0),
    ('Coastal Wonders of Algarve', 'Discovering the stunning coastal landscapes of Algarve', 5, '2023-08-05', '2023-08-12', 3, 2000, 8, 7, 'FINISHED', 0),
    ('Carnival in Rio', 'Immersing in the vibrant atmosphere of Rio Carnival', 6, '2023-02-25', '2023-03-05', 10, 3500, 9, 8, 'FINISHED', 0),
    ('Fairy Tale of Odense', 'Exploring the charming fairy tale setting of Odense', 7, '2023-06-05', '2023-06-12', 11, 2200, 8, 7, 'IN_PROGRESS', 0),
    ('Mystical Beauty of Ha Long Bay', 'Exploring the mystical beauty of Ha Long Bay', 1, '2023-09-15', '2023-09-20', 1, 2000, 6, 5, 'PLANNING', 0),
    ('Champs-Élysées Elegance', 'Strolling down the elegant Champs-Élysées in Paris', 2, '2023-05-10', '2023-05-15', 3, 1800, 6, 5, 'IN_PROGRESS', 0),
    ('Winter Wonderland in Lapland', 'Immersing in the enchanting winter wonderland of Lapland', 3, '2023-01-05', '2023-01-12', 3, 2500, 8, 7, 'FINISHED', 0),
    ('Buenos Aires Tango Nights', 'Dancing through the lively tango nights in Buenos Aires', 4, '2023-07-01', '2023-07-07', 8, 2200, 7, 6, 'PLANNING', 0),
    ('Sunset Serenity in Lagos', 'Experiencing the serenity of sunsets in Lagos', 5, '2023-08-25', '2023-08-30', 3, 1900, 6, 5, 'IN_PROGRESS', 0),
    ('Cultural Extravaganza in São Paulo', 'Immersing in the cultural extravaganza of São Paulo', 6, '2023-04-20', '2023-04-27', 10, 2800, 8, 7, 'PLANNING', 0),
    ('Viking Heritage in Randers', 'Exploring the Viking heritage in Randers', 7, '2023-06-15', '2023-06-22', 6, 2100, 8, 7, 'IN_PROGRESS', 0),
    ('Whale Watching in Vancouver', 'Witnessing majestic whales in Vancouver', 8, '2023-09-01', '2023-09-07', 5, 2400, 7, 6, 'FINISHED', 0),
    ('Cherry Blossom Magic in Kyoto', 'Capturing the magic of cherry blossoms in Kyoto', 9, '2023-04-01', '2023-04-08', 4, 2600, 8, 7, 'IN_PROGRESS', 0),
    ('Swiss Chocolate Delights in Zurich', 'Indulging in Swiss chocolate delights in Zurich', 10, '2023-02-10', '2023-02-17', 9, 3200, 8, 7, 'PLANNING', 0),
    ('Imperial Splendors of Hue', 'Exploring the imperial splendors of Hue', 1, '2023-03-10', '2023-03-16', 1, 1800, 7, 6, 'IN_PROGRESS', 0),
    ('Scenic Beauty of Lyon', 'Admiring the scenic beauty of Lyon', 2, '2023-07-05', '2023-07-12', 3, 2100, 8, 7, 'PLANNING', 0),
    ('Midsummer Magic in Turku', 'Experiencing the midsummer magic in Turku', 3, '2023-06-21', '2023-06-28', 3, 2400, 8, 7, 'PLANNING', 0),
    ('Vibrant Energy of Buenos Aires', 'Feeling the vibrant energy of Buenos Aires', 4, '2023-04-15', '2023-04-22', 8, 2000, 8, 7, 'FINISHED', 0),
    ('Portuguese Coastal Delights', 'Indulging in Portuguese coastal delights', 5, '2023-08-10', '2023-08-17', 3, 2300, 8, 7, 'IN_PROGRESS', 0),
    ('Amazon Rainforest Adventure in Manaus', 'Embarking on an Amazon Rainforest adventure in Manaus', 6, '2023-05-01', '2023-05-07', 10, 2600, 7, 6, 'PLANNING', 0),
    ('Carnival Spirit in Rio de Janeiro', 'Immersing in the carnival spirit of Rio de Janeiro', 6, '2023-02-25', '2023-03-03', 10, 2900, 7, 6, 'PLANNING', 0),
    ('Historic Charm of Quebec City', 'Discovering the historic charm of Quebec City', 8, '2023-09-15', '2023-09-22', 2, 1800, 8, 7, 'IN_PROGRESS', 0),
    ('Toronto Skyline Exploration', 'Exploring the iconic skyline of Toronto', 8, '2023-11-01', '2023-11-07', 2, 2200, 7, 6, 'PLANNING', 0),
    ('Osaka Culinary Journey', 'Embarking on a culinary journey in Osaka', 9, '2023-10-10', '2023-10-17', 4, 2500, 8, 7, 'FINISHED', 0),
    ('Swiss Alps Adventure in Zermatt', 'Adventuring in the Swiss Alps in Zermatt', 10, '2023-01-20', '2023-01-27', 9, 3100, 8, 7, 'IN_PROGRESS', 0);





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
