# Sistema CRUD de Parqueo 🚗

Este es un proyecto web desarrollado en Java para gestionar un sistema de parqueo, con funcionalidades CRUD (Crear, Leer, Actualizar y Eliminar) para **clientes** y **vehículos**. El proyecto utiliza **Java Servlets**, **JSP**, y **MySQL** como base de datos. 
Está diseñado para ser escalable, portátil y fácil de mantener.

## 📋 Características
- **CRUD de Clientes:** Gestión completa de los clientes, incluyendo:
  - Crear un nuevo cliente.
  - Ver todos los clientes.
  - Actualizar información del cliente.
  - Eliminar clientes.
  
- **CRUD de Vehículos:** Gestión completa de los vehículos asociados a los clientes, incluyendo:
  - Crear un nuevo vehículo.
  - Ver todos los vehículos.
  - Actualizar información del vehículo.
  - Eliminar vehículos.

- **Interfaz JSP:** Renderización dinámica de datos desde los servlets.
- **Conexión a MySQL:** Almacenamiento de datos persistente utilizando una base de datos relacional.
- **Fácil portabilidad:** Construido con **Maven** para una gestión sencilla de dependencias y despliegue.

---

## 🛠️ Tecnologías Utilizadas
- **Lenguaje:** Java
- **Frameworks:** Servlets y JSP
- **Base de Datos:** MySQL
- **Gestión de Dependencias:** Maven
- **IDE:** NetBeans
- **Servidor de Aplicaciones:** Apache Tomcat

---

## 🚀 Configuración del Proyecto

### Requisitos Previos
1. **Java JDK 8 o superior**.
2. **Apache Tomcat 9 o superior** (o cualquier servidor compatible con Java EE).
3. **MySQL 5.7 o superior**.
4. **NetBeans** (opcional, puedes usar cualquier IDE compatible con Maven).
5. **Maven** (si deseas construir el proyecto desde la terminal).



### Configuración de la Base de Datos
1. Crea una base de datos en MySQL llamada `parqueo`.
2. Ejecuta el siguiente script SQL para crear las tablas necesarias:
   ```sql
   CREATE TABLE clientes (
       id INT AUTO_INCREMENT PRIMARY KEY,
       nombre VARCHAR(100) NOT NULL,
       cedula VARCHAR(20) NOT NULL UNIQUE,
       telefono VARCHAR(15),
       email VARCHAR(100) UNIQUE
   );

   CREATE TABLE vehiculos (
       id INT AUTO_INCREMENT PRIMARY KEY,
       tipo VARCHAR(50) NOT NULL,
       placa VARCHAR(20) NOT NULL UNIQUE,
       modelo VARCHAR(50),
       marca VARCHAR(50),
       cliente_id INT,
       FOREIGN KEY (cliente_id) REFERENCES clientes(id) ON DELETE SET NULL
   );


## 📦 Cómo Ejecutar el Proyecto

# Opción 1: Desde NetBeans

Abre el proyecto en NetBeans.
Configura Apache Tomcat como servidor.

Haz clic derecho en el proyecto y selecciona Run.

Accede a la aplicación en tu navegador en http://localhost:8080/ParqueoCRUD.

# Opción 2: Desde la Terminal con Maven
Navega a la carpeta del proyecto.
Ejecuta:
bash
mvn clean package

Esto generará un archivo .war en la carpeta target/.
Despliega el archivo .war en tu servidor Apache Tomcat.
Accede a la aplicación en tu navegador en http://localhost:8080/ParqueoCRUD.

## 🖥️ Uso de la Aplicación
# CRUD de Clientes
Accede a http://localhost:8080/ParqueoCRUD/clientes.

# Realiza operaciones de:
Crear un cliente.
Ver todos los clientes.
Editar un cliente.
Eliminar un cliente.
CRUD de Vehículos
Accede a http://localhost:8080/ParqueoCRUD/vehiculos.

# Realiza operaciones de:
Crear un vehículo.
Ver todos los vehículos.
Editar un vehículo.
Eliminar un vehículo.

## ✨ Mejora y Personalización
Autenticación: Agregar un sistema de login para clientes o administradores.
Reportes: Generar reportes de los vehículos registrados.
Estilo: Mejorar la interfaz con CSS o frameworks como Bootstrap


   
