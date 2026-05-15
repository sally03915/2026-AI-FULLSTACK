package cyj.tracker.basic;

public class AppStatus {
	private boolean running = true;

    public boolean isRunning() { return running; }
    public void stop() { this.running = false; }
}
