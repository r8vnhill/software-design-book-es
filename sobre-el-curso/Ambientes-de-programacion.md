# Instalaciones y Configuraciones para el curso

Para el curso recomendamos fuertemente el uso de un _IDE_ para programar las tareas. Si bien esto no es obligatorio, sera mucho mas facil para pedir ayuda y solucionar los problemas rapidamente. Tambien, la universidad tiene convenio con JetBrains para obtener sus productos profesionales gratis mientras sean estudiantes, mejor aprovecharlo mientras se pueda.

## Java

Este curso se dicta en Java, por lo que como minimo deberan instalar la version de desarrollador de Java, `Java Development Kit` o JDK. Pueden usar cualquier version posterior a la 8, pero recomendamos actualizarse a la version LTS del momento (hasta ahora Java 11), ya que podriamos utilizar alguna de estas funcionalidades nuevas en las tareas.

### Instalacion

Para instalar Java pueden hacerlo desde la pagina [oficial de Oracle](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html), pero pide registrarse ~~no gracias~~.
Estan las siguientes alternativas (son basicamente lo mismo):

* **[OpenJDK](https://adoptopenjdk.net/)**: es la version de codigo abierto de Java. Para efectos del curso, es lo mismo.
* **[JDK Builds](http://jdk.java.net/)**: recopilador de las versiones JDK de Java.
* **[OpenJDK 2](https://openjdk.java.net/)**: pagina oficial que recopila las versiones _Open_ de Java.

### Configuracion

Una vez instalado Java debemos configurar las variables de ambiente para que nuestro computador sepa donde buscar cuando le pidamos hacer `java` o `javac`. Deben configurar las siguientes 2 variables de ambiente: `JAVA_HOME` y `PATH`. Como configurar las variables de ambiente difiere entre sistemas operativos. Se mostrara para Windows y Linux, pero MacOS deberia ser muy similar a Linux.

Llamaremos el directorio donde instalo Java como `JavaInstall` por conveniencia.

#### JAVA_HOME

* **Windows**: Abrir el menu y escribir _variables de ambiente_ o _environment variables_ (o en el idioma que use Windows). Presione `Edit system environment variables` y luego en `Environment Variables...`. Aqui en la ventana de usuario seleccione `New...` y escriba en el nombre de la variable `JAVA_HOME` y en el valor busque el directorio donde instalo Java: `JavaInstall`. Luego aceptar y listo.
* **Linux**: Primero revise si Java ya configuro esta variable. Abra su terminal y escriba `echo $JAVA_HOME`. Si se imprime algun directorio entonces esta variable ya esta configurada. En caso de que no lo este cree en si `HOME` un archivo `.bashrc`, `.bash_profile`, `.profile`, o la consola que usted use. Dentro del archivo agrege la linea `export JAVA_HOME=JavaInstall`, siendo `JavaInstall` el directorio donde instalo Java.

#### PATH

* **Windows**: En el menu de variables de ambiente, haga doble click sobre la variable `Path` o `PATH`. Seleccione `New` y luego escriba `%JAVA_HOME%\bin`.
* **Linux**: En el mismo archivo donde agrego `JAVA_HOME` agregue la siguiente linea: `export PATH=$JAVA_HOME/bin:$PATH`.

#### Probar que funciona

Abra su consola o terminal favorito y escriba `javac`. Si esto no arroja un error, entonces la configuracion fue correcta. Puede que necesite reiniciar su computador en Windows, o hacer `source el-archivo-donde-agrego-las-lineas` en Linux.

## Entorno de desarrollo (IDE)

Para el curso puede usar el ambiente de desarrollo que quiera. Recomendamos _Intellij_ porque tenemos convenio de estudiantes con la empresa, pero es libre de usar _Eclipse_, _Visual Studio Code_, etc.

Para aplicar al convenio de estudiantes de _Intellij_ vayan a la siguiente pagina: https://www.jetbrains.com/shop/eform/students. El sistema esta automatizado con su correo `@ug`, `@ing` y `@dcc`. Una vez se le acepte, descargue _Intellij Ultimate_ y listo.

Si quiere utilizar Visual Studio Code, recomendamos las siguientes extensiones:

* [Bracket Pair Colorizer 2](https://marketplace.visualstudio.com/items?itemName=CoenraadS.bracket-pair-colorizer-2)
* [Java Extension Pack](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack) (incluye 6 extensiones)
* [GitLens](https://marketplace.visualstudio.com/items?itemName=eamodio.gitlens)
* [gitignore](https://marketplace.visualstudio.com/items?itemName=codezombiech.gitignore)
