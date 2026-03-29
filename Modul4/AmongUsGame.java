public class AmongUsGame {
    public static void main(String[] args) {
        Character brian, cindy, david, jacky;

        brian = new Crew("Brian");
        cindy = new Crew("Cindy");
        david = new Crew("David");

        jacky = new Crew("Jacky");
        jacky = new Impostor(jacky);
        jacky = new NonPlayableChar(jacky);

        brian.doWork();
        cindy.doWork();
        david.doWork();
        jacky.doWork();

        if (david instanceof Crew crew) {
            crew.callMeeting();
        }

        AmongUsGame.check(brian);
        AmongUsGame.check(david);
        AmongUsGame.check(jacky);
    }

    public static void check(Character ch) {
        if (AmongUsGame.isImpostor(ch)) {
            System.out.println(ch.name + " is the impostor!");
        } else {
            System.out.println(ch.name + " is not the impostor.");
        }
    }

   public static boolean isImpostor(Character ch) {
    if (ch instanceof NonPlayableChar) {
        return false;
    }
    return (ch instanceof Impostor);
}
}
