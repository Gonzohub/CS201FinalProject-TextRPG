package game;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class GameLogic {
    static Scanner scanner = new Scanner(System.in);

    public static boolean isRunning;

    static Player player;

    //enemy names
    public static String[] enemies = {"Student-Bob","Student-John","Student-George","Student-Emily","Student-Abigail"};

    //Story elements
    public static int place = 0, act = 1;
    public static String[] places = {"1st Study Session", "2nd Study Session", "CS 201 Final"};

    //method to get user input from console
    public static int readInt(String prompt, int userChoices){
        int input;

        do{
            System.out.println(prompt);
            try{
                input = Integer.parseInt(scanner.next());
            }catch(Exception e){
                input = -1;
                System.out.println("Enter an Integer!");
            }
        }while(input < 1 || input > userChoices);
        return input;
    }

    //method to simulate clearing out the console
    public static void clearConsole(){
        for (int i = 0; i < 100; i++)
            System.out.println();
    }

    //method to print n lengthed seperator
    public static void printSeperator(int n){
        for(int i=0; i < n ; i++)
            System.out.print("-");
        System.out.println();
    }

    //print header method
    public static void printHeading(String title){
        printSeperator(30);
        System.out.println(title);
        printSeperator(30);
    }

    public static void anythingToContinue(){
        System.out.println("\nEnter any key to continue...");
        scanner.nextLine();
    }

    //method to start the game
    public static void startGame(){
        boolean nameSet = false;
        String name;
        //Title Screen
        clearConsole();
        printSeperator(40);
        printSeperator(35);
        System.out.println("Institute of Technomancers");
        printSeperator(35);
        printSeperator(40);
        anythingToContinue();

        //geting the player name
        do{
            clearConsole();
            printHeading("What's your name?");
            name = scanner.next();
            //asking if the name needs to be corrected
            clearConsole();
            printHeading("Your name is " + name + ".\nIs that correct?");
            System.out.println("(1) Yes!");
            System.out.println("(2) No, I want to change it.");
            int input = readInt("->",2);
            if(input == 1)
                nameSet = true;
        }while(!nameSet);

        //**INSERT STORY PART HERE!!!*****(vid3)
        //print story intro
        //Story.printIntro();
        Story.printfirstActIntro();
        Story.printFirstBattle();
        //create new player object with the name
        player = new Player(name);
        //setting isRunning to true, so the game can continue
        isRunning = true;
        //start main game loop
        gameLoop();

    }

    public static void checkAct(){
        if(player.xp >= 10 && act ==1){
            act = 2;
            place = 1;
            Story.printFirstBattleOutro();
            Story.printSecondActIntro();
            Story.printSecondBattle();
            player.chooseTrait();
            enemies[0] = "TA-Fran";
            enemies[1] = "TA-Jonathon";
            enemies[2] = "TA-Franco";
            enemies[3] = "TA-Lewis";
            enemies[4] = "TA-Franchesca";
            //fully heal the player
            player.hp = player.maxHp;
        }else if(player.xp >= 20 && act == 2){
            act = 3;
            place = 2;
            Story.printSecondBattleOutro();
            Story.printThirdActIntro();
            Story.printFinalBoss();
            //fully heal the player and increase
            player.maxHp = player.maxHp + 10;
            player.hp = player.maxHp;

        }
    }

    //method to continue the journey
    public static void continueJourney(){
        checkAct();
        //check to see if game isn't in final act
        if(act == 1){
            randomBattle();
        }else if(act == 2){
            randomBattle2();
        }else {
            FinalBattle();
        }
    }

    //printing out most important information about the player character
    public static void characterInfo(){
        clearConsole();
        printHeading("CHARACTER INFO");
        System.out.println(player.name + "\tHP: " + player.hp + "/" + player.maxHp);
        printSeperator(20);
        System.out.println("XP: " + player.xp);

        //printing the chosen traits
        if(player.numAtkUpgrades > 0){
            System.out.println("Offensive trait: " + player.atkUpgrades[player.numAtkUpgrades - 1]);
            printSeperator(20);
        }
        if(player.numDefUpgrades > 0){
            System.out.println("Defensive trait: " + player.defUpgrades[player.numDefUpgrades - 1]);
        }
        anythingToContinue();  //*COME BACK TO THIS!!!
    }
    //Battles for Act 1
    public static void randomBattle(){
        clearConsole();
        printHeading("You must win this battle to complete the study session.");
        anythingToContinue();
        battle(new Enemy(enemies[(int)(Math.random()*enemies.length)], player.xp ));
    }
    //Battles for Act 2
    public static void randomBattle2(){
        clearConsole();
        printHeading("You must win this battle to complete the study session.");
        anythingToContinue();
        battle(new Enemy(enemies[(int)(Math.random()*enemies.length)], player.xp*4 ));
    }

    //main Battle method
    public static void battle(Enemy enemy){
        while(true){
            clearConsole();
            printHeading(enemy.name + "\nHP: " + enemy.hp + "/" + enemy.maxHp);
            printHeading(player.name + "\nHP: " + player.hp + "/" + player.maxHp);
            System.out.println("Choose an action: ");
            printSeperator(20);
            System.out.println("(1) Fight\n(2) Run Away");
            int input = readInt("->", 2);
            //react accordingly to player input
            if(input == 1){
                int dmg = player.attack() - enemy.defend();
                int dmgTook = enemy.attack() - player.defend();
                if(dmgTook < 0){
                    dmg -= dmgTook/2;
                    dmgTook = 0;
                }
                if(dmg < 0)
                    dmg = 0;
                player.hp -= dmgTook;
                enemy.hp -= dmg;
                //infor of this battle round
                clearConsole();
                printHeading("BATTLE");
                System.out.println("You dealt " + dmg + " damage to the " + enemy.name + ".");
                printSeperator(15);
                System.out.println("The " + enemy.name + " dealt " + dmgTook + " damage to you.");
                anythingToContinue();
                //check if player is alive or dead
                if(player.hp <= 0){
                    playerDied();
                    break;
                }else if(enemy.hp <= 0){
                    //tell player they won
                    clearConsole();
                    printHeading("You defeated the " + enemy.name + "!");
                    //increase player xp
                    player.xp += enemy.xp;
                    System.out.println("You earned " + enemy.xp + "XP!");
                    anythingToContinue();
                    break;
                }
            }
            else if(input == 2){
                //this is for the second option
                if(act != 3){
                    //35% chance of escaping
                    if(Math.random()*10 + 1 <= 3.5){
                        printHeading("You ran away from the " + enemy.name + "!");
                        try {
                            TimeUnit.SECONDS.sleep(2);
                        }
                        catch (Exception e)
                        {
                            System.out.println("error");
                        }
                        //anythingToContinue();
                        break;
                    }else{
                        printHeading("You didn't manage to escape.");
                        //calculate damage the player takes
                        int dmgTook = enemy.attack();
                        System.out.println("In your hurry you took:  " + dmgTook + " damage!");
                        player.hp = player.hp - dmgTook;
                        try {
                            TimeUnit.SECONDS.sleep(2);
                        }
                        catch (Exception e)
                        {
                            System.out.println("error");
                        }
                        //anythingToContinue();
                        if(player.hp <=0)
                            playerDied();
                    }
                }else{
                    printHeading("You cannot escape!");
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    }
                    catch (Exception e)
                    {
                        System.out.println("error");
                    }
                    //anythingToContinue();
                }
            }
        }
    }

    //printing main menu
    public static void printMenu(){
        clearConsole();
        printHeading("MENU");
        System.out.println("Choose an action");
        printSeperator(20);
        System.out.println("(1) Continue your journey");
        System.out.println("(2) Character Info");
        System.out.println("(3) Exit Game");
    }

    //the final battle
    public static void FinalBattle(){
        player.chooseTrait();
        battle(new Enemy("The final", 50));
        if(player.xp >= 21 && act == 3){
            Story.printFinalBossOutro();
            Story.printEnd();
        } else {
            playerDied();
        }
        isRunning = false;
    }

    //method for when player dies
    public static void playerDied(){
        clearConsole();
        printHeading("You dropped out...");
        printHeading("You earned " + player.xp + "XP on your journey.");
        System.out.println("Thanks for playing!");
        isRunning = false;
    }

    //main game loop
    public static void gameLoop(){
        while(isRunning){
            printMenu();
            int input = readInt("-> ", 3);
            if(input == 1)
                continueJourney();
            else if(input == 2)
                characterInfo();
            else
                isRunning = false;
        }
    }
}