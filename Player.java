public class Player {
    private String name;
    private String player;
    private int win;
    private int lose;
    private int draw;

    Player(String player) {
        this.name = "default name";
        this.player = player;
    }

    public String getPlayer() {
        return this.player;
    }

    public String getName() {
        return this.name;
    }

    public int getWin() {
        return this.win;
    }

    public int getLose() {
        return this.lose;
    }

    public int getDraw() {
        return this.draw;
    }

    public int win() {
        return this.win += 1;
    }

    public int lose() {
        return this.lose += 1;
    }

    public int draw() {
        return this.draw += 1;
    }
}