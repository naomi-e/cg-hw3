package edu.cg.scene.lightSources;

import edu.cg.algebra.Point;
import edu.cg.algebra.Ray;
import edu.cg.algebra.Vec;
import edu.cg.scene.objects.Surface;

public class Spotlight extends PointLight {
	private Vec direction;
	private double angle = 0.866; //cosine value ~ 30 degrees
	
	public Spotlight initDirection(Vec direction) {
		this.direction = direction;
		return this;
	}
	
	public Spotlight initAngle(double angle) {
		this.angle = angle;
		return this;
	}
	
	@Override
	public String toString() {
		String endl = System.lineSeparator();
		return "Spotlight: " + endl +
				description() + 
				"Direction: " + direction + endl +
				"Angle: " + angle + endl;
	}
	
	@Override
	public Spotlight initPosition(Point position) {
		return (Spotlight)super.initPosition(position);
	}
	
	@Override
	public Spotlight initIntensity(Vec intensity) {
		return (Spotlight)super.initIntensity(intensity);
	}
	
	@Override
	public Spotlight initDecayFactors(double q, double l, double c) {
		return (Spotlight)super.initDecayFactors(q, l, c);
	}
	
	@Override
	public Vec getDirection(Point src) {
		Vec direction = this.position.sub(src).normalize();
		return direction;
	}
	
	public Vec getIntensity(Point src) {
		double d = this.position.sub(src).norm();
		Vec dir = this.getDirection(src);
		double theta = this.direction.neg().normalize().dot(this.getDirection(src));
		double decay = this.kc + this.kl*d + this.kq*d*d;
		if(theta < angle) {
			return new Vec(0,0,0);
		}
		return this.intensity.mult(theta/decay);
	}
	
	public double getDistance(Point src) {
		return this.position.sub(src).norm();
	}
	
	@Override
	public Ray rayToLight(Point fromPoint) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isOccludedBy(Surface surface, Ray rayToLight) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Vec intensity(Point hittingPoint, Ray rayToLight) {
		// TODO Auto-generated method stub
		return null;
	}
}