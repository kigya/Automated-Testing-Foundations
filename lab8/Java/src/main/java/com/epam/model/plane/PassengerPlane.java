package com.epam.model.plane;

public class PassengerPlane extends Plane {
    private final int passengersCapacity;

    public PassengerPlane(
            String model,
            int maxSpeed,
            int maxFlightDistance,
            int maxLoadCapacity,
            int passengersCapacity
    ) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.passengersCapacity = passengersCapacity;
    }

    public int getPassengersCapacity() {
        return passengersCapacity;
    }

    @Override
    public String toString() {
        return super.toString()
                .replace(
                        "}", ", passengersCapacity=" + passengersCapacity + '}'
                );
    }
}