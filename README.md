Proyecto: Simulación de Recolección de Pepinos y Melones 🌱🍈

Descripción 📋

Este proyecto simula el proceso de recolección en una parcela donde un agricultor cultiva y recoge pepinos y melones. La simulación sigue un conjunto de reglas específicas que involucran tiempos, prioridades y restricciones para el crecimiento y recolección de los cultivos.

Reglas del agricultor:

* Prioridad de recolección:

  Si hay pepinos disponibles, el agricultor los recoge primero, en lotes.
  Si no hay más pepinos, recoge melones uno a uno.

* Tiempos de recolección:

  Pepinos: 50 ms por cada unidad en el lote.
  Melones: 100 ms por cada melón.

* Restricción:

  Durante el proceso de recolección (pepinos o melones), no es posible que crezcan nuevos cultivos.

Objetivo:
El programa coordina dos procesos paralelos, uno dedicado exclusivamente a recoger pepinos y otro a recoger melones, hasta completar la recolección de 50 pepinos y 20 melones.

Lenguaje utilizado 🖥️

El proyecto está desarrollado en Java, utilizando conceptos de programación concurrente y sincronización con monitores.

Colaboradores 🤝

Nombre del Colaborador Asier Rodríguez
Nombre del Colaborador Iván Gulín
María Rosete
