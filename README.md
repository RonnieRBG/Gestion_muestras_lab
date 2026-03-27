# Gestión de Muestras de Laboratorio

API REST desarrollada en Spring Boot para la gestión de muestras y resultados microbiológicos, 
permitiendo registrar, consultar y filtrar información relevante para análisis de laboratorio.

## Tecnologías

		- Java 21
		- Spring Boot
		- Spring Data JPA (Hibernate)
		- MySQL
		- Spring Security (Basic Auth)
		- Maven

## Estructura

		- controllers → endpoints REST
		- services → lógica de negocio
		- repositories → acceso a base de datos
		- models → entidades (Muestra, Resultado, TipoResultado)
		- config/security → configuración de seguridad

## Base de Datos

Nombre: gestion_muestras_lab

		Configuración en application.properties:
			
		spring.datasource.url=jdbc:mysql://localhost:3306/gestion_muestras_lab
		spring.datasource.username=root
		spring.datasource.password=*****

## Funcionalidades

		### Muestras
		- Crear muestra
		- Listar muestras
		- Buscar por ID
		- Buscar por item
		- Buscar por lote
		- Eliminar muestra

		### Resultados
		- Crear resultado asociado a muestra
		- Listar resultados
		- Buscar por ID
		- Buscar por tipo de resultado
		- Buscar por fecha de inicio
		- Eliminar resultado
		
## Endpoints

			### Muestras
			
			GET /muestras  
			GET /muestras/{id}  
			GET /muestras/item?item=ABC123  
			GET /muestras/lote?lote=L001  
			POST /muestras  
			DELETE /muestras/{id}

### Resultados

			GET /resultados  
			GET /resultados/{id}  
			GET /resultados/tipo?tipoResultado=RAM  
			GET /resultados/fecha?fechaInicio=2026-03-26  
			POST /resultados  
			DELETE /resultados/{id}
			
						## Ejemplo de creación de resultado
			
						POST /resultados
						
						```json
						{
						  "tipoResultado": "RAM",
						  "valor": "<10",
						  "fechaInicio": "2026-03-26",
						  "fechaFin": "2026-03-28",
						  "estado": "FINALIZADO",
						  "muestra": {
						    "id": 1
			  						}
							}
## Ejecución

				1. Clonar repositorio
				2. Crear base de datos en MySQL:
				   CREATE DATABASE gestion_muestras_lab;
				3. Configurar application.properties
				4. Ejecutar la aplicación desde STS o con Maven:
				   mvn spring-boot:run
				5. Probar endpoints con Postman
				
## Mejoras futuras

			- Implementación de autenticación con JWT
			- Validaciones con @Valid
			- Manejo global de excepciones
			- Uso de DTOs para evitar exposición directa de entidades
			- Integración con frontend				