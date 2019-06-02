public class NBody{
	public static double readRadius(String fname) {
		In in = new In(fname);

		int num = in.readInt();
		double radius = in.readDouble();
		return radius;
	}

	public static Body[] readBodies(String fname2) {
		In in = new In(fname2);
		int num = in.readInt();
		Body[] Bodies = new Body[num];
		double radius = in.readDouble();
		int i = 0;
		while(i < num) {
			double xpos = in.readDouble();
			double ypos = in.readDouble();
			double xvel = in.readDouble();
			double yvel = in.readDouble();
			double mass = in.readDouble();
			String name = in.readString();
			Body ibody = new Body(xpos, ypos, xvel, yvel, mass, name);
			Bodies[i] = ibody;
			i = i + 1;
		}
		return Bodies;			
	}

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double r = readRadius(filename);
		Body[] bodys = readBodies(filename);

		StdDraw.enableDoubleBuffering();
		StdDraw.setScale(-r, r);
		StdDraw.clear();

		double t = 0;
		while(t < T) {
			int bodynum = bodys.length;
			double[] xForces = new double[bodynum];
			double[] yForces = new double[bodynum];
			for(int j = 0; j < bodynum; j = j + 1) {
				xForces[j] = bodys[j].calcNetForceExertedByX(bodys);
				yForces[j] = bodys[j].calcNetForceExertedByY(bodys);
			}

			for(int k = 0; k < bodynum; k = k + 1) {
				bodys[k].update(dt, xForces[k], yForces[k]);
			}

			StdDraw.picture(0, 0, "./images/starfield.jpg");
			for (int i = 0; i < bodynum; i = i + 1) {
				Body.draw(bodys[i].xxPos, bodys[i].yyPos, bodys[i].imgFileName);
			}
			StdDraw.show();
			StdDraw.pause(10);
			t = t + dt;
		}
		StdOut.printf("%d\n", bodys.length);
		StdOut.printf("%.2e\n", r);
		for (int i = 0; i < bodys.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  bodys[i].xxPos, bodys[i].yyPos, bodys[i].xxVel,
                  bodys[i].yyVel, bodys[i].mass, bodys[i].imgFileName);   
		}
	}
}