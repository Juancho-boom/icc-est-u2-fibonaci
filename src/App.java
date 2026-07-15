public class App {
    public static void main(String[] args) throws Exception {
       // System.out.println("Lento-");
       // runFibonaci();
       // System.out.println("Rapido");
       // runFibonaciRecPD();
       // System.out.println("---------------");

       // System.out.println("Lento");
       // runFibonaciIterativo();
       // System.out.println("Rapido");
       // runFibonaciIterativoRapido();

        runMaze();
    }

    private static void runMaze() {
        Maze maze = new Maze();
        maze.resolver();
        System.out.println("\nCeldas visitadas:");
        System.out.println(maze.getVisitados());
    }
    
    private static void runFibonaciIterativo() {
        long startTime = System.nanoTime();
        int num = 48;
        long i = getFibonacciIter(num);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        double milliseconds = (executionTime / 1_000_000.0);

        System.out.println("Finbonaci de " + num + " es " + i + "  en: " + milliseconds + " milliseconds");
    }
    public static long getFibonacciIter(int num){
        if (num <= 1) 
            return num;
        long[] cache = new long[num+1];
        cache[0] = 0; cache[1] = 1;
        for (int i = 2; i <= num; i++){
            cache[i] = cache[i-1] + cache[i-2];
        }
        return cache[num];
    }


    private static void runFibonaciIterativoRapido() {
        long startTime = System.nanoTime();
        int num = 48;
        long i = getFibonacciIter2(num);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        double milliseconds = (executionTime / 1_000_000.0);

        System.out.println("Finbonaci de " + num + " es " + i + "  en: " + milliseconds + " milliseconds");
    }

    public static long getFibonacciIter2(int num){
        if (num <= 1) 
            return num;
        long a = 0, b =1;
        long res = 0;
        for (int i = 2; i <= num; i++){
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }





    private static void runFibonaciRecPD() {
        long startTime = System.nanoTime();
        int num = 48;
        long i = getFibonacci(num);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        double milliseconds = (executionTime / 1_000_000.0);

        System.out.println("Finbonaci de " + num + " es " + i + "  en: " + milliseconds + " milliseconds");
    }

    public static long getFibonacciPD(int num, long[] cache){
       
        return 0;
    }

    public static long getFibonacciPD2(int num, long[] cache){
        if (num <= 1)
            return num;
        if(cache[num] != 0){
            return cache[num];
        }
        cache[num] = getFibonacciPD(num- 1, cache)+ getFibonacciPD(num-2, cache);
        return cache[num];
    }

    private static void runFibonaci() {
        long startTime = System.nanoTime();
        int num = 48;
        long i = getFibonacci(num);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        double milliseconds = (executionTime / 1_000_000.0);

        System.out.println("Finbonaci de " + num + " es " + i + "  en: " + milliseconds + " milliseconds");

    }

    private static long getFibonacci(int i) {
        if (i <= 1) {
            return i;
        }
        return getFibonacci(i - 1) + getFibonacci(i - 2);
    }

    
}