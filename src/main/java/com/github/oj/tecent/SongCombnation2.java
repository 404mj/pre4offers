package com.github.oj.tecent;

/**
 * Author: fengchen.zsx
 * date: 2018/8/31 21:11
 */
public class SongCombnation2 {

    //a：存放待操作的数据
//start:每个子问题从数组a的什么位置开始
//*path：临时数组 记录每一条走过的路径
//top: path的下标
//sum:最终结果 求一个数组里面所有和等于m的组合
//num:返回 总共得到的组合种类的数目
//v:返回满足和等于m的所有排列的组合 到二维数组 vector<vector<int>> v 中

    /*
    public void findpath(vector<int> a, int start, int *path, int top, int sum, int &num) {
        for (int i = start; i < a.size(); i++) {
            sum -= a[i];//想法是做减法
            path[top++] = i;//path记录每一条经过的路径
            if (sum == 0)
                num++;//得到的组合种类的数目 +1
            else if (sum > 0)
                findpath(a, i + 1, path, top, sum, num);//迭代
            sum += a[i];
            top--;
        }
    }

    int main() {
        vector<int> v;

        int a;
        int A, X, B, Y;
        cin >> a;
        cin >> A >> X >> B >> Y;

        for (int i = 0; i < X; ++i)
            v.push_back(A);
        for (int i = X; i < X + Y; ++i)
            v.push_back(B);

        int path[ 6] ={
            0
        } ;
        int No = 0;//总共得到的组合种类的数目

        findpath(v, 0, path, 0, a, No);
        cout << No << endl;

        return 0;
    }

*/
}
