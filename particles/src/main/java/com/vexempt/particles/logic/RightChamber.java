package com.vexempt.particles.logic;

public class RightChamber {

	private boolean[] hasParticle;
	private int cursor = 0;
	
	public void init(String data) {

		this.cursor = 0;
		hasParticle = new boolean[data.length()]; // all initially false
		for (int i = 0; i < data.length(); i++) {
			if (data.charAt(i) == 'R')
				hasParticle[i] = true;
		}
		
	}
	
	public void shift(int speed) {
		for (int i = 0; i < speed; i++ ) {
			cursor--;
			if (cursor < 0) cursor = hasParticle.length - 1;
			hasParticle[cursor] = false;
		}
	}
	
	public boolean cellHasValue(int index) {
		index += cursor;
		if (index >= hasParticle.length) index -= hasParticle.length;
		return hasParticle[index];
	}
	
}
