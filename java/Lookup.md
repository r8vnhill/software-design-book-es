# Lookup

> this y super

> ambos sabemos referencian al mismo objeto, que es el objeto que recibio el mensaje

> this comienza el lookup en la clase a la que apunta. tecnicamente es la clase de objeto al que apunta, pero esta bien.

> super comienza el lookup en la super clase de la clase donde esta la llamada a super. Cualquier otra definicion esta propensa a quedarse en un loop.

## errores comunes

> comienza el lookup en la clase del objeto... **que objeto**

> comienza el lookup en la super clase. **de quien**

> comienza el lookup en la super clase del objeto que recibio el mensaje. **loop**

> comienza el lookup en la clase que *hizo* la llamada. **es el que recibe, no el que la hace**
