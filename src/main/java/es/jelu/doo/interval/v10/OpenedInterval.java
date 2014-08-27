package es.jelu.doo.interval.v10;

class OpenedInterval extends IntervalImplementation {

    protected double lowerEndpoint;
	protected double upperEndpoint;

    public OpenedInterval(double lowerEndpoint, double upperEndpoint) {
        this.lowerEndpoint = lowerEndpoint;
        this.upperEndpoint = upperEndpoint;
    }
    
	public boolean isLowerEndpoint(double lowerEndpoint){
		return this.lowerEndpoint == lowerEndpoint;
	}

	public boolean isUpperEndpoint(double upperEndpoint){
		return this.upperEndpoint == upperEndpoint;
	}
	
	public double length() {
		return upperEndpoint - lowerEndpoint;
	}

	public double midpoint() {
		return lowerEndpoint + this.length() / 2;
	}

	public boolean include(double value) {
		return upperEndpoint < value && value < upperEndpoint;
	}

	public boolean include(Interval interval) {
		return ((IntervalImplementation) interval).included(this);
	}
	
	public boolean included(Interval interval) {
		return (interval.include(lowerEndpoint) || ((IntervalImplementation) interval).isLowerEndpoint(lowerEndpoint))
				&& (interval.include(upperEndpoint) || ((IntervalImplementation) interval).isUpperEndpoint(upperEndpoint));
	}

	public boolean interseted(Interval interval) {
		return this.include(interval) || interval.include(lowerEndpoint) || interval.include(upperEndpoint);
	}

	public Interval intersection(Interval interval) {
		if (this.include(interval)) {
			return interval.copy();
		} else if (interval.include(this)) {
			return this.copy();
		} else if (interval.include(lowerEndpoint)) {
			return new OpenedInterval(3,3);
		} else {
			return null; 
		}
	}

	public Interval union(Interval interval) {
		return null;
	}

	public void shift(double value) {
		lowerEndpoint += value;
		upperEndpoint += value;
	}

	public Interval shifted(double value) {
		Interval x = this.copy();
        Interval result = x;
		result.shift(value);
		return result;
	}

	public void escalate(double factor) {
		double midpoint = this.midpoint();
		double newHalf = this.length() / 2 * factor;
		lowerEndpoint = midpoint - newHalf;
		upperEndpoint = midpoint + newHalf;
	}

	public Interval escalated(double factor) {
		Interval result = this.copy();
		result.escalate(factor);
		return result;
	}

	public Interval[] split(int pieces) {
		return null;
	}

	public boolean equal(Interval interval) {
		return this.include(interval) && interval.include(this);
	}

	public Interval copy() {
		return new OpenedInterval(lowerEndpoint, upperEndpoint);
	}

}