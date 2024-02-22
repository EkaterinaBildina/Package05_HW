public class ForkID {


    private final int forkID;
    private boolean forkInHande = false;

    public ForkID(int forkID) {
        this.forkID = forkID;
    }

    public int getForkID() {
        return forkID;
    }

    public synchronized void pickUpFork() throws InterruptedException {
        while (forkInHande){
                wait();
        }
        forkInHande = true;
    }

       public synchronized void putDownFork(){
        forkInHande = false;
        notifyAll();
    }
}
