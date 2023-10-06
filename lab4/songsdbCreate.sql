CREATE TABLE IF NOT EXISTS songsdb (SongID int auto_increment PRIMARY KEY, SongName varchar(255),Duration int, Artist varchar(255), Score int);
INSERT INTO songsdb (SongName,Duration,Artist,Score) VALUES 
	( 'Sorry',10 *rand(), 'Nothing But Thieves' , rand()*5),
    ( 'Break up together', 3 * rand() , 'Theo Katzman' , rand()*5),
    ( 'The Steps', 10 * rand() , 'HAIM' , rand()*5),
    ( 'Shy Away', 14 * rand() , 'Twenty One Pilots' , rand()*5),
    ( 'Over your head', 10 * rand() , 'Orla Gartland' , rand()*5),
    ( 'Beautiful faces' , 5 * rand() , 'Declan Mc''Kenna' , rand()*5),
    ( 'G.O.A.T' , 3 * rand() , 'Polyphia' , rand()*5),
    ( 'Song in my head' , 3 * rand() , 'Madison Cunninggham' , rand()*5),
    ( '5''1' , 3 * rand() , 'Greta Isaac' , rand()*5),
    ( 'Chico Pum' , 3 * rand() , 'Ginebras' , rand()*5),
    ( 'Zapatillas' , 3 * rand() , 'El canto del loco' , rand()*5),
    ( 'That wasn''t me' , 3 * rand() , 'Brandi Carlile' , rand()*5),
    ( 'Alto' , 3 * rand() , 'Vetusta Morla' , rand()*5),
    ( 'La Rumba del tartamudo' , 3 * rand() , 'Té Canela' , rand()*5);
