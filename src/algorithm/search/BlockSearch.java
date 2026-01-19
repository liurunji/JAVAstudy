package algorithm.search;

public class BlockSearch {
    public static void main(String[] args) {
        int[] arr = {27, 22, 30, 40, 36, 13, 19, 116, 20, 7, 10, 43, 50, 48};
        Block b1 = new Block(22, 40, 0, 4);
        Block b2 = new Block(13, 20, 5, 8);
        Block b3 = new Block(7, 10, 9, 10);
        Block b4 = new Block(43, 50, 11, 13);
        Block[] blockArr = {b1, b2, b3, b4};
        System.out.println(getIndex(blockArr, arr, 19));

    }

    private static int getIndex(Block[] blockArr, int[] arr, int num) {
        int block = findIndexBlock(blockArr, num);
        if (block == -1)
            return -1;

        for (int i = blockArr[block].getStartIndex(); i <= blockArr[block].getEndIndex(); i++) {
            if (num == arr[i])
                return i;
        }
        return -1;
    }

    //确定在那个块中
    private static int findIndexBlock(Block[] blockArr, int num) {
        for (int i = 0; i < blockArr.length; i++) {
            if (num >= blockArr[i].getMin() && num <= blockArr[i].getMax()) {
                return i;
            }
        }
        return -1;
    }
}

class Block {
    private int min;
    private int max;
    private int startIndex;
    private int endIndex;

    public Block() {
    }

    public Block(int min, int max, int startIndex, int endIndex) {
        this.max = max;
        this.min = min;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }
}
