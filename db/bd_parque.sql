CREATE DATABASE amusement_park;
USE amusement_park;

CREATE TABLE park (
  id_park INT AUTO_INCREMENT,
  name VARCHAR(150),
  start_tm TIME,
  end_tm TIME,
  PRIMARY KEY (id_park)
) ENGINE=InnoDB;

CREATE TABLE ride (
  id_ride INT AUTO_INCREMENT,
  name VARCHAR(100),
  capacity CHAR(2),
  type_ride VARCHAR(100),
  height_rqmt DECIMAL(3,2),
  start_tm TIME,
  end_tm TIME,
  PRIMARY KEY (id_ride)
) ENGINE=InnoDB;

CREATE TABLE park_ride (
  id_park INT NOT NULL,
  id_ride INT NOT NULL,
  PRIMARY KEY (id_park, id_ride),
  CONSTRAINT fk_pr_park
    FOREIGN KEY (id_park) REFERENCES park(id_park),
  CONSTRAINT fk_pr_ride
    FOREIGN KEY (id_ride) REFERENCES ride(id_ride)
) ENGINE=InnoDB;

CREATE TABLE ride_visit (
  id_visit BIGINT NOT NULL,
  visit_dt DATE NOT NULL,
  id_park INT NOT NULL,
  id_ride INT NOT NULL,
  PRIMARY KEY (id_visit, visit_dt),
  INDEX ix_rv_park (id_park),
  INDEX ix_rv_ride (id_ride)
)
PARTITION BY RANGE (TO_DAYS(visit_dt)) (
  PARTITION p2025 VALUES LESS THAN (TO_DAYS('2026-01-01')),
  PARTITION p2026 VALUES LESS THAN (TO_DAYS('2027-01-01')),
  PARTITION pmax VALUES LESS THAN MAXVALUE
);