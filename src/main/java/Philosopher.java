public class Philosopher implements Runnable {
    private final int philNum;
    private final ForkID rightForkPosition;
    private final ForkID leftForkPosition;


    public Philosopher(int philNum, ForkID rightForkPosition, ForkID leftForkPosition) {
        this.philNum = philNum;
        this.rightForkPosition = rightForkPosition;
        this.leftForkPosition = leftForkPosition;

    }

    // Каждый философ может либо есть, либо размышлять.
    @Override
    public void run() {
        while (true) {
            //Философ не может есть два раза подряд,
            //не прервавшись на размышления
            System.out.println("Филосов " + philNum + " размышляет.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
            //Философ может есть только тогда,
            // когда держит две вилки — взятую справа и слева.

            synchronized (rightForkPosition) {
                synchronized (leftForkPosition) {
                    System.out.println("Филосов " + philNum + " держит вилки " + rightForkPosition.getForkID()
                            + " в правой руке и " + leftForkPosition.getForkID() + " в левой руке. ЕСТ");
                     try {

                        rightForkPosition.pickUpFork();
                        leftForkPosition.pickUpFork();
                        Thread.sleep(1000);
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                    }
                }

            }
            // после чего положить вилки на место,
            // что позволит другим философам взять их


            rightForkPosition.putDownFork();
            //System.out.println("Филосов " + philNum + " положил правую вилку");
            leftForkPosition.putDownFork();
            //System.out.println("Филосов " + philNum + " положил левую вилку");
            System.out.println("Филосов " + philNum + " положил вилки на стол");
        }
    }
}
