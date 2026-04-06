# TecnoCasa Backend 

Backend desarrollado con **Spring Boot**, **JPA/Hibernate** y **MySQL**, encargado de gestionar usuarios, empleados, propiedades y citas.  
Proporciona una API REST consumida por la aplicación móvil desarrollada en React Native.

# Descripcion

El backend ofrece los siguientes servicios para su buen funcionamiento 
- empleados y clientes  
- Gestión de propiedades  
- Gestión de citas  
- Roles: Administrador, Gestor y  
  Cliente  
- Acceso desde frontend móvil  
- Documentación mediante Swagger (si está habilitado)


# Tecnologias aplicadas para backend
- Java 17  
- Spring Boot  
- Spring Web  
- Spring Data JPA  
- MySQL  
- Docker + Docker Compose  
- Lombok  
- Swagger (opcional)

# Instalacion

### Opcion N1 -> Usando el docker

1.- Levantar el servido Docker con su contenedor MYSQL Y PHPMYADMIN

***Comando**
mvn spring-boot:run

### Opcion N2 ->
Crear una base de datos llamada
ProyectoFinal

***Configurar application.properties***
spring.datasource.url=jdbc:mysql://localhost:3306/proyectofinal
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_PASSWORD
spring.jpa.hibernate.ddl-auto=update

*** Metodo de ejecucion ***
mvn spring-boot:run

## Endpoints principales.

  **Usuario/Clientes**
-POST/api/usuarios/login-Login de cliente
-POST/api/usuariosRegistrar-cliente

**Empleados Administrador/Gestor**

POST/api/empleados/login-Login de empleado
GET/api/empleados/{id}-Obtener empleado

**Citas**

POST/api/citas-Crear cita
GET	/api/citas/gestor/{id}-Citas asignadas a un gestor
PUT	/api/citas/{id}/confirmar-Confirmar cita
PUT	/api/citas/{id}/cancelar-Cancelar cita

# Errores que pueden ocurrir


* Cannot connect to MySQL, el docker no esta levantado, solucion docker-compose up -d

404 Not Found ruta incorrecta, solucion revisar los endpoints

500 Internal Error, datos incompletos, revisar el JSON enviado

# Autor
Gabriel David Gelviz Monterrey.


