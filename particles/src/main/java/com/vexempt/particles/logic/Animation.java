package com.vexempt.particles.logic;

import java.util.ArrayList;
import java.util.List;

public class Animation {
	
	public List<String> animate(String init, int speed) {
		List<String> result = new ArrayList<String>();
		Chamber chamber = new Chamber();
		chamber.init(init);
		
		String currentFrame = "";
		do {
			currentFrame = chamber.getFrame();
			result.add(currentFrame);
			chamber.shift(speed);
		} while (!flushed(currentFrame));
		
		return result;
	}
	
	private boolean flushed(String frame) {
		return !frame.contains("X");
	}

}
