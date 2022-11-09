package com.epam.model.airport;

import com.epam.model.ClassificationLevel;
import com.epam.model.ExperimentalType;
import com.epam.model.MilitaryType;
import com.epam.model.plane.ExperimentalPlane;
import com.epam.model.plane.MilitaryPlane;
import com.epam.model.plane.PassengerPlane;
import com.epam.model.plane.Plane;

import java.util.*;

import static java.util.Collections.max;
import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

public class Airport {
    private final List<Plane> planes;

    public Airport(List<Plane> planes) {
        this.planes = planes;
    }

    public List<Plane> getPlanes() {
        return planes;
    }

    public List<PassengerPlane> getPassengerPlanes() {
        return planes.stream()
                .filter(PassengerPlane.class::isInstance)
                .map(PassengerPlane.class::cast)
                .collect(toList());
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        return max(getPassengerPlanes(), comparing(PassengerPlane::getPassengersCapacity));
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        return planes.stream()
                .filter(MilitaryPlane.class::isInstance)
                .map(MilitaryPlane.class::cast)
                .collect(toList());
    }

    public List<MilitaryPlane> getMilitaryPlanesByCertainType(MilitaryType militaryType) {
        return getMilitaryPlanes().stream()
                .filter(plane -> plane.getType().equals(militaryType))
                .collect(toList());
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        return planes.stream()
                .filter(ExperimentalPlane.class::isInstance)
                .map(ExperimentalPlane.class::cast)
                .collect(toList());
    }

    public List<ExperimentalPlane> getExperimentalPlanesByCertainType(ExperimentalType experimentalType) {
        return getExperimentalPlanes().stream()
                .filter(plane -> plane.getType().equals(experimentalType))
                .collect(toList());
    }

    public List<ExperimentalPlane> getExperimentalPlanesByCertainClassificationLevel(
            ClassificationLevel classificationLevel
    ) {
        return getExperimentalPlanes().stream()
                .filter(plane -> plane.getClassificationLevel().equals(classificationLevel))
                .collect(toList());
    }

    public List<ExperimentalPlane> getExperimentalPlanesByCertainTypeAndClassificationLevel(
            ExperimentalType experimentalType, ClassificationLevel classificationLevel) {
        return getExperimentalPlanes().stream()
                .filter(plane -> plane.getType().equals(experimentalType))
                .filter(plane -> plane.getClassificationLevel().equals(classificationLevel))
                .collect(toList());
    }

    public void sortPlanesByModel() {
        planes.sort(comparing(Plane::getModel));
    }

    public void sortPlanesByMaxFlightDistance() {
        planes.sort(comparingInt(Plane::getMaxFlightDistance));
    }

    public void sortPlanesByMaxSpeed() {
        planes.sort(comparingInt(Plane::getMaxSpeed));
    }

    public void sortPlanesByMaxLoadCapacity() {
        planes.sort(comparingInt(Plane::getMaxLoadCapacity));
    }
}
