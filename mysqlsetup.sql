-- Drop and create the database
DROP DATABASE IF EXISTS `oop_ca6`;
CREATE DATABASE `oop_ca6`;

-- Use the database
USE `oop_ca6`;

-- Create table "developers"
CREATE TABLE developers (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    age INT,
    email VARCHAR(100),
    website VARCHAR(100)
);

-- Insert some sample data
INSERT INTO developers (first_name, last_name, age, email, website) VALUES 
('John', 'Doe', 30, 'john.doe@example.com', 'johndoe.com'),
('Jane', 'Doe', 28, 'jane.doe@example.com', 'janedoe.com'),
('Bob', 'Smith', 35, 'bob.smith@example.com', 'bobsmith.com'),
('Alice', 'Johnson', 25, 'alice.johnson@example.com', 'alicejohnson.com'),
('David', 'Lee', 42, 'david.lee@example.com', 'davidlee.com'),
('Karen', 'Wang', 29, 'karen.wang@example.com', 'karenwang.com'),
('Michael', 'Chen', 31, 'michael.chen@example.com', 'michaelchen.com'),
('Emily', 'Davis', 27, 'emily.davis@example.com', 'emilydavis.com'),
('Richard', 'Brown', 33, 'richard.brown@example.com', 'richardbrown.com'),
('Samantha', 'Nguyen', 24, 'samantha.nguyen@example.com', 'samanthanguyen.com');