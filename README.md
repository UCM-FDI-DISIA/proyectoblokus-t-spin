<div align="center">
  <h1>Proyecto Blokus T-Spin 🎮🧩</h1>
  <h3>Equipo: 💻 </h3>
  <h4> <a href="https://github.com/AlexandraMolina">Carolina Molina</a> |
  <a href="https://github.com/scfUcm">Sofia Capmany</a> |
  <a href="https://github.com/luisolUCM">Luis Solis</a> |
  <a href="https://github.com/dprieto96">Daniel Prieto</a> |
  <a href="https://github.com/Mauricio-NCB">Mauricio Calderón</a> |
  <a href="https://github.com/robertotejedor">Roberto Tejedor</a> |
  <a href="https://github.com/Andresfyc">Andres Yunda</a></h4>
  <br>
  <img src="https://media.giphy.com/media/QBamGOmsJym57De1Ze/giphy.gif" width=40%>
</div>


## Contenido

- [Información general](https://github.com/UCM-FDI-DISIA/proyectoblokus-t-spin#informaci%C3%B3n-general-)
- [Tecnologías y Herramientas](https://github.com/UCM-FDI-DISIA/proyectoblokus-t-spin#tecnolog%C3%ADas-y-herramientas-%EF%B8%8F%EF%B8%8F)
- [Implementación](https://github.com/UCM-FDI-DISIA/proyectoblokus-t-spin#implementaci%C3%B3n-)
- [Wiki](https://github.com/UCM-FDI-DISIA/proyectoblokus-t-spin#wiki-)
- [Versiones](https://github.com/UCM-FDI-DISIA/proyectoblokus-t-spin#versiones-)
- [Autores](https://github.com/UCM-FDI-DISIA/proyectoblokus-t-spin#autores-%EF%B8%8F)

<div align="center">
  
## Información general 🌎
</div>

### Proyecto Blokus - UCM/Facultad de informática, IS II

Blokus es un juego de mesa de estrategia basado en la conquista del tablero: el objetivo es rellenar el
mayor espacio posible dentro del tablero con las piezas de cada color. Es para dos o hasta cuatro
jugadores y fue inventado por Bernard Tavitian, y publicado por primera vez en el 2002 por Sekkoïa,
una compañía francesa.

### Fichas
  
- 1 monominó (un cuadradito).
- 1 dominó (dos cuadraditos juntos).
- 2 trominós (una pieza en forma de L y tres cuadraditos en línea).
- 5 tetrominós.
- 12 pentominós.

<img src="https://cdn.discordapp.com/attachments/842864387726508052/842864413190914078/unknown.png"   width=30% />

### Puntuación

La puntuación de cada jugador se calcula de la siguiente manera:

- Se resta un punto por cada cuadrado de cada pieza que no se haya colocado. Cada cuadrado no colocado resta una pieza.
- Se le suman 15 puntos si ha colocado las 21 piezas de su color.

<img src="https://cdn.discordapp.com/attachments/842864387726508052/842869350494765056/unknown.png"   width=30% />

Para más información del juego y del proyecto de IS-2 [PDF][desPDF].

[desPDF]: https://github.com/UCM-FDI-DISIA/proyectoblokus-t-spin/files/6480746/Proyecto.pdf


<div align="center">
  
## Tecnologías y Herramientas 🖥️🛠️
</div>

<details>
<summary>Tecnologías</summary>
<br>

</details>


<details>
<summary>Herramientas</summary>
<br>
  
- **Github** :octocat: : Es un sistema de control de versiones, donde también se utiliza para agregar la documentación del proyecto, las historias de usuario, además de que todo el equipo tendrá la versión actual del código para trabajr sobre el.
- **Eclipse:** Es el IDE, en donde se está desarrollando el proyecto.
- **Discord:** Es el servicio de mensajería, el cual se utiliza para las reuniones dos veces por semana, así llevar un seguimiento en los avances del proyecto.
- **Modelio:** Es la herramienta la cual se usa para la creación, modificación de los UML y diagramas de secuencia.
- **Photoshop:** Es una herramienta de edición la cual se ha utilizado, para la modificiacón de imagenes del jugador en la GUI.
- **Google Docs:** Es un servicio de alojamiento de archivos, con este creamos un archivo compartido, donde todos colabaoran rellenando su sección de las dayli.
</details>


<div align="center">
  
## Implementación 🧑‍💻
</div>

> "Programar sin una arquitectura o diseño en mente es como explorar una gruta sólo con una linterna: no sabes dónde estás, dónde has estado ni hacia dónde vas”  – Danny Thorpe

<details>
<summary>Arquitectura de Software - MVC </summary>
<br>
<p> Desde el inicio del proyecto, aplicamos el patrón modelo vista controlador veíamos las ventajas y comodidad de usarlo, puesto que todo quedaría más ordenado y entendible para cada uno de los integrantes, sobre las modificaciones que hacían los otros. </p>

<p> Por lo general el patrón se divide en tres categorías: </p>

- **Modelo:** implementan la lógica del juego y los hace interactuar entre ellos.
- **Vista:** en nuestro caso la vista sirve como medio de entrada de datos para el usuario, aparte de representar la información y los cambios que se producen en él.
- **Controller:** es el intermediario entre la vista y el modelo, permite al usuario introducir datos en el modelo para provocar cambios en él.
</details>


<details>
<summary>UML</summary>
<br>

<div align="center">
  <img src="https://user-images.githubusercontent.com/32586089/118138691-eb92c500-b406-11eb-87e4-770aed968c64.png"   width=75% />
</div>
</details>


<details>
<summary>Diagramas de Secuencia</summary> 
<br>

<div align="center">
  <img src="https://user-images.githubusercontent.com/62907237/118175170-09c0eb00-b430-11eb-9eaf-7c5f489d7af8.png"   width=50% />
</div>
</details>

<div align="center">
  
## Wiki 📖
</div>
Puedes encontrar mucho más de este proyecto en nuestra [Wiki.](https://github.com/UCM-FDI-DISIA/proyectoblokus-t-spin/wiki)


<div align="center">
  
## Versiones 📌
</div>
<details>
<summary>V1.0.0 First Version (Console)</summary> 
<br>

* Dimensiones del Tablero (19,19)
* Piezas Cuadradas
* Número de Jugadores [2-4]
* Contrucción de 84 piezas (21 Formas, 4 Colores)
* Inicio de Partida
* Rotar Piezas
* Siguientes Turnos
* Pasar turno
* Fin del juego
* Puntuación Jugadores
* Excepciones durante la partida
</details>


### [![Version](https://img.shields.io/badge/Version-1.0.0-blue)](https://github.com/UCM-FDI-DISIA/proyectoblokus-t-spin/releases/tag/v1.0)

---

<details>
<summary>V1.1.0 Second Version (GUI)</summary>
<br>

* Menú Inicio
* Menú Superior
* Barra Inferior Jugador
* Lista Lateral Jugadores
* Puntuación
* Correción Rotar
* Boton Rotar
* Boton Pasar turno
* Listener controller
* Textura piezas/botones/jugadores
* Pestaña principal  
</details>

### [![Version](https://img.shields.io/badge/Version-1.1.0-blue)]()

<div align="center">
  
## Autores ✒️
</div>
<div align="center">

| Luis Solís 	| Roberto Tejedor	| Carolina Molina 	|  Sofia Capmany	| Daniel Prieto 	|  Mauricio Calderón  	|  Andres Yunda	|
|:-:	|:-:	|:-:	|:-:	|:-:	|:-:	|:-:	|
| _Scrum Master_ 	|  _Product Owner_	|  _Development Team_	|  _Development Team_	| _Development Team_ 	| _Development Team_ |  _Development Team_	|

</div>

