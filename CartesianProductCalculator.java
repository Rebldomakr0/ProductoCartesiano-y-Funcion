import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CartesianProductCalculator {
    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de elementos en los arreglos: ");
        int cantidad = scanner.nextInt();

        List<Object> arreglo1 = leerArreglo(cantidad, scanner);
        List<Object> arreglo2 = leerArreglo(cantidad, scanner);

        List<Pair<Object, Object>> pares = generarProductoCartesiano(arreglo1, arreglo2);

        mostrarProductoCartesiano(pares);

        FunctionChecker functionChecker = new FunctionChecker();
        boolean esFuncion = functionChecker.esFuncion(pares);

        if (esFuncion) {
            System.out.println("\n¡Los conjuntos de elementos forman una función!");
        } else {
            System.out.println("\nLos conjuntos de elementos no forman una función.");
        }

        scanner.close();
    }

    private List<Object> leerArreglo(int cantidad, Scanner scanner) {
        List<Object> arreglo = new ArrayList<>();
        System.out.print("Ingrese los elementos del arreglo: ");
        for (int i = 0; i < cantidad; ++i) {
            Object elem = leerElemento(scanner);
            arreglo.add(elem);
        }
        return arreglo;
    }

    private Object leerElemento(Scanner scanner) {
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
            return scanner.next();
        }
    }

    private List<Pair<Object, Object>> generarProductoCartesiano(List<Object> arreglo1, List<Object> arreglo2) {
        List<Pair<Object, Object>> pares = new ArrayList<>();
        for (Object elem1 : arreglo1) {
            for (Object elem2 : arreglo2) {
                pares.add(new Pair<>(elem1, elem2));
            }
        }
        Collections.sort(pares, (a, b) -> {
            int compareFirst = a.getFirst().toString().compareTo(b.getFirst().toString());
            return (compareFirst != 0) ? compareFirst : a.getSecond().toString().compareTo(b.getSecond().toString());
        });
        return pares;
    }

    private void mostrarProductoCartesiano(List<Pair<Object, Object>> pares) {
        System.out.print("Multiplicación Cartesiana: ");
        for (Pair<Object, Object> p : pares) {
            System.out.print("{" + p.getFirst() + ", " + p.getSecond() + "} ");
        }
    }
}
