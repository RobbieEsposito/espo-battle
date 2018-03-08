package Mechanics;

import Mechanics.TypeChart.*;

public class Move {
    private String _name;
    private Element _element;
    private int _power;
    private int _priority;
    private Boolean _isValid;

    public Move() {
        _name = "Undefined";
        _element = Element.NULL;
        _power = 10;
        _priority = 0;
        _isValid = false;
    }

    public Move(String name) {
        _name = name;
        _isValid = true;
        switch (name) {
            case "Tail Slap":
                _element = Element.BASIC;
                _power = 70;
                _priority = 0;
                break;
            case "Punch":
                _element = Element.BASIC;
                _power = 45;
                _priority = 0;
                break;
            case "Roll Rush":
                _element = Element.BASIC;
                _power = 80;
                _priority = 0;
                break;
            case "Fireball":
                _element = Element.FIRE;
                _power = 60;
                _priority = 0;
                break;
            case "Thermo Claw":
                _element = Element.FIRE;
                _power = 75;
                _priority = 0;
                break;
            case "Volcano Storm":
                _element = Element.FIRE;
                _power = 90;
                _priority = 0;
                break;
            case "Aqua Burst":
                _element = Element.WATER;
                _power = 85;
                _priority = 0;
                break;
            case "Moisture Ball":
                _element = Element.WATER;
                _power = 70;
                _priority = 0;
                break;
            case "Leaf Slap":
                _element = Element.PLANT;
                _power = 50;
                _priority = 0;
                break;
            case "Grass Blades":
                _element = Element.PLANT;
                _power = 60;
                _priority = 0;
                break;
            case "Static Sparks":
                _element = Element.LIGHTNING;
                _power = 50;
                _priority = 0;
                break;
            case "Zap Strike":
                _element = Element.LIGHTNING;
                _power = 100;
                _priority = 0;
                break;
            case "Sand Kick":
                _element = Element.EARTH;
                _power = 40;
                _priority = 0;
                break;
            case "Earth Force":
                _element = Element.EARTH;
                _power = 80;
                _priority = 0;
                break;
            case "Dagger Slash":
                _element = Element.METAL;
                _power = 60;
                _priority = 0;
                break;
            case "Shining Smash":
                _element = Element.METAL;
                _power = 80;
                _priority = 0;
                break;
            case "Poison Ivy":
                _element = Element.POISON;
                _power = 55;
                _priority = 0;
                break;
            case "Venom Fang":
                _element = Element.POISON;
                _power = 75;
                _priority = 0;
                break;
            case "Swoop":
                _element = Element.AIR;
                _power = 50;
                _priority = 0;
                break;
            case "Gale Rush":
                _element = Element.AIR;
                _power = 80;
                _priority = 0;
                break;
            case "Cold Edge":
                _element = Element.ICE;
                _power = 75;
                _priority = 0;
                break;
            case "Snow Throw":
                _element = Element.ICE;
                _power = 40;
                _priority = 0;
                break;
            case "Flake Spikes":
                _element = Element.ICE;
                _power = 60;
                _priority = 0;
                break;
            case "Icy Wing":
                _element = Element.ICE;
                _power = 50;
                _priority = 0;
                break;
            default:
                _isValid = false;
                break;
        }
    }

    public String getName() {
        return _name;
    }

    public Element getElement() {
        return _element;
    }

    public int getPower() {
        return _power;
    }

    public int getPriority() {
        return _priority;
    }

    public Boolean isAttack() {
        return _power > 0;
    }

    public Boolean getIsValid() {
        return _isValid;
    }
}
