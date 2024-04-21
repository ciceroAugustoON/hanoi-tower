package game;

import datastructure.Stack;

public class Game {
    private Towers towers;
    private View view;

    public Game(int disks) {
        towers = new Towers(disks);
        view = new View(disks);
    }

    public void move(Tower of, Tower to) {
        if (of == to) {
            System.err.println("Invalid Movement!");
            return;
        }

        Stack<Integer> valueOf = towers.getTowers().get(of.ordinal());
        Stack<Integer> valueTo = towers.getTowers().get(to.ordinal());
        
        if (valueTo.isEmpty()) {
            valueTo.push(valueOf.pop());
            view.change(of, to);
            return;
        }
        if (valueOf.peek() > valueTo.peek()) {
            System.err.println("Invalid Movement");
        } else {
            valueTo.push(valueOf.pop());
            view.change(of, to);
        }
    }

    public void see() {
        System.out.println(view);
    }

    public boolean isGameFinished() {
        if (towers.finalTower.isEmpty()) return false;

        if (towers.finalTower.peek() == 1 && towers.finalTower.lenght() == view.viewLines.length) 
            return true;
        else
            return false;
    }
    
}
