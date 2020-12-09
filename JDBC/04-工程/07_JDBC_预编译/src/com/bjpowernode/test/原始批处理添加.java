package com.bjpowernode.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * 问题：
 *   1.SQL命令书写麻烦：
 *       为了确保每条SQL语句携带不同数据，采用字符串拼接方式
 *       "insert into dept(deptno,dname,loc) values("+i+",'dept_"+i+"','北京')";
 *
 *   2.浪费时间：
 *      PreparedStatement对象每次只能推送一条SQL命令。
 *      为了推送100条Sql命令，需要往返100次，浪费了大量时间
 *
 *
 *      超级烂的一段程序【烂车】
 */
public class 原始批处理添加 {
    //throw 与 throws区别 【面试】
    public static void main(String[] args)throws Exception {

        //1.注册
        Class.forName("com.mysql.jdbc.Driver");
        //2.建立通道
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode", "root", "123");
        //3.建立交通工具
        PreparedStatement ps = con.prepareStatement("");
        //4.向mysql服务器推送100条数据进行插入
        for(int i=1;i<=100;i++){
            String sql="insert into dept(deptno,dname,loc) values("+i+",'dept_"+i+"','北京')";//麻烦
            ps.executeUpdate(sql);
        }
        //5.销毁资源
        if(ps!=null){
            ps.close();
        }
        if(con!=null){
            con.close();
        }
    }
}
