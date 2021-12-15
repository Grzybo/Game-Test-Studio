
DROP TABLE IF EXISTS bug_dic_platforms CASCADE;
DROP TABLE IF EXISTS test_dic_platforms CASCADE;
DROP TABLE IF EXISTS project_users CASCADE;
DROP TABLE IF EXISTS project_dic_platforms CASCADE;

DROP TABLE IF EXISTS areas CASCADE;
DROP TABLE IF EXISTS attachments CASCADE;
DROP TABLE IF EXISTS bugs CASCADE;
DROP TABLE IF EXISTS projects CASCADE;
DROP TABLE IF EXISTS roles CASCADE;
DROP TABLE IF EXISTS tests CASCADE;
DROP TABLE IF EXISTS users CASCADE;

DROP TABLE IF EXISTS dic_builds CASCADE;
DROP TABLE IF EXISTS dic_issues CASCADE;
DROP TABLE IF EXISTS dic_platforms CASCADE;
DROP TABLE IF EXISTS dic_priorities CASCADE;
DROP TABLE IF EXISTS dic_results CASCADE;
DROP TABLE IF EXISTS dic_states CASCADE;
---------------------------------------------------------------------------------------------------------------------
-- dictionaries 
--------------------------------------------------------------------------------------------------------------------- 
CREATE TABLE dic_builds (
     id BIGSERIAL NOT NULL PRIMARY KEY,
     name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE dic_issues (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    type VARCHAR(50) NOT NULL UNIQUE 
);

CREATE TABLE dic_platforms (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE     
);  

CREATE TABLE dic_priorities (
    id BIGSERIAL NOT NULL PRIMARY KEY, 
    type VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE dic_results (
    id BIGSERIAL NOT NULL PRIMARY KEY, 
    type VARCHAR(50) NOT NULL UNIQUE
); 

CREATE TABLE dic_states (
    id BIGSERIAL NOT NULL PRIMARY KEY, 
    name VARCHAR(50) NOT NULL UNIQUE          
); 
---------------------------------------------------------------------------------------------------------------------
-- tables
--------------------------------------------------------------------------------------------------------------------- 
CREATE TABLE roles (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE  
);

CREATE TABLE users (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    fk_roles_id BIGINT REFERENCES roles(id) NOT NULL, 
    first_name VARCHAR(150) NOT NULL,
    last_name VARCHAR(150) NOT NULL,
    password VARCHAR(150) NOT NULL, 
    email VARCHAR(200) NOT NULL UNIQUE, 
    confirmed BOOLEAN, 
    hash_key VARCHAR(255), 
    mail_type VARCHAR(100),
    mail_date VARCHAR(10),
    mail_used BOOLEAN
);

CREATE TABLE projects (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    title VARCHAR (250) NOT NULL,
    description TEXT NOT NULL, 
    estimated_time NUMERIC(19, 2), 
    start_date VARCHAR(10), 
    end_date VARCHAR(10), 
    testers_number INT, 
    work_time NUMERIC(19, 2),
    fk_dic_states_id BIGINT NOT NULL REFERENCES dic_states(id) ON DELETE CASCADE
);

CREATE TABLE areas (
    id BIGSERIAL NOT NULL PRIMARY KEY, 
    title VARCHAR (250) NOT NULL,
    description TEXT NOT NULL,  
    estimated_time NUMERIC(19, 2), 
    start_date VARCHAR(10), 
    end_date VARCHAR(10), 
    testers_number INT, 
    work_time NUMERIC(19, 2),
    fk_projects_id BIGINT NOT NULL REFERENCES projects(id) ON DELETE CASCADE,
    fk_dic_states_id BIGINT NOT NULL REFERENCES dic_states(id) ON DELETE CASCADE, 
    fk_dic_priorities_id BIGINT NOT NULL REFERENCES dic_priorities(id) ON DELETE CASCADE 
);

CREATE TABLE attachments (
    id BIGSERIAL NOT NULL PRIMARY KEY, 
    name VARCHAR(50) NOT NULL, 
    type VARCHAR(50) NOT NULL,
    path VARCHAR(255) NOT NULL 
); 

CREATE TABLE tests (
    id BIGSERIAL NOT NULL PRIMARY KEY, 
    title VARCHAR (250) NOT NULL,
    description VARCHAR(1000) NOT NULL,
    estimated_time NUMERIC(19, 2), 
    start_date VARCHAR(10), 
    end_date VARCHAR(10), 
    testers_number INT, 
    work_time NUMERIC(19, 2),
	version DOUBLE PRECISION,
    fk_dic_priorities_id BIGINT REFERENCES dic_priorities(id) ON DELETE CASCADE ,
    fk_dic_builds_id BIGINT REFERENCES dic_builds(id) ON DELETE CASCADE ,
    fk_dic_states_id BIGINT REFERENCES dic_states(id) ON DELETE CASCADE, 
    fk_users_id BIGINT NOT NULL REFERENCES users(id) ON DELETE SET NULL, 
    fk_areas_id BIGINT NOT NULL REFERENCES areas(id) ON DELETE CASCADE,
    fk_dic_results_id BIGINT NOT NULL REFERENCES dic_results(id) ON DELETE CASCADE
);

CREATE TABLE bugs (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    title VARCHAR (250) NOT NULL, 
    description VARCHAR(1000) NOT NULL,
    steps_to_reproduction VARCHAR(1000) NOT NULL, 
    repro_frequency  INT CONSTRAINT frequency_constraint CHECK( repro_frequency BETWEEN 0 and 100 ), 
    min_kit_number INT,
    version DOUBLE PRECISION, 
    fk_dic_issues_id BIGINT NOT NULL REFERENCES dic_issues(id),
    fk_users_id BIGINT REFERENCES users(id) ON DELETE SET NULL,
    fk_dic_priorities_id BIGINT REFERENCES dic_priorities(id) ON DELETE CASCADE ,
    fk_dic_builds_id BIGINT REFERENCES dic_builds(id) ON DELETE CASCADE,
    fk_dic_states_id BIGINT REFERENCES dic_states(id) ON DELETE CASCADE,
    fk_tests_id BIGINT REFERENCES tests(id) ON DELETE CASCADE, 
    fk_attachments_id BIGINT REFERENCES attachments(id) ON DELETE CASCADE
); 

CREATE TABLE actions (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name VARCHAR (250) NOT NULL UNIQUE
);
---------------------------------------------------------------------------------------------------------------------
-- tabele asocjacyjne
---------------------------------------------------------------------------------------------------------------------
CREATE TABLE role_actions (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    fk_roles_id BIGINT NOT NULL REFERENCES roles(id) ON DELETE CASCADE, 
    fk_actions_id BIGINT NOT NULL REFERENCES actions(id) ON DELETE CASCADE, 
    UNIQUE (fk_roles_id, fk_actions_id)
);

CREATE TABLE bug_dic_platforms ( 
    id BIGSERIAL NOT NULL PRIMARY KEY,
    fk_bugs_id BIGINT NOT NULL REFERENCES bugs(id) ON DELETE CASCADE, 
    fk_dic_platforms_id BIGINT NOT NULL REFERENCES dic_platforms(id) ON DELETE CASCADE, 
    UNIQUE (fk_bugs_id, fk_dic_platforms_id) 
); 

CREATE TABLE project_dic_platforms ( 
    id BIGSERIAL NOT NULL PRIMARY KEY,
    fk_projects_id BIGINT NOT NULL REFERENCES projects(id) ON DELETE CASCADE , 
    fk_dic_platforms_id BIGINT NOT NULL REFERENCES dic_platforms(id) ON DELETE CASCADE , 
    UNIQUE (fk_projects_id, fk_dic_platforms_id) 
);

CREATE TABLE project_users (                
    id BIGSERIAL NOT NULL PRIMARY KEY, 
    fk_projects_id BIGINT NOT NULL REFERENCES projects(id)  ON DELETE CASCADE, 
    fk_users_id BIGINT NOT NULL REFERENCES users(id)  ON DELETE CASCADE, 
    UNIQUE (fk_projects_id, fk_users_id)
);

CREATE TABLE test_dic_platforms (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    fk_tests_id BIGINT NOT NULL REFERENCES tests(id) ON DELETE CASCADE,
    fk_dic_platforms_id BIGINT NOT NULL REFERENCES dic_platforms(id) ON DELETE CASCADE,  
    UNIQUE (fk_tests_id, fk_dic_platforms_id)
);
---------------------------------------------------------------------------------------------------------------------
-- dictionaries - inserts
--------------------------------------------------------------------------------------------------------------------- 
insert into  dic_issues (type) values ('Crash');
insert into  dic_issues (type) values ('Graphical');
insert into  dic_issues (type) values ('Placeholder');
insert into  dic_issues (type) values ('Input');
insert into  dic_issues (type) values ('Content');
insert into  dic_issues (type) values ('Assert');
insert into  dic_issues (type) values ('Function');
insert into  dic_issues (type) values ('Texture');
insert into  dic_issues (type) values ('Audio');
insert into  dic_issues (type) values ('Code');
insert into  dic_issues (type) values ('Gameplay');
insert into  dic_issues (type) values ('UI');
insert into  dic_issues (type) values ('Language');
insert into  dic_issues (type) values ('Animation');

insert into  dic_platforms (name) values ('PlayStation 5'); 
insert into  dic_platforms (name) values ('PlayStation 4');
insert into  dic_platforms (name) values ('Xbox One');
insert into  dic_platforms (name) values ('Xbox Series X'); 
insert into  dic_platforms (name) values ('PC'); 
insert into  dic_platforms (name) values ('Xbox Series S');

insert into  dic_priorities (type) values ('Critical');
insert into  dic_priorities (type) values ('Important');
insert into  dic_priorities (type) values ('Very Important'); 

insert into  dic_states (name) values ('New');
insert into  dic_states (name) values ('Active');
insert into  dic_states (name) values ('Closed');
insert into  dic_states (name) values ('Ready to retest'); 
insert into  dic_states (name) values ('Blocked');

insert into  dic_results (type) values ('Positive');
insert into  dic_results (type) values ('Negative');
insert into  dic_results (type) values ('Blocked'); 
insert into  dic_results (type) values ('None');  
---------------------------------------------------------------------------------------------------------------------
-- tables - inserts
--------------------------------------------------------------------------------------------------------------------- 
insert into  roles (name) values ('Tester');
insert into  roles (name) values ('Tester Manager'); 
insert into  roles (name) values ('Developer');
insert into  roles (name) values ('Developer Manager'); 
insert into  roles (name) values ('Administrator');

insert into  users (fk_roles_id, first_name, last_name, password, email) values (1, 'Donald', 'Duck', 'a7a8e59a40f58c58251097d6bf857b01db290337f3c33a7c910b8e00bec7871b', 'donald@disney.com');
insert into  users (fk_roles_id, first_name, last_name, password, email) values (2, 'Mickey', 'Mouse', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', 'mickey@disney.com'); 
insert into  users (fk_roles_id, first_name, last_name, password, email) values (3, 'Admin', 'Administrator', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 'admin@admin.com'); 

insert into  projects (title, description,  fk_dic_states_id)
values ('FIFA 22', 
'Electronic Arts Sports 
Director: John Doe 
Tests of all game functionality, specially of the new content.   
New Content:
 - Leagues: 
	Fortuna 1 Liga (PL)
	UEFA Conference League (EU)
 - Stadiums: 
	Stadion im. Marszałka J.Piłsudskiego w Radomiu (PL 1)	
 - Animations: 
	Crostiano Ronaldo
	Robert Lewnadowski 
	Leo Messi
 - Functionallity: 
	New penalty kicks
	New free kicks', 
    2
    );

insert into areas (title, description, fk_projects_id, fk_dic_states_id, fk_dic_priorities_id) 
    values (
        'Stadiums', 
        'New Stadiums: 
	        Stadion im. Marszałka J.Piłsudskiego w Radomiu (Radiomiak)
        Stadiums with new functionality : 
            Etihad Stadium (Manchester City)
            Wembley Stadium (England)
            BayArena (Bayer Leverkusen)
        Old Stadiums (FIFA 21): 
	        Premier League
                Anfield (Liverpool)
                Bramall Lane (Sheffield United)
                Craven Cottage (Fulham)
                Elland Road (Leeds United) 
                Emirates Stadium (Arsenal)
                (...)
	        Bundesliga
                BayArena (Bayer Leverkusen)
                BORUSSIA-PARK (Borussia Mönchengladbach)
                Deutsche Bank Park (Eintracht Frankfurt)
                (...)', 
                1, 2, 2);   

INSERT INTO tests (title, fk_users_id, description, fk_areas_id, fk_dic_results_id)
values ('Stadiums - New - Radomiak - Model and Functionality', 1, 
'Remamber to read all scenario before starting the test. 
Test have to be done on one of platforms: 
Nowa generacja (PS5, XSeries X/S), Stara generacja (PS4, XOne), PC. 
 
1. Launch FIFA 22 - Developer Version. 
2. Go to Quick Match Mode. 
3. Check functionalities: 
	- Stadium is available.  
	- Stadium have correct name.
	- Stadium is correctlly rendered.
	- All weather conditions can be chosen.
	- All night and day presets can be chosen.
	 (...)', 
     1, 1
); 

INSERT INTO bugs (title, fk_users_id, description, steps_to_reproduction, fk_dic_issues_id, repro_frequency, fk_tests_id)
values (
    '[Test Blocker] Stadiums - Radomiak - Stadium is not available in Quick Match Mode', 
    1, 
    '"Stadion im. Marszałka J.Piłsudskiego w Radomiu" (Radomiak) is not available in Quick Match Mode. 
    Stadium cannot be chosen becouse its not visible one the stadiums list. 
    Video of the issue.', 
    '1. Launch FIFA 22 - Developer Version. 
    2. Go to Quick Match Mode. 
    3. Choose any teams and go to match settings. 
    4. Go to stadium settings. 
    5. Observe lack of stadium: "Stadion im. Marszałka J.Piłsudskiego w Radomiu." ', 5, 100, 1
);
---------------------------------------------------------------------------------------------------------------------
-- tabele asocjacyjne - inserts
---------------------------------------------------------------------------------------------------------------------
INSERT INTO project_dic_platforms (fk_projects_id, fk_dic_platforms_id) VALUES (1 , 1);
INSERT INTO project_dic_platforms (fk_projects_id, fk_dic_platforms_id) VALUES (1 , 2);
INSERT INTO project_dic_platforms (fk_projects_id, fk_dic_platforms_id) VALUES (1 , 3);

INSERT INTO bug_dic_platforms (fk_bugs_id, fk_dic_platforms_id) VALUES (1 , 1);

INSERT INTO test_dic_platforms (fk_tests_id, fk_dic_platforms_id) VALUES (1 , 1);

INSERT INTO project_users (fk_projects_id, fk_users_id) VALUES (1 , 1);
INSERT INTO project_users (fk_projects_id, fk_users_id) VALUES (1 , 2);
---------------------------------------------------------------------------------------------------------------------
-- 
---------------------------------------------------------------------------------------------------------------------
