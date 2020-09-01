# gl-hack

# Assusming below things have already installed on the given laptop

	1. Docker
	2. Gradle
	3. Java 8


# Database setup on Docker

Step 1 : Pull postgres docker
	
	docker pull postgres

Step 2 : Run postgres docker with database name, username and password configuration
	
	docker run --name gl_db_docker -e POSTGRES_DB=postgres -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -d postgres:latest

Step 3 : Get into the docker to run below database script
	
	docker exec -it gl_db_docker /bin/sh

Step 4 : Get into postgres sql inside docker to run below database script
	
	psql -h localhost -U postgres postgres

Step 5 : Run the below 3 sql queries

  CREATE TABLE users (
      id INT GENERATED ALWAYS AS IDENTITY,
      PRIMARY KEY(id),
      name VARCHAR(100) NOT NULL UNIQUE,
      email VARCHAR(100) NULL UNIQUE,
      phone VARCHAR(100) NULL UNIQUE,
      created_at TIMESTAMP NOT NULL,
      updated_at TIMESTAMP NOT NULL
  );

  CREATE TABLE groups (
      id INT GENERATED ALWAYS AS IDENTITY,
      PRIMARY KEY(id),
      name VARCHAR(100) NOT NULL UNIQUE,
      created_at TIMESTAMP NOT NULL,
      updated_at TIMESTAMP NOT NULL
  );

  CREATE TABLE user_group (
    id INT GENERATED ALWAYS AS IDENTITY,
    PRIMARY KEY(id),
    user_id INT NOT NULL,
    group_id INT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    CONSTRAINT fk_user_group_user_id FOREIGN KEY(user_id) REFERENCES users(id),
    CONSTRAINT fk_user_group_group_id FOREIGN KEY(group_id) REFERENCES groups(id)
  );

  CREATE TABLE invite_data (
      id INT GENERATED ALWAYS AS IDENTITY,
      PRIMARY KEY(id),
      invited_by_user_id INT NOT NULL,
      invited_to_user_id INT NOT NULL,
      created_at TIMESTAMP NOT NULL,
      updated_at TIMESTAMP NOT NULL,
      CONSTRAINT fk_invite_data_user_by FOREIGN KEY(invited_by_user_id) REFERENCES users(id),
      CONSTRAINT fk_invite_data_user_to FOREIGN KEY(invited_to_user_id) REFERENCES users(id)
  );

  CREATE TABLE test_cases (
    id INT GENERATED ALWAYS AS IDENTITY,
    PRIMARY KEY(id),
    name VARCHAR(100) NOT NULL UNIQUE,
    assert_values VARCHAR[] NOT NULL,
    points INT NOT NULL,
    created_at TIMESTAMP NOT NULL,
      updated_at TIMESTAMP NOT NULL
  );

  CREATE TABLE hackathons (
      id INT GENERATED ALWAYS AS IDENTITY,
      PRIMARY KEY(id),
      name VARCHAR(100) NOT NULL UNIQUE,
      question VARCHAR(100) NOT NULL,
      start_date TIMESTAMP NOT NULL,
      end_date TIMESTAMP NOT NULL,
      created_at TIMESTAMP NOT NULL,
      updated_at TIMESTAMP NOT NULL,
      visible_test_cases INT[],
      hidden_test_cases INT[],
      test_cases INT[]
  );

  CREATE TABLE submissions (
    id INT GENERATED ALWAYS AS IDENTITY,
    PRIMARY KEY(id),
    group_id INT NOT NULL,
    hackthon_id INT NOT NULL,
    points INT NOT NULL,
    created_at TIMESTAMP NOT NULL,
      updated_at TIMESTAMP NOT NULL,
      CONSTRAINT fk_submissions_group_id FOREIGN KEY(group_id) REFERENCES groups(id),
      CONSTRAINT fk_submissions_hackthon_id FOREIGN KEY(hackthon_id) REFERENCES hackathons(id)
  );
  
Step 5 : Preparing sample data

  INSERT INTO test_cases(name, assert_values, points, created_at, updated_at) VALUES ('TestCase1', ARRAY['A'], 10, now(), now());
  INSERT INTO test_cases(name, assert_values, points, created_at, updated_at) VALUES ('TestCase2', ARRAY['B'], 10, now(), now());
  INSERT INTO test_cases(name, assert_values, points, created_at, updated_at) VALUES ('TestCase3', ARRAY['C'], 10, now(), now());
  INSERT INTO test_cases(name, assert_values, points, created_at, updated_at) VALUES ('TestCase4', ARRAY['D'], 10, now(), now());

  INSERT INTO hackathons(name, question, start_date, end_date, created_at, updated_at, visible_test_cases, hidden_test_cases, test_cases) VALUES ('Hackathon1', 'Test Question 1', now(), now() + INTERVAL '1 DAY', now(), now(), ARRAY[1, 2], ARRAY[3, 4], ARRAY[1, 2, 3, 4]);

  INSERT INTO users(name, email, phone, created_at, updated_at) VALUES ('name1', 'email1', 'phone1', now(), now());
  INSERT INTO users(name, email, phone, created_at, updated_at) VALUES ('name2', 'email2', 'phone2', now(), now());
  INSERT INTO users(name, email, phone, created_at, updated_at) VALUES ('name3', 'email3', 'phone3', now(), now());
  INSERT INTO users(name, email, phone, created_at, updated_at) VALUES ('name4', 'email4', 'phone4', now(), now());

  INSERT INTO groups(name, created_at, updated_at) VALUES ('group1', now(), now());

  INSERT INTO user_group(user_id, group_id, created_at, updated_at) VALUES (1, 1, now(), now());
  INSERT INTO user_group(user_id, group_id, created_at, updated_at) VALUES (2, 1, now(), now());
  INSERT INTO user_group(user_id, group_id, created_at, updated_at) VALUES (3, 1, now(), now());
  INSERT INTO user_group(user_id, group_id, created_at, updated_at) VALUES (4, 1, now(), now());


  INSERT INTO test_cases(name, assert_values, points, created_at, updated_at) VALUES ('TestCase5', ARRAY['E'], 10, now(), now());
  INSERT INTO test_cases(name, assert_values, points, created_at, updated_at) VALUES ('TestCase6', ARRAY['F'], 10, now(), now());
  INSERT INTO test_cases(name, assert_values, points, created_at, updated_at) VALUES ('TestCase7', ARRAY['G'], 10, now(), now());
  INSERT INTO test_cases(name, assert_values, points, created_at, updated_at) VALUES ('TestCase8', ARRAY['H'], 10, now(), now());

  INSERT INTO hackathons(name, question, start_date, end_date, created_at, updated_at, visible_test_cases, hidden_test_cases, test_cases) VALUES ('Hackathon2', 'Test Question 2', now(), now() + INTERVAL '1 DAY', now(), now(), ARRAY[5, 6], ARRAY[7, 8], ARRAY[5, 6, 7, 8]);

  INSERT INTO users(name, email, phone, created_at, updated_at) VALUES ('name5', 'email5', 'phone5', now(), now());
  INSERT INTO users(name, email, phone, created_at, updated_at) VALUES ('name6', 'email6', 'phone6', now(), now());
  INSERT INTO users(name, email, phone, created_at, updated_at) VALUES ('name7', 'email7', 'phone7', now(), now());
  INSERT INTO users(name, email, phone, created_at, updated_at) VALUES ('name8', 'email8', 'phone8', now(), now());

  INSERT INTO groups(name, created_at, updated_at) VALUES ('group2', now(), now());

  INSERT INTO user_group(user_id, group_id, created_at, updated_at) VALUES (5, 2, now(), now());
  INSERT INTO user_group(user_id, group_id, created_at, updated_at) VALUES (6, 2, now(), now());
  INSERT INTO user_group(user_id, group_id, created_at, updated_at) VALUES (7, 2, now(), now());
  INSERT INTO user_group(user_id, group_id, created_at, updated_at) VALUES (8, 2, now(), now());

# Application setup

Clone the spring boot application and run the below commands (Run these commands from spring boot application root directory)

Step 1 : Build the application to generate the jar file
	
	mvn clean install

Step 2 : Create a docker Image for spring boot application
	
	docker build . -t gl-spring-boot

Step 3 : Run the spring boot application by linked database docker
	
	docker run -p 8080:8080 --name gl-spring-boot --link gl_db_docker:postgres -d gl-spring-boot:latest

# Swagger URL

	http://{host_name/ip_addr}:8086/swagger-ui.html

# Sample JSON for /submit-hackathon API

  {
    "group_id": 1,
    "hackathon_id": 1,
    "submit_testcases": [
      {
        "submitted_values": [
          "A"
        ],
        "testcase_id": 1
      },
      {
        "submitted_values": [
          "B"
        ],
        "testcase_id": 2
      },
      {
        "submitted_values": [
          "C"
        ],
        "testcase_id": 3
      },
      {
        "submitted_values": [
          "DD"
        ],
        "testcase_id": 4
      }
    ]
  }
