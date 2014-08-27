package es.jelu.doo.interval.v10;

class LeftClosedInterval extends OpenedInterval {
    public LeftClosedInterval(double lowerEndpoint, double upperEndpoint) {
        super(lowerEndpoint, upperEndpoint);
    }

    public boolean include(double value) {
        return (lowerEndpoint == value) || super.include(value);
    }
}
