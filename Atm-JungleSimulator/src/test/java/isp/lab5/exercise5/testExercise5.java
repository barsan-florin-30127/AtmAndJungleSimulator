package isp.lab5.exercise5;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//This test sometimes work,sometimes some methods dont pass the test and didn't show a result.
public class testExercise5 {
    @Test
    public void testSimulateMethodEqualCase() {
        Herbivorous[] herbivorous0 = new Herbivorous[1];
        Carnivorous[] carnivorous0 = new Carnivorous[1];
        for (int i = 0; i < herbivorous0.length; i++) {
            double rand1 = 100;
            double rand2 = 100;
            double rand3 = 100;
            double rand4 = 100;
            double choice = Math.random();
            if (choice <= 0.5) {
                String deerNameTemplate = "Bambi";
                String lionNameTemplate = "Simba";
                int randInt1 = (int) rand1;
                int randInt2 = (int) rand2;
                herbivorous0[i] = new Dear(deerNameTemplate + i, "Mountain Deer", randInt1 % 20, randInt1);
                carnivorous0[i] = new Lion(lionNameTemplate + i, "Mountain Lion", randInt2 % 40, randInt2);
            } else {
                String elkNameTemplate = "Elki";
                String tigerNameTemplate = "Scar";
                int randInt3 = (int) rand3;
                int randInt4 = (int) rand4;
                herbivorous0[i] = new Elk(elkNameTemplate + i, "Mountain Elk", randInt3 % 20, randInt3);
                carnivorous0[i] = new Tiger(tigerNameTemplate + i, "Mountain Tiger", randInt4 % 40, randInt4);
                Jungle jungle0 = new Jungle(herbivorous0, carnivorous0);
                Simulator simulator0 = new Simulator(jungle0);
                assertEquals("This assertEqual should test the right construnction of the simulator", 0, simulator0.getStatus());
                simulator0.simulate();
                assertEquals("This equal should test the equal case when the run and hunt chances are the same", 3, simulator0.getStatus());

            }

        }
    }

    @Test
    public void testSimulateMethodHerbivorusWins() {
        Herbivorous[] herbivorous0 = new Herbivorous[1];
        Carnivorous[] carnivorous0 = new Carnivorous[1];
        for (int i = 0; i < herbivorous0.length; i++) {
            double rand1 = 100;
            double rand2 = 2;
            double rand3 = 100;
            double rand4 = 2;
            double choice = Math.random();
            if (choice <= 0.5) {
                String deerNameTemplate = "Bambi";
                String lionNameTemplate = "Simba";
                int randInt1 = (int) rand1;
                int randInt2 = (int) rand2;
                herbivorous0[i] = new Dear(deerNameTemplate + i, "Mountain Deer", randInt1 % 20, randInt1);
                carnivorous0[i] = new Lion(lionNameTemplate + i, "Mountain Lion", randInt2 % 40, randInt2);
            } else {
                String elkNameTemplate = "Elki";
                String tigerNameTemplate = "Scar";
                int randInt3 = (int) rand3;
                int randInt4 = (int) rand4;
                herbivorous0[i] = new Elk(elkNameTemplate + i, "Mountain Elk", randInt3 % 20, randInt3);
                carnivorous0[i] = new Tiger(tigerNameTemplate + i, "Mountain Tiger", randInt4 % 40, randInt4);
                Jungle jungle0 = new Jungle(herbivorous0, carnivorous0);
                Simulator simulator0 = new Simulator(jungle0);
                assertEquals("This assertEqual should test the right construnction of the simulator", 0, simulator0.getStatus());
                simulator0.simulate();
                assertEquals("This equal should test the equal case when the run and hunt chances are the same", 1, simulator0.getStatus());

            }

        }
    }

    @Test
    public void testSimulateMethodCarnivorusWins() {
        Herbivorous[] herbivorous0 = new Herbivorous[1];
        Carnivorous[] carnivorous0 = new Carnivorous[1];
        for (int i = 0; i < herbivorous0.length; i++) {
            double rand1 = 2;
            double rand2 = 100;
            double rand3 = 2;
            double rand4 = 100;
            double choice = Math.random();
            if (choice <= 0.5) {
                String deerNameTemplate = "Bambi";
                String lionNameTemplate = "Simba";
                int randInt1 = (int) rand1;
                int randInt2 = (int) rand2;
                herbivorous0[i] = new Dear(deerNameTemplate + i, "Mountain Deer", randInt1 % 20, randInt1);
                carnivorous0[i] = new Lion(lionNameTemplate + i, "Mountain Lion", randInt2 % 40, randInt2);
            } else {
                String elkNameTemplate = "Elki";
                String tigerNameTemplate = "Scar";
                int randInt3 = (int) rand3;
                int randInt4 = (int) rand4;
                herbivorous0[i] = new Elk(elkNameTemplate + i, "Mountain Elk", randInt3 % 20, randInt3);
                carnivorous0[i] = new Tiger(tigerNameTemplate + i, "Mountain Tiger", randInt4 % 40, randInt4);
                Jungle jungle0 = new Jungle(herbivorous0, carnivorous0);
                Simulator simulator0 = new Simulator(jungle0);
                assertEquals("This assertEqual should test the right construnction of the simulator", 0, simulator0.getStatus());
                simulator0.simulate();
                assertEquals("This equal should test the equal case when the run and hunt chances are the same", 2, simulator0.getStatus());

            }

        }
    }
}
