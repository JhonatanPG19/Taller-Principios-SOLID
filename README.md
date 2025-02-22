# Taller-Principios-SOLID
#	Javier Alexis Ceron / Jhonatan Palacios Gomez / Rubeiro Romero

#Elementos Correctamente Codificados:
- La clase CompanySerivce, en el paquete Domain.services, segun los conceptos vistos, ya tienen implementado el principo de Inversion de Dependencias, ya que no depende de implementaciones de repositorio, sino de la interfaz.
- En el paquete Domain.entitie, la clase Company, en el paquete Domain.entities aplica para el principio de Responsabilidad Unica, al igual que la clase Sector, esta ultima tambien aplica para el principio Abierto/Cerrado.

#Elementos Con Posibles Mejoras:
- CompanyArraysRepository, esta inicializando datos, cosa que podria hacerse en una clase aparte, asi aplicando el principio de Unica Responsabilidad.
- Factory, esta realizando una instancia de ella misma en su clase, que quizas podria ser modificado, ademas de que esta instanciando repositorios.

# Preguntas del punto 2.2: Debe considerar una nueva implementación (pueden dejar los métodos lanzando una
excepción) de la interfaz de repositorio la cual almacena en un archivo binario de sólo
lectura. ¿Qué principio de diseño se estaría violando? ¿Qué otro principio podría venir al
rescate? Considere una refactorización de la interfaz repositorio en el código de acuerdo a
sus respuestas.
- ¿Qué principio de diseño se estaría violando?
Se estaria violando el principio de Liskov (LSP), ya que, en el proyecto actual se tiene una interfaz de repositorio con unos metodos propios, pero al implementar lo mencionado en el enunciado (Que solo pueda leer desde un archivo binario), pasaria que, estaria obligado a implementar los metodos que ya estan implementados en la interfaz, pero estos quedarian obsoletos, debido a que el archivo binario solo es de lectura. Este principio menciona que una subclase debe poder replazar la superclase sin causar errores, en este caso, si tratamos de usar el metodo save(), simplemente el repositorio binario no lo soportaria.
- ¿Qué otro principio podría venir al rescate?
Quizas haciendo implementacion del principio de Segregacion de Interfaces (ISP), aplicando lo siguiente: En lugar de tener una sola interfaz para todos los metodos, deberiamos dividirlo en dos interfaces, una que se encargue solo de la lectura del repositorio binario, y la otra interfaz solo se encargaria de la escritura, de esta manera solucionariamos el problema de violacion del principio de Liskov (LSP).
  
