import java.io.*;  // Importa clases para entrada/salida (File, BufferedReader, FileReader, etc.)
import java.util.*; // Importa clases utilitarias (Scanner, Arrays)

public class ManejoEstudiantes {
    
    public static void main(String[] args) {
        String nombreArchivo = "estudiantes.txt"; // Define el nombre del archivo a trabajar
        
        // Parte 1: Operaciones básicas con archivos
        System.out.println("PARTE 1: Operaciones basicas con archivos");
        verificarYCrearArchivo(nombreArchivo); // Llama al método para verificar/crear el archivo
        mostrarContenidoArchivo(nombreArchivo); // Llama al método para mostrar el contenido
        
        // Parte 2: Acceso directo a archivos
        System.out.println("\nPARTE 2: Acceso directo a archivos");
        Scanner scanner = new Scanner(System.in); // Crea objeto Scanner para leer entrada del usuario
        System.out.print("Ingrese el número de línea a mostrar: "); // Solicita número de línea
        int numeroLinea = scanner.nextInt(); // Lee el número de línea ingresado
        mostrarLineaEspecifica(nombreArchivo, numeroLinea); // Muestra la línea específica
        
        // Parte 3: Ordenación externa
        System.out.println("\nPARTE 3: Ordenacion externa");
        
        // Simulación de bloques para mezcla directa
        int[] bloque1 = {85, 89, 92}; // Crea primer bloque de datos ordenados
        int[] bloque2 = {78, 90, 95}; // Crea segundo bloque de datos ordenados
        System.out.println("Bloque 1: " + Arrays.toString(bloque1)); // Muestra bloque 1
        System.out.println("Bloque 2: " + Arrays.toString(bloque2)); // Muestra bloque 2
        
        int[] fusionado = mezclaDirecta(bloque1, bloque2); // Fusiona los dos bloques
        System.out.println("Resultado de mezcla directa: " + Arrays.toString(fusionado)); // Muestra resultado
        
        // Detección de corridas naturales
        int[] arreglo = {5, 8, 12, 3, 7, 15, 20, 2, 4, 6}; // Crea arreglo de prueba
        System.out.println("Arreglo para detectar corridas: " + Arrays.toString(arreglo)); // Muestra arreglo
        detectarCorridasNaturales(arreglo); // Detecta y muestra corridas naturales
        
        // Parte 4: Recursividad aplicada
        System.out.println("\nPARTE 4: Recursividad aplicada");
        int cantidad = contarEstudiantesNotaAlta(nombreArchivo, 0, 0); // Cuenta estudiantes con nota alta
        System.out.println("Cantidad de estudiantes con nota >= 90: " + cantidad); // Muestra resultado
        
        scanner.close(); // Cierra el scanner para liberar recursos
    }
    
    // Método para verificar si el archivo existe y crearlo si no existe
    public static void verificarYCrearArchivo(String nombreArchivo) {
        File archivo = new File(nombreArchivo); // Crea objeto File con el nombre del archivo
        
        if (!archivo.exists()) { // Verifica si el archivo NO existe
            try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) { // Try-with-resources para auto-cerrar
                writer.println("Nombre, Edad, Nota"); // Escribe cabecera
                writer.println("Ana, 21, 89");       // Escribe primer registro
                writer.println("Luis, 23, 92");      // Escribe segundo registro
                writer.println("Maria, 20, 95");     // Escribe tercer registro
                writer.println("Carlos, 22, 85");    // Escribe cuarto registro
                System.out.println("Archivo creado con registros iniciales."); // Mensaje de confirmación
            } catch (IOException e) { // Manejo de excepciones de IO
                System.out.println("Error al crear el archivo: " + e.getMessage()); // Mensaje de error
            }
        } else { // Si el archivo ya existe
            System.out.println("El archivo ya existe."); // Mensaje informativo
        }
    }
    
    // Método para leer y mostrar todo el contenido del archivo (acceso secuencial)
    public static void mostrarContenidoArchivo(String nombreArchivo) {
        System.out.println("Contenido del archivo:"); // Encabezado
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) { // Try-with-resources
            String linea; // Variable para almacenar cada línea leída
            while ((linea = reader.readLine()) != null) { // Lee mientras haya líneas
                System.out.println(linea); // Imprime la línea actual
            }
        } catch (IOException e) { // Manejo de excepciones
            System.out.println("Error al leer el archivo: " + e.getMessage()); // Mensaje de error
        }
    }
    
    // Método para mostrar una línea específica del archivo (acceso directo)
    public static void mostrarLineaEspecifica(String nombreArchivo, int numeroLinea) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) { // Try-with-resources
            String linea; // Variable para almacenar cada línea
            int contador = 1; // Contador de líneas
            
            while ((linea = reader.readLine()) != null) { // Lee mientras haya líneas
                if (contador == numeroLinea) { // Si encontramos la línea buscada
                    System.out.println("Línea " + numeroLinea + ": " + linea); // Muestra la línea
                    return; // Termina el método
                }
                contador++; // Incrementa el contador de líneas
            }
            
            System.out.println("La línea " + numeroLinea + " no existe en el archivo."); // Mensaje si no existe
        } catch (IOException e) { // Manejo de excepciones
            System.out.println("Error al leer el archivo: " + e.getMessage()); // Mensaje de error
        }
    }
    
    // Método para fusionar dos bloques ordenados (mezcla directa)
    public static int[] mezclaDirecta(int[] bloque1, int[] bloque2) {
        int[] resultado = new int[bloque1.length + bloque2.length]; // Crea array para resultado
        int i = 0, j = 0, k = 0; // Índices para bloques y resultado
        
        // Mientras ambos bloques tengan elementos
        while (i < bloque1.length && j < bloque2.length) {
            if (bloque1[i] <= bloque2[j]) { // Si elemento de bloque1 es menor o igual
                resultado[k++] = bloque1[i++]; // Agrega elemento de bloque1 al resultado
            } else { // Si elemento de bloque2 es menor
                resultado[k++] = bloque2[j++]; // Agrega elemento de bloque2 al resultado
            }
        }
        
        // Agrega elementos restantes de bloque1 (si los hay)
        while (i < bloque1.length) {
            resultado[k++] = bloque1[i++]; // Agrega elemento y avanza índices
        }
        
        // Agrega elementos restantes de bloque2 (si los hay)
        while (j < bloque2.length) {
            resultado[k++] = bloque2[j++]; // Agrega elemento y avanza índices
        }
        
        return resultado; // Retorna el array fusionado y ordenado
    }
    
    // Método para detectar corridas naturales en un arreglo
    public static void detectarCorridasNaturales(int[] arreglo) {
        System.out.print("Corridas naturales detectadas: ["); // Encabezado
        
        int inicio = 0; // Índice de inicio de la corrida actual
        boolean primeraCorrida = true; // Bandera para controlar comas
        
        // Recorre el arreglo desde el segundo elemento
        for (int i = 1; i < arreglo.length; i++) {
            if (arreglo[i] < arreglo[i-1]) { // Si rompe la secuencia ascendente
                if (!primeraCorrida) { // Si no es la primera corrida
                    System.out.print(", "); // Agrega coma separadora
                }
                System.out.print("[" + inicio + "-" + (i-1) + "]"); // Muestra la corrida
                primeraCorrida = false; // Actualiza bandera
                inicio = i; // Establece nuevo inicio de corrida
            }
        }
        
        // Procesa la última corrida
        if (!primeraCorrida) { // Si ya se mostraron corridas anteriores
            System.out.print(", "); // Agrega coma separadora
        }
        System.out.println("[" + inicio + "-" + (arreglo.length-1) + "]]"); // Muestra última corrida
    }
    
    // Método recursivo para contar estudiantes con nota >= 90
    public static int contarEstudiantesNotaAlta(String nombreArchivo, int lineaActual, int contador) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) { // Try-with-resources
            // Saltar líneas ya procesadas en llamadas recursivas anteriores
            for (int i = 0; i < lineaActual; i++) {
                reader.readLine(); // Lee y descarta la línea
            }
            
            String linea = reader.readLine(); // Lee la línea actual
            if (linea == null) { // Si no hay más líneas (fin de archivo)
                return contador; // Caso base: retorna el contador acumulado
            }
            
            // Procesar línea actual (omitir la cabecera que es línea 0)
            if (lineaActual > 0) { // Si no es la cabecera
                String[] partes = linea.split(","); // Divide la línea por comas
                if (partes.length >= 3) { // Si tiene al menos 3 partes (nombre, edad, nota)
                    try {
                        int nota = Integer.parseInt(partes[2].trim()); // Convierte la nota a entero
                        if (nota >= 90) { // Si la nota es mayor o igual a 90
                            contador++; // Incrementa el contador
                        }
                    } catch (NumberFormatException e) { // Si la nota no es un número válido
                        System.out.println("Error al procesar la nota en línea: " + linea); // Mensaje error
                    }
                }
            }
            
            // Llamada recursiva para la siguiente línea
            return contarEstudiantesNotaAlta(nombreArchivo, lineaActual + 1, contador);
            
        } catch (IOException e) { // Manejo de excepciones de IO
            System.out.println("Error al leer el archivo: " + e.getMessage()); // Mensaje de error
            return contador; // Retorna el contador acumulado hasta el error
        }
    }
}