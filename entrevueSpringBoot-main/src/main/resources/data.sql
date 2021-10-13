CREATE SEQUENCE SEQ_ID;

CREATE TABLE FILMS
(
    ID          INT AUTO_INCREMENT,
    TITRE       TEXT(50),
    DESCRIPTION TEXT(250),
    CONSTRAINT FILM_PK
        PRIMARY KEY (ID)
);

CREATE TABLE ACTEURS
(
    ID       INT AUTO_INCREMENT,
    NOM      TEXT(50),
    PRENOM   TEXT(50),
    ID_FILMS INT,
    CONSTRAINT ACTEURS_PK
        PRIMARY KEY (ID),
    CONSTRAINT ACTEURS_FILMS_ID_FK
        FOREIGN KEY (ID_FILMS) REFERENCES FILMS (ID)
);

INSERT INTO FILMS (ID, TITRE, DESCRIPTION)
VALUES (SEQ_ID.nextval, 'Star Wars: The Empire Strikes Back',
        'Darth Vader is adamant about turning Luke Skywalker to the dark side.');

INSERT INTO ACTEURS (ID, NOM, PRENOM, ID_FILMS)
VALUES (SEQ_ID.nextval, 'Ford', 'Harrison',
        (SELECT ID FROM FILMS WHERE TITRE LIKE 'Star Wars: The Empire Strikes Back'));
INSERT INTO ACTEURS (ID, NOM, PRENOM, ID_FILMS)
VALUES (SEQ_ID.nextval, 'Hamill', 'Mark',
        (SELECT ID FROM FILMS WHERE TITRE LIKE 'Star Wars: The Empire Strikes Back'));

COMMIT;