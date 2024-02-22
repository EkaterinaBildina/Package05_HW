public class Main {
    public static void main(String[] args) {

        // Вилки лежат на столе между каждой парой ближайших философов
        ForkID[] forks = new ForkID[5];
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new ForkID(i);
        }


        // Пять безмолвных философов сидят вокруг круглого стола,
        Philosopher[] philosophers = new Philosopher[5];

        for (int i = 0; i < philosophers.length; i++) {
            if (i == 0) {
                philosophers[0] = new Philosopher(i, forks[i], forks[forks.length - 1]);
            } else {
                philosophers[i] = new Philosopher(i, forks[i], forks[(i - 1)]);
            }


        }


        for (Philosopher phil : philosophers) {
                new Thread(phil).start();
                           }


    }
}
