package Mechanics;

import Mechanics.TypeChart.*;
import Mechanics.TrainingBuild.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Creature {
    private String _name;
    private Element _element1;
    private Element _element2;
    private int _hp;
    private double _basePower;
    private double _baseDefense;
    private double _baseSpeed;
    private Build _build;
    private Move[] _move;
    private ArrayList<String> _movepool;
    private Boolean _isValid;

    public Creature() {
        _name = "Undefined";
        _element1 = Element.NULL;
        _element2 = Element.NULL;
        _hp = 100;
        _basePower = 50;
        _baseDefense = 50;
        _baseSpeed = 50;
        _build = Build.NULL;
        _move = new Move[5];
        for (int i =0; i < 5; i++) {
            _move[i] = new Move();
        }
        _movepool = new ArrayList<>();
        _isValid = false;
    }

    public Creature(String name) {
        _name = name;
        _hp = 100;
        _build = Build.NULL;
        _move = new Move[5];
        _movepool = new ArrayList<>();
        _isValid = true;
        switch (name) {
            case "Koalava":
                _element1 = Element.FIRE;
                _element2 = Element.NULL;
                _basePower = 71;
                _baseDefense = 38;
                _baseSpeed = 70;
                _movepool.addAll(Arrays.asList("Punch", "Fireball", "Sand Kick", "Thermo Claw", "Volcano Storm"));
                break;
            case "Elastail":
                _element1 = Element.BASIC;
                _element2 = Element.NULL;
                _basePower = 46;
                _baseDefense = 46;
                _baseSpeed = 73;
                _movepool.addAll(Arrays.asList("Punch", "Tail Slap", "Swoop", "Leaf Slap", "Sand Kick"));
                break;
            case "Hejbog":
                _element1 = Element.WATER;
                _element2 = Element.EARTH;
                _basePower = 37;
                _baseDefense = 69;
                _baseSpeed = 30;
                _movepool.addAll(Arrays.asList("Moisture Ball", "Aqua Burst", "Earth Force", "Leaf Slap", "Roll Rush"));
                break;
            case "Gekknife":
                _element1 = Element.METAL;
                _element2 = Element.NULL;
                _basePower = 81;
                _baseDefense = 43;
                _baseSpeed = 45;
                _movepool.addAll(Arrays.asList("Dagger Slash", "Shining Smash", "Tail Slap", "Grass Blades", "Cold Edge"));
                break;
            case "Vineper":
                _element1 = Element.PLANT;
                _element2 = Element.POISON;
                _basePower = 65;
                _baseDefense = 31;
                _baseSpeed = 79;
                _movepool.addAll(Arrays.asList("Tail Slap", "Leaf Slap", "Grass Blades", "Poison Ivy", "Venom Fang"));
                break;
            case "Crystalis":
                _element1 = Element.ICE;
                _element2 = Element.NULL;
                _basePower = 14;
                _baseDefense = 94;
                _baseSpeed = 2;
                _movepool.addAll(Arrays.asList("Snow Throw", "Flake Spikes", "Cold Edge", "Roll Rush", "Earth Force"));
                break;
            case "Elecho":
                _element1 = Element.LIGHTNING;
                _element2 = Element.AIR;
                _basePower = 60;
                _baseDefense = 42;
                _baseSpeed = 80;
                _movepool.addAll(Arrays.asList("Swoop", "Static Sparks", "Zap Strike", "Gale Rush", "Icy Wing"));
                break;
            default:
                _isValid = false;
                break;
        }
    }

    public String getName() {
        return _name;
    }

    public int getRemainingHP() {
        return _hp;
    }

    // TODO: can be refactored to use DamageCalc's function
    public double getPower() {
        if (_build == Build.BREAKER)
            return Math.floor(_basePower * 1.2 + 10);
        else if (_build == Build.TANK || _build == Build.SWEEPER)
            return Math.floor(_basePower * 1.1 + 5);
        return (double)_basePower;
    }

    // TODO: can be refactored to use DamageCalc's function
    public double getDefense() {
        if (_build == Build.WALL)
            return Math.floor(_baseDefense * 1.2 + 10);
        else if (_build == Build.TANK || _build == Build.SURVIVALIST)
            return Math.floor(_baseDefense * 1.1 + 5);
        return _baseDefense;
    }

    // TODO: can be refactored to use DamageCalc's function
    public double getSpeed() {
        if (_build == Build.SPEEDSTER)
            return Math.floor(_baseSpeed * 1.2 + 10);
        else if (_build == Build.SWEEPER || _build == Build.SURVIVALIST)
            return Math.floor(_baseSpeed * 1.1 + 5);
        return _baseSpeed;
    }

    public double getBasePower() {
        return _basePower;
    }

    public double getBaseDefense() {
        return _baseDefense;
    }

    public double getBaseSpeed() {
        return _baseSpeed;
    }

    public Build getBuild() {
        return _build;
    }

    public Move getMove(int index) {
        return _move[index];
    }

    public ArrayList<String> getMovepool() {
        return _movepool;
    }

    public Element getElement1() {
        return _element1;
    }

    public Element getElement2() {
        return _element2;
    }

    public Boolean hasElement(Element e) {
        return _element1 == e || _element2 == e;
    }

    public void setBuild(Build build) {
        _build = build;
    }

    public void setMove(Move move, int slot) {
        _move[slot] = move;
    }

    public void takeDamage(int amount) {
        _hp -= amount;
        if (_hp < 0)
            _hp = 0;
    }

    public void heal(int amount) {
        _hp += amount;
        if (_hp > 100)
            _hp = 100;
    }

    public Boolean getIsValid() {
        return _isValid;
    }

    // TODO Clean this up, hide null element, show stats as ints, fix move display
    public void printData() {
        System.out.println();
        System.out.println(_name + " (" + _build.toString() + ")");
        System.out.println("Element: " + _element1.toString() + " / " + _element2.toString());
        System.out.println("Pow: " + getPower() + ", Def: " + getDefense() + ", Spe: " + getSpeed());
        //System.out.println("Moves: " + _move.toString());
        System.out.println();
    }
}