insert into tool(id, name, producer, description, parameters, hyperlink, img_url) VALUES
                                                                                      (1, 'Frez trzpieniowy','Garant', 'Frez 16 mm, zgrubny, 4 ostrza',
                                                                                       'Parametry','frez-trzp','xyx'),
                                                                                      (2, 'Wiertło VHM','Kyocera', 'Wiertło 8 mm, chłodzenie przez wrzeciono ',
                                                                                       'Parametry','wiertlo-mono','xyx'),
                                                                                      (3, 'Nóż tokarski','Mitsubishi', 'Płytka WNMG',
                                                                                       'Parametry','noz-tokarski','xyx'),
                                                                                      (4, 'Głowica frezarska','Kyocera', 'Głowica 50 mm, płytki XYZ x 8',
                                                                                       'Parametry','glowica-frez','xyx');

insert into client_order(id, address, telephone, status) VALUES
                                                             (1, 'Zakrzewskiego 23/5, 50-225 Wrocław', '888777666', 'NEW'),
                                                             (2, 'Kościuszki 13, 52-316 Wrocław', '767454989', 'NEW'),
                                                             (3, 'Krakowska 88/16, 51-515 Wrocław', '666234123', 'IN_PROGRESS'),
                                                             (4, 'Centralna 8/12, 55-100 Wrocław', '598787999', 'IN_PROGRESS'),
                                                             (5, 'Dworcowa 33, 51-200 Wrocław', '600700900', 'COMPLETE'),
                                                             (6, 'Krucza 66/4, 53-300 Wrocław', '696787898', 'COMPLETE');

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