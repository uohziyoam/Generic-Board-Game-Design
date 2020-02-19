public class IndexMap {
    private int row;
    private int col;
    public Coordinate[] INDEX_TO_COORDINATE;

    IndexMap(int row, int col) {
        this.row = row;
        this.col = col;
        initIndexMap();
    }

    private void initIndexMap() {
        this.INDEX_TO_COORDINATE = new Coordinate[this.row * this.col];

        for (int i = 0; i < INDEX_TO_COORDINATE.length; i++) {
            Coordinate coordinate = new Coordinate((i / this.col), i % (this.row));
            this.INDEX_TO_COORDINATE[i] = coordinate;
        }
    }

    public Coordinate get(int index) {
        return this.INDEX_TO_COORDINATE[index - 1];
    }

    public void print() {
        for (Coordinate coordinate : INDEX_TO_COORDINATE) {
            System.out.print("(" + coordinate.row + "," + coordinate.col + ")");
        }
    }
}