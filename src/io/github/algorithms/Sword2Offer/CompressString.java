package io.github.algorithms.Sword2Offer;

/**
 * Created by zsx at 18-6-2 下午4:43
 * <p>
 * 压缩字符串,examples:
 * input:  aaacbcccbb
 * output: a2cbc3b2
 * ps...其实没压缩多少啊....
 */
public class CompressString {
    public static void main(String[] args) {
        CompressString cs = new CompressString();
//        String s = "aaacbcccbb";//expect: a3cbc3b2
        String s = "aaaabbbbcba";// ecpect: a4b4cba
        cs.mysovle(s);
    }

    /**
     * 思路::可以使用hashmap,但是有个问题, 连着出现的a和最后出现的a显然是不能放到一起的,
     * hashmap解决不了这种问题, --> 自己定义一个hash方式, -->使用二元数组dict:
     * dict[0]是每个字符,dict[1]目前为止出现次数,傻逼了, 元素不一样, 还是用两个变量!
     * <p>
     * 遍历每个元素, 及时清理,保存结果就可!
     *
     * @param s
     */
    public void mysovle(String s) {
        //check parameters....

        char[] source = s.toCharArray();
        StringBuffer sbuf = new StringBuffer();

        char dict = source[0];
        int count = 1;
        for (int i = 1; i < source.length; i++) {
            if (source[i] == dict) {
                count++;
            } else {
                //如果之出现1次就只添加字符不加具体次数!
                sbuf.append(count > 1 ? dict + String.valueOf(count) : dict);
                dict = source[i];
                count = 1;
            }
        }

        //处理残余
        sbuf.append(count > 1 ? dict + String.valueOf(count) : dict);

        System.out.println("result --> " + sbuf.toString());
    }
}
