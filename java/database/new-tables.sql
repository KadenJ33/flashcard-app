CREATE TABLE decks (
        deck_id serial,
        user_id int NOT NULL,
        name varchar NOT NULL,
        correct boolean,
        CONSTRAINT PK_deck PRIMARY KEY (deck_id),
        CONSTRAINT FK_user FOREIGN KEY(user_id) REFERENCES users(user_id)
);
CREATE TABLE cards (
        card_id serial,
        deck_id int NOT NULL,
        user_id int NOT NULL,
        question varchar NOT NULL,
        answwer varchar NOT NULL,
        correct boolean,
        
        CONSTRAINT PK_card PRIMARY KEY (card_id),
        CONSTRAINT FK_deck FOREIGN KEY(deck_id) REFERENCES decks(deck_id),
        CONSTRAINT FK_user FOREIGN KEY(user_id) REFERENCES users(user_id)
); 