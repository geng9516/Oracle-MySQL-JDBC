package com.bjpowernode.test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * 2020/4/23
 */
public class 推送插入命令 {

    public static void main(String[] args) throws Exception{
         // "jdbc:mysql://服务器所在计算机IP地址:服务器端口号/数据库"
        String url = "jdbc:mysql://localhost:3306/bjpowernode";
        //sql命令
        String sql="insert into dept(deptno,dname,loc) values(100,'大额贷款部门','上海'),(101,'银行融合部','北京')";


        //1.将MySql服务器提供的jar包中Driver接口实现类，注册到JVM
        Driver driver = new com.mysql.jdbc.Driver();
        DriverManager.registerDriver(driver);

        //2.通过DriverManager在Java工程与MySql服务器之间建立一个连接通道
        Connection con= DriverManager.getConnection(url, "root", "123");

        //3.在通道上创建一个交通工具
        PreparedStatement ps = con.prepareStatement("");

        //4.通过交通工具将SQL命令推送到MySql服务器上来执行并带回处理结果
        int result =  ps.executeUpdate(sql);

        //5.销毁相关资源
        if(ps!=null){
            ps.close();
        }
        if(con!=null){
            con.close();
        }
        System.out.println("本次交易中，在Dept表文件添加 "+result+"行数据");

    }
}
