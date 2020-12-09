package com.bjpowernode.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * 2020/4/23
 */
public class 预编译实现批处理 {

    public static void main(String[] args)throws Exception {

        //预编译形式SQL命令
        //"？"是占位符，一个问号代替一个值
        //预编译SQL相当一个模具，在后续开发时，只需要将数据填充到占位符，就可以得到一个全新SQL
        String sql ="insert into dept(deptno,dname,loc) values(?,?,?)";

        //1.注册Driver
        Class.forName("com.mysql.jdbc.Driver");
        //2.建立通道
       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode", "root", "123");
        //3.【建立交通工具时，需要将预编译SQL命令注册到PreparedStatement】
        PreparedStatement ps =  con.prepareStatement(sql);

        //4.向MySql服务器推送100条数据
        for(int i=1;i<=100;i++){
            //通过向预编译SQL命令填充数据生成全新的SQL命令
            ps.setInt(1, i); //inser into dept (deptno,dname,loc) values(1,?,?)
            ps.setString(2, "dept_"+i); //inser into dept (deptno,dname,loc) values(1,'dept_1',?)
            ps.setString(3, "北京");//inser into dept (deptno,dname,loc) values(1,'dept_1','北京')
            //在新的SQL语句生成之后，将SQL语句作为子弹添加到PS的弹夹
            ps.addBatch(); //[sql1,sql2,...]
        }

        //5.【一次性】通过ps将100条sql语句推送到mysql服务器执行
          ps.executeBatch(); // 推送100条SQL命令只需要往返一次

        //6.销毁资源
        if(ps!=null){
            ps.close();
        }
        if(con!=null){
            con.close();
        }
    }
}
