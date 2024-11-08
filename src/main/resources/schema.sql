DROP TABLE IF EXISTS Run;

CREATE TABLE Run (
   id SERIAL PRIMARY KEY,
   title varchar(250) NOT NULL,
   started_on timestamp NOT NULL,
   completed_on timestamp NOT NULL,
   miles INT NOT NULL,
   run_type varchar(10) NOT NULL,
   version INT
);