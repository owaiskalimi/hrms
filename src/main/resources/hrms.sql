--Adding roles

INSERT INTO public.role(id, type)
VALUES ((select nextval('"public"."role_id_seq"')), 'Admin');

INSERT INTO public.role(id, type)
VALUES ((select nextval('"public"."role_id_seq"')), 'User');

--Adding employee

INSERT INTO public."employee"(id, is_active, email, username, password, role_id)
VALUES ((select nextval('"public"."user_id_seq"')), true,'admin@admin.com','admin','$2a$10$QBNbxRU.ic4BYR5Pmv14DeQpcWV2hUfeKINg5EmA3J4PMDJZcKB/6', '1');

--Adding custom roles

INSERT INTO public."custom_roles"(id, employee_id, role_id)
VALUES ((select nextval('"public"."user_id_seq"')), '1', '1')

--Adding default company

INSERT INTO public."company"(id, is_active, name)
VALUES ((select nextval('"public"."user_id_seq"')), true, VinnCorp)

--Adding default privileges

INSERT INTO public."privileges"(id, type)
VALUES ('1', 'Create Company')
INSERT INTO public."privileges"(id, type)
VALUES ('2', 'Edit Company')
INSERT INTO public."privileges"(id, type)
VALUES ('3', 'Delete Company')
INSERT INTO public."privileges"(id, type)
VALUES ('4', 'View Company')
INSERT INTO public."privileges"(id, type)
VALUES ('5', 'Create Employee')
INSERT INTO public."privileges"(id, type)
VALUES ('6', 'Edit Employee')
INSERT INTO public."privileges"(id, type)
VALUES ('7', 'Delete Employee')
INSERT INTO public."privileges"(id, type)
VALUES ('8', 'View Employee')
INSERT INTO public."privileges"(id, type)
VALUES ('9', 'Mark Attendance')
INSERT INTO public."privileges"(id, type)
VALUES ('10', 'View Attendance')
INSERT INTO public."privileges"(id, type)
VALUES ('11', 'Update Attendance')
INSERT INTO public."privileges"(id, type)
VALUES ('12', 'Delete Attendance')

