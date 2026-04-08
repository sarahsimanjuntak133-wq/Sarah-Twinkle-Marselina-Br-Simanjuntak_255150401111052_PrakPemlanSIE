public class Crew implements ICrew, IPlayer {

    private String name;
    private boolean isAlive = true;

    public Crew(String name) {
        this.name = name;
    }

    @Override
    public void doWork() {
        System.out.println("Crew " + this.name + " is doing work.");
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void callMeeting() {
    if (isAlive) {
        System.out.print(this.name + " found a corpse ");
        System.out.print("and calls a meeting. ");
        System.out.println("Let's find the impostor!");
    } else {
        System.out.println(this.name + " is dead and cannot call a meeting.");
    }
}

    @Override
    public void kick() {
        System.out.println(this.name + " has been kicked from the spaceship.");
    }

    public void setAlive(boolean status) {
    this.isAlive = status;
    }
}
