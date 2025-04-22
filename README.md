# README - Aplicación de Matrices

## Descripción General
Aplicación para manipulación de matrices que implementa una arquitectura cliente-servidor. Permite realizar operaciones matemáticas sobre matrices como la transposición.

## Arquitectura
El proyecto utiliza una arquitectura separada en dos componentes:

1. **Servidor REST** (Spring Boot): Procesa las operaciones matemáticas
2. **Cliente Swing**: Proporciona interfaz gráfica para interactuar con el servidor

## Componentes Principales

### Backend (Spring Boot)
- **MatrizApplication**: Clase principal que inicia el servidor REST
- **Dominio**:
  - `Matriz`: Clase que encapsula los datos de una matriz
- **Servicios**:
  - `MatrizService`: Interfaz que define operaciones sobre matrices
  - `MatrizServiceImpl`: Implementación que realiza las operaciones matemáticas
- **Controladores**:
  - `MatrizController`: API REST con endpoints para manipular matrices
  - `MatrizDto`: Clase para transferencia de datos entre cliente y servidor

### Frontend (Swing)
- **MatrizFrame**: Ventana principal con tabla editable y botones de acción
- **SwingToRestAdapter**: Adaptador que comunica la interfaz con el servidor REST

## Diagrama de Funcionamiento

```
[Interfaz Swing] <--> [SwingToRestAdapter] <--> [API REST] <--> [Servicios] <--> [Dominio]
```

## Instrucciones de Uso

### 1. Iniciar el servidor
```
1. Ejecutar la clase MatrizApplication
2. Esperar hasta ver el mensaje "Started MatrizApplication" en la consola
```

### 2. Iniciar la interfaz gráfica
```
1. Ejecutar la clase MatrizFrame
2. Se abrirá una ventana con una tabla 2x2 predeterminada
```

### 3. Verificar funcionamiento
- Acceder a http://localhost:8080/api/matrices para confirmar que la API está activa
- La interfaz gráfica debería estar conectada automáticamente al servidor

## Operaciones Disponibles

### Desde la interfaz gráfica
1. Editar valores en la tabla
2. Hacer clic en "Transponer" para calcular la matriz transpuesta

### Desde la API REST
- `GET /api/matrices`: Información sobre los endpoints disponibles
- `POST /api/matrices/transponer`: Recibe una matriz en JSON y devuelve su transpuesta
- `POST /api/matrices/imprimir`: Recibe una matriz en JSON y devuelve formato para impresión

## Solución de Problemas

### Puerto ocupado
Si aparece error "Port 8080 already in use":
1. Terminar procesos previos de la aplicación
2. O configurar otro puerto en `application.properties`:
   ```
   server.port=8081
   ```
   (Recordar actualizar también la URL en `SwingToRestAdapter`)

## Requisitos Técnicos
- Java 17+
- Maven
- Spring Boot 3.4.4
- Spring AI 1.0.0-M7

## Principios de Diseño Aplicados
- SRP (Single Responsibility Principle)
- DIP (Dependency Inversion Principle)
- Arquitectura por capas y orientada a servicios
