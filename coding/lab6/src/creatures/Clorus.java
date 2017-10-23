package  creatures;
import huglife.Creature;
import huglife.Direction;
import huglife.Action;
import huglife.Occupant;
import huglife.HugLifeUtils;
import java.awt.Color;
import java.util.Map;
import java.util.List;

public class Clorus extends Creature {

    /** red color. */
    private int r;
    /** green color. */
    private int g;
    /** blue color. */
    private int b;

    private static final double moveene = 0.03;
    private static final double stayene = 0.01;

    /** creates Clorus with energy equal to E. */
    public Clorus(double e) {
        super("clorus");
        r = 0;
        g = 0;
        b = 0;
        energy = e;
    }

    /** creates a Clorus with energy equal to 1. */
    public Clorus() {
        this(1);
    }

    /** Should return a color with red = 99, blue = 76, and green that varies
     *  linearly based on the energy of the Clorus. If the Clorus has zero energy,
     *  it should have a green value of 63. If it has max energy, it should
     *  have a green value of 255. The green value should vary with energy
     *  linearly in between these two extremes. It's not absolutely vital
     *  that you get this exactly correct.
     */

    public Color color() {
        r = 34;
        b = 231;
        g = 0;
        return color(r, g, b);
    }

    /** Do nothing with C, Cloruss are pacifists. */
    public void attack(Creature c) {
        energy = energy + c.energy();
    }

    /** Cloruss should lose 0.15 units of energy when moving. If you want to
     *  to avoid the magic number warning, you'll need to make a
     *  private static final variable. This is not required for this lab.
     */
    public void move() {
        energy = energy - moveene;
    }


    /** Cloruss gain 0.2 energy when staying due to photosynthesis. */
    public void stay() {
        energy = energy + stayene;
    }

    /** Cloruss and their offspring each get 50% of the energy, with none
     *  lost to the process. Now that's efficiency! Returns a baby
     *  Clorus.
     */
    public Clorus replicate() {
        Clorus offspring = new Clorus();
        offspring. energy = energy / 2;
        this.energy = 0.5*this.energy;
        return offspring;
    }

    /** Cloruss take exactly the following actions based on NEIGHBORS:
     *  1. If no empty adjacent spaces, STAY.
     *  2. Otherwise, if energy >= 1, REPLICATE.
     *  3. Otherwise, if any Cloruses, MOVE with 50% probability.
     *  4. Otherwise, if nothing else, STAY
     *
     *  Returns an object of type Action. See Action.java for the
     *  scoop on how Actions work. See SampleCreature.chooseAction()
     *  for an example to follow.
     */
    public Action chooseAction(Map<Direction, Occupant> neighbors) {
        List<Direction> empties = getNeighborsOfType(neighbors, "empty");
        List<Direction> plips = getNeighborsOfType(neighbors, "plip");
        if(empties.size() == 0){
            return new Action(Action.ActionType.STAY);
        }
        else{
            if(plips.size() > 0){
                Direction moveDir1 = HugLifeUtils.randomEntry(plips);
                return new Action(Action.ActionType.ATTACK, moveDir1);
            }
            else{
                if(energy >= 1){
                    Direction moveDir2 = HugLifeUtils.randomEntry(empties);
                    return new Action(Action.ActionType.REPLICATE, moveDir2);
                }
            }
        }
        Direction moveDir3 = HugLifeUtils.randomEntry(empties);
        return new Action(Action.ActionType.MOVE, moveDir3);
    }

}