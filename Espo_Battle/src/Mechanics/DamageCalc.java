package Mechanics;

public class DamageCalc {
    public static int calculateDamage(Creature attacker, Creature defender, Move move) {
        double dam = attacker.getPower() / defender.getDefense() * move.getPower() / 4;
        //System.out.println(dam);
        if (attacker.hasElement(move.getElement()))
            dam *= 1.25;
        //System.out.println(dam + " after STAB");
        dam *= TypeChart.getMatchup(move.getElement(), defender.getElement1(), defender.getElement2());
        //System.out.println(dam + " after elemental matchups");
        //System.out.println((int) Math.max(Math.floor(dam), 1));
        return (int) Math.max(Math.floor(dam), 1);
    }

    public static int calculateBuildBoost(double base, int boosts) {
        double ret = Math.floor(base * (0.1 * boosts) + (5 * boosts));
        return (int) ret;
    }
}
