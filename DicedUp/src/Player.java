public class Player {
     private int health;
     private int level;
     private int attackPower;
     private int exp;
     private String playerName;
        //Set foundation of player stats
        public Player(){
        this.health = 100;
        this.level = 1;
        this.attackPower = 15;
        this.exp = 0;
    }

    public void LevelUp() {
        this.level++;
        this.attackPower += 2;
        this.exp = 0;
        this.health = 105;
    }
    //Retrieve the health of player
    public int getHealth() {
        return health;
    }
    public int void setHealth(int health) {
            this.health = health;
    }
    //Retrieve the level of player
    public int getLevel() {
        return level;
    }
    public int void setLevel(int level) {
            this.level = level
    }
    //Retrieve the Experience Points of player
    public int getEXP(){
        return exp;
    }
    public int void setEXP(int exp) {
        this.exp = exp
    }
    public int getAttackPower() {
            return attackPower;
        }
    public int void setAttackPower(int attackPower) {
            this.attackPower = attackPower;
    }
    public String getPlayerName() {
            return playerName;
    }
    public String void setPlayerName(String playerName) {
            this.playerName = playerName;
    }
}
