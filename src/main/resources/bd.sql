--DROP DATABASE IF EXISTS otrs;
CREATE DATABASE IF NOT EXISTS otrs;
USE otrs;

SELECT 'CREATING DATABASE STRUCTURE' as 'INFO';

/*!50503 set default_storage_engine = InnoDB */;
/*!50503 select CONCAT('storage engine: ', @@default_storage_engine) as INFO */;

 CREATE TABLE sysman_contratado (
    id_cliente   INT             NOT NULL,
    ip           VARCHAR(20)     NOT NULL,
    fecha_inicio DATE            NOT NULL,
    fecha_final  DATE            NOT NULL,
    h_presencial INT             NOT NULL DEFAULT 0,
    h_virtual    INT             NOT NULL DEFAULT 0,
    h_ajuste     INT             NOT NULL DEFAULT 0,
    transaccion_tol  INT         NOT NULL DEFAULT 0,
    estado       INT             NOT NULL DEFAULT -1,
    PRIMARY KEY (id_cliente, ip)
);
flush /*!50503 binary */ logs;
