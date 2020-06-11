package com.vincentperrier.softOscilloscope;

public class inputDummy {
    controller dataDestionation;

    public inputDummy(controller c) {
        this.dataDestionation = c;
    }

    public void loopRead() {
        for (int i = 0; i < 7; i++) {
            try {
                Thread.sleep(100);
                float array[] = new float[1000];
                for (int x = 0; x < 1000; x++) {
                    float work = (2.0f * (float)Math.PI);
                    array[x] = (float) Math.sin(Math.toRadians(work * x/i));
                    array[x] = array[x] * 10 * i;
                }
                this.dataDestionation.treatIncomingSamples(array);
                System.out.println("looping");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
