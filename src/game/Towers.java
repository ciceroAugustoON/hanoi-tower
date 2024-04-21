package game;

import java.util.List;

import datastructure.Stack;

public class Towers {
    Stack<Integer> initialTower, intermediateTower, finalTower;
    Integer disks;

    public Towers(int disks) {
        this.disks = disks;
        initialTower = new Stack<>();
        intermediateTower = new Stack<>();
        finalTower = new Stack<>();

        for (int i = disks; i > 0; i--) {
            initialTower.push(i);
        }
    }

    public List<Stack<Integer>> getTowers() {
        return List.of(initialTower, intermediateTower, finalTower);
    }
}
