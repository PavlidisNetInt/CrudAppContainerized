alter session set "_ORACLE_SCRIPT"=true;
create user spring_crud identified by "spring_crud";
grant sysdba to spring_crud;
grant all privileges to spring_crud;

exit;
