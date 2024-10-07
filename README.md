# README - Alberto Valera - Aplicación Android: Gestión de Tareas en Segundo Plano

## Link al Repositorio GitHub
https://github.com/aalbertovalera48/Taller2AplicacionAlbertoValera.git

## Unidad de Aprendizaje

En esta unidad, el objetivo es profundizar en la **gestión de tareas en segundo plano en Android** mediante técnicas de Programación Dirigida por Eventos. Exploraremos las capacidades de `AsyncTask`, `AsyncTaskLoader`, hilos y servicios para optimizar la experiencia de usuario y el rendimiento de la aplicación. Con estas herramientas, los estudiantes implementarán funcionalidades que aseguren la eficiencia de las operaciones sin bloquear el hilo principal de la interfaz.

### Objetivo General
Desarrollar competencias en la creación y gestión de tareas en segundo plano en aplicaciones Android mediante Programación Dirigida por Eventos.

### Objetivos Específicos
- Comprender el uso de `AsyncTask` y `AsyncTaskLoader` en Android.
- Implementar hilos y servicios para tareas de larga duración.
- Diseñar aplicaciones eficientes y reactivas a las acciones del usuario sin bloquear el hilo principal.
- Realizar pruebas y depuración de aplicaciones Android que integren tareas en segundo plano.

## Enunciado

**Actividad grupal:** Se propone el desarrollo de una aplicación Android que incluya diversas funcionalidades relacionadas con las tareas en segundo plano, abordando las siguientes pantallas:

1. **Pantalla de Inicio**:
   - Un saludo personalizado que cambia según la hora del día (Buenos días, Buenas tardes, Buenas noches).
   - Un botón que lleva a la pantalla de la actividad principal.

2. **Actividad Principal**:
   - Un campo de texto para ingresar el nombre del usuario.
   - Un botón para guardar el nombre ingresado.
   - Un `TextView` que muestra el nombre ingresado.
   - Un botón para iniciar una tarea en segundo plano que simula una operación de red y muestra un progreso.

3. **Pantalla de Configuración**:
   - Opciones para cambiar el color del fondo de la aplicación.
   - Un botón para volver a la pantalla de inicio.

## Estructura del Código

### 1. `MainActivity.kt`
`MainActivity` es el núcleo de la aplicación, donde el usuario puede interactuar con la interfaz principal, ingresar su nombre y navegar entre las diferentes pantallas.

**Descripción:**
- **MainScreen**: Una función composable que presenta la interfaz de usuario principal. Permite al usuario ingresar su nombre y guardar la información ingresada.
- **Snackbar**: Utilizado para notificar al usuario cuando el servicio de segundo plano se inicia.

### 2. `SplashScreenActivity.kt`
Esta actividad muestra una pantalla de bienvenida con un saludo personalizado que cambia según la hora del día, proporcionando una experiencia más atractiva para el usuario.

**Descripción:**
- **SplashScreen**: Función composable que muestra el saludo y un botón que redirige a `MainActivity`.

### 3. `PantallaConfiguracionActivity.kt`
En esta pantalla, los usuarios pueden seleccionar el color de fondo de la aplicación, permitiéndoles personalizar su experiencia de usuario.

**Descripción:**
- **SettingsScreenContent**: Función composable que encapsula la lógica de la pantalla de configuración y gestiona el cambio de color.

### 4. `Servicio.kt`
Esta clase gestiona las tareas de larga duración en segundo plano, utilizando `Service` para simular una operación que se ejecuta en segundo plano sin interferir en la interfaz principal.

**Descripción:**
- **Servicio**: Implementa `Service` para manejar tareas largas de forma asíncrona. Un `Snackbar` informa al usuario cada vez que se inicia el servicio, sin necesidad de un receptor `BroadcastReceiver` adicional.

### 5. `AsyncTaskLoader` y `AsyncTask`
Se emplean para tareas que requieren el uso de datos en segundo plano, sin bloquear la UI. Estos componentes garantizan que las tareas se gestionen de manera eficiente, especialmente en simulaciones de operaciones de red.

**Descripción:**
- **AsyncTask**: Inicia tareas simuladas en segundo plano, mostrando el progreso en la UI mediante un `Snackbar` y manteniendo la interfaz fluida.

### 6. `Persistencia de Datos`
Las funciones `saveBackgroundColor` y `getBackgroundColor` almacenan el color de fondo seleccionado por el usuario en `SharedPreferences`, asegurando que las preferencias se mantengan en cada inicio de sesión.

**Descripción:**
- **saveBackgroundColor**: Guarda el color de fondo seleccionado para recordar la elección del usuario en futuras sesiones.
- **getBackgroundColor**: Recupera el color almacenado, aplicando el color adecuado al inicio de la aplicación.

## Conclusión

La integración de tareas en segundo plano en esta aplicación ha mejorado la experiencia de usuario al mantener una interfaz fluida y eficiente, incluso durante operaciones complejas. Este enfoque permite una mayor interacción y personalización sin afectar la velocidad o respuesta de la aplicación.

## Aprendizajes Clave

- **Optimización de la Experiencia de Usuario**: Al utilizar hilos, `AsyncTask` y `Service`, se asegura una aplicación reactiva, permitiendo al usuario interactuar sin interrupciones en la UI.
- **Gestión de Tareas Asíncronas**: Las tareas en segundo plano son manejadas de manera efectiva, evitando bloqueos en el hilo principal y manteniendo una interfaz responsiva.
- **Persistencia de Preferencias de Usuario**: El almacenamiento de configuraciones personalizadas en `SharedPreferences` asegura que la aplicación recuerde las preferencias del usuario entre sesiones.
- **Desarrollo Colaborativo y Mejora Continua**: La actividad grupal fomenta la revisión y retroalimentación de código, lo que contribuye a mejorar la calidad del proyecto y a desarrollar habilidades de trabajo en equipo.

## Implicaciones Futuras

Este proyecto constituye una base sólida para explorar aplicaciones más avanzadas en Android, integrando APIs, bases de datos y arquitectura de patrones de diseño. Las habilidades adquiridas en la gestión de tareas en segundo plano, combinadas con el enfoque en la experiencia de usuario, permitirán abordar proyectos más complejos y escalables.

## Reflexión Final

Este proyecto destaca la importancia de mantenerse actualizado en las mejores prácticas y herramientas para el desarrollo móvil. La combinación de aprendizaje teórico y práctico ha permitido no solo consolidar competencias técnicas, sino también comprender la importancia de la mejora continua y de un enfoque centrado en el usuario.
