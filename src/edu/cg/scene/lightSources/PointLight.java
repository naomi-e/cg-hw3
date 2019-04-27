package edu.cg.scene.lightSources;

import edu.cg.algebra.Hit;
import edu.cg.algebra.Point;
import edu.cg.algebra.Ray;
import edu.cg.algebra.Vec;
import edu.cg.scene.objects.Surface;

public class PointLight extends Light {
	protected Point position;

	// Decay factors:
	protected double kq = 0.01;
	protected double kl = 0.1;
	protected double kc = 1;

	protected String description() {
		String endl = System.lineSeparator();
		return "Intensity: " + intensity + endl + "Position: " + position + endl + "Decay factors: kq = " + kq
				+ ", kl = " + kl + ", kc = " + kc + endl;
	}

	@Override
	public String toString() {
		String endl = System.lineSeparator();
		return "Point Light:" + endl + description();
	}

	@Override
	public PointLight initIntensity(Vec intensity) {
		return (PointLight) super.initIntensity(intensity);
	}

	public PointLight initPosition(Point position) {
		this.position = position;
		return this;
	}

	public PointLight initDecayFactors(double kq, double kl, double kc) {
		this.kq = kq;
		this.kl = kl;
		this.kc = kc;
		return this;
	}

	public Vec getDirection(Point src) {
		Vec direction = this.position.sub(src).normalize();
		return direction;
	}

	public Vec getIntensity(Point src) {
		double d = this.position.sub(src).norm();
		double decay = this.kc + this.kl * d + this.kq * d * d;
		return this.intensity.mult(1 / decay);
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