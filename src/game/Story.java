package game;

public class Story {
    
    public static void printfirstActIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("ACT I - INTRO");
        GameLogic.printSeperator(30);
        System.out.println("As you begin your journey at IIT, you enroll in the course CS201.");
        System.out.println("You find this course is very challenging. It will take a lot of dedication to succeed.");
        System.out.println("After a long semester, finals week is quickly approaching and it is time to prepare.");
        GameLogic.anythingToContinue();
    }
    public static void printFirstBattle(){
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("First Session");
        GameLogic.printSeperator(30);
        System.out.println("You meet up with some your classmates to study for your CS201 final.");
        GameLogic.anythingToContinue();
    }

    public static void printFirstBattleOutro(){
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("First Session Complete");
        GameLogic.printSeperator(30);
        System.out.println("Great studying! Let's hope you're ready to study with the TAs.");
        GameLogic.anythingToContinue();
    }

    public static void printSecondActIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("ACT II - INTRO");
        GameLogic.printSeperator(30);
        System.out.println("Although studying with your classmates went well, you still need to meet with the TAs.");
        System.out.println("You make sure you are available to meet with the TAs during their office hours.");
        System.out.println("Thankfully you are free. You send them a quick email to let them know you will be there.");
        GameLogic.anythingToContinue();
    }


    public static void printSecondBattle(){
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("Second Session");
        GameLogic.printSeperator(30);
        System.out.println("It's time to meet with the TAs to study for your CS201 final.");
        GameLogic.anythingToContinue();
    }

    public static void printSecondBattleOutro(){
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("Second Session Complete");
        GameLogic.printSeperator(30);
        System.out.println("You gave the TAs a run for their money! You're definitely ready for the final");
        GameLogic.anythingToContinue();
    }

    public static void printThirdActIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("ACT III - The Final");
        GameLogic.printSeperator(30);
        System.out.println("All the hard work and dedication has come down to this very day: THE FINAL EXAM");
        System.out.println("You wake up, get ready, have a quick breakfast, and head to your final exam.");
        System.out.println("Once in the testing room, your nerves begin to kick in.");
        System.out.println("Although you are nervous, you remember that you have done everything you could to prepare and now it is time to prove yourself.");
        GameLogic.anythingToContinue();
    }

    public static void printFinalBoss(){
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("Final");
        GameLogic.printSeperator(30);
        System.out.println("This is IT!");
        System.out.println("It's time to take your CS201 final");
        GameLogic.anythingToContinue();
    }

    public static void printFinalBossOutro(){
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("Final - COMPLETE");
        GameLogic.printSeperator(30);
        System.out.println("That wasn't so bad, was it?");
        GameLogic.anythingToContinue();
    }

    public static void printEnd(){
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("End");
        GameLogic.printSeperator(30);
        System.out.println("Congratulations! You've Passed CS201! You're one step closer to your degree.");
        GameLogic.anythingToContinue();
    }

}