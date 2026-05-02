# POS System

## 📌 Descripción
Sistema de punto de venta (POS) web que permite gestionar usuarios, inventario y ventas en tiempo real, con control de acceso basado en roles.

---

## 🧠 Arquitectura
- Backend: Spring Boot (API REST)
- Frontend: Angular (en desarrollo)
- Base de datos: PostgreSQL

---

## ⚙️ Tecnologías
- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Lombok
- Docker (próximamente)

---

## 📂 Estructura del proyecto
/backend → API REST  
/frontend → Cliente web (Angular)

---

## 🚀 Cómo ejecutar

1. Clonar el repositorio
2. Crear base de datos en PostgreSQL
3. Configurar `application.properties`
4. Ejecutar la aplicación

```bash
./mvnw spring-boot:run
```

## API disponible en:
```bash
http://localhost:8080
```
## Endpoints
### Get /users
Obtiene la lista de usuarios

### Post /users
crea un nuevo usuario

Body:
```json
{
  "name": "Manu",
  "email": "manu@test.com",
  "password": "1234",
  "roleId": 1
}
```
### GET /users/{id}
Obtiene un usuario por ID

#### Response:
```json
{
  "id": 1,
  "name": "Manu",
  "email": "..."
}
```
### Error
{
"message": "User not found"
}

### PUT /users/{id}
Actualiza un usuario existente

#### Body:
```json
{
  "name": "Manu Updated",
  "email": "manu@test.com",
  "password": "12345678",
  "roleId": 1
}
```
#### Error (404)
```json
{
  "id": 1,
  "name": "Manu Updated",
  "email": "manu@test.com"
}
```

### Response 
```json
{
  "id": 1,
  "name": "Manu Updated",
  "email": "manu@test.com"
}
```
### DELETE /users/{id}
Elimina un usuario

#### Response:
204 No Content

#### Error (404):
{
"message": "User not found"
}

## Seguridad
- Contraseñas encriptadas con BCrypt
- Validación de datos con @Valid
- Manejo global de excepciones
  
## Validaciones
- Email con formato válido 
- Password mínimo 8 caracteres 
- Campos obligatorios

## Estado del proyecto
### En desarrollo
- Gestión de usuarios implementada

## Autor

- Manuel Hernández Soriano