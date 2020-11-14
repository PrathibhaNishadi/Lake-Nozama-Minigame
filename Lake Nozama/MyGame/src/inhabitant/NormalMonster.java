public class NormalMonster extends InnocentMonster {

    public NormalMonster(String name, int age, LandOfMordor land) {                                // Construct the normal monster object
        super(name, age, land);

    }

    public synchronized void kill(Warrior w) {                                                       // Normal monsters killing method
        if (!w.isImmortal()) {
            walkingSticks.add(w.loseStick());
            w.setMobility(false);
            System.out.println(w.getCharacterName() + " was killed by " + this.getCharacterName() + " !");
            w = null;
            MyGame.warriorsInTheGame--;
        } else {
            super.steal(w);
        }
    }

    public void update(Warrior w) {
        if (this.node.getX() == w.node.getX() && this.node.getY() == w.node.getY()) {
            kill(w);
        }
    }

}
