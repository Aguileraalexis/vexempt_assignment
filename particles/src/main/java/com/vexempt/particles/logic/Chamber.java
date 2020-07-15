package com.vexempt.particles.logic;

public class Chamber {
	
	private LeftChamber left = new LeftChamber();
	private RightChamber right = new RightChamber();
	private int dataLength = 0;
	
	public void init(String data) {
		this.dataLength = data.length();
		left.init(data);
		right.init(data);
	}

	public String getFrame() {
		StringBuilder currentFrame = new StringBuilder();
		for (int i = 0; i < dataLength; i++) {
			currentFrame.append(left.cellHasValue(i) || right.cellHasValue(i) ? "X" : ".");
		}
		return currentFrame.toString();
	}

	public void shift(int speed) {
		left.shift(speed);
		right.shift(speed);
	}

}
