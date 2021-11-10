
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

CREATE TABLE attachements (
    id BIGSERIAL NOT NULL PRIMARY KEY, 
    name VARCHAR(50) NOT NULL, 
    type VARCHAR(50) NOT NULL,
    path VARCHAR(255) NOT NULL 
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
    fk_attachments_id BIGINT REFERENCES attachements(id) ON DELETE CASCADE
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

CREATE TABLE roles (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE  
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

CREATE TABLE users (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    fk_roles_id BIGINT REFERENCES roles(id) NOT NULL, 
    first_name VARCHAR(150) NOT NULL,
    last_name VARCHAR(150) NOT NULL,
    password VARCHAR(150) NOT NULL, 
    email VARCHAR(200) NOT NULL UNIQUE
); 
---------------------------------------------------------------------------------------------------------------------
-- tabele asocjacyjne
---------------------------------------------------------------------------------------------------------------------
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
-- Inserty
---------------------------------------------------------------------------------------------------------------------
insert into  dic_issues (type) values ('Crash');
insert into  dic_issues (type) values ('Graphical');
insert into  dic_issues (type) values ('Placeholder');
insert into  dic_issues (type) values ('Input');
insert into  dic_issues (type) values ('Content');
insert into  dic_platforms (name) values ('PlayStation 5'); 
insert into  dic_platforms (name) values ('Xbox One');
insert into  dic_platforms (name) values ('PlayStation 4');
insert into  dic_platforms (name) values ('Xbox Series X'); 
insert into  dic_platforms (name) values ('PC');