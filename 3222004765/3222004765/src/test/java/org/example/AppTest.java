package org.example;

import org.example.Utils.TxtException;
import org.example.Utils.SimilarityHash;
import org.example.Utils.IOtxt;
import org.example.Utils.HamMingUtils;
import org.junit.Test;


public class AppTest {

    String path1="D:\\rgcs\\orig.txt";//原文
    String path2="D:\\rgcs\\orig_0.8_add.txt";
    String path3="D:\\rgcs\\orig_0.8_del.txt";
    String path4="D:\\rgcs\\orig_0.8_dis_1.txt";
    String path5="D:\\rgcs\\orig_0.8_dis_10.txt";
    String path6="D:\\rgcs\\orig_0.8_dis_15.txt";

@Test// 把原文和其他文章对比
public void Test1(){
    try {
        String[] str = new String[6];
        str[0] = IOtxt.readTxt(path1);
        str[1] = IOtxt.readTxt(path2);
        str[2] = IOtxt.readTxt(path3);
        str[3] = IOtxt.readTxt(path4);
        str[4] = IOtxt.readTxt(path5);
        str[5] = IOtxt.readTxt(path6);
        String ansFileName = "D:\\rgcs\\output\\ans1.txt";//输出路径
        for(int i = 0; i <= 5; i++){
            double ans= HamMingUtils.getSimilarity(SimilarityHash.getSimHash(str[0]), SimilarityHash.getSimHash(str[i]));
            String result="查重率："+ans;
            IOtxt.writeTxt(result, ansFileName);
        }
    }catch (Exception err){
        System.out.println(err);
    }
}

    @Test     //原文与原文对比,查重率百分之百
    public void Test2(){
     try {
         String str0 = IOtxt.readTxt(path1);
         String str1 = IOtxt.readTxt(path1);
         String ansFileName = "D:\\rgcs\\output\\ans2.txt";
         double ans = HamMingUtils.getSimilarity(SimilarityHash.getSimHash(str0), SimilarityHash.getSimHash(str1));
         String result="查重率："+ans;
         IOtxt.writeTxt(result, ansFileName);
     }catch (Exception err){
         System.out.println(err);
     }
    }

    @Test     //正常读写(文件内容差距大)
    public void Test3(){
        try {
            String str0 = IOtxt.readTxt(path1);
            String str1 = IOtxt.readTxt(path5);
            String ansFileName = "D:\\rgcs\\output\\ans3.txt";
            double ans = HamMingUtils.getSimilarity(SimilarityHash.getSimHash(str0), SimilarityHash.getSimHash(str1));
            String result="查重率："+ans;
            IOtxt.writeTxt(result, ansFileName);
        }catch (Exception err){
            err.printStackTrace();
            System.out.println("写入路径错误！");
        }
    }

    @Test     //正常读写(文件内容差距小)
    public void Test4(){
        try {
            String str0 = IOtxt.readTxt(path3);
            String str1 = IOtxt.readTxt(path4);
            String ansFileName = "D:\\rgcs\\output\\ans4.txt";
            double ans = HamMingUtils.getSimilarity(SimilarityHash.getSimHash(str0), SimilarityHash.getSimHash(str1));
            String result="查重率："+ans;
            IOtxt.writeTxt(result, ansFileName);
        }catch (Exception err){
            err.printStackTrace();
            System.out.println("写入路径错误！");
        }
    }

}