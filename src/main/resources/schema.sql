CREATE TABLE IF NOT EXISTS tblDepartments(
                               dpId int not null auto_increment primary key,
                               dpName varchar(255) not null

);

CREATE TABLE IF NOT EXISTS tblEmployees(
                             empId int not null auto_increment primary key,
                             empName varchar(255) not null,
                             empActive boolean not null default false,
                             dptId int not null,
                             FOREIGN KEY fk_dpm (dptId)
                                 REFERENCES tblDepartments(dpId)
                                 ON UPDATE CASCADE
                                 ON DELETE RESTRICT
);

