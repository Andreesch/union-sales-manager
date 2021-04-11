create table quota (id varchar(255) not null, created_at timestamp not null, end_quarter_reference date not null, initial_quarter_reference date not null, quota_type varchar(255) not null, value double not null, salesman_id varchar(255) not null, primary key (id))
create table sale (id varchar(255) not null, created_at timestamp not null, description varchar(255) not null, value double not null, quota_id varchar(255) not null, employee_id varchar(255) not null, primary key (id))
create table salesman (id varchar(255) not null, name varchar(255) not null, region integer not null, salesman_config_id varchar(255) not null, primary key (id))
create table salesman_config (id varchar(255) not null, commission_type varchar(255) not null, value double not null, primary key (id))
alter table quota add constraint FKo6ntq6o2u7cm6wgxay1u2ano4 foreign key (salesman_id) references salesman
alter table sale add constraint FKaqd0dq8cwk9ukw0aopv1qp1wv foreign key (quota_id) references quota
alter table sale add constraint FK5yd9hiwqwk2r5xdrbfysct5bb foreign key (employee_id) references salesman
alter table salesman add constraint FK9eclil381jisb0m6rabowg4rh foreign key (salesman_config_id) references salesman_config
