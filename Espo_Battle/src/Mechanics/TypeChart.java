package Mechanics;

import java.util.ArrayList;
import java.util.Scanner;

public class TypeChart {
    public enum Element {
        BASIC, FIRE, WATER, PLANT, LIGHTNING, EARTH, METAL, POISON, AIR, ICE, NULL
    }

    public static double getMatchup(Element a, Element d1, Element d2) {
        return fetchRawMatchupData(a)[d1.ordinal()] * fetchRawMatchupData(a)[d2.ordinal()];
    }

    public static void printMatchups() {
        System.out.print("Enter type combination: ");
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        Element type1 = Element.NULL;
        Element type2 = Element.NULL;

        String temptype = "";
        for (int i = 0; i < input.length(); i++) {
            temptype += input.substring(i, i+1).toUpperCase();
            for (int j = 0; j < 11; j++) {
                if (temptype.contains(Element.values()[j].toString())) {
                    if (type1 == Element.NULL) {
                        type1 = Element.values()[j];
                    }
                    else if (type2 == Element.NULL && type1 != Element.values()[j]) {
                        type2 = Element.values()[j];
                    }
                }
            }
        }
        if (type1 == Element.BASIC || type2 == Element.BASIC) {
            type2 = Element.NULL;
        }

        System.out.print("Elemental Matchups for ");
        if (type2.toString().equals("NULL"))
            System.out.println(type1.toString() + ":");
        else
            System.out.println(type1.toString() + " / " + type2.toString() + ":");
        System.out.println();
        double[] tm1 = fetchRawMatchupData(type1);
        double[] tm2 = fetchRawMatchupData(type2);
        ArrayList<String> stren2 = new ArrayList<>();
        ArrayList<String> stren4 = new ArrayList<>();
        ArrayList<String> weak2 = new ArrayList<>();
        ArrayList<String> weak4 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            double matchup = tm1[i] * tm2[i];
            if (matchup == 2)
                stren2.add(Element.values()[i].toString());
            else if (matchup == 4)
                stren4.add(Element.values()[i].toString());
            else if (matchup == 0.5)
                weak2.add(Element.values()[i].toString());
            else if (matchup == 0.25)
                weak4.add(Element.values()[i].toString());
        }

        if (stren4.size() > 0)
            System.out.println("Very strong against: " + String.join(",", stren4));
        if (stren2.size() > 0)
            System.out.println("Strong against: " + String.join(",", stren2));
        if (weak2.size() > 0)
            System.out.println("Weak against: " + String.join(",", weak2));
        if (weak4.size() > 0)
            System.out.println("Very weak against: " + String.join(",", weak4));
        if (stren2.size() == 0 && stren4.size() == 0 && weak2.size() == 0 && weak4.size() == 0)
            System.out.println("No strengths or weaknesses");
    }

    private static double[] fetchRawMatchupData(Element e) {
        switch (e) {
            case BASIC: return new double[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
            case FIRE: return new double[]{1, 1, 0.5, 2, 1, 0.5, 2, 1, 0.5, 2, 1};
            case WATER: return new double[]{1, 2, 1, 0.5, 0.5, 2, 2, 0.5, 1, 1, 1};
            case PLANT: return new double[]{1, 0.5, 2, 1, 2, 2, 1, 0.5, 1, 0.5, 1};
            case LIGHTNING: return new double[]{1, 1, 2, 0.5, 1, 0.5, 0.5, 1, 2, 2, 1};
            case EARTH: return new double[]{1, 2, 0.5, 0.5, 2, 1, 1, 1, 0.5, 2, 1};
            case METAL: return new double[]{1, 0.5, 0.5, 1, 2, 1, 1, 2, 1, 1, 1};
            case POISON: return new double[]{1, 1, 2, 2, 1, 1, 0.5, 1, 1, 0.5, 1};
            case AIR: return new double[]{1, 2, 1, 1, 0.5, 2, 1, 1, 1, 0.5, 1};
            case ICE: return new double[]{1, 0.5, 1, 2, 0.5, 0.5, 1, 2, 2, 1, 1};
            default: return new double[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        }
    }
}