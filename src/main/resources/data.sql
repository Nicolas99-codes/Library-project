INSERT INTO APP_USER(USERNAME, PASSWORD, FIRST_NAME ,SURNAME, EMAIL, ROLE)
VALUES ('admin', '$2a$10$CmNH0hEDvSeAZJfqmRZBwus9dZOkxHGwfDeoDnK/WNHPBKrDPa3IO', 'Vera', 'test' ,'test@gmail.com', 'ROLE_ADMIN');

INSERT INTO APP_USER(USERNAME, PASSWORD, FIRST_NAME ,SURNAME, EMAIL, ROLE)
VALUES ('user', '$2a$10$CmNH0hEDvSeAZJfqmRZBwus9dZOkxHGwfDeoDnK/WNHPBKrDPa3IO', 'Nicolas', 'test' ,'user@gmail.com', 'ROLE_USER');

INSERT INTO AUTHOR(author_name, SURNAME, BIO, COUNTRY)
VALUES
    ('Chugong', '', '', 'South Korea');

INSERT INTO AUTHOR(author_name, SURNAME, BIO, COUNTRY)
VALUES
    ('Reki', 'Kawahara', '', 'Japan');

INSERT INTO AUTHOR(author_name, SURNAME, BIO, COUNTRY)
VALUES
    ('Fuse', '', '?', 'Japan');

INSERT INTO AUTHOR(author_name, SURNAME, BIO, COUNTRY)
VALUES
    ('Kana', 'Akatsuki', '', 'Japan');

INSERT INTO AUTHOR(author_name, SURNAME, BIO, COUNTRY)
VALUES
    ('Atsushi', 'Nishigori', '', 'Japan');

INSERT INTO AUTHOR(author_name, SURNAME, BIO, COUNTRY)
VALUES
    ('Naotaka', 'Hayashi', '', '');

INSERT INTO AUTHOR(author_name, SURNAME, BIO, COUNTRY)
VALUES
    ('Haruto', 'Umezawa', '', 'Japan');

INSERT INTO AUTHOR(author_name, SURNAME, BIO, COUNTRY)
VALUES
    ('Rifujin', 'na Magonote', '', 'Japan');

INSERT INTO AUTHOR(author_name, SURNAME, BIO, COUNTRY)
VALUES
    ('Kisetsu', 'Morita', '', 'Japan');

INSERT INTO AUTHOR(author_name, SURNAME, BIO, COUNTRY)
VALUES
    ('Shinkoshoto', '', '', 'Japan');

INSERT INTO AUTHOR(author_name, SURNAME, BIO, COUNTRY)
VALUES
    ('Shogo', 'Kinugasa', '', 'Japan');

INSERT INTO AUTHOR(author_name, SURNAME, BIO, COUNTRY)
VALUES
    ('Sui', 'Ishida', '', 'Japan');

INSERT INTO AUTHOR(author_name, SURNAME, BIO, COUNTRY)
VALUES
    ('Kaneshiro', '', '', 'Japan');

INSERT INTO AUTHOR(author_name, SURNAME, BIO, COUNTRY)
VALUES
    ('Miki', 'Nazuna', '', 'Japan');

INSERT INTO AUTHOR(author_name, SURNAME, BIO, COUNTRY)
VALUES
    ('Aneko', 'Yusagi', '', 'Japan');

INSERT INTO AUTHOR(author_name, SURNAME, BIO, COUNTRY)
VALUES
    ('Kaiu', 'Shirai', '', 'Japan');

INSERT INTO AUTHOR(author_name, SURNAME, BIO, COUNTRY)
VALUES
    ('Ceez', '', '', '');

INSERT INTO BOOK (TITLE, DESCRIPTION, IMAGE_URL, RELEASE_YEAR)
VALUES
    ('Solo Leveling',
     'In a world where hunters — human warriors who possess supernatural abilities — must battle deadly monsters to protect mankind from certain annihilation'
        , 'https://firebasestorage.googleapis.com/v0/b/bibliotheek-fedaf.appspot.com/o/images%2Fbook%2FSolo-leveling.jpg?alt=media&token=8276e84c-81db-42e3-88cb-2470a116824b' ,2018);

INSERT INTO BOOK (TITLE, DESCRIPTION, IMAGE_URL, RELEASE_YEAR)
VALUES
    ('Sword Art Online',
     'In the year 2022, virtual reality has progressed by leaps and bounds, and a massive online role-playing game called Sword Art Online (SAO) is launched. ' ||
     'With the aid of "NerveGear" technology, players can control their avatars within the game using nothing but their own thoughts. Kirito is one such player. ' ||
     'Having logged in to test the game, he is ready to begin his quest, when suddenly the game goes live. ' ||
     'However, in a cruel twist of fate, the players soon discover that they cannot log out, as the game creator is holding them captive unless they reach the 100th floor of the game tower and defeat the final boss. Their struggle for survival starts now.'
       , 'https://firebasestorage.googleapis.com/v0/b/bibliotheek-fedaf.appspot.com/o/images%2Fbook%2FSword_art_online.jpg?alt=media&token=b427d40d-5392-4ebf-aa8d-395a69b12a12' , 2012);

INSERT INTO BOOK (TITLE, DESCRIPTION, IMAGE_URL, RELEASE_YEAR)
VALUES
    ('That time I got reincarnated as a slime',
     'Satoru Mikami is a thirty-seven-year-old office worker who has just been killed by a robber. ' ||
     'He soon awakens to find himself reincarnated in a fantasy world and he is shocked to discover he has become a slime monster! ' ||
     'However, his new life in this strange world is just beginning. ' ||
     'With the future of the world at stake, Satoru must use his newfound powers to defeat the Demon King and restore peace to the land.'
      , 'https://firebasestorage.googleapis.com/v0/b/bibliotheek-fedaf.appspot.com/o/images%2Fbook%2FSlime.jpg?alt=media&token=d622ed4e-ff46-4520-99c9-0919a4837e3e'  , 2018);

INSERT INTO BOOK (TITLE, DESCRIPTION, IMAGE_URL, RELEASE_YEAR)
VALUES
    ('Violet Evergarden',
     'There was a machine invented as a prototype for the typewriter, called Auto Memory Dolls. It was originally made by Professor Orlando, the authority on letterpress printing and a researcher of mechanical dolls.'
      , 'https://firebasestorage.googleapis.com/v0/b/bibliotheek-fedaf.appspot.com/o/images%2Fbook%2FViolet.jpg?alt=media&token=3abfb46e-0d48-4ea7-896a-4416f264882b'  , 2018);

INSERT INTO BOOK (TITLE, DESCRIPTION, IMAGE_URL, RELEASE_YEAR)
VALUES
    ('Darling in the Franxx',
     'In the distant future, humanity has been driven to near-extinction by monstrous creatures known as Klaxosaurs, forcing the remaining humans to take refuge in massive mobile fortresses called Plantations. ' ||
     'In order to combat the Klaxosaurs, humanity developed the Franxx, giant humanoid weapons that are controlled by pairs of pilots whose minds are joined by a neural bridge. ' ||
     'The story follows the adventures of Hiro and Zero Two, two Franxx pilots who are part of the experimental Strelizia Battalion, as they fight to protect humanity from the Klaxosaur threat.'
      , 'https://firebasestorage.googleapis.com/v0/b/bibliotheek-fedaf.appspot.com/o/images%2Fbook%2FDarlingInTheFranxx.jpg?alt=media&token=4687ea46-6a5c-4356-9497-64e9b4594c9d'  , 2018);

INSERT INTO BOOK (TITLE, DESCRIPTION, IMAGE_URL, RELEASE_YEAR)
VALUES
    ('86',
     'In the year 2086, the world is divided into two superpowers: the Empire of Japan and the Federation of North America. ' ||
     'The Empire of Japan is a totalitarian state that has conquered the entire Eurasian continent, while the Federation of North America is a democratic nation that has conquered the entire North American continent. ' ||
     'The two superpowers are engaged in a cold war, and the Federation of North America has developed a new weapon called the "86" that can destroy the Empire of Japan. ' ||
     'The story follows the adventures of Shiro Amada, a young soldier who is part of the 86th Platoon of the Imperial Army, as he fights to protect his country from the Federation of North America.'
      , 'https://firebasestorage.googleapis.com/v0/b/bibliotheek-fedaf.appspot.com/o/images%2Fbook%2F86Shin.jpg?alt=media&token=addd5053-13fd-4146-b9df-ae27bb1bd92b'  , 2018);

INSERT INTO BOOK (TITLE, DESCRIPTION, IMAGE_URL, RELEASE_YEAR)
VALUES
    ('Mushoku Tensei: Jobless Reincarnation',
     'An unnamed 34-year old Japanese NEET is evicted from his home following his parents death and skipping the funeral. ' ||
     'He is then reincarnated in a world of swords and magic as Rudeus Greyrat, a baby. ' ||
     'However, Rudeus is not alone, as he is accompanied by the spirit of a recently deceased sage, Libra. ' ||
     'Together, they must work to survive in this new world.', 'https://firebasestorage.googleapis.com/v0/b/bibliotheek-fedaf.appspot.com/o/images%2Fbook%2FRudeus.jpg?alt=media&token=4848fe81-cd21-494e-bc3d-2f8e41dbb355' ,2014);

INSERT INTO BOOK (TITLE, DESCRIPTION,IMAGE_URL, RELEASE_YEAR)
VALUES
    ('I have been killing slimes for 300 years and maxed out my level',
     'After living a painful life as an office worker, Azusa ends up dying from overworking.' ||
     'She finds herself reincarnated as undying, unaging witch in a new world, and now she vows to spend her days as pleasantly and stress-free as possible.', 'https://firebasestorage.googleapis.com/v0/b/bibliotheek-fedaf.appspot.com/o/images%2Fbook%2FWitchSlime.jpg?alt=media&token=fbecdb48-f56e-4e1b-85e5-34ab7a01d78b' , 2017);

INSERT INTO BOOK (TITLE, DESCRIPTION, IMAGE_URL, RELEASE_YEAR)
VALUES
    ('The Strongest Sage with Weakest Crest',
     'In a world of magic, the powers and future of a mage are predetermined at birth through so-called Marks, four symbols that categorize a humans aptitude for magic. ' ||
     'Lamenting the fact that his mark was considered ill-suited for combat and only useful for magic augmentation, an incredibly skilled sage decided to reincarnate thousands of years in the future.',
     'https://firebasestorage.googleapis.com/v0/b/bibliotheek-fedaf.appspot.com/o/images%2Fbook%2FWeakest.jpg?alt=media&token=648c9107-ab36-4f22-9274-4d132994b394' ,2017);

INSERT INTO BOOK (TITLE, DESCRIPTION, IMAGE_URL, RELEASE_YEAR)
VALUES
    ('Classroom of the Elite',
     'The Japanese government has established the Tokyo Metropolitan Advanced Nurturing School, dedicated to instruct and foster the generation of people that will support the country in the future.' ||
     'The students are given a high degree of freedom in order to closely mimic real life.',
      'https://firebasestorage.googleapis.com/v0/b/bibliotheek-fedaf.appspot.com/o/images%2Fbook%2FClassroom.jpg?alt=media&token=10b090ee-613c-48c9-b26a-700e5da2f7cc' ,2016);

INSERT INTO BOOK (TITLE, DESCRIPTION, IMAGE_URL, RELEASE_YEAR)
VALUES
    ('Tokyo Ghoul',
     'Ken Kaneki, a student who barely survives a deadly encounter with Rize Kamishiro, his date who reveals herself as a ghoul and tries to eat him.' ||
     'He is taken to the hospital in critical condition. After recovering, Kaneki discovers that he underwent a surgery that transformed him into a half-ghoul.',
     'https://firebasestorage.googleapis.com/v0/b/bibliotheek-fedaf.appspot.com/o/images%2Fbook%2FTokyo-Ghoul.jpg?alt=media&token=7afcea23-ba6e-484a-9f25-9b1cb2a54053' ,2011);

INSERT INTO BOOK (TITLE, DESCRIPTION, IMAGE_URL, RELEASE_YEAR)
VALUES
    ('Blue Lock',
     'In 2018, the Japenese national team finished in 16th in the FIFA World Cup. As a result, the Japan Football Association hires the football engima Ego Jinpachi.' ||
     'His master plan to lead Japan to stardom is Blue lock, a training regimen designed to create the worlds greatest egotist striker.',
     'https://firebasestorage.googleapis.com/v0/b/bibliotheek-fedaf.appspot.com/o/images%2Fbook%2FBlueLock.jpg?alt=media&token=1b7f9da1-e10f-47b5-b902-1612b40a2192', 2018);

INSERT INTO BOOK (TITLE, DESCRIPTION, IMAGE_URL, RELEASE_YEAR)
VALUES
    ('My unique Skill makes me OP even at level 1',
     'Ryouta Satou, who died from overworking at a black company, was reincarnated to another world.' ||
     'Although Ryouta was alive, he was now burdened with the incovenience that his level is fixed to 1 in this new world.',
     'https://firebasestorage.googleapis.com/v0/b/bibliotheek-fedaf.appspot.com/o/images%2Fbook%2FLevelOne.jpg?alt=media&token=8c2ab555-174a-430a-bb82-60f0999c1eee' ,2018);

INSERT INTO BOOK (TITLE, DESCRIPTION, IMAGE_URL, RELEASE_YEAR)
VALUES
    ('The Rising of the Shield Hero',
     'Naofumi Iwatani, an uncharismatic Otaku who spends his days on games and manga, suddenly finds himself summoned to a parallel universe.' ||
     'He discovers he is one of four heroes equipped with legendary weapons and tasked with saving the world from its prophesied destruction.',
     'https://firebasestorage.googleapis.com/v0/b/bibliotheek-fedaf.appspot.com/o/images%2Fbook%2FShieldHero.jpg?alt=media&token=575fc4f1-581f-460d-8004-d7169acb4c7f' ,2018);

INSERT INTO BOOK (TITLE, DESCRIPTION, IMAGE_URL, RELEASE_YEAR)
VALUES
    ('The Promised Neverland',
     'Emma, Norman and Ray are three orphans living at Grace Field House, a seemingly idyllic orphanage.' ||
     'However, the children are actually livestock, and their caretakers are planning to kill them and eat them.',
     'https://firebasestorage.googleapis.com/v0/b/bibliotheek-fedaf.appspot.com/o/images%2Fbook%2FNeverland.jpg?alt=media&token=c479c2cd-6a9c-4b97-b93c-6d66eae05241' ,2016);

INSERT INTO BOOK (TITLE, DESCRIPTION, IMAGE_URL, RELEASE_YEAR)
VALUES
    ('In the Land of Leadale',
     'Due to an accident, half of Keina Kagemi body was paralyzed.' ||
     'One day, because of a power outage, she regrettably died.' ||
     'However, just before that, her mind was moved to the world of online game she was playing.',
     'https://firebasestorage.googleapis.com/v0/b/bibliotheek-fedaf.appspot.com/o/images%2Fbook%2FLeadale.jpg?alt=media&token=67996d37-149c-422f-ab31-07fea58ed7d2' ,2019);

INSERT INTO GENRE (GENRE)
VALUES ('Action');

INSERT INTO GENRE (GENRE)
VALUES ('Adventure');

INSERT INTO GENRE (GENRE)
VALUES ('Comedy');

INSERT INTO GENRE (GENRE)
VALUES ('Drama');

INSERT INTO GENRE (GENRE)
VALUES ('Fantasy');

INSERT INTO GENRE (GENRE)
VALUES ('Isekai');

INSERT INTO GENRE (GENRE)
VALUES ('Mystery');

INSERT INTO GENRE (GENRE)
VALUES ('Romance');

INSERT INTO GENRE (GENRE)
VALUES ('Sports');

INSERT INTO GENRE (GENRE)
VALUES ('Thriller');

INSERT INTO GENRE (GENRE)
VALUES ('Sci-fi');

INSERT INTO STATUS (STATUS)
VALUES ('Ongoing');

INSERT INTO STATUS (STATUS)
VALUES ('Completed');

INSERT INTO STATUS (STATUS)
VALUES ('Hiatus');

INSERT INTO STATUS (STATUS)
VALUES ('Dropped');

INSERT INTO CATEGORY (CATEGORY, COUNTRY, BIO, book_language)
VALUES ('Manga', 'Japan', 'Manga is the Japanese equivalent of comics with a unique style and following.', 'Japanese');

INSERT INTO CATEGORY (CATEGORY, COUNTRY, BIO, book_language)
VALUES ('Light Novel', 'Japan', 'Light novels are Japanese novels that are usually between 50,000 and 300,000 words long.', 'Japanese');

INSERT INTO CATEGORY (CATEGORY, COUNTRY, BIO, book_language)
VALUES ('Manhwa', 'South Korea', 'Manhwa is the Korean equivalent of comics with a unique style and following.', 'Korean');

INSERT INTO BOOK_GENRE (BOOKS_ID, GENRE_ID) VALUES (1, 1); -- Solo Leveling
INSERT INTO BOOK_GENRE (BOOKS_ID, GENRE_ID) VALUES (1, 5); -- Solo Leveling

INSERT INTO BOOK_GENRE (BOOKS_ID, GENRE_ID) VALUES (2, 1); -- Sword Art Online
INSERT INTO BOOK_GENRE (BOOKS_ID, GENRE_ID) VALUES (2, 4); -- Sword Art Online
INSERT INTO BOOK_GENRE (BOOKS_ID, GENRE_ID) VALUES (2, 5); -- Sword Art Online

INSERT INTO BOOK_GENRE(BOOKS_ID, GENRE_ID) VALUES (3, 5); -- That time I got reincarnated as a slime
INSERT INTO BOOK_GENRE(BOOKS_ID, GENRE_ID) VALUES (3, 6); -- That time I got reincarnated as a slime

INSERT INTO BOOK_GENRE (BOOKS_ID, GENRE_ID) VALUES (4, 4); -- Violet Evergarden

INSERT INTO BOOK_GENRE (BOOKS_ID, GENRE_ID) VALUES (5, 1); -- Darling in the Franxx
INSERT INTO BOOK_GENRE (BOOKS_ID, GENRE_ID) VALUES (5, 4); -- Darling in the Franxx
INSERT INTO BOOK_GENRE (BOOKS_ID, GENRE_ID) VALUES (5, 8); -- Darling in the Franxx

INSERT INTO BOOK_GENRE (BOOKS_ID, GENRE_ID) VALUES (6, 1); -- 86
INSERT INTO BOOK_GENRE (BOOKS_ID, GENRE_ID) VALUES (6, 4); -- 86
INSERT INTO BOOK_GENRE (BOOKS_ID, GENRE_ID) VALUES (6, 11); -- 86

INSERT INTO BOOK_GENRE (BOOKS_ID, GENRE_ID) VALUES (7, 5); -- Mushoku Tensei: Jobless Reincarnation
INSERT INTO BOOK_GENRE (BOOKS_ID, GENRE_ID) VALUES (7, 6); -- Mushoku Tensei: Jobless Reincarnation

INSERT INTO BOOK_GENRE (BOOKS_ID, GENRE_ID) VALUES (8, 5); -- I have been killing slimes for 300 years and maxed out my level
INSERT INTO BOOK_GENRE (BOOKS_ID, GENRE_ID) VALUES (8, 6); -- I have been killing slimes for 300 years and maxed out my level

INSERT INTO BOOK_GENRE (BOOKS_ID, GENRE_ID) VALUES (9, 2); -- The Strongest Sage with Weakest Crest
INSERT INTO BOOK_GENRE (BOOKS_ID, GENRE_ID) VALUES (9, 5); -- The Strongest Sage with Weakest Crest

INSERT INTO BOOK_GENRE (BOOKS_ID, GENRE_ID) VALUES (10, 10); -- Classroom of the Elite
INSERT INTO BOOK_GENRE (BOOKS_ID, GENRE_ID) VALUES (10, 4); -- Classroom of the Elite

INSERT INTO BOOK_GENRE (BOOKS_ID, GENRE_ID) VALUES (11, 10); -- Tokyo Ghoul
INSERT INTO BOOK_GENRE (BOOKS_ID, GENRE_ID) VALUES (11, 4); -- Tokyo Ghoul

INSERT INTO BOOK_GENRE (BOOKS_ID, GENRE_ID) VALUES (12, 9); -- Blue Lock
INSERT INTO BOOK_GENRE (BOOKS_ID, GENRE_ID) VALUES (12, 10); -- Blue Lock

INSERT INTO BOOK_GENRE (BOOKS_ID, GENRE_ID) VALUES (13, 2); -- My unique Skill makes me OP even at level 1
INSERT INTO BOOK_GENRE (BOOKS_ID, GENRE_ID) VALUES (13, 5); -- My unique Skill makes me OP even at level 1
INSERT INTO BOOK_GENRE (BOOKS_ID, GENRE_ID) VALUES (13, 6); -- My unique Skill makes me OP even at level 1

INSERT INTO BOOK_GENRE (BOOKS_ID, GENRE_ID) VALUES (14, 1); -- The Rising of the Shield Hero
INSERT INTO BOOK_GENRE (BOOKS_ID, GENRE_ID) VALUES (14, 2); -- The Rising of the Shield Hero
INSERT INTO BOOK_GENRE (BOOKS_ID, GENRE_ID) VALUES (14, 5); -- The Rising of the Shield Hero

INSERT INTO BOOK_GENRE (BOOKS_ID, GENRE_ID) VALUES (15, 7); -- The Promised Neverland
INSERT INTO BOOK_GENRE (BOOKS_ID, GENRE_ID) VALUES (15, 5); -- The Promised Neverland
INSERT INTO BOOK_GENRE (BOOKS_ID, GENRE_ID) VALUES (15, 10); -- The Promised Neverland

INSERT INTO BOOK_GENRE (BOOKS_ID, GENRE_ID) VALUES (16, 2); -- In the Land of Leadale
INSERT INTO BOOK_GENRE (BOOKS_ID, GENRE_ID) VALUES (16, 5); -- In the Land of Leadale

INSERT INTO BOOK_STATUS (BOOKS_ID, STATUS_ID) VALUES (1, 2); -- Solo Leveling
INSERT INTO BOOK_STATUS (BOOKS_ID, STATUS_ID) VALUES (2, 2); -- Sword Art Online
INSERT INTO BOOK_STATUS (BOOKS_ID, STATUS_ID) VALUES (3, 1); -- That time I got reincarnated as a slime
INSERT INTO BOOK_STATUS (BOOKS_ID, STATUS_ID) VALUES (4, 1); -- Violet Evergarden
INSERT INTO BOOK_STATUS (BOOKS_ID, STATUS_ID) VALUES (5, 2); -- Darling in the Franxx
INSERT INTO BOOK_STATUS (BOOKS_ID, STATUS_ID) VALUES (6, 1); -- 86
INSERT INTO BOOK_STATUS (BOOKS_ID, STATUS_ID) VALUES (7, 1); -- Mushoku Tensei: Jobless Reincarnation
INSERT INTO BOOK_STATUS (BOOKS_ID, STATUS_ID) VALUES (8, 1); -- I have been killing slimes for 300 years and maxed out my level
INSERT INTO BOOK_STATUS (BOOKS_ID, STATUS_ID) VALUES (9, 1); -- The Strongest Sage with Weakest Crest
INSERT INTO BOOK_STATUS (BOOKS_ID, STATUS_ID) VALUES (10, 1); -- Classroom of the Elite
INSERT INTO BOOK_STATUS (BOOKS_ID, STATUS_ID) VALUES (11, 2); -- Tokyo Ghoul
INSERT INTO BOOK_STATUS (BOOKS_ID, STATUS_ID) VALUES (12, 1); -- Blue Lock
INSERT INTO BOOK_STATUS (BOOKS_ID, STATUS_ID) VALUES (13, 1); -- My unique Skill makes me OP even at level 1
INSERT INTO BOOK_STATUS (BOOKS_ID, STATUS_ID) VALUES (14, 1); -- The Rising of the Shield Hero
INSERT INTO BOOK_STATUS (BOOKS_ID, STATUS_ID) VALUES (15, 1); -- The Promised Neverland
INSERT INTO BOOK_STATUS (BOOKS_ID, STATUS_ID) VALUES (16, 1); -- In the Land of Leadale

INSERT INTO BOOK_CATEGORY (BOOKS_ID, CATEGORY_ID) VALUES (1, 3); -- Solo Leveling
INSERT INTO BOOK_CATEGORY (BOOKS_ID, CATEGORY_ID) VALUES (2, 2); -- Sword Art Online
INSERT INTO BOOK_CATEGORY (BOOKS_ID, CATEGORY_ID) VALUES (3, 1); -- That time I got reincarnated as a slime
INSERT INTO BOOK_CATEGORY (BOOKS_ID, CATEGORY_ID) VALUES (4, 1); -- Violet Evergarden
INSERT INTO BOOK_CATEGORY (BOOKS_ID, CATEGORY_ID) VALUES (5, 1); -- Darling in the Franxx
INSERT INTO BOOK_CATEGORY (BOOKS_ID, CATEGORY_ID) VALUES (6, 1); -- 86
INSERT INTO BOOK_CATEGORY (BOOKS_ID, CATEGORY_ID) VALUES (7, 2); -- Mushoku Tensei: Jobless Reincarnation
INSERT INTO BOOK_CATEGORY (BOOKS_ID, CATEGORY_ID) VALUES (8, 1); -- I have been killing slimes for 300 years and maxed out my level
INSERT INTO BOOK_CATEGORY (BOOKS_ID, CATEGORY_ID) VALUES (9, 1); -- The Strongest Sage with Weakest Crest
INSERT INTO BOOK_CATEGORY (BOOKS_ID, CATEGORY_ID) VALUES (10, 1); -- Classroom of the Elite
INSERT INTO BOOK_CATEGORY (BOOKS_ID, CATEGORY_ID) VALUES (11, 1); -- Tokyo Ghoul
INSERT INTO BOOK_CATEGORY (BOOKS_ID, CATEGORY_ID) VALUES (12, 1); -- Blue Lock
INSERT INTO BOOK_CATEGORY (BOOKS_ID, CATEGORY_ID) VALUES (13, 2); -- My unique Skill makes me OP even at level 1
INSERT INTO BOOK_CATEGORY (BOOKS_ID, CATEGORY_ID) VALUES (14, 2); -- The Rising of the Shield Hero
INSERT INTO BOOK_CATEGORY (BOOKS_ID, CATEGORY_ID) VALUES (15, 1); -- The Promised Neverland
INSERT INTO BOOK_CATEGORY (BOOKS_ID, CATEGORY_ID) VALUES (16, 1); -- In the Land of Leadale

INSERT INTO BOOK_AUTHOR (BOOKS_ID, AUTHOR_ID) VALUES (1, 1);
INSERT INTO BOOK_AUTHOR (BOOKS_ID, AUTHOR_ID) VALUES (2, 2);
INSERT INTO BOOK_AUTHOR (BOOKS_ID, AUTHOR_ID) VALUES (3, 3);
INSERT INTO BOOK_AUTHOR (BOOKS_ID, AUTHOR_ID) VALUES (4, 4);
INSERT INTO BOOK_AUTHOR (BOOKS_ID, AUTHOR_ID) VALUES (5, 5);
INSERT INTO BOOK_AUTHOR (BOOKS_ID, AUTHOR_ID) VALUES (5, 6);
INSERT INTO BOOK_AUTHOR (BOOKS_ID, AUTHOR_ID) VALUES (6, 7);
INSERT INTO BOOK_AUTHOR (BOOKS_ID, AUTHOR_ID) VALUES (7, 8);
INSERT INTO BOOK_AUTHOR (BOOKS_ID, AUTHOR_ID) VALUES (8, 9);
INSERT INTO BOOK_AUTHOR (BOOKS_ID, AUTHOR_ID) VALUES (9, 10);
INSERT INTO BOOK_AUTHOR (BOOKS_ID, AUTHOR_ID) VALUES (10, 11);
INSERT INTO BOOK_AUTHOR (BOOKS_ID, AUTHOR_ID) VALUES (11, 12);
INSERT INTO BOOK_AUTHOR (BOOKS_ID, AUTHOR_ID) VALUES (12, 13);
INSERT INTO BOOK_AUTHOR (BOOKS_ID, AUTHOR_ID) VALUES (13, 14);
INSERT INTO BOOK_AUTHOR (BOOKS_ID, AUTHOR_ID) VALUES (14, 15);
INSERT INTO BOOK_AUTHOR (BOOKS_ID, AUTHOR_ID) VALUES (15, 16);
INSERT INTO BOOK_AUTHOR (BOOKS_ID, AUTHOR_ID) VALUES (16, 17);