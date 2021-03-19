package isp.lab5.exercise5;

public class Tiger extends Animal implements Carnivorous {
    private int chanceToHuntSuccesfully;
    private String name;

    public Tiger(String name, String species, int age, int chanceToHuntSuccesfully) {
        this.name = name;
        this.species = species;
        this.age = age;
        this.chanceToHuntSuccesfully = chanceToHuntSuccesfully;
        this.eat();
    }

    public void eat() {
        System.out.println("Tiger " + this.name + " started to eat fresh meat..");
    }

    public void huntSuccesfully() {
        System.out.println("Tiger " + this.name + " hunt successfully at age " + this.age + " with a chance of " + this.chanceToHuntSuccesfully);
    }

    public void huntFailed() {
        System.out.println("Tiger " + this.name + " failed to hunt at age " + this.age + " with a chance to succeed of" + this.chanceToHuntSuccesfully);
    }

    @Override
    public String toString() {
        return "Tiger{" +
                "chanceToHuntSuccesfully=" + chanceToHuntSuccesfully +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public int getChancesToHuntSuccesfully() {
        return this.chanceToHuntSuccesfully;
    }
}
