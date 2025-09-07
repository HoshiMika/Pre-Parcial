# Pre-Parcial
Manejo, ordenacion y recursividad en archivos
Explicaciones adicionales
Cuándo es conveniente usar acceso secuencial y cuándo acceso directo:
Acceso secuencial es conveniente cuando necesitamos procesar todos los registros de un archivo en orden, como cuando mostramos todo el contenido o procesamos todos los datos.

Acceso directo es útil cuando necesitamos acceder a registros específicos sin leer todo el archivo, como cuando buscamos un registro por su posición o clave.

Diferencia entre mezcla directa y mezcla natural:
Mezcla directa divide los datos en bloques de tamaño fijo, los ordena y luego los fusiona.

Mezcla natural aprovecha las "corridas naturales" (secuencias ya ordenadas) en los datos, lo que puede ser más eficiente cuando los datos tienen cierto grado de ordenamiento previo.

Ventajas y limitaciones de usar recursividad:
Ventajas:

Código más claro y conciso para problemas que se pueden dividir en subproblemas similares.

Facilita la implementación de algoritmos que naturalmente son recursivos.

Limitaciones:

Puede consumir más memoria debido a la pila de llamadas.

Puede causar desbordamiento de pila (StackOverflowError) para archivos muy grandes.

Puede ser menos eficiente en términos de rendimiento que una solución iterativa.