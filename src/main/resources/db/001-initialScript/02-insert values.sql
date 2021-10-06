
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
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID)
VALUES(1, N'jlgP/6YLVVps6l/cdfb0Rg==', N'eUw4L0vFtZ8APnfEk15cNg==', N'EiOt4UMFxvszqeXD7QxXG7hEFXOEXJv36ysr9J5BSP4=', N'sDoBUXW+M4Hp7UYQiC8+bQ==', 1, 1, N'ADMIN', 1);
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID)
VALUES(2, N'3vh0LboekDAXIIXp7RY5GA==', N'JLFc3HyJtGoXToKEbnZ4CQ==', N'ZR8bKddn+mqiPdaB2PbSHRsxWCIMXKMbNHkbh99rozs=', N'sDoBUXW+M4Hp7UYQiC8+bQ==', 1, 1, N'ADMIN', 1);
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID)
VALUES(3, N'JS5Cxo/+htOx9lVsqfvTpA==', N'IuxmwHJ0hMrOygzNkYdiEA==', N'/HlHo4YQCcCc0/pXQZ7UKyetrnuaNi513R+wkYSzfNI=', N'sDoBUXW+M4Hp7UYQiC8+bQ==', 3, 1, N'USER', 1);
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID)
VALUES(4, N'2JTmYt3RYqo7vkWo33uKtg==', N'6qslbFfSlq2SJtb6RN/jRw==', N'5NCcupMeSTkBPByQM1aaFSWe955vwlf2f4/RUbvdb34=', N'sDoBUXW+M4Hp7UYQiC8+bQ==', 3, 1, N'USER', 1);
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID)
VALUES(5, N'kwVUyDqQBwnZdHLaOI4PGw==', N'1nm0tdcyIWIU40JPzg2UKw==', N'zpkMuUsiUeJeqBd46emYqyWe955vwlf2f4/RUbvdb34=', N'sDoBUXW+M4Hp7UYQiC8+bQ==', 2, 1, N'USER', 2);
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID)
VALUES(6, N'Z3BvnBHOV1NcEHQygxvDkg==', N'w+W+1zkqYQo/cX970gRASA==', N'hcc13x8T827bTr0W1q0xOgXXY3gG3r9B+1oPbgh7U8g=', N'sDoBUXW+M4Hp7UYQiC8+bQ==', 3, 1, N'USER', 3);
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID)
VALUES(7, N'jdeb0f+0Y87q+6By89Fa+A==', N'mDvZ1nghEhFnu2Z3ENQk4w==', N'0pJ5TK107GpAHIW+PmhLJQXXY3gG3r9B+1oPbgh7U8g=', N'sDoBUXW+M4Hp7UYQiC8+bQ==', 3, 1, N'USER', 3);
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID)
VALUES(8, N'T30NuyuzFkBwyZTvYJEaTw==', N'dcE1sbLLXEdhIkQVj03oFQ==', N'kI0Ax1potwyOihzj7JWq89bIe2lj8uohBxYHCFrCpwHrY9inV6M7IbsmOLXvCbG6', N'sDoBUXW+M4Hp7UYQiC8+bQ==', 3, 1, N'USER', 5);
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID)
VALUES(9, N'GTiDMg/n7gMQED+EonjBRQ==', N'23mReeF0JV6wJ8DRam2MAA==', N'cfTtQIslmoR1IEnuR5rrmaCI1wGPeVirUponaccj7bY=', N'sDoBUXW+M4Hp7UYQiC8+bQ==', 3, 1, N'USER', 1);
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID)
VALUES(10, N'cd2MMe6+ZI5QB+baVjbXRA==', N'kLt+EGktk46SyNODjoo3jQ==', N'dxcqqe+Wt8WkqTOgF8uDRcfxc8Gerz9R1gmnlBlhqM8yPAm0MFjiSXmlC65xos6a', N'sDoBUXW+M4Hp7UYQiC8+bQ==', 3, 1, N'USER', 1);
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID)
VALUES(11, N'C5VKTGVS2crWDFG9vz/qRg==', N'IFEaRt8YzvDa64gVnDlBoQ==', N'yKCAsmTOzP/HlyWl7LcWwxsxWCIMXKMbNHkbh99rozs=', N'sDoBUXW+M4Hp7UYQiC8+bQ==', 5, 1, N'USER', 1);
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID)
VALUES(12, N'GIFxarEtUe6Es+11sAq55w==', N'9/gq2NfAWHfa35bE6sjg1g==', N'L8p+4QsELmC2Y2HAn0L3qjT5PJDDj3B+c8CXGtHv+oM=', N'sDoBUXW+M4Hp7UYQiC8+bQ==', 5, 1, N'USER', 1);
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID)
VALUES(13, N'f8RwV7wu6IJgfusEOxZJKA==', N'2GwkehJs1b3BJ2xPGQP5xw==', N'31JkDYWE0JT3L5QCtsgFudbIe2lj8uohBxYHCFrCpwHrY9inV6M7IbsmOLXvCbG6', N'sDoBUXW+M4Hp7UYQiC8+bQ==', 2, 1, N'USER', 2);
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID)
VALUES(14, N'b4qKRx4wf0lus0WpP+DY0w==', N'Bg4qCSvLowqLq/aWRFZz8Q==', N'SBRm+y09xTKZs55tKYNySaCI1wGPeVirUponaccj7bY=', N'sDoBUXW+M4Hp7UYQiC8+bQ==', 3, 1, N'ADMIN', 1);
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID)
VALUES(15, N'PrTC/CIZvIoFu2qbzVIrPQ==', N'WH3jrYGWpf+uRLN+dVwHnw==', N'5DDqPYAaV/FmSLuBT6+hcyetrnuaNi513R+wkYSzfNI=', N'sDoBUXW+M4Hp7UYQiC8+bQ==', 3, 1, N'USER', 1);
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID)
VALUES(16, N'nZ3nBgzijHZ8vwc2wNdhTg==', N'V03aXznd3XaDUATgxBmYVw==', N'jkTG7fS21hHCHGpkYJjMGTT5PJDDj3B+c8CXGtHv+oM=', N'sDoBUXW+M4Hp7UYQiC8+bQ==', 5, 1, N'USER', 1);
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID)
VALUES(17, N'D9vmE4Rgiia3eJhuOAjF7g==', N'm35e5f4mJSho5sEe2eBzSQ==', N'hcc13x8T827bTr0W1q0xOgXXY3gG3r9B+1oPbgh7U8g=', N'sDoBUXW+M4Hp7UYQiC8+bQ==', 5, 1, N'USER', 1);
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID)
VALUES(18, N'YGvEe/lgh5inWFWTHmcmCA==', N'es3mWmAHxXy8hEJ7oK7z7Q==', N'tQ6ET9w07jJuNmpN5wuds9bIe2lj8uohBxYHCFrCpwHrY9inV6M7IbsmOLXvCbG6', N'sDoBUXW+M4Hp7UYQiC8+bQ==', 2, 1, N'USER', 2);
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID)
VALUES(19, N'2JTmYt3RYqo7vkWo33uKtg==', N'c27ElRzpMguL4ApaqtGjLg==', N'Ux+CY4L4VIpIINyGhIXl19bIe2lj8uohBxYHCFrCpwHrY9inV6M7IbsmOLXvCbG6', N'sDoBUXW+M4Hp7UYQiC8+bQ==', 3, 1, N'USER', 1);
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID)
VALUES(20, N'Ymqx8PTDpU6+arnf+naSjw==', N'USIwa/iau7S3noxyqHMLjQ==', N'uC7JyT4ryGzNdESp5ysvnMfxc8Gerz9R1gmnlBlhqM8yPAm0MFjiSXmlC65xos6a', N'sDoBUXW+M4Hp7UYQiC8+bQ==', 3, 1, N'USER', 1);
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID)
VALUES(21, N'XS9aA8Crfdxe6rwjjW7jnw==', N'IGxEiS/t4osFrnVLJdKdAg==', N'NKp5BhRpjU/Muz1WxwhLPKCI1wGPeVirUponaccj7bY=', N'sDoBUXW+M4Hp7UYQiC8+bQ==', 3, 1, N'USER', 1);
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID)
VALUES(22, N'2JTmYt3RYqo7vkWo33uKtg==', N'qF5B+AsYGAUrWbLF1LHsVg==', N'J6S9vOFZOGzM4EFnsQx90RsxWCIMXKMbNHkbh99rozs=', N'sDoBUXW+M4Hp7UYQiC8+bQ==', 5, 1, N'USER', 1);
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID)
VALUES(23, N'YGvEe/lgh5inWFWTHmcmCA==', N'EZ0KK6heyYm9sbSCMnejlQ==', N'kff2x60u30oE0wPTxGoK5KCI1wGPeVirUponaccj7bY=', N'sDoBUXW+M4Hp7UYQiC8+bQ==', 3, 1, N'USER', 1);
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID)
VALUES(24, N'7soZ7bWFTMjgC4FkqGouBw==', N'2aEBv/riCv6oAj5fKs3rIQ==', N'M3TPhIO8lRX6BBvHIOBMPdbIe2lj8uohBxYHCFrCpwHrY9inV6M7IbsmOLXvCbG6', N'sDoBUXW+M4Hp7UYQiC8+bQ==', 3, 1, N'USER', 1);
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID)
VALUES(25, N'GIFxarEtUe6Es+11sAq55w==', N'44twmRcw8omRXJGuTAJXcA==', N'gklGSYe4hDRJSzv87XT9XRsxWCIMXKMbNHkbh99rozs=', N'sDoBUXW+M4Hp7UYQiC8+bQ==', 3, 1, N'USER', 3);
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID)
VALUES(26, N'HljmHUOh4enkxGQtMjOvfg==', N'sIcpX3x+uY1LnGRtDKUPXg==', N'21qlRGRKCr66jn+tDroAuxsxWCIMXKMbNHkbh99rozs=', N'sDoBUXW+M4Hp7UYQiC8+bQ==', 3, 1, N'USER', 1);
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID)
VALUES(27, N'6A30cfN9W/9y2g5tQGHoyQ==', N'EmrsXZ+8H1/OFLrEXR9YkA==', N'BYFmfMIB7Fkm47K+iiTHnoNxHzXrgycDZ4IisRf9jObVOK32TLT8orm8nz6fBwfy', N'sDoBUXW+M4Hp7UYQiC8+bQ==', 3, 1, N'USER', 1);
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID)
VALUES(28, N'PrTC/CIZvIoFu2qbzVIrPQ==', N'Hy0T9ArpYoxvvZ8eLqXwTw==', N'Y6NMh/7iRGx6MPny8YCYkietrnuaNi513R+wkYSzfNI=', N'sDoBUXW+M4Hp7UYQiC8+bQ==', 4, 1, N'USER', 1);
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID)
VALUES(29, N'FRs+euakUKPtAoo6UmUTgg==', N'V0dS/1ObML4WnLSyIxyV3w==', N'YR3Fu4QD0GjeLhxjlWYlMxsxWCIMXKMbNHkbh99rozs=', N'sDoBUXW+M4Hp7UYQiC8+bQ==', 5, 1, N'USER', 1);
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID)
VALUES(30, N'Eo2Q281uuSWA0NXQkGig5A==', N'mDMl/0lKBbm1o/5p0zc/LQ==', N'fLR3j2MQNufFZsKXxcSdDaCI1wGPeVirUponaccj7bY=', N'sDoBUXW+M4Hp7UYQiC8+bQ==', 5, 1, N'USER', 1);
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID)
VALUES(31, N'LMRR2lerwHojMgxK5z2JmA==', N'x7cp5YUbynnKQK13JI9L6w==', N'yrP2n5sdBz9CXEgcYIDXesfxc8Gerz9R1gmnlBlhqM8yPAm0MFjiSXmlC65xos6a', N'sDoBUXW+M4Hp7UYQiC8+bQ==', 3, 1, N'USER', 1);
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID)
VALUES(32, N'kSTZ/PTtIgMkgtGw+V9PcA==', N'WXsMo+vOTR+V1aIS+hhROA==', N'QFW5U01NADeS1fGwbS/CHMfxc8Gerz9R1gmnlBlhqM8yPAm0MFjiSXmlC65xos6a', N'sDoBUXW+M4Hp7UYQiC8+bQ==', 3, 1, N'USER', 1);
INSERT INTO EMPLOYEE
(USER_ID, NAME, SURNAME, EMAIL, PASSWORD, ROLE_ID, OFFICE_ID, APPLICATIONROLE, MENTOR_ID)
VALUES(33, N'kvG0+er274fkzSiRH7JYog==', N'KKzvNTvBWNFT1yoyuDK3lg==', N'1n5kMas7WmSVHOgE52qLE9bIe2lj8uohBxYHCFrCpwHrY9inV6M7IbsmOLXvCbG6', N'sDoBUXW+M4Hp7UYQiC8+bQ==', 3, 1, N'USER', 1);

  
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
