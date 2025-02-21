# Taller-Principios-SOLID
#	Javier Alexis Ceron / Jhonatan Palacios Gomez / Rubeiro Romero

#Elementos Correctamente Codificados:
- La clase CompanySerivce, en el paquete Domain.services, segun los conceptos vistos, ya tienen implementado el principo de Inversion de Dependencias, ya que no depende de implementaciones de repositorio, sino de la interfaz.
- En el paquete Domain.entitie, la clase Company, en el paquete Domain.entities aplica para el principio de Responsabilidad Unica, al igual que la clase Sector, esta ultima tambien aplica para el principio Abierto/Cerrado.

#Elementos Con Posibles Mejoras:
- CompanyArraysRepository, esta inicializando datos, cosa que podria hacerse en una clase aparte, asi aplicando el principio de Unica Responsabilidad.
- Factory, esta realizando una instancia de ella misma en su clase, que quizas podria ser modificado, ademas de que esta instanciando repositorios.
