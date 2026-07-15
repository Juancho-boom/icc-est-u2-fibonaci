import java.util.Objects;

/**
 *
 */
public class Celda {
    private int fila;
    private int columna;


    public Celda(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }


    public Celda() {
    }


    public int getFila() {
        return fila;
    }


    public void setFila(int fila) {
        this.fila = fila;
    }


    public int getColumna() {
        return columna;
    }


    public void setColumna(int columna) {
        this.columna = columna;
    }


    public int getX() {
        return fila;
    }


    public int getY() {
        return columna;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Celda other = (Celda) obj;
        return fila == other.fila && columna == other.columna;
    }


    @Override
    public int hashCode() {
        return Objects.hash(fila, columna);
    }


    @Override
    public String toString() {
        return "Celda [fila=" + fila + ", columna=" + columna + ", getFila()=" + getFila() + ", getColumna()="
                + getColumna() + ", getX()=" + getX() + ", getY()=" + getY() + ", getClass()=" + getClass()
                + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

}