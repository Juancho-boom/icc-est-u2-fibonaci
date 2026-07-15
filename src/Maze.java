import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Maze {

    private int[][] laberinto;
    private Set<Celda> visitados;

    public Maze() {
        this.laberinto = new int[][]{
            {0, 0, 0, 1, 0, 0},
            {1, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 0, 0},
            {0, 1, 1, 0, 1, 0},
            {0, 1, 1, 0, 0, 0},
            {0, 1, 1, 0, 1, 0},
        };
    }
    public void resolver() {
        Celda inicio = new Celda(0, 0);
        Celda fin = new Celda(5, 5);
        List<Celda> camino = new ArrayList<>();
        visitados = new HashSet<>();
        
        boolean encontrado = encontrarCamino(laberinto, inicio, fin, camino, visitados);
        
        if (encontrado) {
            System.out.println("\nCamino encontrado:");
            printMazeWithPath(camino);
        } else {
            System.out.println("\nNo existe un camino.");
        }
    }

    public Set<Celda> getVisitados() {
        return visitados;
    }
    private void printMazeWithPath(List<Celda> camino) {
        for (int i = 0; i < laberinto.length; i++) {
            for (int j = 0; j < laberinto[i].length; j++) {
                Celda celdaActual = new Celda(i, j);
                
                if (camino.contains(celdaActual)) { 
                    System.out.print(" * ");
                } else if (laberinto[i][j] == 1) {
                    System.out.print(" # ");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
    }

    private boolean encontrarCamino(int[][] laberinto, Celda inicio, Celda fin, List<Celda> camino, Set<Celda> visitados) {
        int fila = inicio.getX();
        int columna = inicio.getY();

        if (fila < 0 || fila >= laberinto.length || columna < 0 || columna >= laberinto[0].length) {
            return false;
        }

        if (laberinto[fila][columna] == 1) {
            return false;
        }

        if (visitados.contains(inicio)) {
            return false;
        }
        visitados.add(inicio);

        if (inicio.equals(fin)) {
            camino.add(inicio);
            return true;
        }

        Celda derecha = new Celda(fila, columna + 1);
        if (encontrarCamino(laberinto, derecha, fin, camino, visitados)) {
            camino.add(inicio);
            return true;
        }
        Celda abajo = new Celda(fila + 1, columna);
        if (encontrarCamino(laberinto, abajo, fin, camino, visitados)) {
            camino.add(inicio);
            return true;
        }
        Celda izquierda = new Celda(fila, columna - 1);
        if (encontrarCamino(laberinto, izquierda, fin, camino, visitados)) {
            camino.add(inicio);
            return true;
        }
        Celda arriba = new Celda(fila - 1, columna);
        if (encontrarCamino(laberinto, arriba, fin, camino, visitados)) {
            camino.add(inicio);
            return true;
        }
        return false;
    }
}