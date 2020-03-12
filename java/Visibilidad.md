# Visibilidad de variables y metodos

Cuando tenemos un objeto no siempre queremos que todos puedan ver las variables de nuestro objeto. Mas aun, muchas veces tenemos acciones que nos gustarian sean internas para el objeto y que no puedan ser ejecutadas desde otras partes.

## Motivacion

Consideremos el ejemplo de una caja fuerte. Podemos tener un metodo `ingresarPassword`, que si la contraseña es correcta abre la caja fuerte. Para abrir la caja fuerte, el metodo `ingresarPassword` llama a `abrirCaja`. Si no configuramos bien nuestra visibilidad alguien podria simplemente llamar `abrirCaja` e ignorar el metodo para ingresar la contraseña.

Lo mismo podria pasar con las variables. Nuestra `CajaFuerte` necesita saber la contraseña correcta para saber si se ingreso bien o no, asi que tenemos una variable `password`. Si no tenemos la visibilidad correcta alguien simplemente podria mirar la contraseña y violar nuestra seguridad.

## Niveles de visibilidad

En la siguiente tabla puede encontrar los niveles de visibilidad.

|    Modificador    | Clase | Paquete | Subclases | El mundo |
| :---------------: | :---: | :-----: | :-------: | :------: |
|     `public`      |  SI   |   SI    |    SI     |    SI    |
|    `protected`    |  SI   |   SI    |    SI     |    NO    |
| _sin modificador_ |  SI   |   SI    |    NO     |    NO    |
|     `private`     |  SI   |   NO    |    NO     |    NO    |

Considere que el "modificador" _sin modificador_ es lo que se conoce como _default_ y provee una visibilidad solo dentro del paquete. Es decir, si una subclase de no se encuentra dentro del mismo paquete, entonces no puede acceder a las variables y los metodos declarados como _sin modificador_.

## Recomendaciones

### `getters` y `setters`

Siempre declare sus variables `private`, ya que no corresponde que otros objetos puedan observar el estado interno de otro objeto sin primero preguntarle al objeto en cuestion. Para esto existen los metodos conocidos como `getters` y `setters`. Para acceder a variables

### Sobre el uso de `public`

Cuide mucho los elementos que declara `public`. En general **nunca** necesitara declarar una variable como `public`, salvo situaciones muy puntuales, donde si probablemente se encuentra en ellas no necesita que le digan que hacer.

Los metodos deben ser declarados `public` siempre y cuando aporten algo a como se comunica la clase con el mundo. Si ser publico no aporta en nada, restrinja la visibilidad a `protected`.
