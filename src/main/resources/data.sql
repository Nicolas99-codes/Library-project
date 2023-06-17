INSERT INTO USERS (ID, USERNAME, SURNAME, EMAIL, USER_ROLE)
VALUES
    (1, 'Lix', 'test', 'test@gmail.com', 'test');

INSERT INTO USERS (ID, USERNAME, SURNAME, EMAIL, USER_ROLE)
VALUES
    (2, 'Lore', 'test', 'test@gmail.com', 'test');

INSERT INTO USERS (ID, USERNAME, SURNAME, EMAIL, USER_ROLE)
VALUES
    (3, 'Ikram', 'test', 'test@gmail.com', 'test');

INSERT INTO USERS (ID, USERNAME, SURNAME, EMAIL, USER_ROLE)
VALUES
    (4, 'Olephia', 'test', 'test@gmail.com', 'test');

INSERT INTO USERS (ID, USERNAME, SURNAME, EMAIL, USER_ROLE)
VALUES
    (5, 'Viviane', 'test', 'test@gmail.com', 'test');

INSERT INTO USERS (ID, USERNAME, SURNAME, EMAIL, USER_ROLE)
VALUES
    (6, 'Max', 'test', 'test@gmail.com', 'test');

INSERT INTO USERS (ID, USERNAME, SURNAME, EMAIL, USER_ROLE)
VALUES
    (7, 'Tim', 'test', 'test@gmail.com', 'test');

INSERT INTO USERS (ID, USERNAME, SURNAME, EMAIL, USER_ROLE)
VALUES
    (8, 'Anna', 'test', 'test@gmail.com', 'test');

INSERT INTO USERS (ID, USERNAME, SURNAME, EMAIL, USER_ROLE)
VALUES
    (9, 'Miele', 'test', 'test@gmail.com', 'test');

INSERT INTO USERS (ID, USERNAME, SURNAME, EMAIL, USER_ROLE)
VALUES
    (10, 'Silke', 'test', 'test@gmail.com', 'test');

INSERT INTO TRANSACTIONS(ID, book, title, author, users)
VALUES
    (1, 1, 'Solo Leveling', 'Chugong', 'Lix');

INSERT INTO TRANSACTIONS(ID, book, title, author, users)
VALUES
    (2, 1, 'Sword Art Online', 'Reki Kawahara', 'Lore');

INSERT INTO TRANSACTIONS(ID, book, title, author, users)
VALUES
    (3, 1, 'Tokyo Ghoul', 'Sui Ishida', 'Ikram');

INSERT INTO TRANSACTIONS(ID, book, title, author, users)
VALUES
    (4, 1, 'Solo Leveling', 'Chugong', 'Olephia');

INSERT INTO TRANSACTIONS(ID, book, title, author, users)
VALUES
    (5, 1, 'Violet Evergarden', 'Kana Akatsuki', 'Viviane');

INSERT INTO TRANSACTIONS(ID, book, title, author, users)
VALUES
    (6, 1, 'In the Land of Leadale', 'Ceez', 'Max');

INSERT INTO TRANSACTIONS(ID, book, title, author, users)
VALUES
    (7, 1, 'Darling in the franxx', 'Atsushi Nishogri, Naotaka Hayashi', 'Tim');

INSERT INTO TRANSACTIONS(ID, book, title, author, users)
VALUES
    (8, 1, 'Blue Lock', 'Muneyuki Kaneshiro', 'Anna');

INSERT INTO TRANSACTIONS(ID, book, title, author, users)
VALUES
    (9, 1, 'Solo Leveling', 'Chugong', 'Miele');

INSERT INTO TRANSACTIONS(ID, book, title, author, users)
VALUES
    (10, 1, '86', 'Haruto Umezawa', 'Silke');

INSERT INTO AUTHOR(ID, author_name, SURNAME, BIO, COUNTRY)
VALUES
    (1, 'Chugong', '-', '-', 'South Korea');

INSERT INTO AUTHOR(ID, author_name, SURNAME, BIO, COUNTRY)
VALUES
    (2, 'Reki', 'Kawahara', '-', 'Japan');

INSERT INTO AUTHOR(ID, author_name, SURNAME, BIO, COUNTRY)
VALUES
    (3, 'Fuse', '-', '?', 'Japan');

INSERT INTO AUTHOR(ID, author_name, SURNAME, BIO, COUNTRY)
VALUES
    (4, 'Kana', 'Akatsuki', '-', 'Japan');

INSERT INTO AUTHOR(ID, author_name, SURNAME, BIO, COUNTRY)
VALUES
    (5, 'Atsushi', 'Nishigori', '-', 'Japan');

INSERT INTO AUTHOR(ID, author_name, SURNAME, BIO, COUNTRY)
VALUES
    (6, 'Naotaka', 'Hayashi', '-', '-');

INSERT INTO AUTHOR(ID, author_name, SURNAME, BIO, COUNTRY)
VALUES
    (7, 'Haruto', 'Umezawa', '-', 'Japan');

INSERT INTO AUTHOR(ID, author_name, SURNAME, BIO, COUNTRY)
VALUES
    (8, 'Rifujin', 'na Magonote', '-', 'Japan');

INSERT INTO AUTHOR(ID, author_name, SURNAME, BIO, COUNTRY)
VALUES
    (9, 'Kisetsu', 'Morita', '-', 'Japan');

INSERT INTO AUTHOR(ID, author_name, SURNAME, BIO, COUNTRY)
VALUES
    (10, 'Shinkoshoto', '-', '-', 'Japan');

INSERT INTO AUTHOR(ID, author_name, SURNAME, BIO, COUNTRY)
VALUES
    (11, 'Shogo', 'Kinugasa', '-', 'Japan');

INSERT INTO AUTHOR(ID, author_name, SURNAME, BIO, COUNTRY)
VALUES
    (12, 'Sui', 'Ishida', '-', 'Japan');

INSERT INTO AUTHOR(ID, author_name, SURNAME, BIO, COUNTRY)
VALUES
    (13, 'Muneyuki', 'Kaneshiro', '-', 'Japan');

INSERT INTO AUTHOR(ID, author_name, SURNAME, BIO, COUNTRY)
VALUES
    (14, 'Miki', 'Nazuna', '-', 'Japan');

INSERT INTO AUTHOR(ID, author_name, SURNAME, BIO, COUNTRY)
VALUES
    (15, 'Aneko', 'Yusagi', '-', 'Japan');

INSERT INTO AUTHOR(ID, author_name, SURNAME, BIO, COUNTRY)
VALUES
    (16, 'Kaiu', 'Shirai', '-', 'Japan');

INSERT INTO AUTHOR(ID, author_name, SURNAME, BIO, COUNTRY)
VALUES
    (17, 'Ceez', '-', '-', '-');

INSERT INTO BOOK (TITLE, AUTHOR, GENRE, CATEGORY, DESCRIPTION, STATUS, RELEASE_YEAR, VIEWS)
VALUES
    ('Solo Leveling', 'Chugong', 'Fantasy, Action', 'Manhwa',
     'In a world where hunters — human warriors who possess supernatural abilities — must battle deadly monsters to protect mankind from certain annihilation'
        , 'Ongoing', 2018, 17688);

INSERT INTO BOOK (TITLE, AUTHOR, GENRE, CATEGORY, DESCRIPTION, STATUS, RELEASE_YEAR, VIEWS)
VALUES
    ('Sword Art Online', 'Reki Kawahara', 'Fantasy, Action, Drama', 'Light Novel',
     'In the year 2022, virtual reality has progressed by leaps and bounds, and a massive online role-playing game called Sword Art Online (SAO) is launched. ' ||
     'With the aid of "NerveGear" technology, players can control their avatars within the game using nothing but their own thoughts. Kirito is one such player. ' ||
     'Having logged in to test the game, he is ready to begin his quest, when suddenly the game goes live. ' ||
     'However, in a cruel twist of fate, the players soon discover that they cannot log out, as the game creator is holding them captive unless they reach the 100th floor of the game tower and defeat the final boss. Their struggle for survival starts now.'
        , 'Completed', 2012, 19238);

INSERT INTO BOOK (TITLE, AUTHOR, GENRE, CATEGORY, DESCRIPTION, STATUS, RELEASE_YEAR, VIEWS)
VALUES
    ('That time I got reincarnated as a slime', 'Fuse', 'Fantasy, Isekai', 'Manga',
     'Satoru Mikami is a thirty-seven-year-old office worker who has just been killed by a robber. ' ||
     'He soon awakens to find himself reincarnated in a fantasy world and he is shocked to discover he has become a slime monster! ' ||
     'However, his new life in this strange world is just beginning. ' ||
     'With the future of the world at stake, Satoru must use his newfound powers to defeat the Demon King and restore peace to the land.'
        , 'Ongoing', 2018, 91871);

INSERT INTO BOOK (TITLE, AUTHOR, GENRE, CATEGORY, DESCRIPTION, STATUS, RELEASE_YEAR, VIEWS)
VALUES
    ('Violet Evergarden', 'Kana Akatsuki', 'Drama', 'Manga',
     'There was a machine invented as a prototype for the typewriter, called Auto Memory Dolls. It was originally made by Professor Orlando, the authority on letterpress printing and a researcher of mechanical dolls.'
        , 'Completed', 2018, 9002);

INSERT INTO BOOK (TITLE, AUTHOR, GENRE, CATEGORY, DESCRIPTION, STATUS, RELEASE_YEAR, VIEWS)
VALUES
    ('Darling in the Franxx', 'Atsushi Nishigori, Naotaka Hayashi', 'Action, Drama, Romance', 'Manga',
     'In the distant future, humanity has been driven to near-extinction by monstrous creatures known as Klaxosaurs, forcing the remaining humans to take refuge in massive mobile fortresses called Plantations. ' ||
     'In order to combat the Klaxosaurs, humanity developed the Franxx, giant humanoid weapons that are controlled by pairs of pilots whose minds are joined by a neural bridge. ' ||
     'The story follows the adventures of Hiro and Zero Two, two Franxx pilots who are part of the experimental Strelizia Battalion, as they fight to protect humanity from the Klaxosaur threat.'
        , 'Completed', 2018, 91891);

INSERT INTO BOOK (TITLE, AUTHOR, GENRE, CATEGORY, DESCRIPTION, STATUS, RELEASE_YEAR, VIEWS)
VALUES
    ('86', 'Haruto Umezawa', 'Action, Drama, Sci-Fi', 'Manga',
     'In the year 2086, the world is divided into two superpowers: the Empire of Japan and the Federation of North America. ' ||
     'The Empire of Japan is a totalitarian state that has conquered the entire Eurasian continent, while the Federation of North America is a democratic nation that has conquered the entire North American continent. ' ||
     'The two superpowers are engaged in a cold war, and the Federation of North America has developed a new weapon called the "86" that can destroy the Empire of Japan. ' ||
     'The story follows the adventures of Shiro Amada, a young soldier who is part of the 86th Platoon of the Imperial Army, as he fights to protect his country from the Federation of North America.'
        , 'Ongoing', 2018, 25142);

INSERT INTO BOOK (TITLE, AUTHOR, GENRE, CATEGORY, DESCRIPTION, STATUS, RELEASE_YEAR, VIEWS)
VALUES
    ('Mushoku Tensei: Jobless Reincarnation', 'Rifujin na Magonote', 'Fantasy, Isekai', 'Light Novel',
     'An unnamed 34-year old Japanese NEET is evicted from his home following his parents death and skipping the funeral. ' ||
     'He is then reincarnated in a world of swords and magic as Rudeus Greyrat, a baby. ' ||
     'However, Rudeus is not alone, as he is accompanied by the spirit of a recently deceased sage, Libra. ' ||
     'Together, they must work to survive in this new world.', 'Ongoing', 2014, 39187);

INSERT INTO BOOK (TITLE, AUTHOR, GENRE, CATEGORY, DESCRIPTION, STATUS, RELEASE_YEAR, VIEWS)
VALUES
    ('I have been killing slimes for 300 years and maxed out my level', 'Kisetsu Morita', 'Fantasy, Isekai', 'Manga',
     'After living a painful life as an office worker, Azusa ends up dying from overworking.' ||
     'She finds herself reincarnated as undying, unaging witch in a new world, and now she vows to spend her days as pleasantly and stress-free as possible.', 'Ongoing', 2017, 8918);

INSERT INTO BOOK (TITLE, AUTHOR, GENRE, CATEGORY, DESCRIPTION, STATUS, RELEASE_YEAR, VIEWS)
VALUES
    ('The Strongest Sage with Weakest Crest', 'Shinkoshoto', 'Adventure, Fantasy', 'Manga',
     'In a world of magic, the powers and future of a mage are predetermined at birth through so-called Marks, four symbols that categorize a humans aptitude for magic. ' ||
     'Lamenting the fact that his mark was considered ill-suited for combat and only useful for magic augmentation, an incredibly skilled sage decided to reincarnate thousands of years in the future.', 'Ongoing', 2017, 46512);

INSERT INTO BOOK (TITLE, AUTHOR, GENRE, CATEGORY, DESCRIPTION, STATUS, RELEASE_YEAR, VIEWS)
VALUES
    ('Classroom of the Elite', 'Shogo Kinugasa', 'Thriller, Drama', 'Manga',
     'The Japanese government has established the Tokyo Metropolitan Advanced Nurturing School, dedicated to instruct and foster the generation of people that will support the country in the future.' ||
     'The students are given a high degree of freedom in order to closely mimic real life.', 'Ongoing', 2016, 81716);

INSERT INTO BOOK (TITLE, AUTHOR, GENRE, CATEGORY, DESCRIPTION, STATUS, RELEASE_YEAR, VIEWS)
VALUES
    ('Tokyo Ghoul', 'Sui Ishida', 'Thriller, Fantasy', 'Manga',
     'Ken Kaneki, a student who barely survives a deadly encounter with Rize Kamishiro, his date who reveals herself as a ghoul and tries to eat him.' ||
     'He is taken to the hospital in critical condition. After recovering, Kaneki discovers that he underwent a surgery that transformed him into a half-ghoul.', 'Completed', 2011, 81715);

INSERT INTO BOOK (TITLE, AUTHOR, GENRE, CATEGORY, DESCRIPTION, STATUS, RELEASE_YEAR, VIEWS)
VALUES
    ('Blue Lock', 'Muneyuki Kaneshiro', 'Sports, Thriller', 'Manga',
     'In 2018, the Japenese national team finished in 16th in the FIFA World Cup. As a result, the Japan Football Association hires the football engima Ego Jinpachi.' ||
     'His master plan to lead Japan to stardom is Blue lock, a training regimen designed to create the worlds greatest egotist striker.', 'Ongoing', 2018, 98112);

INSERT INTO BOOK (TITLE, AUTHOR, GENRE, CATEGORY, DESCRIPTION, STATUS, RELEASE_YEAR, VIEWS)
VALUES
    ('My unique Skill makes me OP even at level 1', 'Nazuna Miki', 'Fantasy, Isekai, Adventure', 'Light Novel',
     'Ryouta Satou, who died from overworking at a black company, was reincarnated to another world.' ||
     'Although Ryouta was alive, he was now burdened with the incovenience that his level is fixed to 1 in this new world.', 'Ongoing', 2018, 44551);

INSERT INTO BOOK (TITLE, AUTHOR, GENRE, CATEGORY, DESCRIPTION, STATUS, RELEASE_YEAR, VIEWS)
VALUES
    ('The Rising of the Shield Hero', 'Aneko Yusagi', 'Action, Adventure, Fantasy', 'Light Novel',
     'Naofumi Iwatani, an uncharismatic Otaku who spends his days on games and manga, suddenly finds himself summoned to a parallel universe.' ||
     'He discovers he is one of four heroes equipped with legendary weapons and tasked with saving the world from its prophesied destruction.', 'Ongoing', 2018, 42141);

INSERT INTO BOOK (TITLE, AUTHOR, GENRE, CATEGORY, DESCRIPTION, STATUS, RELEASE_YEAR, VIEWS)
VALUES
    ('The Promised Neverland', 'Kaiu Shirai', 'Mystery, Thriller, Fantasy', 'Manga',
     'Emma, Norman and Ray are three orphans living at Grace Field House, a seemingly idyllic orphanage.' ||
     'However, the children are actually livestock, and their caretakers are planning to kill them and eat them.', 'Ongoing', 2016, 53327);

INSERT INTO BOOK (TITLE, AUTHOR, GENRE, CATEGORY, DESCRIPTION, STATUS, RELEASE_YEAR, VIEWS)
VALUES
    ('In the Land of Leadale', 'Ceez', 'Adventure, Fantasy', 'Manga',
     'Due to an accident, half of Keina Kagemi body was paralyzed.' ||
     'One day, because of a power outage, she regrettably died.' ||
     'However, just before that, her mind was moved to the world of online game she was playing.', 'Ongoing', 2019, 91781);

INSERT INTO GENRE (ID, GENRE)
VALUES (1, 'Action');

INSERT INTO GENRE (ID, GENRE)
VALUES (2, 'Adventure');

INSERT INTO GENRE (ID, GENRE)
VALUES (3, 'Comedy');

INSERT INTO GENRE (ID, GENRE)
VALUES (4, 'Drama');

INSERT INTO GENRE (ID, GENRE)
VALUES (5, 'Fantasy');

INSERT INTO GENRE (ID, GENRE)
VALUES (6, 'Isekai');

INSERT INTO GENRE (ID, GENRE)
VALUES (7, 'Mystery');

INSERT INTO GENRE (ID, GENRE)
VALUES (8, 'Romance');

INSERT INTO GENRE (ID, GENRE)
VALUES (9, 'Sports');

INSERT INTO GENRE (ID, GENRE)
VALUES (10, 'Thriller');

INSERT INTO GENRE (ID, GENRE)
VALUES (11, 'Sci-fi');

INSERT INTO STATUS (ID, STATUS)
VALUES (1, 'Ongoing');

INSERT INTO STATUS (ID, STATUS)
VALUES (2, 'Completed');

INSERT INTO CATEGORY (ID, CATEGORY, COUNTRY, BIO, book_language)
VALUES (1, 'Manga', 'Japan', 'Manga is the Japanese equivalent of comics with a unique style and following.', 'Japanese');

INSERT INTO CATEGORY (ID, CATEGORY, COUNTRY, BIO, book_language)
VALUES (2, 'Light Novel', 'Japan', 'Light novels are Japanese novels that are usually between 50,000 and 300,000 words long.', 'Japanese');

INSERT INTO CATEGORY (ID, CATEGORY, COUNTRY, BIO, book_language)
VALUES (3, 'Manhwa', 'South Korea', 'Manhwa is the Korean equivalent of comics with a unique style and following.', 'Korean');

INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (1, 1);
INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (2, 2);
INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (3, 3);
INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (4, 4);
INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (5, 5);
INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (5, 6);
INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (6, 7);
INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (7, 8);
INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (8, 9);
INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (9, 10);
INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (10, 11);
INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (11, 12);
INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (12, 13);
INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (13, 14);
INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (14, 15);
INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (15, 16);
INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (16, 17);