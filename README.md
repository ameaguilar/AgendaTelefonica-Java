# Agenda Telefónica — Hackatón Java

> Proyecto de gestión de agenda de contactos desarrollado en Java con interfaz por consola.
> **Equipo 2** — Hackatón de Java

![Java](https://img.shields.io/badge/Java-8%2B-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![Status](https://img.shields.io/badge/Status-Completado-brightgreen?style=flat-square)
![Version](https://img.shields.io/badge/Version-1.0.0-blue?style=flat-square)

---

## 📋 Tabla de contenidos
- [Descripción del proyecto](#-descripción-del-proyecto)
- [Funcionalidades](#-funcionalidades)
- [Estructura del proyecto](#-estructura-del-proyecto)
- [Requisitos previos](#-requisitos-previos)
- [Instalación y ejecución](#-instalación-y-ejecución)
- [Menú de opciones](#-menú-de-opciones)
- [Detalles técnicos](#-detalles-técnicos)
- [Decisiones de diseño](#-decisiones-de-diseño)
- [Equipo y roles](#-equipo-y-roles)
- [Casos de prueba verificados](#-casos-de-prueba-verificados)
- [Flujo de trabajo con Git](#-flujo-de-trabajo-con-git)
- [Notas y aprendizajes](#-notas-y-aprendizajes)

---

## Descripción del proyecto

Sistema de gestión de una agenda telefónica desarrollado íntegramente en Java.
Permite almacenar, consultar, modificar y eliminar contactos, con control de
capacidad máxima, validación de datos y detección de contactos duplicados.

El proyecto sigue un enfoque orientado a objetos con separación de capas
(entidad, lógica de negocio e interfaz de usuario) y fue desarrollado de forma
colaborativa utilizando Git con ramas por tarea.

---

## Funcionalidades

| Funcionalidad | Descripción |
|---|---|
| **Agregar contacto** | Registra nombre, apellido y teléfono. Valida que no estén vacíos. |
| **Verificar existencia** | Comprueba si un contacto ya está registrado. |
| **Listar contactos** | Muestra todos los contactos ordenados alfabéticamente (A–Z). |
| **Buscar contacto** | Localiza un contacto por nombre y apellido y muestra su teléfono. |
| **Eliminar contacto** | Elimina un contacto existente de la agenda. |
| **Modificar teléfono** | Actualiza el número telefónico de un contacto existente. |
| **Agenda llena** | Indica cuando se alcanzó la capacidad máxima. |
| **Espacios libres** | Informa cuántos contactos más se pueden agregar. |
| **Capacidad configurable** | 10 contactos por defecto; se puede personalizar al crear la agenda. |

**Reglas de negocio:**
- Nombre y apellido **no pueden estar vacíos**.
- Dos contactos con el mismo nombre y apellido (sin distinguir mayúsculas/minúsculas)
  se consideran **duplicados** y no se pueden agregar dos veces.
- El teléfono no requiere validación de formato.

---

## Estructura del proyecto

```
AgendaTelefonica-Java/
├── .gitignore
├── README.md
└── src/
    └── phonebook/
        ├── entity/
        │   └── Contact.java          # Modelo de datos del contacto
        ├── service/
        │   └── PhoneBook.java        # Lógica de negocio de la agenda
        └── app/
            ├── ConsoleMenu.java      # Interfaz por consola (menú + Scanner)
            └── PhoneBookApp.java     # Punto de entrada (main)
```

| Paquete | Clase | Responsabilidad |
|---|---|---|
| `phonebook.entity` | `Contact` | Modelo de datos, validaciones, `equals()`/`hashCode()` |
| `phonebook.service` | `PhoneBook` | Alta, baja, consulta, modificación y control de capacidad |
| `phonebook.app` | `ConsoleMenu` | Menú interactivo, lectura por teclado, mensajes al usuario |
| `phonebook.app` | `PhoneBookApp` | Punto de entrada del programa (`public static void main`) |

---

## Requisitos previos

- **Java Development Kit (JDK) 8** o superior.
- IDE opcional: IntelliJ IDEA, Eclipse o VS Code con extensión de Java.

Verifica tu versión de Java:
```bash
java -version
javac -version
```

---

## Instalación y ejecución

### Opción 1 — Línea de comandos

```bash
# 1. Clonar el repositorio
git clone https://github.com/ameaguilar/AgendaTelefonica-Java.git
cd AgendaTelefonica-Java

# 2. Compilar (genera carpeta bin/)
javac -d bin src/phonebook/**/*.java

# 3. Ejecutar
java -cp bin phonebook.app.PhoneBookApp
```

### Opción 2 — Desde un IDE
1. Abrir el proyecto en IntelliJ IDEA / Eclipse / VS Code.
2. Localizar la clase `phonebook.app.PhoneBookApp`.
3. Ejecutar el método `main`.

---

## Menú de opciones

```
====== AGENDA TELEFÓNICA ======
1.- Añadir contacto
2.- Verificar si existe un contacto
3.- Listar contactos
4.- Buscar contacto
5.- Eliminar contacto
6.- Modificar teléfono
7.- Verificar si la agenda está llena
8.- Ver espacios libres
9.- Salir
Elige una opción: _
```

---

## Detalles técnicos

### Clase `Contact` (entity)
- **Atributos:** `firstName`, `lastName`, `phoneNumber` (encapsulados).
- **Validación:** el constructor y los setters rechazan valores nulos, vacíos
  o compuestos solo por espacios, lanzando `IllegalArgumentException`.
- **`equals(Object o)`:** sobrescrito para comparar por `firstName` y `lastName`
  usando `equalsIgnoreCase()` (el teléfono no influye en la igualdad).
- **`hashCode()`:** consistente con `equals()`, usa `toLowerCase(Locale.ROOT)`
  para garantizar el mismo hash sin importar mayúsculas/minúsculas.
- **`toString()`:** devuelve el formato `Nombre Apellido - Teléfono` utilizado al listar.

### Clase `PhoneBook` (service)
- **Colección:** `List<Contact>` implementada con `ArrayList<Contact>`.
- **Constructores:** `PhoneBook()` (capacidad por defecto = 10) y
  `PhoneBook(int maximumCapacity)` (capacidad personalizada).
- **Métodos principales:**

  | Método | Retorno | Descripción |
  |---|---|---|
  | `addContact(Contact c)` | `String` | `"ADDED"`, `"FULL"` o `"DUPLICATE"` |
  | `existsContact(Contact c)` | `boolean` | Usa `contains()` (aprovecha `equals`) |
  | `listContacts()` | `List<Contact>` | Copia ordenada A–Z (case-insensitive) |
  | `searchContact(String, String)` | `Contact` / `null` | Búsqueda por nombre y apellido |
  | `deleteContact(Contact c)` | `boolean` | Usa `remove()` (aprovecha `equals`) |
  | `modifyPhone(String, String, String)` | `boolean` | Actualiza teléfono si existe |
  | `agendaFull()` | `boolean` | Indica si se alcanzó la capacidad |
  | `freeSpaces()` | `int` | Espacios disponibles restantes |
  | `getMaximumCapacity()` | `int` | Capacidad total configurada |

- **Ordenamiento:** `lista.sort(Comparator.comparing(...).thenComparing(...))`
  con `String.CASE_INSENSITIVE_ORDER`.
- Sin bucles manuales para búsqueda/eliminación: se delega en `contains()`,
  `remove()` e `indexOf()`.

### Clase `ConsoleMenu` (app)
- Utiliza un único objeto `Scanner` para toda la sesión.
- `readOption()` valida que la entrada sea numérica y consume el salto de línea
  con `nextLine()` tras `nextInt()` para evitar lecturas vacías.
- Cada opción del menú invoca el método correspondiente de `PhoneBook` y
  traduce el resultado a un mensaje amigable para el usuario.
- El bucle principal termina con la opción **9** y cierra el `Scanner`.

### Clase `PhoneBookApp` (app)
- Contiene `public static void main(String[] args)`.
- Instancia `PhoneBook` (capacidad por defecto) y `ConsoleMenu`, y arranca el menú.

---

## Decisiones de diseño

1. **Nombres en inglés para clases y métodos** (`Contact`, `PhoneBook`,
   `addContact`, etc.); mensajes al usuario en español.
2. **`searchContact` recibe nombre Y apellido:** el enunciado mencionaba un
   solo parámetro, pero se amplió a dos para evitar ambigüedad entre homónimos.
3. **Separación de capas:** `PhoneBook` retorna valores (`boolean`, `Contact`,
   `String`); la impresión de mensajes reside exclusivamente en `ConsoleMenu`.
4. **`ArrayList` como colección:** sencillo control de capacidad y ordenamiento;
   la unicidad se garantiza mediante `equals()`/`hashCode()`.
5. **Identidad inmutable:** nombre y apellido validados; solo el teléfono es
   modificable tras la creación (vía `modifyPhone`).

---

## Equipo y roles

| Integrante | Responsabilidad | Rama |
|---|---|---|
| **Itzel Zavala** | Clase `Contact` — modelo, validaciones, `equals()`/`hashCode()` | `feature/contact` |
| **Vanya Espinoza** | `PhoneBook` — estructura, constructores, alta y control de capacidad | `feature/phonebook` |
| **Karen López** | `PhoneBook` — listado, búsqueda, eliminación, modificación | `feature/queries` |
| **Angélica Mercado** | `ConsoleMenu` — menú, `Scanner`, conexión con la lógica | `feature/menu` |
| **Mario Solano** | Integración de ramas, `PhoneBookApp`, README, pruebas finales | `develop` / `main` |

---

## Casos de prueba verificados

- [x] Agregar contacto válido → se registra correctamente.
- [x] Nombre o apellido vacío → rechazado con mensaje de error.
- [x] Contacto duplicado (distintas mayúsculas) → no se agrega.
- [x] Llenar la agenda (capacidad máxima) → no permite más altas.
- [x] `freeSpaces()` refleja el conteo correcto tras altas y bajas.
- [x] `listContacts()` muestra orden alfabético correcto (case-insensitive).
- [x] `searchContact` existente → muestra teléfono; inexistente → avisa.
- [x] `deleteContact` existente → se elimina; inexistente → avisa.
- [x] `modifyPhone` existente → actualiza el número; inexistente → avisa.
- [x] Opción inválida (no numérica o fuera de rango) → no rompe el programa.
- [x] Opción 9 (Salir) → cierra el `Scanner` y termina limpiamente.

---

## Flujo de trabajo con Git

- Rama principal: `main`.
- Rama de integración: `develop`.
- Cada funcionalidad se desarrolla en una rama `feature/*` y se integra a `develop`.
- Integración en orden de dependencia: `Contact` → `PhoneBook` (core) →
  `PhoneBook` (consultas) → `ConsoleMenu`.
- Release final etiquetada en `main`.

---

## Notas y aprendizajes

- Archivos guardados en codificación **UTF-8**.
- Compatible con Java 8+ (no se utilizan `records`, `var` ni `switch` expressions).
- Sin `equals()`/`hashCode()` consistentes, la detección de duplicados mediante
  `contains()`/`remove()` no funciona correctamente.
- Tras `Scanner.nextInt()` es necesario consumir el salto de línea con
  `nextLine()` para evitar que la siguiente lectura llegue vacía.

---

## Agradecimientos

Desarrollado como parte del Hackatón de Java por el **Equipo 2**.
Agradecemos a los organizadores por la oportunidad y a todo el equipo por el
esfuerzo y la colaboración. 

---

*Última actualización: Octubre 2026*
