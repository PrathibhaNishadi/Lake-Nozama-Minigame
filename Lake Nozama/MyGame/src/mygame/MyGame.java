public class MyGame {

    public static int warriorsInTheGame = 0;

    /**
     * @param args the command line arguments
     */
    private static long startTime;
    public static void main(String[] args) {
        ArrayList<InhabitantChracter> monsters = new ArrayList<InhabitantChracter>();  // Create a list for hold 5 monsters
        ArrayList<InhabitantChracter> warriors = new ArrayList<InhabitantChracter>();  // Create a list for hold 4 warriors
        ArrayList<Tree> trees = new ArrayList<Tree>();                                 // Create a list for hold 5 trees

        MountDoom md = new MountDoom(warriors);                                         // Create mountdoom object
        LandOfMordor land = new LandOfMordor(md, 11, 11);                           // Create land of mordor object
        Random random = new Random();                                           // Random object for get random numbers                                         

        monsters.add(new InnocentMonster("Isuri", 28, land));                         // Add 2 Innocent monsters & 3 Normal monsters to monstres list
        monsters.add(new InnocentMonster("Damsha", 28, land));
        monsters.add(new NormalMonster("Thilani", 26, land));
        monsters.add(new NormalMonster("Mihiri", 26, land));
        monsters.add(new NormalMonster("Yasara", 26, land));

        warriors.add(new Warrior("Yasiru", 21, land, monsters));                                // Add 4 warriors to warriors list
        warriors.add(new Warrior("Maneesha", 21, land, monsters));
        warriors.add(new SuperWarrior("Thilina", 21, land, monsters));
        warriors.add(new Warrior("Chathuka", 21, land, monsters));

        trees.add(new Tree());                                                  // Add 5 trees to trees list
        trees.add(new Tree());
        trees.add(new Tree());
        trees.add(new Tree());
        trees.add(new Tree());
        land.addObject(md, 5, 5, 0);                                                     // Add mount doom to (5,5)
        System.out.println("Mountdoom at index of (5,5)");

        int treeCount = 0;                                                      // Add 5 trees to grid
        while (treeCount < 5) {
            int x = random.nextInt(11);
            int y = random.nextInt(11);
            if (land.isEmptyNode(x, y, 0) == 0) {
                land.addObject(trees.get(treeCount), x, y, 0);
                trees.get(treeCount).addCoordinate(x, y);
                System.out.println("A Tree at index of (" + x + "," + y + ")");
                treeCount++;
            }
        }

        int monsterCount = 0;                                                   // Add 5 monsters to grid
        while (monsterCount < 5) {
            int x = random.nextInt(11);
            int y = random.nextInt(11);
            if (land.isEmptyNode(x, y, 0) == 0) {
                land.addObject(monsters.get(monsterCount), x, y, 0);
                monsters.get(monsterCount).addCoordinates(x, y);
                System.out.println("A " + monsters.get(monsterCount).getClass().getSimpleName() + " " + monsters.get(monsterCount).getCharacterName() + " of age " + monsters.get(monsterCount).getAge() + " at index of (" + x + "," + y + ")");
                monsterCount++;
            }
        }

        int[] verticesOfGrid = {0, 10};                                         // Add random number of warriors to edges of the grid
        int warriorCount = random.nextInt(4);
        while (warriorsInTheGame <= warriorCount) {
            int sideSelect = random.nextInt(2);
            int x = 0;
            int y = 0;
            if (sideSelect == 0) {
                x = random.nextInt(11);
                y = verticesOfGrid[random.nextInt(2)];
            } else {
                x = verticesOfGrid[random.nextInt(2)];
                y = random.nextInt(11);
            }
            if (land.isEmptyNode(x, y, 0) == 0) {
                land.addObject(warriors.get(warriorsInTheGame), x, y, 1);
                warriors.get(warriorsInTheGame).addCoordinates(x, y);
                System.out.println("A " + warriors.get(warriorsInTheGame).getClass().getSimpleName() + " " + warriors.get(warriorsInTheGame).getCharacterName() + " of age " + warriors.get(warriorsInTheGame).getAge() + " at index of (" + x + "," + y + ")");
                warriorsInTheGame++;
            }
        }

        System.out.println("Number Of Warriors = " + warriorsInTheGame);
        System.out.println("==================================================");
        startTime =  System.currentTimeMillis();
        for (int i = 0; i < warriorsInTheGame; i++) {
            warriors.get(i).start();
        }

    }

    /**
     * @return the startTime
     */
    public static long getStartTime() {
        return startTime;
    }

}
