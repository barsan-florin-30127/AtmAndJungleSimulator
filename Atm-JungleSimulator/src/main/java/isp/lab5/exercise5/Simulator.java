package isp.lab5.exercise5;

/**
 * Class that will simulate the fight between the animals form the jungle.
 * We use "status" private atribute to allow us to test the simulate method.
 * After each simulation, status atribute will gain a value depending on what case end the simulation.
 * status=0-simulation method wasn't called on the current object
 * status=1-simulation ends with herbivore as the winners
 * status=2-simulation ends with carnivore as the winners
 * status=3-simulation ends with an equal between the two most powerful herbivore and carnivore
 */
public class Simulator {
    private Jungle jungle;
    private int status;

    /**
     * Main constructor that will construct our Jungle
     * Jungle is constructed by populating the two arrays of herbivorus and carnivorus
     * We use the four rand variables to assign random values to animals attributes.
     * Choice variable will decide which type of herbivorus/carnivorus we will create.
     */
    public Simulator() {
        Herbivorous[] herbivorous = new Herbivorous[20];
        Carnivorous[] carnivorous = new Carnivorous[20];
        for (int i = 0; i < herbivorous.length; i++) {
            double rand1 = (Math.random() * 100);
            double rand2 = (Math.random() * 100);
            double rand3 = (Math.random() * 100);
            double rand4 = (Math.random() * 100);
            double choice = Math.random();
            if (choice <= 0.5) {
                String deerNameTemplate = "Bambi";
                String lionNameTemplate = "Simba";
                int randInt1 = (int) rand1;
                int randInt2 = (int) rand2;
                herbivorous[i] = new Dear(deerNameTemplate + i, "Mountain Deer", randInt1 % 20, randInt1);
                carnivorous[i] = new Lion(lionNameTemplate + i, "Mountain Lion", randInt2 % 40, randInt2);
            } else {
                String elkNameTemplate = "Elki";
                String tigerNameTemplate = "Scar";
                int randInt3 = (int) rand3;
                int randInt4 = (int) rand4;
                herbivorous[i] = new Elk(elkNameTemplate + i, "Mountain Elk", randInt3 % 20, randInt3);
                carnivorous[i] = new Tiger(tigerNameTemplate + i, "Mountain Tiger", randInt4 % 40, randInt4);

            }
            this.jungle = new Jungle(herbivorous, carnivorous);
            this.status = 0;
        }
    }

    /**
     * Aditional parameter so that we can test the simulate method with our desired jungle.
     *
     * @param jungle
     */
    public Simulator(Jungle jungle) {
        this.jungle = jungle;
    }

    /**
     * Getter to check the status of the simulation and determine which condition stopped our simulation.
     *
     * @return int status
     */
    public int getStatus() {
        return status;
    }

    /**
     * Method that simulate the fight between animals previously created in the constructor.
     * The infinite cycle will be stopped when one of the following conditions is true:
     * -Either herbivores/carnivores array is null.
     * -The two more powerfull pair of herbivore-carnivore have the same percent to run-hunt.
     * RandIndex variables are used to keep track of the remaining animals of each type(herbivorus/carnivorus)
     */
    public void simulate() {
        int herbivorousLength = jungle.getHerbivoreLength();
        int carnivorousLength = jungle.getCarnivoreLength();
        for (; ; ) {
            int randIndexHerbivorous = (int) (Math.random() * herbivorousLength);
            int randIndexCarnivorous = (int) (Math.random() * carnivorousLength);
            if (carnivorousLength == 0) {
                System.out.println("Herbivores are the only animals in the jungle!");
                this.status = 1;
                System.exit(1);
            } else if (herbivorousLength == 0) {
                System.out.println("Carnivores are the only animals in the jungle!");
                this.status = 2;
                System.exit(2);
            } else if (jungle.getHerbivore(randIndexHerbivorous).getChancesToRunSuccesfully() > jungle.getCarnivore(randIndexCarnivorous).getChancesToHuntSuccesfully()) {
                jungle.getHerbivore(randIndexHerbivorous).runSuccesfully();
                jungle.getCarnivore(randIndexCarnivorous).huntFailed();
                jungle.removeAnimalFromCarnivores(randIndexCarnivorous);
                carnivorousLength--;
            } else if (jungle.getHerbivore(randIndexHerbivorous).getChancesToRunSuccesfully() < jungle.getCarnivore(randIndexCarnivorous).getChancesToHuntSuccesfully()) {
                jungle.getHerbivore(randIndexHerbivorous).runFailed();
                jungle.getCarnivore(randIndexCarnivorous).huntSuccesfully();
                jungle.removeAnimalFromHerbivores(randIndexHerbivorous);
                herbivorousLength--;
            }//I added the last two conditions from the next if to be sure that the animals that have equal chances are the most powerful from each type of animals
            if ((jungle.getHerbivore(randIndexHerbivorous).getChancesToRunSuccesfully() == jungle.getCarnivore(randIndexCarnivorous).getChancesToHuntSuccesfully()) && (herbivorousLength == 1) && (carnivorousLength == 1)) {
                System.out.println("There was a draw between the animals: " + jungle.getCarnivore(randIndexCarnivorous).toString() + " and " + jungle.getHerbivore(randIndexHerbivorous).toString());
                this.status = 3;
                System.exit(3);
            }

        }
    }
}
