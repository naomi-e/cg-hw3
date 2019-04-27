package edu.cg.scene.lightSources;

import edu.cg.algebra.Ops;
import edu.cg.algebra.Point;
import edu.cg.algebra.Ray;
import edu.cg.algebra.Vec;
import edu.cg.scene.objects.Surface;

public class DirectionalLight extends Light {
	private Vec direction = new Vec(0, -1, -1);

	public DirectionalLight initDirection(Vec direction) {
		this.direction = direction;
		return this;
	}

	@Override
	public String toString() {
		String endl = System.lineSeparator();
		return "Directional Light:" + endl + super.toString() +
				"Direction: " + direction + endl;
	}

	@Override
	public DirectionalLight initIntensity(Vec intensity) {
		return (DirectionalLight)super.initIntensity(intensity);
	}
	
	public Vec getDirection(Point p) {
		return this.direction.normalize().neg();
	}
	
	public Vec getIntensity(Point p) {
		return this.intensity;
	}
	
	public double getDistance(Point p) {
		return Ops.infinity;
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
