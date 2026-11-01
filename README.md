# Inventiory (versión Thymeleaf)

Sistema web de gestión de stock y ventas para comercios pequeños: productos, clientes, ventas, ajustes masivos de precios e informes.

Es la primera versión de Inventiory, construida en 2024 como aplicación monolítica con Spring Boot y vistas renderizadas en el servidor con Thymeleaf. Las versiones posteriores separaron el backend y el frontend.

## Funcionalidades

**Productos**
- Alta, edición, baja lógica y listado de productos con marca, categoría, precio y stock.
- Stock con decimales, para productos que se venden por peso o medida.
- Actualización de stock.
- Aumentos y descuentos de precio por porcentaje, aplicados a una selección de productos.

**Ventas**
- Registro de ventas con varios productos, con cliente opcional.
- Descuento automático del stock al confirmar la venta.
- Observaciones editables en cada venta.
- Listado y eliminación de ventas, y ventas del día.

**Clientes**
- Alta, edición y listado de clientes.
- Historial de compras de cada cliente.

**Informes**
- Ventas por mes.
- Productos más vendidos.
- Informe de productos.

**Usuarios y notificaciones**
- Inicio de sesión con contraseñas guardadas con hash SHA-256 y sal aleatoria.
- Expiración de sesión: un interceptor redirige al inicio si no hay sesión activa.
- Alta, edición y baja de usuarios, y cambio de contraseña.
- Cada usuario ve sólo sus propios productos y ventas.
- Centro de notificaciones con avisos de stock bajo y de cambio de contraseña.

## Stack

- Java 17
- Spring Boot 3.3 (Web, Data JPA)
- Thymeleaf
- MySQL 8
- Lombok
- Bootstrap (plantilla SB Admin 2) y Chart.js
- Docker

## Estructura

```
inventiory/
├── src/main/java/com/imperialnet/inventiory/
│   ├── config/        interceptor de sesión y configuración web
│   ├── controller/    controladores MVC por módulo
│   ├── entities/      entidades JPA
│   ├── repository/    repositorios Spring Data
│   ├── service/       interfaces y lógica de negocio
│   └── util/          hash de contraseñas
├── src/main/resources/
│   ├── templates/     vistas Thymeleaf
│   └── static/        CSS, JS, imágenes y librerías
├── Dockerfile
└── docker-compose.yml
```

## Ejecutar en local

Requisitos: Java 17, Maven y MySQL corriendo en `localhost:3306`.

```bash
cd inventiory
mvn spring-boot:run
```

La aplicación queda en `http://localhost:5000`. El perfil `local` (por defecto) crea la base `inventiory_thymeleaf` si no existe. El usuario y la clave de MySQL se ajustan en `src/main/resources/application-local.properties`.

## Ejecutar con Docker

```bash
cd inventiory
cp .env.example .env
docker compose up --build
```

El archivo `.env` define `DB_PASSWORD`, que usan tanto el contenedor de MySQL como la aplicación. En el perfil `prod` la conexión se toma de las variables `DB_URL`, `DB_USERNAME` y `DB_PASSWORD`.

## Licencia

Distribuido bajo licencia MIT. Ver [LICENSE](LICENSE).

## Autor

Jonathan Illescas · [GitHub](https://github.com/MichaelIllescas)
