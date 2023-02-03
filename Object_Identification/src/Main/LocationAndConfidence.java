package Main;

public class LocationAndConfidence {
	private int x;
	private int y;
	private double confidence;
	public LocationAndConfidence(int x, int y, double confidence) {
		this.x = x;
		this.y = y;
		this.confidence = confidence;
	}
	public double getConfidence() {
		return confidence;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
