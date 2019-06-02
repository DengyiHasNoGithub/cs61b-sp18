public class Body{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public double G = 6.67e-11;

	public Body (double xP, double yP, double xV, double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Body (Body b) {
		b.xxPos = xxPos;
		b.yyPos = yyPos;
		b.xxVel = xxVel;
		b.yyVel = yyVel;
		b.mass = mass;
		b.imgFileName = imgFileName;
	}

	public double calcDistance(Body b2) {
		double xdis = (this.xxPos - b2.xxPos) * (this.xxPos - b2.xxPos);
		double ydis = (this.yyPos - b2.yyPos) * (this.yyPos - b2.yyPos);
		return Math.sqrt(xdis + ydis); 
	}

	public double calcForceExertedBy(Body b3) {
		return (G * mass * (b3.mass))/((this.calcDistance(b3))*(this.calcDistance(b3)));
	}

	public double calcForceExertedByX(Body b4) {
		return this.calcForceExertedBy(b4) * (b4.xxPos - this.xxPos) / (this.calcDistance(b4));
	}

	public double calcForceExertedByY(Body b5) {
		return this.calcForceExertedBy(b5) * (b5.yyPos - this.yyPos) / (this.calcDistance(b5));
	}

	public double calcNetForceExertedByX(Body[] allBodys) {
		double xforce = 0;
		int len = allBodys.length;
		for (int i=0; i<len; i=i+1) {
			if (! this.equals(allBodys[i])){
				xforce = xforce + this.calcForceExertedByX(allBodys[i]);
			}
		}
		return xforce;
	}

	public double calcNetForceExertedByY(Body[] allBodys) {
		double yforce = 0;
		int len = allBodys.length;
		for (int i=0; i<len; i=i+1) {
			if (! this.equals(allBodys[i]))
			yforce = yforce + this.calcForceExertedByY(allBodys[i]);
		}
		return yforce;
	}

	public void update(double t, double fx, double fy) {
		double ax = fx/this.mass;
		double ay = fy/this.mass;
		this.xxVel = this.xxVel + t * ax;
		this.yyVel = this.yyVel + t * ay;
		this.xxPos = this.xxPos + t * this.xxVel;
		this.yyPos = this.yyPos + t * this.yyVel;
	}

	public static void draw(double x, double y, String bodyimage) {
		String bodyadr = "./images/" + bodyimage;
		StdDraw.picture(x, y, bodyadr);
	}

}