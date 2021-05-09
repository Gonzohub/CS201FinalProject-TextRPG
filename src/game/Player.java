package game;

public class Player extends Character{

    public int numAtkUpgrades, numDefUpgrades;

    public String[] atkUpgrades = {"Bookworm","Teaching Assistant","Student Researcher"};
    public String[] defUpgrades = {"Study Guide","TI-1000","TI-X"};

    public Player(String name) {
        super(name, 10, 0);//calling constructor of superclass
        //setting # of upgrdes to 0
        this.numAtkUpgrades = 0;
        this.numDefUpgrades = 0;
        //let player choose a trait when creating a new character
        chooseTrait();
    }

    @Override
    public int attack(){
        return (int) (Math.random()*(xp/4 + numAtkUpgrades*3 + 3) + xp/10 + numAtkUpgrades*2 + numDefUpgrades + 1) ;
    }

    @Override
    public int defend(){
        return (int) (Math.random()*(xp/4 + numDefUpgrades*3 + 3) + xp/10 + numAtkUpgrades*2 + numDefUpgrades + 1) ;
    }

    public void chooseTrait(){
        GameLogic.clearConsole();
        GameLogic.printHeading("Choose a trait:");
        System.out.println("(1) (Offense)" + atkUpgrades[numAtkUpgrades]);
        System.out.println("(2) (Defense)" + defUpgrades[numDefUpgrades]);
        //getting player's choice
        int input = GameLogic.readInt("-> ", 2);
        GameLogic.clearConsole();
        //conditional for both cases
        if(input == 1){
            GameLogic.printHeading("You chose " + atkUpgrades[numAtkUpgrades] + "!");
            numAtkUpgrades++;
        }else{
            GameLogic.printHeading("You chose " + defUpgrades[numDefUpgrades]+ "!");
            numDefUpgrades++;
        }
        GameLogic.anythingToContinue();
    }

}