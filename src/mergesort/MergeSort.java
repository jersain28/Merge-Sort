/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mergesort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author jersain
 */
public class MergeSort {
   public static void main(String[] args) throws IOException {

        // Solicitamos el nombre del archivo de texto a leer
        System.out.println("Escribe el nombre del archivo de texto a leer:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        // Abrimos el archivo de texto
        FileReader fileReader = new FileReader("D:\\" + fileName);

        // Leemos el número de líneas del archivo de texto
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int numLines = 0;
        while(bufferedReader.readLine() != null){
            numLines++;
        }

        // Volvemos al inicio del archivo
        bufferedReader.close();
        fileReader = new FileReader("D:\\" + fileName);
        bufferedReader = new BufferedReader(fileReader);

        // Inicializamos el arreglo numbers
        int[] numbers = new int[numLines];

        // Leemos los números del archivo de texto y los guardamos en el arreglo
        System.out.println("Los numeros desordenados son:");
        for (int i = 0; i < numLines; i++) {
            String line = bufferedReader.readLine();
            if (line.isEmpty()) {
                System.out.println("Error: Se encontró una línea vacía en el archivo.");
                break;
            } else {
                numbers[i] = Integer.parseInt(line);
                System.out.print(numbers[i] + " ");
            }
        }

        // Salto de línea después de imprimir los números desordenados
        System.out.println();

        // Ordenamos los números
        mergeSort(numbers, 0, numbers.length - 1);

        // Imprimimos los números ordenados
        System.out.println("Los numeros ordenados son:");
        System.out.println(Arrays.toString(numbers));
    }

    public static void mergeSort(int[] numbers, int inicio, int fin) {

        // Si el arreglo tiene un solo elemento, no es necesario ordenarlo
        if (inicio >= fin) {
            return;
        }

        // Calculamos el punto medio del arreglo
        int medio = (inicio + fin) / 2;

        // Ordenamos la primera mitad del arreglo
        mergeSort(numbers, inicio, medio);

        // Ordenamos la segunda mitad del arreglo
        mergeSort(numbers, medio + 1, fin);

        // Fusionamos las dos mitades ordenadas
        merge(numbers, inicio, medio, fin);
    }

    public static void merge(int[] numbers, int inicio, int medio, int fin) {

        // Creamos dos arreglos temporales para almacenar las dos mitades ordenadas
        // El tamaño de los arreglos temporales es el mismo que el de las mitades del arreglo original
        int[] left = new int[medio - inicio + 1];
        int[] right = new int[fin - medio];

        // Copiamos los elementos de la primera mitad del arreglo al arreglo temporal izquierdo
        for (int i = inicio; i <= medio; i++) {
            left[i - inicio] = numbers[i];
        }

        // Copiamos los elementos de la segunda mitad del arreglo al arreglo temporal derecho
        for (int i = medio + 1; i <= fin; i++) {
            right[i - medio - 1] = numbers[i];
        }

        // Inicializamos los índices de los arreglos temporales
        int i = 0;
        int j = 0;

        // Inicializamos el índice del arreglo original
        int k = inicio;

        // Comparamos los elementos de los dos arreglos temporales y los copiamos al arreglo original en orden
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                numbers[k] = left[i];
                i++;
            } else {
                numbers[k] = right[j];
                j++;
            }
            k++;
        }

        // Copiamos los elementos restantes del arreglo temporal izquierdo al arreglo original
        while (i < left.length) {
            numbers[k] = left[i];
            i++;
            k++;
        }

        // Copiamos los elementos restantes del arreglo temporal derecho al arreglo original
        while (j < right.length) {
            numbers[k] = right[j];
            j++;
            k++;
        }   
    }
    
}
