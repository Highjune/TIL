```
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Spot { // Mine or Num
    int count;
    boolean isMine;

    Spot (int count, boolean isMine) {
        this.count = count;
        this.isMine = isMine;
    }
}

class LandMine {

    public static void main(String[] args) {
        LandMine mine = new LandMine();
        Spot[][] spots = mine.plantMines();
        mine.print(mine.solution(spots));
    }

    public Spot[][] solution(Spot[][] spots) {
        if (spots == null || spots.length == 0) return new Spot[][]{};
        for (int i = 0 ; i < spots.length; i++) {
            for (int j = 0; j < spots[i].length; j++) {
                spots[i][j].count = getNumOfMines(spots, i, j);
            }
        }
        return spots;
    }

    public int getNumOfMines(Spot[][] spots, int x, int y) {
        int[][] arounds = {{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}}; // check around spot
        if (spots[x][y].isMine) return 0;
        int count = 0;
        for (int[] around : arounds) {
            int pointX = around[0] + x;
            int pointY = around[1] + y;
            if (pointX >= 0 && // validation check
                    pointY >= 0 &&
                    pointX < spots.length &&
                    pointY < spots[0].length &&
                    spots[pointX][pointY].isMine == true) {

                count++;
            }
        }
        return count;
    }

    public Spot[][] plantMines() {

        Spot[][] spots = new Spot[10][10];
        for (int i =0; i<spots.length; i++) {
            for (int j =0; j < spots[i].length; j++) {
                spots[i][j] = new Spot(0, false);
            }
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        int num = 0;

        while (num < 10) {
            int p = (int)(Math.random() * 10);
            int q = (int)(Math.random() * 10);
            if (map.containsKey(p)) {
                if (map.get(p).contains(q)) {
                    continue;
                } else {
                    map.get(p).add(q);
                }
            } else {
                List<Integer> list = new ArrayList();
                list.add(q);
                map.put(p, list);
            }
            num++;
        }

        for (int i = 0 ; i < 10 ; i++) {
            if (!map.containsKey(i)) {
                continue;
            } else {
                List<Integer> list = map.get(i);
                for (int j = 0 ; j < list.size() ; j++) {
//                    System.out.println("a = " + i + "  b = " + list.get(j));
                    spots[i][list.get(j)] = new Spot(0, true);
                }
            }
        }

        return spots;
    }

    public void print(Spot[][] spots) {
        for (int i = 0; i < spots.length; i++) {
            for (int j = 0; j < spots[i].length; j++) {
                System.out.print(String.format("%2s ", spots[i][j].isMine ? "*" : spots[i][j].count));
            }
            System.out.println();
        }
    }

}
```