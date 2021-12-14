package club.zhuangbinan;

import java.io.*;
import java.util.Arrays;

/**
 * https://www.bilibili.com/video/BV1E4411H73v?p=9
 * 稀疏数组课后练习
 * @author zhuangbinan 2021.12.14
 */
public class SparseArrayTest {


    public static void main(String[] args) {

        //有一个棋盘 有11行11列 11*11 = 121
        int chessLength = 11;
        int chessHeight = 11;
        //用二维数组表示
        int [][] chessArr = new int [chessLength][chessHeight];
        //初始化的棋盘上0表示空着的,二维数组的默认值也是0
        //棋盘上有 黑子,蓝子, 1表示黑子, 2表示蓝子
        //在棋盘的第2行第3个放了一个黑子
        //       第3行第4个放了一个蓝子
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        //输出棋盘 ,查看效果
        queryDoubleArray(chessArr);
        // 需求: 棋盘要有 存盘到文件,读取存盘复盘功能
        // 要做到存盘文件要尽可能少的占用磁盘空间
        // 可以用到稀疏数组
        // 稀疏数组: 是一个双列数组,第一行第一列存了原始棋盘有多少行,第二列存了有多少列,第三列存了原始棋盘有几个棋子;
        // 第二行 到 最后一行, 存的是 棋子的位置 和值,
        // 例如 :稀疏数组的第二行第一列是原始棋盘的第一个棋子的行数,
        //      第二行第二列是第一个棋子的列数,
        //      第二行第三列是第一个棋子的值
        //
        // 行(row)    列(col)   值(value)

        //原始棋盘转为稀疏数组
        //首先为了创建稀疏数组,要获取原始棋盘上棋子数量
        int count = 0;
        for (int[] row : chessArr) {
            for (int col : row) {
                if (col != 0) {
                    count ++;
                }
            }
        }
        System.out.println("棋盘上棋子数量:"+count);
        //创建稀疏数组
        int[][] sparseArr = new int[count + 1][3];
        //
        System.out.println("查看初始化的稀疏数组");
        queryDoubleArray(sparseArr);
        //给稀疏数组填值
        //第一行
        sparseArr[0][0] = chessLength;
        sparseArr[0][1] = chessHeight;
        sparseArr[0][2] = count;
        //第二行 - 最后一行
        int num = 1;
        for (int row = 0; row < chessArr.length; row++) {
            for (int col = 0; col < chessArr.length; col++) {
                if (chessArr[row][col] != 0) {
                    sparseArr[num][0] = row;
                    sparseArr[num][1] = col;
                    sparseArr[num][2] = chessArr[row][col];
                    num ++;
                }
            }
        }
        System.out.println("查看有值后的稀疏数组");
        queryDoubleArray(sparseArr);
        //稀疏数组有值后,要进行存盘;
        //将数组转为字符格式
        File file = new File("chessSrc.txt");
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            for (int[] row : sparseArr) {
                for (int col : row) {
                    String s = col + ",";
                    outputStream.write(s.getBytes());
                }
                outputStream.write("\n".getBytes());
            }
            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        //存到chessSrc.txt文件里了
        //现在要读出来,转为棋盘
        try {
            FileReader fr2 = new FileReader(file);
            BufferedReader bufferedReader2 = new BufferedReader(fr2);
            int readRows = 0;
            while (true) {
                String line = bufferedReader2.readLine();
                if (line != null) {
                    readRows ++;
                }else {
                    break;
                }
            }
            bufferedReader2.close();
            fr2.close();
            //首先要根据读到的文件判断有几行,好创建稀疏数组
            System.out.println("有几行:"+readRows);
            //稀疏数组总是3列,创建复原的稀疏数组
            int [][] recoverySparseArr = new int[readRows][3];
            //再读一次文件,给稀疏数组填充值
            FileReader fr = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fr);
            int row = 0;
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    String[] lineArr = line.split(",");
                    System.out.println(Arrays.toString(lineArr));
                    recoverySparseArr[row][0] = Integer.valueOf(lineArr[0]);
                    recoverySparseArr[row][1] = Integer.valueOf(lineArr[1]);
                    recoverySparseArr[row][2] = Integer.valueOf(lineArr[2]);
                    row ++;
                } else {
                    break;
                }
            }
            bufferedReader.close();
            fr.close();
            System.out.println("查看复原后的稀疏数组:");
            queryDoubleArray(recoverySparseArr);
            //再把稀疏数组还原成二维棋盘
            //首先读取第一行,创建二维数组
            int [][] recoveryChessArr =
                    new int[recoverySparseArr[0][0]][recoverySparseArr[0][1]];
            //给里面填充值
            for (int i = 1; i < recoverySparseArr.length; i++) {
                recoveryChessArr[
                                recoverySparseArr[i][0]
                        ]
                        [
                                recoverySparseArr[i][1]
                        ]
                        =       recoverySparseArr[i][2];
            }
            System.out.println("查看复原后的棋盘");
            queryDoubleArray(recoveryChessArr);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void queryDoubleArray(int [][] doubleArr){
        System.out.println();
        for (int[] row : doubleArr) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

}
