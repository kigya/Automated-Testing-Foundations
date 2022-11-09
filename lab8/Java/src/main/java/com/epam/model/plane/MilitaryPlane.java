package com.epam.model.plane;

import com.epam.model.MilitaryType;

public class MilitaryPlane extends Plane {
    private final MilitaryType type;

    public MilitaryPlane(
            String model,
            int maxSpeed,
            int maxFlightDistance,
            int maxLoadCapacity,
            MilitaryType type
    ) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.type = type;
    }

    public MilitaryType getType() {
        return type;
    }

    @Override
    public String toString() {
        return super.toString().replace("}", ", type=" + type + '}');
    }
}
