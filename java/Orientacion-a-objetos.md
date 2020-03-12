# Programacion orientada a objetos

Es un paradigma de programacion que consisten en estructurar y modelar los problemas en base a objetos, como estructuras de encapsulamiento de acciones, y usar los datos de estos objetos para modelar la logica del programa.

## Propiedades de OOP

1. **Encapsulacion**: cada objeto es responsable de manejar su propio estado y comportamiento. Quienes estan fuera del objeto no deben poder modificar lo que esta dentro, es decir, el objeto mismo debe autoadministrarse y ejecutarse a partir de los mensajes que le lleguen.
2. **Composicion**: objetos pueden contener a otros objetos. Es el equivalente a la relacion `has-a` en bases de datos.
3. **Separacion de responsabilidades**: cada objeto maneja un parte de la logica del programa, sin dejar que otros objetos interfieran directamente en esto.
4. **Delegacion**: cada objeto ejecuta solo las acciones que le corresponde. Si algo no le corresponde, entonces le manda un mensaje a otro (idealmente a quien si le corresponde) que lo haga. Basicamente es un "si no es mi trabajo que lo haga otro".
5. **Herencia**: relaciones `is-a` en bases de datos. Permite estructurar jerarquicamente un conjunto de clases. Cada clase se especializa sobre la enterior, permitiendo que las "sub-clases" hereden la funcionalidad de las clases "padre". El requerimiento para las buenas practicas es que esta herencia/jerarquia, debe tener una relacion logica/semantica.
