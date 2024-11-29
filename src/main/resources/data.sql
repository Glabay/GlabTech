-- Services
CREATE TABLE services
(
    service_name        VARCHAR(255) PRIMARY KEY,
    service_description TEXT,
    service_price       DOUBLE PRECISION,
    fixed_rate          BOOLEAN
);
-- Employees
CREATE TABLE employees
(
    employee_id         VARCHAR(50) PRIMARY KEY,
    employee_first_name VARCHAR(255),
    employee_last_name  VARCHAR(255),
    employee_start_date DATE,
    employee_end_date   DATE,
    contact_number      VARCHAR(20),
    position            VARCHAR(255)
);
-- Customers
CREATE TABLE customers
(
    customer_id    SERIAL PRIMARY KEY,
    first_name     VARCHAR(255),
    last_name      VARCHAR(255),
    email          VARCHAR(255),
    contact_number VARCHAR(20)
);
-- Data DropOffs
CREATE TABLE drop_offs
(
    drop_off_id        SERIAL PRIMARY KEY,
    customer_id       INTEGER REFERENCES customers (customer_id),
    dropoff_date      DATE,
    notes             TEXT
);
-- SQL data file to insert service data
-- Services
INSERT INTO services (service_name, service_description, service_price, fixed_rate)
VALUES ('Destroy', '32-pass Data Erase; Followed with physical destruction.', 22.00, TRUE),
       ('Re-Image', 'Reinstall the Operating System of a PC/Tablet/Laptop/Mobile device.', 50.00, TRUE),
       ('Backup', 'Create an archived backup of all essential and user files.', 25.00, TRUE),
       ('Diagnostic', 'Check the health of the physical Hardware, as well as scan for malicious software', 40.00, TRUE),
       ('Hardware Upgrade', 'Install new Hardware and Drivers + Device Hardware health Scan.', 20.00, TRUE),
       ('On-site Tech', 'On-Site technician, $99/first hr then $40/hr additional.', 99.00, FALSE);

-- Employees
INSERT INTO employees (employee_id, employee_first_name, employee_last_name, employee_start_date, employee_end_date,
                       contact_number, position)
VALUES ('emp001', 'Mike', 'Glabay', '2008-06-01', null, '555-0101', 'Owner'),
       ('emp002', 'Jane', 'Smith', '2023-02-01', null, '555-0102', 'Technician'),
       ('emp003', 'John', 'Doe', '2023-01-01', null, '555-0103', 'Technician'),
       ('emp004', 'Alice', 'Johnson', '2023-03-01', null, '555-0104', 'Manager');

-- Insert mock data into customers
INSERT INTO customers (first_name, last_name, email, contact_number)
VALUES ('John', 'Doe', 'john.doe@example.com', '555-0201'),
       ('Sarah', 'Connor', 'sarah.connor@example.com', '555-0202'),
       ('Bruce', 'Wayne', 'bruce.wayne@example.com', '555-0203');

-- Insert mock data into drop_offs
INSERT INTO drop_offs (customer_id, dropoff_date, notes)
VALUES (1, '2024-02-18', 'Customer requests express service.'),
       (2, '2024-02-19', 'Screen replacement required.'),
       (3, '2024-02-20', 'Battery replacement required.');
