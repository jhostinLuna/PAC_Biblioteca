CREATE TABLE Libro (
    id INT AUTO_INCREMENT,
    titulo VARCHAR(255),
    autor VARCHAR(255),
    año_de_publicación INT,
    disponible BOOLEAN,
    PRIMARY KEY (id)
);

CREATE TABLE Lector (
    id INT AUTO_INCREMENT,
    nombre VARCHAR(255),
    apellido VARCHAR(255),
    email VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE Préstamo (
    id INT AUTO_INCREMENT,
    fecha_de_préstamo DATE,
    fecha_de_devolución DATE,
    libro_id INT,
    lector_id INT,
    FOREIGN KEY (libro_id) REFERENCES Libro(id),
    FOREIGN KEY (lector_id) REFERENCES Lector(id),
    PRIMARY KEY (id)
);
