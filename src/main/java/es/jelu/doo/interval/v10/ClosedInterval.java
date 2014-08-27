package es.jelu.doo.interval.v10;

class ClosedInterval extends OpenedInterval {

	public ClosedInterval(double lowerEndpoint, double upperEndpoint) {
		super(lowerEndpoint, upperEndpoint);
	}
	
	public boolean include(double value) {
		return lowerEndpoint == value || upperEndpoint == value
				|| super.include(value);
	}

	public boolean include(Interval interval) {
		return interval.include(lowerEndpoint)
				&& interval.include(lowerEndpoint) && interval.include(this);
	}
}