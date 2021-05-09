package game;

public class Enemy extends Character{
    //variable to store the player's current xp
    int playerXp;

    public Enemy(String name, int playerXp){
        super(name, (int) (Math.random()*playerXp + playerXp/3 + 5), (int) (Math.random()*playerXp/4 + 2) + 1);
        this.playerXp = playerXp;
    }
    public int attack(){
        return (int) (Math.random()*(playerXp/4 + 2) + xp/4 + 3);
    }
    public int defend(){
        return (int) (Math.random()*(playerXp/4 + 2) + xp/4 + 3);
    }

}