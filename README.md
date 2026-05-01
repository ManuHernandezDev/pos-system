# POS System

## 📌 Descripción
Sistema de punto de venta web para gestión de inventario y ventas en tiempo real.

## 🧠 Arquitectura
- Backend: Spring Boot
- Frontend: Angular (en progreso)
- Base de datos: PostgreSQL

## ⚙️ Tecnologías
- Java 17
- Spring Boot
- PostgreSQL
- Docker (futuro)

## 📂 Estructura
/backend → API REST  
/frontend → interfaz de usuario

## 🚀 Cómo ejecutar
1. Clonar repositorio
2. Configurar base de datos PostgreSQL
3. Ejecutar proyecto Spring Boot
4. Acceder en: http://localhost:8080

## 📡 Endpoints
### GET /users
Obtiene todos los usuarios

### POST /users
Crea un nuevo usuario

Body:
```json
{
  "name": "Manu",
  "email": "manu@test.com",
  "password": "1234"
}