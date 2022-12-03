package Java2.HW05AmidstUs;

import java.util.Arrays;

public class RedAstronaut extends Player implements Impostor {

    private String skill;

    public RedAstronaut(String name, int susLevel, String skill) {
        super(name, susLevel);
        this.skill = skill;
    }

    public RedAstronaut(String name) {
        super(name, 15);
        skill = "experienced";
    }

    // If the target player is another imposter, or is frozen, or if imposter trying
    // to freeze, then nothin happens.
    // else. the targer is frozen, and the impostors sus level doubles.
    @Override
    public void freeze(Player p) {
        if (p instanceof Impostor || this.isFrozen() || p.isFrozen()) {
            return;
        }

        if (this.compareTo(p) < 0) {
            p.setFrozen(true);
        } else {
            setSusLevel(this.getSusLevel() * 2);
        }
        gameOver();

    }// freeze

    // A sabotage can't happen if target player, saboteur, are frozen, or if target
    // is not an impostor
    // else. if saboteur has suslevel below 20, target suslevel increases by 50%,
    // else by 25%
    @Override
    public void sabotage(Player p) {
        if (p instanceof Impostor || this.isFrozen() || p.isFrozen()) {
            return;
        }

        if (this.getSusLevel() < 20) {
            p.setSusLevel((int) (p.getSusLevel() * 1.5));
        } else {
            p.setSusLevel((int) (p.getSusLevel() * 1.25));
        }
    }// sabotage

    @Override
    public void emergencyMeeting() {
        if (this.isFrozen()) {
            return;
        }
        // get list of all Players and sort in ascending order based on susLevel
        // So loop can start on right and grab that player if non frozen
        Player[] allPlayers = getPlayers();
        Arrays.sort(allPlayers);

        Player mostSus = null;

        for (int i = allPlayers.length - 1; i > 0; i--) {
            if (i > 0 && !(allPlayers[i].isFrozen()) && !(this.equals(allPlayers[i]))) {
                for (int j = i - 1; j >= 0; j--) {
                    if (allPlayers[j].compareTo(allPlayers[i]) == 0 && !(allPlayers[j].isFrozen())) {
                        return;
                    }
                }
                mostSus = allPlayers[i];
                break;
            }
        }
        mostSus.setFrozen(true);
        gameOver();
    }

    public boolean equals(Object o) {
        if (o instanceof Impostor) {
            return super.equals(o);
        } else {
            return false;
        }
    }// equals

    public String toString() {
        String s = super.toString();
        s += " I am an " + skill + " player!";

        if (this.getSusLevel() > 15) {
            return (s.toUpperCase());
        }
        return s;
    }// toString

}
