import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<ParallelMonteCarloPi> pi = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        System.out.println("Input iters");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        //Здесь добавляем объекты класса. которые оптом будем оборачивать в потоки
        //На один поток 1/8 от кол-ва вычислений
        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
            pi.add(new ParallelMonteCarloPi(n / 8));
            threads.add(new Thread(pi.get(i)));
        }

        long m = System.currentTimeMillis(); //замер времени на старте
        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
            threads.get(i).start();
        }

        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
            try {
                threads.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //Замер конца на окончании исполнения потоков
        double end = (double) (System.currentTimeMillis() - m);

        //Вывод информации
        System.out.println("Threads: " + Runtime.getRuntime().availableProcessors());
        System.out.println("Iteration per thread: " + n / Runtime.getRuntime().availableProcessors());
        System.out.println("Time: " + end + " ms");
        System.out.println("Pi: " + ParallelMonteCarloPi.calcPi());
    }


}