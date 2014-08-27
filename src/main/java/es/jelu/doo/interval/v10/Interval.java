package es.jelu.doo.interval.v10;

interface Interval {

	double length();

	double midpoint();

	boolean include(double value);

	boolean include(Interval interval);

	boolean interseted(Interval interval);

	Interval intersection(Interval interval);

	Interval union(Interval interval);

	void shift(double value);

	Interval shifted(double value);

	void escalate(double factor);

	Interval escalated(double factor);

	Interval[] split(int pieces);

	boolean equal(Interval interval);

	Interval copy();

}







