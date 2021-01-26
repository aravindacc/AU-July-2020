class Consumer2 implements Runnable {
    private MyBlockingQueue customBlockingQueue;

    public Consumer2(MyBlockingQueue customBlockingQueue){
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