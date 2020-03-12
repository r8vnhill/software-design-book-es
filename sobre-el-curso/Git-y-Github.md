# Sistema de Control de Versiones

El control de versiones es una herramienta fundamental en el _toolbox_ de un programador, o  persona que trabaja con código, especialmente si es de forma colaborativa. Imaginen como un _Google Docs_, u ~~Sharelatex~~ _Overleaf_ pero para codigo. Estas herramientas se llevan usando por decadas, partiendo por _CVS_ (_Concurrent Versions System_) por los 90, luego _SVN_ (_Subversion_) y _Git_ como el mas moderno (2005).

## Git

Git tiene una base muy linda en teoria de grafos y calculo de diferencias de archivos. Lamentablemente a pocas personas les importa eso y solo lo usan, y como este curso no se trata de versionamiento de codigo, haremos lo mismo. Sin embargo, si quiere saber mas de Git, la teoria detras de este, y lo poderoso que es, siga este link a la [documentacion oficial](https://git-scm.com/book/en/v2).

### Instalar y configurar

Descargue Git desde el siguiente link: https://git-scm.com/downloads. En Linux ya deberia estar instalado.

Configure su identidad para firmar los cambios que haga al codigo. Abra consola y escriba lo siguiente (si esta en Windows abra `git bash`):

```bash
git config --global user.name "Su nombre"
git config --global user.email suEmail@mail.cl
```

### Como funciona

Git tiene 3-4 etapas, usualmente, al llevar los cambios de un proyecto.

* **Untracked**: corresponde al estado por defecto de cualquier archivo en un proyecto. Git no tiene conocimiento del archivo y no lo esta monitoreando.
* **Staged**: git ahora reconoce al archivo y esta listo para agregarlo a su base de datos. Este estado corresponde al estado "normal" de un archivo, donde git tiene conocimiento de este, pero no tiene los cambios mas recientes del archivo.
* **Commited**: el archivo se encuentra agregado a la base de datos en su estado mas reciente.
* **Up-to-date**: el archivo/repositorio esta actualizado cuando de compara con su simil en la nube.

### Comandos se necesitaran

Estos son los comandos que necesitaran usar en el curso en caso de que todo salga bien, todo son predecidor por `git ___`:

* **status**: resumen del estado actual de la rama (base de datos de git) vs los ultimos cambios. Puede mostrar que esta todo al dia, o que hay cosas nuevos cambios que no estan registrados.
* **add**: indica qué archivos serán considerados para agregar a la rama, agrega los archivos a _staged_.
* **commit**: agrega los archivos considerados (en _staged_) en un commit a la rama. Es como un `guardar` en una base de datos.
* **push**: actualiza las referencias remotas del repositorio. Actualiza la nube con los ultimos cambios.
* **pull**: incorpora los cambios remotos en la rama local. Actualiza la base de datos local con los ultimos cambios de la nube (muy util si se trabaja en grupo o en varios computadores).
* **clone**: clona un repositorio localmente. Bajar de la nube una base de datos, la historia y los archivos del proyecto.
* **tag**: crea una etiqueta, un `label`, y se la asigna a un commit. Esto se usa para identificar las versiones de un programa en su historia.

## Github

La pagina donde estan ahora. Github es la "nube" de git mas grande que existe, con millones de repositorios y usuarios. Se utiliza para muchas cosas, incluyendo almacenamiento de codigo, integracion continua, programacion social, trabajo en equipo, entre otras cosas. Aqui subiran sus tareas y se aqui seran corregidas.

### Crear cuenta y Aplicar a convenio

Primero deben [crearse una cuenta](https://github.com/).

La universidad nuevamente tiene convenios de estudiante con Github, por lo que si quieren aplicar a este, primero deben agregar un correo institucional (`@ug`, `@ing` y `@dcc`) en https://github.com/settings/emails, y luego ir a https://education.github.com/pack.

### Autenticacion

Para usar Github junto con Git, deben indicar una forma de como se autenticaran con la pagina cuando suban y bajen codigo de ella. Tienen 2 opciones:

* **Https**: esta es la forma tradicional de autenticarse en cualquier pagina. Cuando descarguen un repositorio o suban algo, seleccionar la option de usar _Https_ y luego ingresar su usuario y contraseña. Algunos IDE pueden darle la conveniencia de guardar sus credenciales para no tener que ingresarlas constantemente.
* **Llave ssh**: consiste en definir una llave secreta con la que firmaran sus paquetes que enviaran por internet y Github utilizara para reconocer que son ustedes. Para configurar todo esto es mas simple que sigan el [siguiente tutorial](https://help.github.com/en/articles/connecting-to-github-with-ssh).

## Tutorial de Git

Visitar [el tutorial de git](Git) para practicar un poco. Esto se considera la tarea 0 del curso.
