# --- !Ups

create table usage_report (
  id                        bigint primary key,
  creation_date             timestamp,
  started_class_name        varchar(255),
  data_class_name           varchar(255),
  alias_name                varchar(255),
  owner_class_name          varchar(255),
  command                   varchar(255),
  software_version          varchar(255),
  software_build            varchar(255),
  user_account              varchar(255),
  project_name              varchar(255),
  project_path              varchar(255))
;

create table wake_up_module (
  started_class_name        varchar(255) primary key,
  module_name               varchar(255))
;




# --- !Downs

PRAGMA foreign_keys = OFF;

drop table usage_report;

drop table wake_up_module;

PRAGMA foreign_keys = ON;

