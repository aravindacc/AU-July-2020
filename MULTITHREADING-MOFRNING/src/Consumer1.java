class Consumer1 implements Runnable {
    private MyBlockingQueue customBlockingQueue;

    public Consumer1(MyBlockingQueue customBlockingQueue){
        this.customBlockingQueue = customBlockingQueue;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                customBlockingQueue.take();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}