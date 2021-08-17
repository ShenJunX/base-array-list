import java.util.Arrays;

/**
 * @ClassName ArrayBase
 * @Description TODO
 * @Author shen
 * @Date 2021/8/16
 */
public class ArrayBase {

    // 声明数组与输出数组
    public static void main(String[] args) {

        // 声明数组 方式1
        String[] names = new String[6];
        names[0] = "语文";
        names[1] = "数学";
        names[2] = "英语";
        names[3] = "物理";
        names[4] = "化学";
        names[5] = "生物";
        // 声明数组 方式2
        // String[] names = {"语文","数学","英语","物理","化学","生物"};
        // 声明数组 方式3
        //String[] names = new String[]{"语文","数学","英语","物理","化学","生物"};

        // 输出数组 方式1
        System.out.print("数组的输出方式1输出的数组内容为：");
        for (int i = 0; i < names.length; i++) {
            System.out.print(names[i] + " ");
        }
        System.out.println('\n' + "=========================");
        // 输出数组 方式2
        System.out.print("数组的输出方式2输出的数组内容为：");
        for (String name : names) {
            System.out.print(name + " ");
        }
        System.out.println('\n' + "=========================");
        // 输出数组 方式3
        System.out.print("数组的输出方式3输出的数组内容为：");
        String arrayToString = Arrays.toString(names);
        System.out.println(arrayToString);
    }
}
