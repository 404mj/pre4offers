package io.github.algorithms.Sword2Offer;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by zsx at 18-5-12 上午9:52
 * <p>
 * 求全排列
 */
public class Permutation {
    public static void main(String[] args) {
        Permutation p = new Permutation();
        p.solve("", "abc");

//        p.permutaiton("abcd").forEach(System.out::println);
//        p.permutaiton("abcd").parallel().forEach(System.out::println);
    }

    /**
     * 我的思路是对的::对于abcd,拿出a拼接上,求bcd全排列结果.然后拿出b, 再拼接上剩余acd的全排列.
     * <p>
     * 但是我的代码实现思路是错的, 是因为有点之前的残余,又完全记忆不出正确的version.
     * <p>
     * 在这里对方法进行参数的改进就行了!!
     *
     * @param res 存放递归调用中的结果! str在每次递归中都会减少,当为0的时候,res中就存放了
     *            一次结果
     * @param str 当前的可选择的str,
     */
    public void solve(String res, String str) {
        //check parameter....
        if (str.length() == 0) {
            System.out.println(res);
        } else {
            for (int i = 0; i < str.length(); ++i) {
                /**
                 * NOTE::注意这里递归调用的第二个参数::str.substring(0,i) + str.substring(i+1),而不是str.substring(i+1)
                 * BECAUSE:: 上面我解释的思路那掉第一个a,只用一个substring是可以的!
                 * 但当进行拿掉b的时候, 需要解决的是b前面和b后面组成的string的permutaition了, 所以 **必须** 两个substring拼接!!!
                 */
                solve(res + str.charAt(i), str.substring(0, i) + str.substring(i + 1));
            }
        }
    }

    /**
     * from https://codereview.stackexchange.com/questions/120041/java-8-string-unique-permutations-in-parallel
     * <p>
     * java8 中中使用Stream API操作!!!
     *
     * @param str
     * @return
     */
    public Stream<String> permutaiton(String str) {
        if (str.isEmpty()) {
            return Stream.of("");
        }

        return IntStream.range(0, str.length())
                .boxed()
                .flatMap(
                        i -> permutaiton(str.substring(0, i) + str.substring(i + 1))
                                .map(t -> str.charAt(i) + t)
                );
    }
}
