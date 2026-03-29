# 🧪 Gestión de Muestras de Laboratorio

API REST desarrollada con **Spring Boot** para la gestión de muestras y resultados microbiológicos, enfocada en laboratorios de alimentos.
Permite registrar muestras, asociar resultados y aplicar reglas de negocio reales sobre estados, valores y fechas.

---

## 🚀 Tecnologías utilizadas

* Java 21
* Spring Boot
* Spring Data JPA (Hibernate)
* MySQL
* Spring Security (Basic Auth)
* Maven

---

## 🧱 Arquitectura

El proyecto sigue una arquitectura en capas:

* **controllers** → exposición de endpoints REST
* **services** → lógica de negocio
* **repositories** → acceso a base de datos
* **models** → entidades (`Muestra`, `Resultado`, `TipoResultado`, `TipoEstado`)
* **exceptions** → manejo global de errores
* **config/security** → configuración de seguridad

---

## 🗄️ Base de datos

Nombre de la base de datos:

```sql
gestion_muestras_lab
```

Configuración (`application.properties`):

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/gestion_muestras_lab
spring.datasource.username=root
spring.datasource.password=*****
spring.jpa.hibernate.ddl-auto=update
```

---

## ⚙️ Funcionalidades

### 📦 Muestras

* Crear muestra
* Listar muestras
* Buscar por ID
* Buscar por item
* Buscar por lote
* Eliminar muestra

---

### 🔬 Resultados

* Crear resultado asociado a una muestra
* Listar resultados
* Buscar por ID
* Buscar por tipo de resultado
* Buscar por fecha de inicio
* Eliminar resultado

---

## 🧠 Reglas de negocio implementadas

### Resultado

* El campo `estado` es obligatorio
* El estado solo puede ser:

  * `PENDIENTE`
  * `FINALIZADO`
* Si el estado es `PENDIENTE`:

  * el campo `valor` debe estar vacío
* Si el estado es `FINALIZADO`:

  * el campo `valor` es obligatorio
* `fechaInicio` es obligatoria
* `fechaFin` no puede ser menor que `fechaInicio`

---

## 🔐 Seguridad

La API utiliza **Spring Security con autenticación básica (Basic Auth)**.

Para probar en Postman:

* seleccionar **Authorization → Basic Auth**
* ingresar usuario y contraseña configurados

---

## 📡 Endpoints

### 📦 Muestras

```
GET    /muestras
GET    /muestras/{id}
GET    /muestras/item?item=ABC123
GET    /muestras/lote?lote=L001
POST   /muestras
DELETE /muestras/{id}
```

---

### 🔬 Resultados

```
GET    /resultados
GET    /resultados/{id}
GET    /resultados/tipoResultado?tipoResultado=RAM
GET    /resultados/fechaInicio?fechaInicio=2026-03-26
POST   /resultados
DELETE /resultados/{id}
```

---

## 📌 Ejemplo de creación de resultado

### POST `/resultados`

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
```

---

## ⚠️ Manejo de errores

Se implementa un manejo global de excepciones mediante `@RestControllerAdvice`.

### Tipos de errores:

#### 🔸 Validación (400)

```json
{
  "mensaje": "El valor es obligatorio si el estado es FINALIZADO",
  "timestamp": "...",
  "status": 400
}
```

#### 🔸 Recurso no encontrado (404)

```json
{
  "mensaje": "Resultado no encontrado",
  "timestamp": "...",
  "status": 404
}
```

---

## ▶️ Ejecución

1. Clonar el repositorio
2. Crear la base de datos:

```sql
CREATE DATABASE gestion_muestras_lab;
```

3. Configurar `application.properties`
4. Ejecutar:

```bash
mvn spring-boot:run
```

5. Probar endpoints con Postman

---

## 📈 Estado del proyecto

✔ CRUD completo de muestras y resultados
✔ Validaciones de negocio implementadas
✔ Manejo de excepciones global
✔ Seguridad básica con Spring Security
✔ API funcional y testeada con Postman

---

## 🔮 Mejoras futuras

* Implementación de autenticación con JWT
* Uso de DTOs
* Validaciones con `@Valid`
* Documentación con Swagger/OpenAPI
* Integración con frontend
* Control de duplicidad de resultados por muestra

---

## 👨‍💻 Autor

Proyecto desarrollado como práctica backend orientada a la gestión de muestras microbiológicas en laboratorio de alimentos.
