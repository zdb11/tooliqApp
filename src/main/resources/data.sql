insert into tool(id, name, producer, description, parameter_speed, parameter_feed, hyperlink) VALUES
                                                                                      (1, 'Frez trzpieniowy','Garant', 'Frez zgrubny, D=16 mm, 4 ostrza',
                                                                                       '120','0.7','frez-trzp'),
                                                                                      (2, 'Wiertło VHM','Kyocera', 'Wiertło 8 mm, chłodzenie przez wrzeciono ',
                                                                                       '160','0.2','wiertlo-mono'),
                                                                                      (3, 'Nóż tokarski','Teknik', 'Nóz do toczenia zewnętrznego, płytka WN--0804--',
                                                                                       '220','0.25','noz-tokarski'),
                                                                                      (4, 'Głowica frezarska','Kyocera', 'Głowica 32 mm, płytki PR15-- lub CA6535',
                                                                                       '160','0.13','glowica-frez');

insert into client_order(id, full_name, department, status) VALUES
                                                             (1, 'Fabian Ziółkowska', 'Tokarki', 'NEW'),
                                                             (2, 'Dariusz Rutkowski', 'Frezarki', 'NEW'),
                                                             (3, 'Paula Czarnecka', 'Tokarki', 'IN_PROGRESS'),
                                                             (4, 'Danuta Krupa', 'Ślusarnia', 'IN_PROGRESS'),
                                                             (5, 'Alana Jankowska', 'EDM', 'COMPLETE'),
                                                             (6, 'Roman Sokołowski', 'Frezarki', 'COMPLETE');

insert into order_tool (order_id, tool_id) values
                                               (1, 1),
                                               (1, 2),
                                               (1, 3),
                                               (2, 3),
                                               (2, 4),
                                               (3, 1),
                                               (3, 1),
                                               (3, 1),
                                               (4, 1),
                                               (4, 2),
                                               (5, 3),
                                               (5, 3),
                                               (5, 4),
                                               (6, 4),
                                               (6, 4);