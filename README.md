# Restaurante Catys - Sistema de Gestión de Inventario y Ventas

Este proyecto es una aplicación web empresarial diseñada para la gestión integral de un restaurante. Permite controlar el inventario de productos, registrar ventas en tiempo real, gestionar categorías y visualizar el cierre de caja diario mediante analítica de datos.

## Arquitectura del Proyecto

El sistema está desarrollado bajo una arquitectura de capas para garantizar la escalabilidad y mantenibilidad del código:

* **Backend**: Desarrollado con Java, utilizando el framework Spring Boot. Se implementa una separación de responsabilidades mediante controladores, servicios y repositorios.
* **Frontend**: Interfaz web dinámica construida con HTML5, Bootstrap 5 y JavaScript. Consume servicios REST expuestos por el backend.
* **Base de Datos**: Sistema de gestión de bases de datos relacional SQL Server.
* **Analítica**: Implementación de Chart.js para la visualización de datos de ventas en tiempo real.

## Características Principales

* **Control de Inventario**: Registro, edición y eliminación de productos con validación de stock en tiempo real.
* **Sistema de Ventas**: Registro automatizado de transacciones con descuento automático de inventario y generación de tickets.
* **Gestión de Categorías**: Administración dinámica de tipos de productos con integración vía menús desplegables.
* **Cierre de Caja**: Visualización gráfica del desempeño de ventas por fecha mediante reportes interactivos.
* **Seguridad**: Autenticación de usuarios para proteger el acceso a las funciones administrativas.

## Tecnologías Utilizadas

* Java 21 / Spring Boot 3.4.2
* Spring Data JPA / Hibernate
* Bootstrap 5
* Chart.js
* SQL Server
* Maven

## Instalación y Configuración

1. **Requisitos Previos**:
    * Tener instalado Java JDK 21 o superior.
    * Tener configurado un servidor SQL Server con las tablas correspondientes.
    * Maven instalado en el entorno de desarrollo.

2. **Configuración de Base de Datos**:
    * Asegurarse de que el archivo `application.properties` en `backend/src/main/resources` contenga las credenciales correctas de acceso a su instancia de SQL Server.

3. **Ejecución del Backend**:
    * Navegar a la carpeta `backend` mediante la terminal.
    * Ejecutar el comando: `mvn spring-boot:run`.

4. **Ejecución del Frontend**:
    * Abrir el archivo `frontend/index.html` en un navegador web compatible.

## Estructura de Capas

El sistema sigue el patrón de arquitectura de capas (n-tier architecture), lo cual permite una clara separación de responsabilidades y mejora la mantenibilidad del código.


1. **Capa de Controlador (Controller)**: Expone los endpoints REST y maneja la comunicación con el frontend.
2. **Capa de Servicio (Service)**: Contiene la lógica de negocio, validaciones y reglas del sistema (ej. cálculo de totales, gestión de inventario).
3. **Capa de Repositorio (Repository)**: Encargada de la persistencia de datos y comunicación directa con SQL Server mediante Spring Data JPA.
4. **Capa de Modelo (Model)**: Define las entidades y estructuras de datos del sistema.