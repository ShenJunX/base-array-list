import java.util.Scanner;

/**
 * @ClassName ScoreMaster
 * @Description TODO
 * @Author shen
 * @Date 2021/8/16
 */
public class ScoreMaster {

    public static void main(String[] args) {
        // 声明六个变量，分别代表六个科目
        int YuWanIndex = 0;
        int ShuXueIndex = 1;
        int YingYuIndex = 2;
        int WuLiIndex = 3;
        int HuaXueIndex = 4;
        int ShengWuIndex = 5;

        int totalScoreCount = 6;

        // 每门课的名字
        String[] names = new String[totalScoreCount];
        names[YuWanIndex] = "语文";
        names[ShuXueIndex] = "数学";
        names[YingYuIndex] = "英语";
        names[WuLiIndex] = "物理";
        names[HuaXueIndex] = "化学";
        names[ShengWuIndex] = "生物";

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入共有多少年的成绩：");
        int yearCount = scanner.nextInt();

        double[][] scores = new double[yearCount][totalScoreCount];
        for (int i = 0; i < yearCount; i++) {
            System.out.print("第" + (i + 1) + "年的");
            for (int j = 0; j < totalScoreCount; j++) {
                scores[i][j] = (80 + Math.random() * 20);
                System.out.print(names[j] + "成绩为" + scores[i][j] + " ");
            }
            System.out.println();
        }

        boolean endFlag = true;
        while (endFlag) {
            System.out.println("请输入要进行操作的编号：");
            System.out.println("1.求某年最好成绩\n" +
                    "2.求某年平均成绩\n" +
                    "3.求所有年份最好成绩\n" +
                    "4.求某门课历年最好成绩");
            int type = scanner.nextInt();

            int year = 0; // 代表年份的索引位置
            switch (type) {
                case 1:
                    // 思路：根据索引（非值）
                    System.out.print("请输入要求哪一年的最好成绩：");
                    year = scanner.nextInt() - 1; // 此处-1 索引
                    if (year < 0 || year >= yearCount) {
                        System.out.println("非法输入");
                        break;
                    }
                    int bestOfScoreId = 0;
                    for (int i = 0; i < scores[year].length; i++) {
                        if (scores[year][i] > scores[year][bestOfScoreId]) {// 默认某年第一个成绩是最大的
                            bestOfScoreId = i;
                        }
                    }
                    System.out.println("第" + year + 1 + "年的最好成绩是" + scores[year][bestOfScoreId]);
                    break;
                case 2:
                    // 思路：根据索引（非值）
                    System.out.print("请输入要求哪一年的平均成绩：");
                    year = scanner.nextInt() - 1; // 此处-1 索引
                    if (year < 0 || year >= yearCount) {
                        System.out.println("非法输入");
                        break;
                    }
                    double sumScore = 0;
                    for (int i = 0; i < scores[year].length; i++) {
                        sumScore += scores[year][i];
                    }
                    double aveScore = sumScore / names.length;
                    System.out.println("第" + (year + 1) + "年的平均成绩是" + aveScore);
                    break;
                case 3:
                    // 思路：根据索引（非值）
                    int bestOfYearScoreId = 0;
                    for (int i = 0; i < scores.length; i++) {
                        for (int j = 0; j < scores[i].length; j++) {
                            if (scores[year][bestOfYearScoreId] < scores[i][j]) {
                                year = i;
                                bestOfYearScoreId = j;
                            }
                        }
                    }
                    System.out.println("历年最好成绩为第" + (year+1) + "年"+names[bestOfYearScoreId]+"的最好成绩是" + scores[year][bestOfYearScoreId]);
                    break;
                case 4:
                    // 思路：根据索引（非值）
                    System.out.print("请输入要求哪门课历年最好成绩：");
                    System.out.println("0.语文 1.数学 2.英语 3.物理 4.化学 5.生物");
                    int scoreIndex = scanner.nextInt(); // 此处 索引
                    for (int i = 0; i < scores.length; i++) {
                        if (scores[year][scoreIndex] < scores[i][scoreIndex]) {
                            year = i;
                        }
                    }
                    System.out.println(names[scoreIndex] + "的最好成绩是第" + (year + 1) + "年" + scores[year][scoreIndex]);
                    break;
                default:
                    endFlag = false;
                    System.out.println("程序结束");
                    break;
            }
        }
    }
}
