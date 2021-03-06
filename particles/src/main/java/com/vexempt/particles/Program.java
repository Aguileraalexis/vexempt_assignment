package com.vexempt.particles;

import java.util.List;

import com.vexempt.particles.logic.Animation;

public class Program {

	public static void main(String[] args) {

		Animation animation = new Animation();
		String data = "";
		int speed = 0;

		data = "..R....";
		speed = 2;
		output(animation.animate(data, speed), data + " -> " + speed);

		data = "RR..LRL";
		speed = 3;
		output(animation.animate(data, speed), data + " -> " + speed);

		data = "LRLR.LRLR";
		speed = 2;
		output(animation.animate(data, speed), data + " -> " + speed);

		data = "RLRLRLRLRL";
		speed = 10;
		output(animation.animate(data, speed), data + " -> " + speed);

		data = "...";
		speed = 1;
		output(animation.animate(data, speed), data + " -> " + speed);

		data = "LRRL.LR.LRR.R.LRRL.";
		speed = 1;
		output(animation.animate(data, speed), data + " -> " + speed);

	}

	private static void output(List<String> result, String title) {
		System.out.println("\nDATA: " + title + "\n");
		result.forEach(item -> System.out.println(item));
		System.out.println("\n");
	}
	
}
