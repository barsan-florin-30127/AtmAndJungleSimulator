package isp.lab5.exercise5;

public class Dear extends Animal implements Herbivorous {
    private int chanceToRunSuccesfully;
    private String name;

    public Dear(String name, String species, int age, int chanceToRunSuccesfully) {
        this.name = name;
        this.species = species;
        this.age = age;
        this.chanceToRunSuccesfully = chanceToRunSuccesfully;
        this.eat();
    }

    public void eat() {
        System.out.println("Dear " + this.name + " started to eat grass..");
    }

    public void runSuccesfully() {
        System.out.println("Dear " + this.name + " run successfully at age " + this.age + " with a chance of " + this.chanceToRunSuccesfully);
    }

    public void runFailed() {
        System.out.println("Dear " + this.name + " failed to run at age " + this.age + " with a chance to succeed of" + this.chanceToRunSuccesfully);

    }

    @Override
    public String toString() {
        return "Dear{" +
                "chanceToRunSuccesfully=" + chanceToRunSuccesfully +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public int getChancesToRunSuccesfully() {
        return this.chanceToRunSuccesfully;
    }
}
