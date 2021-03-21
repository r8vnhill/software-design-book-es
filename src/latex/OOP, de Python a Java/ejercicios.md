# Ejercicios

1.  El largo (o norma) de un vector $\mathbf{v}$ es la distancia de
    dicho vector respecto al origen del sistema de coordenadas y se
    denota como $||\mathbf{v}||$. La norma de un vector se define como:

    $$||\mathbf{v}|| = 
                \sqrt{\mathbf{v}_0^2 + \mathbf{v}_1^2 + \cdots + \mathbf{v}_n^2 }$$

    Implemente el método `double getLength()`{.java} que calcule el
    largo de un vector de dimensión $n$.

2.  Un *vector cero* es un vector especial de largo arbitrario que
    cumple la propiedad de que sumarlo con cualquier otro vector da el
    mismo vector. Formalmente, sea un vector $\mathbf{v}$ de dimensión
    arbitraria y el vector $\mathbf{0}$ de dimensión indefinida: se dice
    que $\mathbf{0}$ es un vector cero ssi
    $\mathbf{v} + \mathbf{0} = \mathbf{v},\ \forall \mathbf{v}$.

    Programe una clase `ZeroVector` que implemente dicha funcionalidad
    al ser sumado con cualquier otro vector.

3.  Agregue un método (en las clases que estime necesarias)
    `boolean isZeroVector()`{.java} que retorne `true`{.java} si el
    objeto es un vector cero y `false`{.java} en caso contrario. Note
    que un objeto de clase `VectorND` también podría ser un vector cero.

4.  Dos vectores $\mathbf{a}$ y $\mathbf{b}$ se dicen opuestos si
    $\forall i \in \mathbb{Z}$ se cumple que
    $\mathbf{a}_i = -\mathbf{b}_i$. Extienda la clase `VectorND` con un
    método `boolean isOppositeTo(VectorND)`{.java} que retorne
    `true`{.java} si los vectores son opuestos y `false`{.java} en caso
    contrario.

5.  El *producto punto* entre 2 vectores $\mathbf{a}$ y $\mathbf{b}$ de
    dimensiones $m$ y $n$ respectivamente, con $m \leq n$ se define
    como: $$\mathbf{a} \cdot \mathbf{b} = \mathbf{a}_1 \mathbf{b}_1 
                + \mathbf{a}_2 \mathbf{b}_2 + \cdots + \mathbf{a}_m \mathbf{b}_m$$

    Implemente el método `double dotProduct(VectorND)`{.java} que
    calcule el producto punto entre 2 vectores.

6.  El *producto cruz* es una operación entre dos vectores de 3
    dimensiones que da como resultado un nuevo vector perpendicular a
    ambos. Se define el producto cruz entre dos vectores $\mathbf{a}$ y
    $\mathbf{b}$ como:

    $$\mathbf{a} \times \mathbf{b} = \left(
                \mathbf{a}_2 \mathbf{b}_3 - \mathbf{a}_3 \mathbf{b}_2,\,
                \mathbf{a}_3 \mathbf{b}_1 - \mathbf{a}_1 \mathbf{b}_3,\,
                \mathbf{a}_1 \mathbf{b}_2 - \mathbf{a}_2 \mathbf{b}_1
                \right)$$

    Cree un método `Vector3D crossProduct(Vector3D)`{.java} que haga
    este cálculo.
