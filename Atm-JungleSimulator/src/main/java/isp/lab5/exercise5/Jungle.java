package isp.lab5.exercise5;

/**
 * Class which represents the place where herbivorous and carnivorous live together.
 */
public class Jungle {
    private Herbivorous[] herbivores;
    private Carnivorous[] carnivores;

    public Jungle(Herbivorous[] herbivorouses, Carnivorous[] carnivorouses) {
        this.herbivores = herbivorouses;
        this.carnivores = carnivorouses;
    }

    /**
     * We use this getter to acces the elements from herbivorous arrays.
     *
     * @param index - index of the element we want to acces
     * @return the herbivorous from the desired index position
     */
    public Herbivorous getHerbivore(int index) {
        return this.herbivores[index];
    }

    /**
     * We use this getter to acces the elements from carnivorous arrays.
     *
     * @param index - index of the element we want to acces
     * @return the carnivorous from the desired index position
     */
    public Carnivorous getCarnivore(int index) {
        return this.carnivores[index];
    }

    /**
     * We use these two getters to get the length of Herbivore array
     *
     * @return int length of herbivore array
     */
    public int getHerbivoreLength() {
        return this.herbivores.length;
    }

    /**
     * We use these two getters to get the length of carnivore array
     *
     * @return int length of carnivore array
     */
    public int getCarnivoreLength() {
        return this.carnivores.length;
    }


    /**
     * We use this method to remove an herbivore which lose a fight in the simulate method
     * The method replaces the elements greater than index with one space backwards
     * This way our herbivore who lost the fight will be replaced by another one who needs to fight
     *
     * @param index - index of the element we want to eliminate
     */

    public void removeAnimalFromHerbivores(int index) {
        if (index < herbivores.length) {
            for (int i = index; i < herbivores.length - 1; i++) {
                herbivores[i] = herbivores[i + 1];
            }
        }
    }

    /**
     * We use this method to remove an carnivore which lose a fight in the simulate method
     * The method replaces the elements greater than index with one space backwards
     * This way our carnivore who lost the fight will be replaced by another one who needs to fight
     *
     * @param index - index of the element we want to eliminate
     */
    public void removeAnimalFromCarnivores(int index) {
        if (index < carnivores.length) {
            for (int i = index; i < carnivores.length - 1; i++) {
                carnivores[i] = carnivores[i + 1];
            }
        }
    }
}
