import java.util.*;
public class NBody{
	public static double readRadius(String name){
		In in = new In(name);
		int num = in.readInt();
		double rad = in.readDouble();
		return rad; 
	}
	public static Planet[] readPlanets(String name){
		List<Planet> result = new ArrayList<Planet>();
		In in = new In(name);
		int num = in.readInt();
		double rad = in.readDouble();
		
		while(!in.isEmpty()){
			double xp = in.readDouble();
			double yp = in.readDouble();
			double xv = in.readDouble();
			double yv = in.readDouble();
			double m = in.readDouble();
			String file = in.readString();
			Planet temp = new Planet(xp,yp,xv,yv,m,file);
			result.add(temp);
		}
		int size=result.size(); 
		//System.out.println(size);
		//System.out.println(xp);
		return (Planet[])result.toArray(new Planet[size]);  
	}
	public static void main(String[] args){
		double TT = Double.valueOf(args[0]).doubleValue();
		double dt = Double.valueOf(args[1]).doubleValue();
		String filename = args[2];
		double rad = readRadius(filename);
		Planet[] planets = readPlanets(filename);
		StdDraw.setScale(- rad, rad);
		StdDraw.picture(0 ,0,"./images/starfield.jpg");
		for( Planet element : planets){
			element.draw();
		}

		
		double currtime = 0.0;
		int size = planets.length;
		while(currtime < TT){
			double[] xforce = new double[size];
			double[] yforce = new double[size];
			for(int i = 0; i<size; i++){
				xforce[i] = planets[i].calcNetForceExertedByX(planets);
				yforce[i] = planets[i].calcNetForceExertedByY(planets);
			}
			for(int i =0; i<size; i++){
				planets[i].update(dt, xforce[i], yforce[i]);
			}
			StdDraw.enableDoubleBuffering();
			StdDraw.picture(0 ,0,"./images/starfield.jpg");
			for( Planet element : planets){
				element.draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
			currtime = currtime + dt;

		} 
	}

}

