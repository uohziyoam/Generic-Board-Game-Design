public class Player {
    private String name;
    private String player;
    private int score;

    Player(String player, String name) {
        this.name = name;
        this.player = player;
    }

    public String getPlayer() {
        return this.player;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    public int setScore() {
        return this.score += 1;
    }
}