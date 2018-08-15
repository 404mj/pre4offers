### 渣记录简单的刷题记录

#### 一部分作为代码写在这个package下了
。。。

#### 其余部分边看边记录代码可能有可能没有

from: 牛客—剑指offer [https://www.nowcoder.com/ta/coding-interviews]
虽然我不齿于刷题，但是实在被在线编程虐的难受！

- 跳台阶，变态跳台阶

归纳法，斐波那契数列

- 2×1矩形填充

归纳总结

- 重建二叉树，给定前序和中序

递归，reConstructBinaryTree(int[] pre，int st, int ed,int[] mid,int st,int ed)

- 判断一个数中1的个数

代码记录过，有一系列变形，核心使用异或特型！
count+＝ n & 1; n>>1;

- 求一个double的int次幂

主要考验写的程序的健壮性。判断特殊情况，使用幂乘法。

- 调整数组分成两部分！

很经典，好多种做法。两个指针或者一个元素记录调整了多少

- 链表倒数第k个元素

快慢指针。

- 反转双链表

基本题， 递归和头插法。

- 判断二叉树B是不是A的子结构。

递归，比较root，比较root.left和B。。。

- 二叉树镜像反转

先序遍历，交换，递归处理左右。

- 给定入栈序列判断出栈序列是否正确

可以不去思考怎么整体的去判断，思维陷阱。直接专门针对一个问题。
因为：我开始想法是遍历所有的出栈顺序，和给定序列匹配。
解决思路是：每入一个元素检查一下。

```java
whil origin.peek == checkd.peek
  pop, continue
while origin.peek != checkd.peek
  if origin.size <= 0
      not match, break;
  push origin.next
```
- 二叉搜索树的后序遍历序列判断

都要忘记二叉搜索树的定义了，其实就是avl红黑树的基础思想，我老是和堆的完全二叉树弄混！

==> 都是2K+1和2K是K的右子树和左子树！

定义：左孩子都小，右孩子都大。中序遍历为递增序列，后序遍历root在最后哦。
直接根据规则判断序列即可，编程实现：

- 二叉树中和为指定值的路径

递归，进行先序遍历即可。

- 复杂链表的复制

返回结果不能是节点的简单引用(就像我想的是的)，这一个约束条件，每个新建节点的地址是不一样的，怎么保存？
方案就是a->b->c  => a->a'->b->b'->c->c'  => a'->b'->c'

> 还可以使用 hash映射，

- 二叉搜索树变为双向链表(不允许创建新的节点)
  - 就是中序遍历的非递归实现，并在遍历的时候修改前驱
  public TreeNode ConvertBSTToBiList(TreeNode root) {
        if(root==null)
            return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        TreeNode pre = null;// 用于保存中序遍历序列的上一节点
        boolean isFirst = true;
        while(p!=null||!stack.isEmpty()){
            while(p!=null){
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if(isFirst){
                root = p;// 将中序遍历序列中的第一个节点记为root
                pre = root;
                isFirst = false;
            }else{
                pre.right = p;
                p.left = pre;
                pre = p;
            }      
            p = p.right;
        }
        return root;
    }

递归方案： 将左子树变成链表，作为root的前驱，再将右子树变成链表。

- 数组中只出现一次的数字

使用异或！pre4offers

- 判断是不是平衡二叉树：

求root节点左右子树的深度即可，if (node == null) return 0  return 1+ Math.max(deepth(node.left),deepth(node.right))

可以优化：进行剪枝？

- 树的深度

基本。

- 数字在排序数组中出现的次数

看见有序，肯定二分查找！找到两个位置相减即可！怎样得到两个位置？firstIndex和lastIndex返回判断mid的条件不同！

> 另外一种方案：因为都是整数，二分查找k-0.5 和 k+0.5的位置。

- 两个链表的第一个公共节点(交叉节点)

先依次找到两个链表的长度！然后一起走！

- 数组中的逆序对

暴力是n^2， 使用归并排序的思想！代码记录过，没有学会！

- 第一个只出现第一次的字符（第一个不重复的字符）

暴力思路通过！使用LinkedHashMap既记录出现次数，又保持插入顺序！找到字符之后因为要返回index，使用strig.indexOf()即可！

- 丑数！

质因数只有2，3，5的。所以 1-2-3-4-5-6-8-9-10-15....
```java
public int GetUglyNumber_Solution2(int n)
    {
        if(n<=0)return 0;
        ArrayList<Integer> list=new ArrayList<Integer>();
        list.add(1);
        int i2=0,i3=0,i5=0;
        while(list.size()<n)//循环的条件
        {
            int m2=list.get(i2)*2;
            int m3=list.get(i3)*3;
            int m5=list.get(i5)*5;
            int min=Math.min(m2,Math.min(m3,m5));
            list.add(min);
            if(min==m2)i2++;
            if(min==m3)i3++;
            if(min==m5)i5++;
        }
        return list.get(list.size()-1);
    }
```

- 把数组排成值最小的数

这个题，代码里也记录过！排序！排序规则是关键！“3” 和 “32” 因为323 < 332 所以两者的顺序是：32 - 3！
我的代码片段如下：
```java
List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(numList, (e1, e2) -> {
            String s1 = e1 + "" + e2;
            String s2 = e2 + "" + e1;
            return s1.compareTo(s2);
        });
String sb = numList.stream().map(String::valueOf).collect(Collectors.joining());
```

- 100-1300整数中包含1的个数！（1-13中有1，10，11，12，13共5个）

判断每个整数权值点：1，10，100，1000.分出高位和低位。不太理解？
[https://www.nowcoder.com/questionTerminal/bd7f978302044eee894445e244c7eee6]

- 连续子数组和

代码之前记录过！我也被考过！MaxSubarray.java, 动态规划入门

- 最小的K个数

代码记录过类似的题目，KthInArray.java。
使用java中的priorityqueeu，维护一个大顶堆！当堆的大小为k时，判断要放的值和堆顶最大元素的大小。如果
堆顶元素大，就poll出来。这样会导致大元素流失！

其实使用冒泡排序也是可以的！

- 数组中出现次数超过一半的数字！

代码记录过！也记录了一些变形题目！MajorityElement*.java!!!

- 字符串全排列！

代码记录过！Permutation.java!!!递归！

- 和为S的连续整数序列！

等差数列求和问题，最牛逼的是双指针(滑动窗口)方案！一个plow=1，一个phigh=2。计算窗口内的值如果大plow移动，如果小，phigh移动。

还有一个基本思路：就是利用求和公式遍历。

- 递增序列和为S的两个数！并且乘积最小！

简单版的2sum啊！头尾指针！因为递增，乘积问题也解决了！

- 循环左移字符串！abcWER ->3 = WERabc

左移n位当做现在index-n，若为负的就加上length。

还有一种思路：把两个字符串拼接起来，然后substr即可！

第三个思路： 字符串翻转!

- 翻转句子！
按照空格split，翻转每个单词。

还有一种思路： 整体reverse，然后每个单词reverse。

- 56 张牌，2个大王，2个小王。可以看成任意值。抽出5张牌,是否是顺子？！(可以抽象为判断连续数字)

抽到的这五个数，max - min < 5, 并且除了0没有重复值。

- 圆圈中最后剩下的数（约瑟夫环问题）

java的话，考虑节点不停的删除，使用linkedlist。
```java
int bt = 0;
    while(list.size() > 1) {
        bt = (bt + m -1) % list.size();
        list.remove(bt);
    }
    return list.size()==1 ? list.get(0):-1;
```

另外一个思路：就是利用递归思想，m-1出去会后，剩下n-1人中从m%n开始数0.1.2.3、、、如果是编号为x的人出去，可以反推：上一个走的人的编号为(x + m%n)%n
f(n) =( f(n-1) +m ) %n;

- 1+2+3+....+n，不能使用循环和条件语句

```java
int Sum_Solution(int n) {
        int ans = n;
        ans && (ans += Sum_Solution(n - 1));
        return ans;
    }
```
```java
public static int plus(int sum, int n) {
    boolean flag = (n > 0) 
                   && (sum = plus(sum + n, n - 1)) > 0;
        return sum;
}
```

- 不使用加减乘除做加法！

我感觉就像使用scheme一样！其实不是！

考点是位运算！step1:按位与是查看两个数哪些二进制位都为1，这些都是进位位，结果需左移一位，表示进位后的结果

step2:异或是查看两个数哪些二进制位只有一个为1，这些是非进位位，可以直接加、减，结果表示非进位位进行加操作后的结果

step3:n1&n2是查看有没有进位位了，如果有，需要重复step1、step2；如果没有，保留n1、n2上二进制为1的部分，用或将之合为一个数，即为最后结果

- 把字符串转换为整数，实现Integer.valueOf(string),非法就返回0.

ascii：(a[i] >= 48 && a[i] <= 57), 判断符号，非法字符，等

- 数组中重复的数字，0~n-1

使用一个同样长度的boolean数组记录每个数字是否出现过，发现为true的直接返回。

还有一个不需要任何辅助数组和hash的方案：因为是严格在0~n-1的。访问元素的时候给对应值得index上加上length，再发先的时候大于n直接返回！

- 根据一个数组A构建另一个数组B，保证 B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]

dp思路： 结果矩阵：计算上下三角矩阵！画个图就出来了。

暴力思路：规律就是B{i}中就是不乘A[i]。所以计算的时候令A[i] = 1,即可。

- 正则表达式匹配

分类讨论，第一个字符不匹配。要看模式串下一个是*吗，

Pattern先结束匹配失败，都结束成功，str先结束有可能成功。

- 一个字符串是否表示整数小数。
 各种规则。
  
- 含有环的链表，找出入口节点。

大众思路，先判断是否有环，一个走一步指针p1，一个走两步指针p2，如果p1=p2,说明有环！

[https://uploadfiles.nowcoder.net/images/20170422/943729_1492841744777_3BB680C9CBA20442ED66C5066E1F7175] 
根据图进行推算：当fast与slow相遇时，fast走过的距离为a + b + c + b，而slow走过的距离为a + b，因为fast是slow速度的两倍，则有a+b+c+b = 2*(a+b)，登出a=c;

此时第三个指针p从x处，以和slow指针相同的速度前进，当它两相遇时，即为环的起点Y处！

- 删除排序链表中重复的节点

常规题目，pass，注意细节即可！

- 二叉树中序遍历的后继节点！

上面有一个类似的是，二叉搜索树变成双向链表，可以使用中序遍历的非递归实现！这个题：其实是有规则的！

1.二叉树为空，则返回空；

2.如果有右子树，则找右子树的最左节点

3.没右子树，则找**第一个** 是**父节点左孩子**的节点


- 判断一个二叉树是否是对称的！
    * 首先根节点以及其左右子树，左子树的左子树和右子树的右子树相同
    * 左子树的右子树和右子树的左子树相同即可，采用递归
    * 非递归也可，采用栈或队列存取各级子树根节点
    
- 之字形打印二叉树！

代码好像记录过，SpiralTraverse.java。

- 序列化和反序列化二叉树

存储前序遍历，按照某种规则！

- 二叉搜索树的第K小的节点

中序遍历记录第K次即可！

- 读取数据流中的中位数

一个大顶堆，一个小顶堆。偶数的话就是maxHeap.peek() 和 minHeap.peek() 平均值，如果是奇数，就是大顶堆的peek。
(count & 1) == 0 判断偶数

- 滑动窗口内的最大值！给定滑动窗口大小和数组，计算窗口内最大值！


- 矩阵中的路径

- 









