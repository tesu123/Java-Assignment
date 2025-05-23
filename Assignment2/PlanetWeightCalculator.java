import java.util.Scanner;

public class PlanetWeightCalculator {
    static final double G = 6.67430e-11;
    enum Planet {
        MERCURY(3.303e+23, 2.4397e6),
        VENUS(4.869e+24, 6.0518e6),
        EARTH(5.976e+24, 6.37814e6),
        MARS(6.421e+23, 3.3972e6),
        JUPITER(1.9e+27, 7.1492e7),
        SATURN(5.688e+26, 6.0268e7),
        URANUS(8.686e+25, 2.5559e7),
        NEPTUNE(1.024e+26, 2.4746e7);

        double mass;   
        double radius; 

        Planet(double mass, double radius) {
            this.mass = mass;
            this.radius = radius;
        }

        double surfaceGravity() {
            return G * mass / (radius * radius);
        }

        double surfaceWeight(double otherMass) {
            return otherMass * surfaceGravity();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your mass on Earth (in kg): ");
        double massOnEarth = scanner.nextDouble();

        System.out.println("Choose a planet to calculate your weight on:");
        for (Planet p : Planet.values()) {
            if (p != Planet.EARTH) {
                System.out.println("- " + p.name());
            }
        }

        System.out.print("Enter planet name: ");
        String inputPlanet = scanner.next().toUpperCase();

        try {
            Planet chosenPlanet = Planet.valueOf(inputPlanet);
            double weight = chosenPlanet.surfaceWeight(massOnEarth);
            System.out.printf("Your weight on %s would be %.2f N (Newtons)%n", inputPlanet, weight);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid planet name. Please choose from the listed planets.");
        }

        scanner.close();
    }
}