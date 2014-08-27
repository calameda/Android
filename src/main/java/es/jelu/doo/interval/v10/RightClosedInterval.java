package es.jelu.doo.interval.v10;

class RightClosedInterval extends OpenedInterval {

	public RightClosedInterval(double lowerEndpoint, double upperEndpoint) {
		super(lowerEndpoint, upperEndpoint);
	}
	
	public boolean include(double value) {
		return upperEndpoint == value || super.include(value);
	}

}

