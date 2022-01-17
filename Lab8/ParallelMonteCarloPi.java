public class ParallelMonteCarloPi implements Runnable {

    /*
    * Кол-во раз исполнения
    * */
    public ParallelMonteCarloPi(int n) {
        this.N= n;
    }


    static int N = 10; //Кол-во раз вычисления
    static volatile int sum = 0; //Сколько раз попали в круг
    double x, y; //x y переменные

    //Считаем PI по формуле, с учетом, что потоков было несколько
    static public double calcPi() {
        return (double) 4 * sum / N / Runtime.getRuntime().availableProcessors();
    }

    //В потоке считаем кол-во попавших точек в сумму
    @Override
    public void run() {
        for(int i = 0; i < N; i++) {
            x = Math.random();
            y = Math.random();
            if ((x * x + y * y) < 1) {
                sum++;
            }
        }
    }
}
