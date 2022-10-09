package designPatterns.lectureExampleBuilder;

public interface Vehicle {

    void startMoving();

    public class Car implements Vehicle {

        @Override
        public void startMoving() {
            System.out.println("Car is moving");
        }

    }

    public class Plane implements Vehicle {

        @Override
        public void startMoving() {
            System.out.println("Plane is moving");
        }

    }

    public class VehicleFactory {
        public static Vehicle create (String vehicleType) {
            switch (vehicleType) {
                case "car":
                    return new Car();
                case "plane":
                    return new Plane();
                default:
                    return null;
            }
        }
    }

}
