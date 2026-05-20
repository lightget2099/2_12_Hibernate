INSERT INTO Client(name) VALUES
                                ('Bogdan'),
                                ('Sasha'),
                                ('Maxim'),
                                ('Andrii'),
                                ('Stanislav'),
                                ('Denys'),
                                ('Artem'),
                                ('Vladyslav'),
                                ('Maria'),
                                ('Alla');



INSERT INTO Planet(id, name) VALUES
                                 ('VENERA', 'Venera'),
                                 ('EARTH', 'Earth'),
                                 ('JUPI', 'Jupiter'),
                                 ('URAN', 'Uran'),
                                 ('MERKYRII', 'Merkyrii');
INSERT INTO Ticket(created_at, client_id, from_planet_id, to_planet_id) VALUES
                                                                            (CURRENT_TIMESTAMP, 1, 'EARTH', 'JUPI'),
                                                                            (CURRENT_TIMESTAMP, 2, 'EARTH', 'URAN'),
                                                                            (CURRENT_TIMESTAMP, 3, 'MERKYRII', 'JUPI'),
                                                                            (CURRENT_TIMESTAMP, 4, 'URAN', 'EARTH'),
                                                                            (CURRENT_TIMESTAMP, 5, 'VENERA', 'URAN'),
                                                                            (CURRENT_TIMESTAMP, 6, 'EARTH', 'MERKYRII'),
                                                                            (CURRENT_TIMESTAMP, 7, 'VENERA', 'MERKYRII'),
                                                                            (CURRENT_TIMESTAMP, 8, 'EARTH', 'VENERA'),
                                                                            (CURRENT_TIMESTAMP, 9, 'URAN', 'MERKYRII'),
                                                                            (CURRENT_TIMESTAMP, 10, 'MERKYRII', 'EARTH');

