
SET 
  IDENTITY_INSERT ROLE ON;
INSERT INTO ROLE (ROLE_ID, ROLE_NAME) 
VALUES 
  ('1', 'Manager'), 
  ('2', 'Scrum Master'), 
  (
    '3', 'Sr. Developer / Architect / Devopps'
  ), 
  ('4', 'Jr. Developer'), 
  ('5', 'QA'), 
  ('6', 'QA Lead');
SET 
  IDENTITY_INSERT ROLE OFF;
SET 
  IDENTITY_INSERT OFFICE ON;
INSERT INTO OFFICE (OFFICE_ID, OFFICE_NAME) 
VALUES 
  ('0', 'No office'), 
  ('1', 'Cordoba');
SET 
  IDENTITY_INSERT OFFICE OFF;
SET 
  IDENTITY_INSERT TEAM ON;
INSERT INTO TEAM (TEAM_ID, TEAM_NAME) 
VALUES 
  ('0', 'No team'), 
  ('1', 'Garzas'), 
  ('2', 'Buhos'), 
  ('3', 'Gansos'), 
  ('4', 'Falcon'), 
  ('5', 'Phoenix');
SET 
  IDENTITY_INSERT TEAM OFF;
  
  
SET 
  IDENTITY_INSERT EMPLOYEE ON;
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID, LINE_MANAGER_ID, TEAM_LEAD_ID, IS_MENTOR, IS_TEAM_LEAD, IS_LINE_MANAGER, STATUS)
VALUES(1, N'Lourdes', N'Bermudo', N'admin@innovation.group', N'demo', 1, 1, N'ADMIN', 1, NULL, 1, 1, 1, 0, N'ACTIVE');
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID, LINE_MANAGER_ID, TEAM_LEAD_ID, IS_MENTOR, IS_TEAM_LEAD, IS_LINE_MANAGER, STATUS)
VALUES(2, N'Angie', N'Luque', N'angie.luque@innovation.group', N'demo', 1, 1, N'ADMIN', 1, 2, 1, 1, 1, 1, N'ACTIVE');
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID, LINE_MANAGER_ID, TEAM_LEAD_ID, IS_MENTOR, IS_TEAM_LEAD, IS_LINE_MANAGER, STATUS)
VALUES(3, N'Jose Alberto', N'Coronado', N'jose.coronado@innovation.group', N'demo', 3, 1, N'USER', 1, 2, 2, 1, 0, 0, N'ACTIVE');
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID, LINE_MANAGER_ID, TEAM_LEAD_ID, IS_MENTOR, IS_TEAM_LEAD, IS_LINE_MANAGER, STATUS)
VALUES(4, N'Rafael', N'Gomez Ramirez', N'rafael.gomez@innovation.group', N'demo', 3, 1, N'USER', 1, 2, 3, 0, 0, 0, N'ACTIVE');
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID, LINE_MANAGER_ID, TEAM_LEAD_ID, IS_MENTOR, IS_TEAM_LEAD, IS_LINE_MANAGER, STATUS)
VALUES(5, N'Alvaro', N'Frias', N'alvaro.frias@innovation.group', N'demo', 2, 1, N'USER', 2, 2, 2, 1, 0, 0, N'ACTIVE');
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID, LINE_MANAGER_ID, TEAM_LEAD_ID, IS_MENTOR, IS_TEAM_LEAD, IS_LINE_MANAGER, STATUS)
VALUES(6, N'Jon', N'Nu??o', N'jon.nu??o@innovation.group', N'demo', 3, 1, N'USER', 3, 2, 5, 0, 0, 0, N'ACTIVE');
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID, LINE_MANAGER_ID, TEAM_LEAD_ID, IS_MENTOR, IS_TEAM_LEAD, IS_LINE_MANAGER, STATUS)
VALUES(7, N'Jesus', N'Gil', N'jesus.gil@innovation.group', N'demo', 3, 1, N'USER', 3, 2, 5, 0, 0, 0, N'ACTIVE');
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID, LINE_MANAGER_ID, TEAM_LEAD_ID, IS_MENTOR, IS_TEAM_LEAD, IS_LINE_MANAGER, STATUS)
VALUES(8, N'Manuel', N'Gonzalez', N'manuel.gonzalez@innovation.group', N'demo', 3, 1, N'USER', 5, 2, 5, 0, 0, 0, N'ACTIVE');
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID, LINE_MANAGER_ID, TEAM_LEAD_ID, IS_MENTOR, IS_TEAM_LEAD, IS_LINE_MANAGER, STATUS)
VALUES(9, N'Pedro', N'Barranco', N'pedro.barranco@innovation.group', N'demo', 3, 1, N'USER', 1, 2, 5, 0, 0, 0, N'ACTIVE');
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID, LINE_MANAGER_ID, TEAM_LEAD_ID, IS_MENTOR, IS_TEAM_LEAD, IS_LINE_MANAGER, STATUS)
VALUES(10, N'Joaquin', N'Mohedano', N'joaquin.mohedano@innovation.group', N'demo', 3, 1, N'USER', 1, 2, 5, 0, 0, 0, N'ACTIVE');
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID, LINE_MANAGER_ID, TEAM_LEAD_ID, IS_MENTOR, IS_TEAM_LEAD, IS_LINE_MANAGER, STATUS)
VALUES(11, N'Elena', N'Salas', N'elena.salas@innovation.group', N'demo', 5, 1, N'USER', 1, 2, 5, 0, 0, 0, N'ACTIVE');
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID, LINE_MANAGER_ID, TEAM_LEAD_ID, IS_MENTOR, IS_TEAM_LEAD, IS_LINE_MANAGER, STATUS)
VALUES(12, N'Angel', N'Mora', N'angel.mora@innovation.group', N'demo', 5, 1, N'USER', 1, 2, 5, 0, 0, 0, N'ACTIVE');
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID, LINE_MANAGER_ID, TEAM_LEAD_ID, IS_MENTOR, IS_TEAM_LEAD, IS_LINE_MANAGER, STATUS)
VALUES(13, N'Laura', N'Fernandez', N'laura.fernandez@innovation.group', N'demo', 2, 1, N'USER', 2, 2, 2, 0, 0, 0, N'ACTIVE');
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID, LINE_MANAGER_ID, TEAM_LEAD_ID, IS_MENTOR, IS_TEAM_LEAD, IS_LINE_MANAGER, STATUS)
VALUES(14, N'Luis', N'Rodriguez', N'luis.rodriguez@innovation.group', N'demo', 3, 1, N'ADMIN', 1, 2, 13, 0, 0, 0, N'ACTIVE');
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID, LINE_MANAGER_ID, TEAM_LEAD_ID, IS_MENTOR, IS_TEAM_LEAD, IS_LINE_MANAGER, STATUS)
VALUES(15, N'David', N'Montero', N'david.montero@innovation.group', N'demo', 3, 1, N'USER', 1, 2, 13, 0, 0, 0, N'ACTIVE');
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID, LINE_MANAGER_ID, TEAM_LEAD_ID, IS_MENTOR, IS_TEAM_LEAD, IS_LINE_MANAGER, STATUS)
VALUES(16, N'Ines', N'Yepez', N'ines.yepez@innovation.group', N'demo', 5, 1, N'USER', 1, 2, 13, 0, 0, 0, N'ACTIVE');
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID, LINE_MANAGER_ID, TEAM_LEAD_ID, IS_MENTOR, IS_TEAM_LEAD, IS_LINE_MANAGER, STATUS)
VALUES(17, N'Mairead', N'Osullivan', N'jon.nu??o@innovation.group', N'demo', 5, 1, N'USER', 1, 2, 17, 0, 0, 0, N'ACTIVE');
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID, LINE_MANAGER_ID, TEAM_LEAD_ID, IS_MENTOR, IS_TEAM_LEAD, IS_LINE_MANAGER, STATUS)
VALUES(18, N'Antonio', N'Arteche', N'antonio.arteche@innovation.group', N'demo', 2, 1, N'USER', 2, 2, 2, 0, 0, 0, N'ACTIVE');
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID, LINE_MANAGER_ID, TEAM_LEAD_ID, IS_MENTOR, IS_TEAM_LEAD, IS_LINE_MANAGER, STATUS)
VALUES(19, N'Rafael', N'Granados', N'rafael.granados@innovation.group', N'demo', 3, 1, N'USER', 1, 2, 19, 0, 0, 0, N'ACTIVE');
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID, LINE_MANAGER_ID, TEAM_LEAD_ID, IS_MENTOR, IS_TEAM_LEAD, IS_LINE_MANAGER, STATUS)
VALUES(20, N'Sergio', N'Caballero', N'sergio.caballero@innovation.group', N'demo', 3, 1, N'USER', 1, 2, 19, 0, 0, 0, N'ACTIVE');
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID, LINE_MANAGER_ID, TEAM_LEAD_ID, IS_MENTOR, IS_TEAM_LEAD, IS_LINE_MANAGER, STATUS)
VALUES(21, N'Daniel', N'Lagarda', N'daniel.lagarda@innovation.group', N'demo', 3, 1, N'USER', 1, 2, 19, 0, 0, 0, N'ACTIVE');
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID, LINE_MANAGER_ID, TEAM_LEAD_ID, IS_MENTOR, IS_TEAM_LEAD, IS_LINE_MANAGER, STATUS)
VALUES(22, N'Rafael', N'Saez', N'rafael.saez@innovation.group', N'demo', 5, 1, N'USER', 1, 2, 19, 0, 0, 0, N'ACTIVE');
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID, LINE_MANAGER_ID, TEAM_LEAD_ID, IS_MENTOR, IS_TEAM_LEAD, IS_LINE_MANAGER, STATUS)
VALUES(23, N'Antonio', N'Casado', N'antonio.casado@innovation.group', N'demo', 3, 1, N'USER', 1, 2, 5, 0, 0, 0, N'ACTIVE');
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID, LINE_MANAGER_ID, TEAM_LEAD_ID, IS_MENTOR, IS_TEAM_LEAD, IS_LINE_MANAGER, STATUS)
VALUES(24, N'Juan Antonio', N'Ruz', N'juanantonio.ruz@innovation.group', N'demo', 3, 1, N'USER', 1, 2, 5, 0, 0, 0, N'ACTIVE');
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID, LINE_MANAGER_ID, TEAM_LEAD_ID, IS_MENTOR, IS_TEAM_LEAD, IS_LINE_MANAGER, STATUS)
VALUES(25, N'Angel', N'Calvo', N'angel.calvo@innovation.group', N'demo', 3, 1, N'USER', 3, 2, 13, 0, 0, 0, N'ACTIVE');
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID, LINE_MANAGER_ID, TEAM_LEAD_ID, IS_MENTOR, IS_TEAM_LEAD, IS_LINE_MANAGER, STATUS)
VALUES(26, N'Ivan', N'Martin', N'ivan.martin@innovation.group', N'demo', 3, 1, N'USER', 1, 2, 13, 0, 0, 0, N'ACTIVE');
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID, LINE_MANAGER_ID, TEAM_LEAD_ID, IS_MENTOR, IS_TEAM_LEAD, IS_LINE_MANAGER, STATUS)
VALUES(27, N'Jose Francisco', N'Ibarra', N'josefrancisco.ibarralozano@Innovation.Group', N'demo', 3, 1, N'USER', 1, 2, 13, 0, 0, 0, N'ACTIVE');
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID, LINE_MANAGER_ID, TEAM_LEAD_ID, IS_MENTOR, IS_TEAM_LEAD, IS_LINE_MANAGER, STATUS)
VALUES(28, N'David', N'Sanchez', N'david.sanchez@innovation.group', N'demo', 4, 1, N'USER', 1, 2, 13, 0, 0, 0, N'ACTIVE');
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID, LINE_MANAGER_ID, TEAM_LEAD_ID, IS_MENTOR, IS_TEAM_LEAD, IS_LINE_MANAGER, STATUS)
VALUES(29, N'Eric', N'Ortega', N'eric.ortega@innovation.group', N'demo', 5, 1, N'USER', 1, 2, 2, 0, 0, 0, N'ACTIVE');
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID, LINE_MANAGER_ID, TEAM_LEAD_ID, IS_MENTOR, IS_TEAM_LEAD, IS_LINE_MANAGER, STATUS)
VALUES(30, N'I??aki', N'De la haba', N'inaki.delahaba@innovation.group', N'demo', 5, 1, N'USER', 1, 2, 13, 0, 0, 0, N'ACTIVE');
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID, LINE_MANAGER_ID, TEAM_LEAD_ID, IS_MENTOR, IS_TEAM_LEAD, IS_LINE_MANAGER, STATUS)
VALUES(31, N'Xiomara', N'Montilla', N'1iomara.montilla@innovation.group', N'demo', 3, 1, N'USER', 1, 2, 1, 0, 0, 0, N'ACTIVE');
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID, LINE_MANAGER_ID, TEAM_LEAD_ID, IS_MENTOR, IS_TEAM_LEAD, IS_LINE_MANAGER, STATUS)
VALUES(32, N'Alejandro', N'Molina', N'alejandro.molina@innovation.group', N'demo', 3, 1, N'USER', 1, 2, 5, 0, 0, 0, N'ACTIVE');
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID, LINE_MANAGER_ID, TEAM_LEAD_ID, IS_MENTOR, IS_TEAM_LEAD, IS_LINE_MANAGER, STATUS)
VALUES(33, N'Natalia', N'Gimenez', N'natalia.gimenez@innovation.group', N'demo', 3, 1, N'USER', 1, 2, 1, 0, 0, 0, N'ACTIVE');

SET 
  IDENTITY_INSERT EMPLOYEE OFF;
  
  
INSERT INTO EMPLOYEE_TEAM (USER_ID, TEAM_ID) 
VALUES 
  ('5', '1'), 
  ('5', '2'), 
  ('6', '1'), 
  ('7', '1'), 
  ('8', '1'), 
  ('9', '1'), 
  ('10', '1'), 
  ('11', '1'), 
  ('12', '1'), 
  ('13', '4'), 
  ('13', '5'), 
  ('14', '4'), 
  ('15', '4'), 
  ('16', '4'), 
  ('17', '4'), 
  ('18', '3'), 
  ('19', '3'), 
  ('20', '3'), 
  ('21', '3'), 
  ('22', '3'), 
  ('23', '2'), 
  ('24', '2'), 
  ('25', '5'), 
  ('26', '5'), 
  ('27', '5'), 
  ('28', '5'), 
  ('29', '5'), 
  ('30', '5'), 
  ('32', '5');
  
SET IDENTITY_INSERT GROUPS ON;
INSERT INTO GROUPS (GROUP_ID, GROUP_NAME) 
VALUES 
  (1, 'INGLES B1'), 
  (2, 'INGLES B2'), 
  (3, 'INGLES C1'), 
  (4, 'INGLES C2');
SET IDENTITY_INSERT GROUPS OFF;

INSERT INTO EMPLOYEE_GROUP (USER_ID, GROUP_ID) 
VALUES 
  ('1', '3'), 
  ('2', '4'), 
  ('3', '4'), 
  ('4', '3'), 
  ('5', '3'), 
  ('6', '1'), 
  ('7', '2'), 
  ('8', '3'), 
  ('9', '2'), 
  ('10', '3'), 
  ('11', '3'), 
  ('12', '4'), 
  ('13', '2'), 
  ('14', '1'), 
  ('15', '1'), 
  ('16', '2'), 
  ('18', '4'), 
  ('19', '2'), 
  ('20', '1'), 
  ('21', '4'), 
  ('22', '3'), 
  ('23', '4'), 
  ('24', '1'), 
  ('25', '4'), 
  ('26', '1'), 
  ('27', '2'), 
  ('28', '3'), 
  ('29', '2'), 
  ('32', '4');

SET IDENTITY_INSERT APPRAISAL_TYPE ON;
INSERT INTO APPRAISAL_TYPE (
  APPRAISAL_TYPE_ID, APPRAISAL_TYPE_NAME
) 
VALUES 
  ('0', 'Individuales'), 
  ('1', 'Trabajo en equipo'), 
  ('2', 'Inherentes al cargo'), 
  ('3', 'Motivaci??n y logros'), 
  ('4', 'Cultura Corporativa / Orgullo de pertenencia'), 
  ('5', 'Organizaci??n personal'), 
  ('6', 'Gesti??n'), 
  ('7', 'Relaci??n/Comunicaci??n'), 
  ('8', 'Impacto general en Innovation Group'), 
  ('9', 'Potencial');
SET IDENTITY_INSERT APPRAISAL_TYPE OFF;

SET IDENTITY_INSERT CRITERIA_NAME ON;
INSERT INTO CRITERIA_NAME (
  CRITERIA_NAME_ID, APPRAISAL_TYPE_ID, 
  SUBTYPE_ID, LANGUAGE, CRITERIA_NAME
) 
VALUES 
  (
    '0', '0', '1', '1', 'Manejo de los lenguajes/herramientas requeridos para el desarrollo de su rol'
  ), 
  (
    '1', '0', '2', '1', 'Calidad del trabajo en las entregas'
  ), 
  (
    '2', '0', '3', '1', 'Evoluci??n y desarrollo profesional (Master, cursos, autodidacta???)'
  ), 
  (
    '3', '0', '4', '1', 'Cumple con las entregas en tiempo'
  ), 
  (
    '4', '0', '5', '1', 'Aporta soluciones valiosas ante dificultades'
  ), 
  (
    '5', '1', '1', '1', 'Actitud ante decisiones y adaptaci??n al cambio'
  ), 
  (
    '6', '1', '2', '1', 'Comparte el conocimiento con los compa??eros que lo necesitan'
  ), 
  (
    '7', '1', '3', '1', 'Contribuci??n a un ambiente de colaboraci??n y confianza en su grupo de trabajo - team player'
  ), 
  (
    '8', '1', '4', '1', 'Contribuye a la gesti??n y organizaci??n del trabajo del equipo'
  ), 
  (
    '9', '1', '5', '1', 'Habilidades de liderazgo demostradas a lo largo del a??o'
  ), 
  (
    '10', '2', '1', '1', 'Desarrollo de las funciones inherentes al cargo'
  ), 
  (
    '11', '2', '2', '1', 'Contribuye a cumplir los objetivos marcados en el sprint'
  ), 
  (
    '12', '2', '3', '1', 'Orientaci??n a la consecuci??n de buenos resultados'
  ), 
  (
    '13', '2', '4', '1', 'Conocimientos t??cnicos relativos al role que desempe??a'
  ), 
  (
    '14', '2', '5', '1', 'Flexibilidad y conocimiento de la metodolog??a ??gil'
  ), 
  (
    '15', '3', '1', '1', 'Capacidad de superaci??n profesional y mejora continua'
  ), 
  (
    '16', '3', '2', '1', 'Proactividad e iniciativa'
  ), 
  (
    '17', '3', '3', '1', 'Aprovechamiento de mentoring'
  ), 
  (
    '18', '3', '4', '1', 'Implicaci??n y motivaci??n diaria '
  ), 
  (
    '19', '3', '5', '1', 'Capacidad de superar los desaf??os planteados a lo largo del a??o'
  ), 
  (
    '20', '4', '1', '1', 'Conocimiento del negocio en su conjunto (Compa????a, departamentos, equipos, producto???)'
  ), 
  (
    '21', '4', '2', '1', 'Participaci??n en actividades organizadas por IG (team building, charlas, clas??s de ingl??s???)'
  ), 
  (
    '22', '4', '3', '1', 'Cumplimiento de pol??ticas, normas, procedimientos y buenas pr??cticas propuestas'
  ), 
  (
    '23', '4', '4', '1', 'Participaci??n en reclutamiento (proponiendo candidatos, compartiendo ofertas,... )'
  ), 
  (
    '24', '4', '5', '1', 'Contribuci??n a la Imagen de Compa????a (compartiendo eventos, noticias, kudos,... )'
  ), 
  (
    '25', '5', '1', '1', 'Capacidad de ser autosuficiente para llevar a cabo sus tareas'
  ), 
  (
    '26', '5', '2', '1', 'Gesti??n del tiempo y de los plazos de entrega'
  ), 
  (
    '27', '5', '3', '1', 'Prepara las reuniones y las planifica con tiempo'
  ), 
  (
    '28', '5', '4', '1', 'Capacidad de asumir m??s trabajo del esperado'
  ), 
  (
    '29', '5', '5', '1', 'Gesti??n del estr??s y la responsabilidad'
  ), 
  (
    '30', '6', '1', '1', 'Capacidad de gesti??n/resoluci??n de conflictos'
  ), 
  (
    '31', '6', '2', '1', 'Gesti??n de equipos'
  ), 
  (
    '32', '6', '3', '1', 'Capacidad para transmitir informaci??n importante al equipo'
  ), 
  (
    '33', '6', '4', '1', 'Capacidad de toma de decisiones'
  ), 
  (
    '34', '6', '5', '1', 'Gesti??n del cambio'
  ), 
  (
    '35', '7', '1', '1', 'Relaci??n con responsable directo'
  ), 
  (
    '36', '7', '2', '1', 'Relaci??n con iguales / equipo'
  ), 
  (
    '37', '7', '3', '1', 'Relaci??n con subordinados/mentorizados y/o con su mentor'
  ), 
  (
    '38', '7', '4', '1', 'Relaci??n con otros equiposdepartamentos / clientes / negocio'
  ), 
  (
    '39', '7', '5', '1', 'Comunicaci??n en ingl??s'
  ), 
  (
    '40', '8', '1', '1', 'Aporte de valor t??cnico a la Compa????a'
  ), 
  (
    '41', '8', '2', '1', 'Impacto en el ambiente laboral diario'
  ), 
  (
    '42', '8', '3', '1', 'Contribuci??n a la comunicaci??n entre departamentos'
  ), 
  (
    '43', '8', '4', '1', 'El impacto en el comportamiento de los compa??eros es??? (Role Model)'
  ), 
  (
    '44', '8', '5', '1', 'Nivel de motivaci??n general con Innovation Group (bajo tu opini??n)'
  ), 
  (
    '45', '9', '1', '1', 'Capacidad de superaci??n / rapidez de aprendizaje y aplicabilidad de lo aprendido'
  ), 
  (
    '46', '9', '2', '1', 'Capacidad profesional para adquirir, procesar y desarrollar informaci??n para el equipo'
  ), 
  (
    '47', '9', '3', '1', 'Capacidad de delegaci??n'
  ), 
  (
    '48', '9', '4', '1', 'Capacidad anal??tica'
  ), 
  (
    '49', '9', '5', '1', 'Inteligencia emocional y empat??a hac??a los compa??eros'
  );
SET IDENTITY_INSERT CRITERIA_NAME OFF;

INSERT INTO SPECIFIC_INTERNAL_APPTYPE (
  GROUP_ID, SUBTYPE_ID, ROLE_ID, WEIGHT
) 
VALUES 
  --COMPETITIVO EN EL SECTOR
  ('0', '0', '1', '20'), 
  ('0', '0', '2', '20'), 
  ('0', '0', '3', '25'), 
  ('0', '0', '4', '25'), 
  ('0', '0', '5', '25'), 
  ('0', '1', '1', '25'), 
  ('0', '1', '2', '20'), 
  ('0', '1', '3', '25'), 
  ('0', '1', '4', '25'), 
  ('0', '1', '5', '25'), 
  ('0', '2', '1', '10'), 
  ('0', '2', '2', '20'), 
  ('0', '2', '3', '20'), 
  ('0', '2', '4', '30'), 
  ('0', '2', '5', '25'), 
  ('0', '3', '1', '20'), 
  ('0', '3', '2', '20'), 
  ('0', '3', '3', '15'), 
  ('0', '3', '4', '5'), 
  ('0', '3', '5', '10'), 
  ('0', '4', '1', '25'), 
  ('0', '4', '2', '20'), 
  ('0', '4', '3', '15'), 
  ('0', '4', '4', '15'), 
  ('0', '4', '5', '15'), 
  -- IMPACTO EN CLIMA LABORAL
  ('1', '0', '1', '20'), 
  ('1', '0', '2', '20'), 
  ('1', '0', '3', '20'), 
  ('1', '0', '4', '20'), 
  ('1', '0', '5', '20'), 
  ('1', '1', '1', '20'), 
  ('1', '1', '2', '25'), 
  ('1', '1', '3', '20'), 
  ('1', '1', '4', '30'), 
  ('1', '1', '5', '20'), 
  ('1', '2', '1', '15'), 
  ('1', '2', '2', '25'), 
  ('1', '2', '3', '20'), 
  ('1', '2', '4', '20'), 
  ('1', '2', '5', '20'), 
  ('1', '3', '1', '20'), 
  ('1', '3', '2', '15'), 
  ('1', '3', '3', '15'), 
  ('1', '3', '4', '15'), 
  ('1', '3', '5', '15'), 
  ('1', '4', '1', '25'), 
  ('1', '4', '2', '15'), 
  ('1', '4', '3', '15'), 
  ('1', '4', '4', '15'), 
  ('1', '4', '5', '15'), 
  -- MEJORA CONTINUA
  ('2', '0', '1', '25'), 
  ('2', '0', '2', '25'), 
  ('2', '0', '3', '30'), 
  ('2', '0', '4', '30'), 
  ('2', '0', '5', '30'), 
  ('2', '1', '1', '20'), 
  ('2', '1', '2', '25'), 
  ('2', '1', '3', '25'), 
  ('2', '1', '4', '30'), 
  ('2', '1', '5', '25'), 
  ('2', '2', '1', '25'), 
  ('2', '2', '2', '25'), 
  ('2', '2', '3', '25'), 
  ('2', '2', '4', '15'), 
  ('2', '2', '5', '25'), 
  -- Dependiendo del rol, estos pesos ser??n para un criterio u otro
  ('2', '3', '1', '30'), 
  ('2', '3', '2', '25'), 
  ('2', '3', '3', '20'), 
  ('2', '3', '4', '25'), 
  ('2', '3', '5', '20'), 
  --
  -- VALOR INDIVIDUAL DEL TRABAJADOR
  ('3', '0', '1', '25'), 
  ('3', '0', '2', '20'), 
  ('3', '0', '3', '15'), 
  ('3', '0', '4', '10'), 
  ('3', '0', '5', '15'), 
  ('3', '1', '1', '25'), 
  ('3', '1', '2', '15'), 
  ('3', '1', '3', '25'), 
  ('3', '1', '4', '10'), 
  ('3', '1', '5', '25'), 
  ('3', '2', '1', '10'), 
  ('3', '2', '2', '15'), 
  ('3', '2', '3', '20'), 
  ('3', '2', '4', '30'), 
  ('3', '2', '5', '20'), 
  ('3', '3', '1', '20'), 
  ('3', '3', '2', '25'), 
  ('3', '3', '3', '20'), 
  ('3', '3', '4', '25'), 
  ('3', '3', '5', '20'), 
  ('3', '4', '1', '20'), 
  ('3', '4', '2', '25'), 
  ('3', '4', '3', '20'), 
  ('3', '4', '4', '25'), 
  ('3', '4', '5', '20');

INSERT INTO GLOBAL_INTERNAL_APPTYPE (GROUP_ID, WEIGHT) 
VALUES 
  ('0', '25'), 
  ('1', '35'), 
  ('2', '20'), 
  ('3', '20');

INSERT INTO GLOBAL_APPRAISAL_TYPE (
  APPRAISAL_TYPE_ID, ROLE_ID, WEIGHT
) 
VALUES 
  ('0', '1', '5'), 
  ('0', '2', '10'), 
  ('0', '3', '30'), 
  ('0', '4', '30'), 
  ('0', '5', '30'), 
  ('1', '1', '5'), 
  ('1', '2', '10'), 
  ('1', '3', '20'), 
  ('1', '4', '20'), 
  ('1', '5', '20'), 
  ('2', '1', '5'), 
  ('2', '2', '5'), 
  ('2', '3', '5'), 
  ('2', '4', '5'), 
  ('2', '5', '5'), 
  ('3', '1', '5'), 
  ('3', '2', '5'), 
  ('3', '3', '5'), 
  ('3', '4', '5'), 
  ('3', '5', '5'), 
  ('4', '1', '15'), 
  ('4', '2', '10'), 
  ('4', '3', '5'), 
  ('4', '4', '5'), 
  ('4', '5', '5'), 
  ('5', '1', '5'), 
  ('5', '2', '10'), 
  ('5', '3', '5'), 
  ('5', '4', '5'), 
  ('5', '5', '5'), 
  ('6', '1', '30'), 
  ('6', '2', '20'), 
  ('6', '3', '5'), 
  ('6', '4', '5'), 
  ('6', '5', '5'), 
  ('7', '1', '10'), 
  ('7', '2', '10'), 
  ('7', '3', '10'), 
  ('7', '4', '10'), 
  ('7', '5', '10'), 
  ('8', '1', '15'), 
  ('8', '2', '15'), 
  ('8', '3', '10'), 
  ('8', '4', '10'), 
  ('8', '5', '10'), 
  ('9', '1', '5'), 
  ('9', '2', '5'), 
  ('9', '3', '5'), 
  ('9', '4', '5'), 
  ('9', '5', '5');

INSERT INTO SPECIFIC_APPRAISAL_TYPE (
  APPRAISAL_TYPE_ID, SUBTYPE_ID, ROLE_ID, 
  WEIGHT
) 
VALUES 
  ('0', '1', '1', '20'), 
  ('0', '1', '2', '20'), 
  ('0', '1', '3', '30'), 
  ('0', '1', '4', '55'), 
  ('0', '1', '5', '35'), 
  ('0', '2', '1', '15'), 
  ('0', '2', '2', '20'), 
  ('0', '2', '3', '25'), 
  ('0', '2', '4', '20'), 
  ('0', '2', '5', '40'), 
  ('0', '3', '1', '25'), 
  ('0', '3', '2', '20'), 
  ('0', '3', '3', '15'), 
  ('0', '3', '4', '10'), 
  ('0', '3', '5', '10'), 
  ('0', '4', '1', '15'), 
  ('0', '4', '2', '15'), 
  ('0', '4', '3', '10'), 
  ('0', '4', '4', '10'), 
  ('0', '4', '5', '5'), 
  ('0', '5', '1', '25'), 
  ('0', '5', '2', '25'), 
  ('0', '5', '3', '20'), 
  ('0', '5', '4', '5'), 
  ('0', '5', '5', '10'), 
  ('1', '1', '1', '15'), 
  ('1', '1', '2', '20'), 
  ('1', '1', '3', '20'), 
  ('1', '1', '4', '25'), 
  ('1', '1', '5', '20'), 
  ('1', '2', '1', '20'), 
  ('1', '2', '2', '15'), 
  ('1', '2', '3', '20'), 
  ('1', '2', '4', '15'), 
  ('1', '2', '5', '20'), 
  ('1', '3', '1', '15'), 
  ('1', '3', '2', '20'), 
  ('1', '3', '3', '20'), 
  ('1', '3', '4', '20'), 
  ('1', '3', '5', '20'), 
  ('1', '4', '1', '25'), 
  ('1', '4', '2', '25'), 
  ('1', '4', '3', '20'), 
  ('1', '4', '4', '20'), 
  ('1', '4', '5', '20'), 
  ('1', '5', '1', '25'), 
  ('1', '5', '2', '20'), 
  ('1', '5', '3', '20'), 
  ('1', '5', '4', '20'), 
  ('1', '5', '5', '20'), 
  ('2', '1', '1', '20'), 
  ('2', '1', '2', '20'), 
  ('2', '1', '3', '20'), 
  ('2', '1', '4', '20'), 
  ('2', '1', '5', '20'), 
  ('2', '2', '1', '20'), 
  ('2', '2', '2', '20'), 
  ('2', '2', '3', '20'), 
  ('2', '2', '4', '20'), 
  ('2', '2', '5', '20'), 
  ('2', '3', '1', '20'), 
  ('2', '3', '2', '20'), 
  ('2', '3', '3', '20'), 
  ('2', '3', '4', '20'), 
  ('2', '3', '5', '20'), 
  ('2', '4', '1', '20'), 
  ('2', '4', '2', '20'), 
  ('2', '4', '3', '20'), 
  ('2', '4', '4', '20'), 
  ('2', '4', '5', '20'), 
  ('2', '5', '1', '20'), 
  ('2', '5', '2', '20'), 
  ('2', '5', '3', '20'), 
  ('2', '5', '4', '20'), 
  ('2', '5', '5', '20'), 
  ('3', '1', '1', '25'), 
  ('3', '1', '2', '20'), 
  ('3', '1', '3', '25'), 
  ('3', '1', '4', '20'), 
  ('3', '1', '5', '20'), 
  ('3', '2', '1', '20'), 
  ('3', '2', '2', '20'), 
  ('3', '2', '3', '20'), 
  ('3', '2', '4', '20'), 
  ('3', '2', '5', '25'), 
  ('3', '3', '1', '15'), 
  ('3', '3', '2', '20'), 
  ('3', '3', '3', '20'), 
  ('3', '3', '4', '20'), 
  ('3', '3', '5', '20'), 
  ('3', '4', '1', '25'), 
  ('3', '4', '2', '20'), 
  ('3', '4', '3', '15'), 
  ('3', '4', '4', '10'), 
  ('3', '4', '5', '15'), 
  ('3', '5', '1', '15'), 
  ('3', '5', '2', '20'), 
  ('3', '5', '3', '20'), 
  ('3', '5', '4', '30'), 
  ('3', '5', '5', '20'), 
  ('4', '1', '1', '25'), 
  ('4', '1', '2', '20'), 
  ('4', '1', '3', '20'), 
  ('4', '1', '4', '20'), 
  ('4', '1', '5', '20'), 
  ('4', '2', '1', '20'), 
  ('4', '2', '2', '25'), 
  ('4', '2', '3', '25'), 
  ('4', '2', '4', '25'), 
  ('4', '2', '5', '25'), 
  ('4', '3', '1', '20'), 
  ('4', '3', '2', '20'), 
  ('4', '3', '3', '25'), 
  ('4', '3', '4', '25'), 
  ('4', '3', '5', '25'), 
  ('4', '4', '1', '20'), 
  ('4', '4', '2', '20'), 
  ('4', '4', '3', '15'), 
  ('4', '4', '4', '15'), 
  ('4', '4', '5', '15'), 
  ('4', '5', '1', '15'), 
  ('4', '5', '2', '15'), 
  ('4', '5', '3', '15'), 
  ('4', '5', '4', '15'), 
  ('4', '5', '5', '15'), 
  ('5', '1', '1', '20'), 
  ('5', '1', '2', '20'), 
  ('5', '1', '3', '20'), 
  ('5', '1', '4', '15'), 
  ('5', '1', '5', '20'), 
  ('5', '2', '1', '20'), 
  ('5', '2', '2', '20'), 
  ('5', '2', '3', '20'), 
  ('5', '2', '4', '30'), 
  ('5', '2', '5', '20'), 
  ('5', '3', '1', '20'), 
  ('5', '3', '2', '20'), 
  ('5', '3', '3', '20'), 
  ('5', '3', '4', '20'), 
  ('5', '3', '5', '20'), 
  ('5', '4', '1', '20'), 
  ('5', '4', '2', '20'), 
  ('5', '4', '3', '20'), 
  ('5', '4', '4', '20'), 
  ('5', '4', '5', '20'), 
  ('5', '5', '1', '20'), 
  ('5', '5', '2', '20'), 
  ('5', '5', '3', '20'), 
  ('5', '5', '4', '15'), 
  ('5', '5', '5', '20'), 
  ('6', '1', '1', '20'), 
  ('6', '1', '2', '20'), 
  ('6', '1', '3', '20'), 
  ('6', '1', '4', '25'), 
  ('6', '1', '5', '20'), 
  ('6', '2', '1', '20'), 
  ('6', '2', '2', '20'), 
  ('6', '2', '3', '10'), 
  ('6', '2', '4', '5'), 
  ('6', '2', '5', '10'), 
  ('6', '3', '1', '20'), 
  ('6', '3', '2', '20'), 
  ('6', '3', '3', '30'), 
  ('6', '3', '4', '25'), 
  ('6', '3', '5', '30'), 
  ('6', '4', '1', '20'), 
  ('6', '4', '2', '20'), 
  ('6', '4', '3', '20'), 
  ('6', '4', '4', '20'), 
  ('6', '4', '5', '20'), 
  ('6', '5', '1', '20'), 
  ('6', '5', '2', '20'), 
  ('6', '5', '3', '20'), 
  ('6', '5', '4', '25'), 
  ('6', '5', '5', '20'), 
  ('7', '1', '1', '20'), 
  ('7', '1', '2', '20'), 
  ('7', '1', '3', '30'), 
  ('7', '1', '4', '30'), 
  ('7', '1', '5', '30'), 
  ('7', '2', '1', '20'), 
  ('7', '2', '2', '20'), 
  ('7', '2', '3', '30'), 
  ('7', '2', '4', '30'), 
  ('7', '2', '5', '30'), 
  ('7', '3', '1', '20'), 
  ('7', '3', '2', '20'), 
  ('7', '3', '3', '20'), 
  ('7', '3', '4', '20'), 
  ('7', '3', '5', '20'), 
  ('7', '4', '1', '20'), 
  ('7', '4', '2', '20'), 
  ('7', '4', '3', '15'), 
  ('7', '4', '4', '15'), 
  ('7', '4', '5', '15'), 
  ('7', '5', '1', '20'), 
  ('7', '5', '2', '20'), 
  ('7', '5', '3', '5'), 
  ('7', '5', '4', '5'), 
  ('7', '5', '5', '5'), 
  ('8', '1', '1', '20'), 
  ('8', '1', '2', '20'), 
  ('8', '1', '3', '20'), 
  ('8', '1', '4', '25'), 
  ('8', '1', '5', '20'), 
  ('8', '2', '1', '20'), 
  ('8', '2', '2', '20'), 
  ('8', '2', '3', '10'), 
  ('8', '2', '4', '5'), 
  ('8', '2', '5', '10'), 
  ('8', '3', '1', '20'), 
  ('8', '3', '2', '20'), 
  ('8', '3', '3', '30'), 
  ('8', '3', '4', '25'), 
  ('8', '3', '5', '30'), 
  ('8', '4', '1', '20'), 
  ('8', '4', '2', '20'), 
  ('8', '4', '3', '20'), 
  ('8', '4', '4', '20'), 
  ('8', '4', '5', '20'), 
  ('8', '5', '1', '20'), 
  ('8', '5', '2', '20'), 
  ('8', '5', '3', '20'), 
  ('8', '5', '4', '25'), 
  ('8', '5', '5', '20'), 
  ('9', '1', '1', '15'), 
  ('9', '1', '2', '20'), 
  ('9', '1', '3', '20'), 
  ('9', '1', '4', '30'), 
  ('9', '1', '5', '25'), 
  ('9', '2', '1', '25'), 
  ('9', '2', '2', '20'), 
  ('9', '2', '3', '20'), 
  ('9', '2', '4', '30'), 
  ('9', '2', '5', '25'), 
  ('9', '3', '1', '20'), 
  ('9', '3', '2', '20'), 
  ('9', '3', '3', '15'), 
  ('9', '3', '4', '10'), 
  ('9', '3', '5', '10'), 
  ('9', '4', '1', '20'), 
  ('9', '4', '2', '20'), 
  ('9', '4', '3', '25'), 
  ('9', '4', '4', '10'), 
  ('9', '4', '5', '20'), 
  ('9', '5', '1', '20'), 
  ('9', '5', '2', '20'), 
  ('9', '5', '3', '20'), 
  ('9', '5', '4', '20'), 
  ('9', '5', '5', '20');
