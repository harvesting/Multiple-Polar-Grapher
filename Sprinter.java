import gpdraw.*;
import java.lang.System;
import java.util.Random;

public class Sprinter {

	public static void main(String[] args) {

		SketchPad paper = new SketchPad(300, 300, 0);
		DrawingTool pen = new DrawingTool(paper);
		long INTERVAL = 1000000;

		for (double i = 0; i <= 10; i += .01) {

			Polar function = new Polar(Math.tan(i), 2, paper, pen);
			function.polarValues();
			function.rectValues();
			function.graph();

			long start = System.nanoTime();
			long end = 0;

			do {
				end = System.nanoTime();

			} while(start + INTERVAL >= end); {
				//System.out.println(end - start);

			}

			function.eraseGraph();




			//System.out.println(System.nanoTime());

		}

	}
}
