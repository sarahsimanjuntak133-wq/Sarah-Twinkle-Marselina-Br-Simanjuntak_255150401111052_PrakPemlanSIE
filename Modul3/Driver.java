public class Driver {

    private Car coupe;

    public Driver() {
        System.out.println("Driver is created.");
        coupe = new Car();
    }

    public void driving() {
        System.out.println("Driver is driving.");
        System.out.println("Using a car that has " 
            + coupe.numWheel + " wheels.");
    }
}
