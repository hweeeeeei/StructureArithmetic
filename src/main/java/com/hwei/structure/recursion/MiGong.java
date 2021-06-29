package com.hwei.structure.recursion;

/**
 * 递归: 迷宫回溯问题
 */
public class MiGong {

    public static void main(String[] args) {
        // 迷宫
        int[][] map = new int[8][7];

        // 上下围墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        // 左右围墙
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        // 阻挡
        map[3][1] = 1;
        map[3][2] = 1;

        setWay2(map, 1, 1);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }
    }

/*  1.map 地图
    2. i j 开始找的位置 (1,1)
    3. 如果小球能到[6][5] 最后一个(出口)位置
    4.约定 :
        当map[i][j]=0 表示改点没有走过;
        当为1的时候表示墙 ;
        为2表示通路 可以走;
        为3不能走
    5. 策略: 下 右 上 左, 如果走不通再回溯*/


    // 修改找路策略 上 右 下 左
    public static boolean setWay2(int[][] map, int i, int j) {

        if (map[6][5] == 2) { // 出口位置
            return true;
        } else {

            // 如果当前位置没有走过
            if (map[i][j] == 0) {

                // 策略: 上 右 下 左
                map[i][j] = 2; // 假定该点能走通

                // 往下走
                if (setWay2(map, i - 1, j)) {
                    return true;
                } else if (setWay2(map, i, j + 1)) {
                    return true;
                } else if (setWay2(map, i + 1, j)) {
                    return true;
                } else if (setWay2(map, i, j - 1)) {
                    return true;
                } else {
                    // 重新设置为走不通
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }


    /**
     * @param map 地图
     * @param i   位置下标
     * @param j   位置下标
     * @return 是否找到路
     */
    public static boolean setWay(int[][] map, int i, int j) {

        if (map[6][5] == 2) { // 出口位置
            return true;
        } else {

            // 如果当前位置没有走过
            if (map[i][j] == 0) {

                // 策略: 下 右 上 左
                map[i][j] = 2; // 假定该点能走通

                // 往下走
                if (setWay(map, i + 1, j)) {
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    return true;
                } else {
                    // 重新设置为走不通
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }

}
