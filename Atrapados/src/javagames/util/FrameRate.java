package javagames.util;

public class FrameRate {
    private String frameRate;
    private long lastTime;
    private long delta;
    private int framCount;

    public void initialize() {
        lastTime = System.currentTimeMillis();
        frameRate = "FPS 0";
    }

    public void calculate() {
        long current = System.currentTimeMillis();
        delta += current - lastTime;
        lastTime = current;
        framCount++;
        if(delta > 1000) {
            delta -= 1000;
            frameRate = String.format("FPS %s", framCount);
            framCount = 0;
        }
    }

    public String getFrameRate() {
        return frameRate;
    }
}
