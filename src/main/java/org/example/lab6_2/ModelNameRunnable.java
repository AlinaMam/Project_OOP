package org.example.lab6_2;

public class ModelNameRunnable implements Runnable {
    private TransportSynchronizer ts;

    public ModelNameRunnable(TransportSynchronizer ts) {
        this.ts = ts;
    }

    @Override
    public void run() {
        ts.printNameOfModel();
    }
}
