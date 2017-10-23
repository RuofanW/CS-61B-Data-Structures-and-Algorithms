public class Planet{
	double xxPos;
	double yyPos;
	double xxVel;
	double yyVel;
	double mass;
	String imgFileName;
	static float GCON = 6.67e-11f;

	public Planet (double xP, double yP, double xV,double yV, double m, String img){
		this.xxPos = xP;
		this.yyPos = yP;
		this.xxVel = xV;
		this.yyVel = yV;
		this.mass = m;
		this.imgFileName = img;
	}
	public Planet(Planet p){
		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName = p.imgFileName;
	}
	public double calcDistance(Planet supplied){
		double dx = this.xxPos - supplied.xxPos;
		double dy = this.yyPos - supplied.yyPos;
		return Math.sqrt(dx * dx + dy * dy);
	}

	public double calcForceExertedBy(Planet supplied){
		double dis = this.calcDistance(supplied);
		double FC = GCON * this.mass * supplied.mass /dis /dis;
		return FC; 
	}
	public double calcForceExertedByX(Planet supplied){
		double FC = this.calcForceExertedBy(supplied);
		double dis = this.calcDistance(supplied);
		double dx = supplied.xxPos - this.xxPos ;
		double FCX = FC * dx / dis;
		return FCX;
	}
	public double calcForceExertedByY(Planet supplied){
		double FC = this.calcForceExertedBy(supplied);
		double dis = this.calcDistance(supplied);
		double dy = supplied.yyPos - this.yyPos ;
		double FCY = FC * dy / dis;
		return FCY;
	}
	public double calcNetForceExertedByX(Planet[] allPlanets){
		int num = allPlanets.length;
		double[] result = new double[num];
		for(int i=0; i<num; i++){
			if(this == allPlanets[i]){
				result[i] = 0.0;
			}
			else{
				result[i] = this.calcForceExertedByX(allPlanets[i]);
			}
		}
		double sum = 0;
		for(int j=0; j<num; j++){
			sum = result[j] + sum;
		}
		return sum; 
	}

	public double calcNetForceExertedByY(Planet[] allPlanets){
		int num = allPlanets.length;
		double[] result = new double[num];
		for(int i=0; i<num; i++){
			if(this == allPlanets[i]){
				result[i] = 0.0;
			}
			else{
				result[i] = this.calcForceExertedByY(allPlanets[i]);
			}
		}
		double sum = 0;
		for(int j=0; j<num; j++){
			sum = result[j] + sum;
		}
		return sum;  
	}

	public void update(double dt,double fX,double fY){
		double ax = fX / this.mass;
		double ay = fY / this.mass;
		double vx = this.xxVel + ax * dt;
		double vy = this.yyVel + ay * dt;
		double px = this.xxPos + vx * dt;
		double py = this.yyPos + vy * dt;
		this.xxVel = vx;
		this.yyVel = vy;
		this.xxPos = px;
		this.yyPos = py;
	}

	public void draw(){
		StdDraw.picture(this.xxPos, this.yyPos, "./images/"+this.imgFileName);
	}
}