package es.jelu.doo.interval.v10;

abstract class IntervalImplementation implements Interval {
	
	abstract boolean isLowerEndpoint(double lowerEndpoint);

	abstract boolean isUpperEndpoint(double upperEndpoint);
	
	abstract boolean included(Interval interval);
	
	public abstract Interval copy();
	
}