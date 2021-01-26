class Producer implements Runnable {

    private MyBlockingQueue customBlockingQueue;

    public Producer(MyBlockingQueue customBlockingQueue){
        this.customBlockingQueue = customBlockingQueue;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {

                customBlockingQueue.put(i);

            } catch (InterruptedException e) {
                e.getMessage();
            }
        }
    }

}