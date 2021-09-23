
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
INSERT INTO EMPLOYEE (
  USER_ID, NAME, SURNAME, EMAIL, PASSWORD, 
  ROLE_ID, OFFICE_ID, APPLICATIONROLE, 
  MENTOR_ID
) 
VALUES 
  -- Admin (1)
  (
    '1', 'Lourdes', 'Bermudo', 'admin@innovation.group', 
    '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 
    '1', '1', 'ADMIN', '1'
  ), 
  -- Manager (2)
  (
    '2', 'Angie', 'Luque', 'angie.luque@innovation.group', 
    '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 
    '1', '1', 'ADMIN', '1'
  ), 
  -- Arch (3-4)
  (
    '3', 'Jose Alberto', 'Coronado', 'jose.coronado@innovation.group', 
    '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 
    '3', '1', 'USER', '1'
  ), 
  (
    '4', 'Rafael', 'Gomez Ramirez', 'rafael.gomez@innovation.group', 
    '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 
    '3', '1', 'USER', '1'
  ), 
  -- Garzas (5-12)
  (
    '5', 'Alvaro', 'Frias', 'alvaro.frias@innovation.group', 
    '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 
    '2', '1', 'USER', '2'
  ), 
  (
    '6', 'Jon', 'Nuño', 'jon.nuño@innovation.group', 
    '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 
    '3', '1', 'USER', '3'
  ), 
  (
    '7', 'Jesus', 'Gil', 'jesus.gil@innovation.group', 
    '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 
    '3', '1', 'USER', '3'
  ), 
  (
    '8', 'Manuel', 'Gonzalez', 'manuel.gonzalez@innovation.group', 
    '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 
    '3', '1', 'USER', '3'
  ), 
  (
    '9', 'Pedro', 'Barranco', 'pedro.barranco@innovation.group', 
    '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 
    '3', '1', 'USER', '1'
  ), 
  (
    '10', 'Joaquin', 'Mohedano', 'joaquin.mohedano@innovation.group', 
    '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 
    '3', '1', 'USER', '1'
  ), 
  (
    '11', 'Elena', 'Salas', 'elena.salas@innovation.group', 
    '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 
    '5', '1', 'USER', '1'
  ), 
  (
    '12', 'Angel', 'Mora', 'angel.mora@innovation.group', 
    '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 
    '5', '1', 'USER', '1'
  ), 
  -- Falcon (13)
  (
    '13', 'Laura', 'Fernandez', 'laura.fernandez@innovation.group', 
    '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 
    '2', '1', 'USER', '2'
  ), 
  (
    '14', 'Luis', 'Rodriguez', 'luis.rodriguez@innovation.group', 
    '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 
    '3', '1', 'USER', '1'
  ), 
  (
    '15', 'David', 'Montero', 'david.montero@innovation.group', 
    '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 
    '3', '1', 'USER', '1'
  ), 
  (
    '16', 'Ines', 'Yepez', 'ines.yepez@innovation.group', 
    '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 
    '5', '1', 'USER', '1'
  ), 
  (
    '17', 'Mairead', 'Osullivan', 'jon.nuño@innovation.group', 
    '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 
    '5', '1', 'USER', '1'
  ), 
  -- Geese (16-17)
  (
    '18', 'Antonio', 'Arteche', 'antonio.arteche@innovation.group', 
    '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 
    '2', '1', 'USER', '2'
  ), 
  (
    '19', 'Rafael', 'Granados', 'rafael.granados@innovation.group', 
    '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 
    '3', '1', 'USER', '1'
  ), 
  (
    '20', 'Sergio', 'Caballero', 'sergio.caballero@innovation.group', 
    '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 
    '3', '1', 'USER', '1'
  ), 
  (
    '21', 'Daniel', 'Lagarda', 'daniel.lagarda@innovation.group', 
    '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 
    '3', '1', 'USER', '1'
  ), 
  (
    '22', 'Rafael', 'Saez', 'rafael.saez@innovation.group', 
    '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 
    '5', '1', 'USER', '1'
  ), 
  --Owls (18-20)
  (
    '23', 'Antonio', 'Casado', 'antonio.casado@innovation.group', 
    '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 
    '3', '1', 'USER', '1'
  ), 
  (
    '24', 'Juan Antonio', 'Ruz', 'juanantonio.ruz@innovation.group', 
    '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 
    '3', '1', 'USER', '1'
  ), 
  --Phoenix
  (
    '25', 'Angel', 'Calvo', 'angel.calvo@innovation.group', 
    '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 
    '3', '1', 'USER', '3'
  ), 
  (
    '26', 'Ivan', 'Martin', 'ivan.martin@innovation.group', 
    '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 
    '3', '1', 'USER', '1'
  ), 
  (
    '27', 'Jose Francisco', 'Ibarra', 
    'josefrancisco.ibarralozano@Innovation.Group', 
    '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 
    '3', '1', 'USER', '1'
  ), 
  (
    '28', 'David', 'Sanchez', 'david.sanchez@innovation.group', 
    '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 
    '4', '1', 'USER', '1'
  ), 
  (
    '29', 'Eric', 'Ortega', 'eric.ortega@innovation.group', 
    '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 
    '5', '1', 'USER', '1'
  ), 
  (
    '30', 'Iñaki', 'De la haba', 'inaki.delahaba@innovation.group', 
    '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 
    '5', '1', 'USER', '1'
  ), 
  --Producto (31-32)
  (
    '31', 'Xiomara', 'Montilla', '1iomara.montilla@innovation.group', 
    '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 
    '3', '1', 'USER', '1'
  ), 
  (
    '32', 'Alejandro', 'Molina', 'alejandro.molina@innovation.group', 
    '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 
    '3', '1', 'USER', '1'
  ), 
  (
    '33', 'Natalia', 'Gimenez', 'natalia.gimenez@innovation.group', 
    '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 
    '3', '1', 'USER', '1'
  );
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
  ('3', 'Motivación y logros'), 
  ('4', 'Cultura Corporativa / Orgullo de pertenencia'), 
  ('5', 'Organización personal'), 
  ('6', 'Gestión'), 
  ('7', 'Relación/Comunicación'), 
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
    '2', '0', '3', '1', 'Evolución y desarrollo profesional (Master, cursos, autodidacta…)'
  ), 
  (
    '3', '0', '4', '1', 'Cumple con las entregas en tiempo'
  ), 
  (
    '4', '0', '5', '1', 'Aporta soluciones valiosas ante dificultades'
  ), 
  (
    '5', '1', '1', '1', 'Actitud ante decisiones y adaptación al cambio'
  ), 
  (
    '6', '1', '2', '1', 'Comparte el conocimiento con los compañeros que lo necesitan'
  ), 
  (
    '7', '1', '3', '1', 'Contribución a un ambiente de colaboración y confianza en su grupo de trabajo - team player'
  ), 
  (
    '8', '1', '4', '1', 'Contribuye a la gestión y organización del trabajo del equipo'
  ), 
  (
    '9', '1', '5', '1', 'Habilidades de liderazgo demostradas a lo largo del año'
  ), 
  (
    '10', '2', '1', '1', 'Desarrollo de las funciones inherentes al cargo'
  ), 
  (
    '11', '2', '2', '1', 'Contribuye a cumplir los objetivos marcados en el sprint'
  ), 
  (
    '12', '2', '3', '1', 'Orientación a la consecución de buenos resultados'
  ), 
  (
    '13', '2', '4', '1', 'Conocimientos técnicos relativos al role que desempeña'
  ), 
  (
    '14', '2', '5', '1', 'Flexibilidad y conocimiento de la metodología ágil'
  ), 
  (
    '15', '3', '1', '1', 'Capacidad de superación profesional y mejora continua'
  ), 
  (
    '16', '3', '2', '1', 'Proactividad e iniciativa'
  ), 
  (
    '17', '3', '3', '1', 'Aprovechamiento de mentoring'
  ), 
  (
    '18', '3', '4', '1', 'Implicación y motivación diaria '
  ), 
  (
    '19', '3', '5', '1', 'Capacidad de superar los desafíos planteados a lo largo del año'
  ), 
  (
    '20', '4', '1', '1', 'Conocimiento del negocio en su conjunto (Compañía, departamentos, equipos, producto…)'
  ), 
  (
    '21', '4', '2', '1', 'Participación en actividades organizadas por IG (team building, charlas, clasés de inglés…)'
  ), 
  (
    '22', '4', '3', '1', 'Cumplimiento de políticas, normas, procedimientos y buenas prácticas propuestas'
  ), 
  (
    '23', '4', '4', '1', 'Participación en reclutamiento (proponiendo candidatos, compartiendo ofertas,... )'
  ), 
  (
    '24', '4', '5', '1', 'Contribución a la Imagen de Compañía (compartiendo eventos, noticias, kudos,... )'
  ), 
  (
    '25', '5', '1', '1', 'Capacidad de ser autosuficiente para llevar a cabo sus tareas'
  ), 
  (
    '26', '5', '2', '1', 'Gestión del tiempo y de los plazos de entrega'
  ), 
  (
    '27', '5', '3', '1', 'Prepara las reuniones y las planifica con tiempo'
  ), 
  (
    '28', '5', '4', '1', 'Capacidad de asumir más trabajo del esperado'
  ), 
  (
    '29', '5', '5', '1', 'Gestión del estrés y la responsabilidad'
  ), 
  (
    '30', '6', '1', '1', 'Capacidad de gestión/resolución de conflictos'
  ), 
  (
    '31', '6', '2', '1', 'Gestión de equipos'
  ), 
  (
    '32', '6', '3', '1', 'Capacidad para transmitir información importante al equipo'
  ), 
  (
    '33', '6', '4', '1', 'Capacidad de toma de decisiones'
  ), 
  (
    '34', '6', '5', '1', 'Gestión del cambio'
  ), 
  (
    '35', '7', '1', '1', 'Relación con responsable directo'
  ), 
  (
    '36', '7', '2', '1', 'Relación con iguales / equipo'
  ), 
  (
    '37', '7', '3', '1', 'Relación con subordinados/mentorizados y/o con su mentor'
  ), 
  (
    '38', '7', '4', '1', 'Relación con otros equiposdepartamentos / clientes / negocio'
  ), 
  (
    '39', '7', '5', '1', 'Comunicación en inglés'
  ), 
  (
    '40', '8', '1', '1', 'Aporte de valor técnico a la Compañía'
  ), 
  (
    '41', '8', '2', '1', 'Impacto en el ambiente laboral diario'
  ), 
  (
    '42', '8', '3', '1', 'Contribución a la comunicación entre departamentos'
  ), 
  (
    '43', '8', '4', '1', 'El impacto en el comportamiento de los compañeros es… (Role Model)'
  ), 
  (
    '44', '8', '5', '1', 'Nivel de motivación general con Innovation Group (bajo tu opinión)'
  ), 
  (
    '45', '9', '1', '1', 'Capacidad de superación / rapidez de aprendizaje y aplicabilidad de lo aprendido'
  ), 
  (
    '46', '9', '2', '1', 'Capacidad profesional para adquirir, procesar y desarrollar información para el equipo'
  ), 
  (
    '47', '9', '3', '1', 'Capacidad de delegación'
  ), 
  (
    '48', '9', '4', '1', 'Capacidad analítica'
  ), 
  (
    '49', '9', '5', '1', 'Inteligencia emocional y empatía hacía los compañeros'
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
  -- Dependiendo del rol, estos pesos serán para un criterio u otro
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
