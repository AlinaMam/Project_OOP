package org.example.lab6_2;

public class PriceNameRunnable implements Runnable {
    private TransportSynchronizer ts;

    public PriceNameRunnable(TransportSynchronizer ts) {
        this.ts = ts;
    }

    @Override
    public void run() {
        ts.printPrice();
    }
}
