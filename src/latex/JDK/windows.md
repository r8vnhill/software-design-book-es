*OpenJDK* con *Chocolatey* (Recomendado)
========================================

Si no lo tienen instalado, el primer paso sería instalar el gestor de
paquetes *Chocolatey*, para esto se debe abrir *Powershell* como
administrador.

```powershell
[Net.ServicePointManager]::SecurityProtocol = `
  [Net.SecurityProtocolType]::Tls12
Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Force
Invoke-WebRequest "https://chocolatey.org/install.ps1" -UseBasicParsing `
  | Invoke-Expression
```

Una vez que tengan *Chocolatey* instalado, basta ejecutar:

```powershell
cinst openjdk -y
```

Para probar que la instalación se haya hecho de forma correcta, cierren
y abran *Powershell* y ejecuten el comando:

```powershell
java -version
```

El input debiera ser algo como:

```
openjdk version "14" 2020-03-17
OpenJDK Runtime Environment (build 14+36-1461)
OpenJDK 64-Bit Server VM (build 14+36-1461, mixed mode, sharing)
```

Si esto no funciona, proceda con la siguiente opción.

*OpenJDK* sin *Chocolatey*
==========================

Primero deben descargar los binarios del *JDK* desde 
[aquí](https://download.java.net/java/GA/jdk14/076bab302c7b4508975440c56f6cc26a/36/GPL/openjdk-14_windows-x64_bin.zip).

Con los binarios descargados, extraigan el `.zip` en algún directorio y
luego abran *Powershell* como administrador y ubíquense en la carpeta
donde extrajeron el archivo. Una vez ahí, ejecuten:

```powershell
Move-Item -Path .\jdk-14 -Destination $Env:Programfiles
[Environment]::SetEnvironmentVariable("JAVA_HOME", 
                                      "$Env:Programfiles\jdk-14")
[Environment]::SetEnvironmentVariable(
  "Path", 
  [Environment]::GetEnvironmentVariable('Path', 
  [EnvironmentVariableTarget]::Machine) + ";$($Env:JAVA_HOME)\bin", 
  [EnvironmentVariableTarget]::Machine)
```

Para probar que la instalación se haya hecho de forma correcta, cierren
y abran *Powershell* y ejecuten el comando:

```powershell
java -version
```

El input debiera ser algo como:

```
openjdk version "14" 2020-03-17
OpenJDK Runtime Environment (build 14+36-1461)
OpenJDK 64-Bit Server VM (build 14+36-1461, mixed mode, sharing)
```

Si esto no funciona, proceda con la siguiente opción.

Opción 3: *Oracle JDK*
======================

Lo primero es descargar el *JDK* desde el 
[sitio de *Oracle*](https://www.oracle.com/java/technologies/javase-jdk14-downloads.html) 
y una vez descargado ejecuten el instalador y sigan las
instrucciones.

Por último, deben agregar el *path* de *Java* a las variables de
entorno, para esto abran *Powershell* como administrador y ejecuten:

```powershell
[Environment]::SetEnvironmentVariable("JAVA_HOME", 
                                      "$Env:Programfiles\Java\jdk-14")
[Environment]::SetEnvironmentVariable(
  "Path", 
  [Environment]::GetEnvironmentVariable('Path', 
  [EnvironmentVariableTarget]::Machine) + ";$($Env:JAVA_HOME)\bin", 
  [EnvironmentVariableTarget]::Machine)
```

Para probar que la instalación se haya hecho de forma correcta, cierren
y abran *Powershell* y ejecuten el comando:

```powershell
java -version
```

El input debiera ser algo como:

```
openjdk version "14" 2020-03-17
OpenJDK Runtime Environment (build 14+36-1461)
OpenJDK 64-Bit Server VM (build 14+36-1461, mixed mode, sharing)
```
