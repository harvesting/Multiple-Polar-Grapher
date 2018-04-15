import java.util.*;
import gpdraw.*;
import java.awt.Color;

public class Polar {

	private DrawingTool marker;
	private SketchPad paper;
	private ArrayList <Double> numR;
	private ArrayList <Double> numTheta;
	private ArrayList <Double> rectX;
	private ArrayList <Double> rectY;
	private double increment;
	private int piInc;

	public Polar(double incrementTheta, int piIncrement, SketchPad paper, DrawingTool pen) {

		increment = incrementTheta;
		piInc = piIncrement;
		this.paper = paper;
		this.marker = pen;
		numR = new ArrayList <Double>();
		numTheta = new ArrayList <Double>();
		rectX = new ArrayList <Double>();
		rectY = new ArrayList <Double>();

	}

	public void polarValues() {

		for (double x = 0; x <= 360; x += .1) {

			numTheta.add(x);
            //equation goes after 100. ex. tan(theta)
			numR.add(100 * Math.tan(increment * (x)));
		}
	}

	//x = r * cos theta, y = r * sin theta

	public void rectValues() {

		for (int x = 0; x < numR.size(); x++) {

			rectX.add(numR.get(x) * Math.cos(numTheta.get(x)));
			rectY.add(numR.get(x) * Math.sin(numTheta.get(x)));
		}
	}

	public void graph() {

		marker.up();
		marker.move(rectX.get(0), rectY.get(0));
		marker.down();

		for (int x = 0; x < rectX.size(); x++) {

			double coordX = rectX.get(x);
			double coordY = rectY.get(x);
			marker.move(coordX, coordY);

			//used to print x and y coordinates (makes it run a lot slower)
			//System.out.println(coordX);
			//System.out.println(coordY);

			}
			marker.move(0,0);
	}

	public void eraseGraph() {

		marker.setColor(Color.WHITE);
		marker.up();
		marker.move(-.5* paper.getWidth(), -.5 * paper.getHeight());
		marker.down();
		marker.fillRect(2 * paper.getWidth(),2 * paper.getHeight());
		marker.setColor(Color.BLACK);


	}

}
