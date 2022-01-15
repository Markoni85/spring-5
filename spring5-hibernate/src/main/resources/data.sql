

insert into singer (first_name, last_name, birth_date)
values ('John', 'Mayer', '1977-10-16');
insert into singer (first_name, last_name, birth_date)
values ('Eric', 'Clapton', '1945-03-30');
insert into singer (first_name, last_name, birth_date)
values ('John', 'Butler', '1975-04-01');

insert into album (singer_id, title, release_date)
values (1, 'The Search For Everything', '2017-01-20');
insert into album (singer_id, title, release_date)
values (1, 'Battle Studies', '2009-11-17');
insert into album (singer_id, title, release_date)
values (2, 'From The Cradle ', '1994-09-13');

insert into instrument (instrument_name) values ('Guitar');
insert into instrument (instrument_name) values ('Piano');
insert into instrument (instrument_name) values ('Voice');
insert into instrument (instrument_name) values ('Drums');
insert into instrument (instrument_name) values ('Synthesizer');

insert into singer_instrument(singer_id, instrument_id) values (1, 1);
insert into singer_instrument(singer_id, instrument_id) values (1, 2);
insert into singer_instrument(singer_id, instrument_id) values (2, 1);