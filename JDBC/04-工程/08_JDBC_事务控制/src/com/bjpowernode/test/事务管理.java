package com.bjpowernode.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 需求：
 *      删除部门30及其部门下所有的职员信息
 *
 * SQL:
 *       delete from dept where deptno=30  #dept.bak
 *       delete from emp  where deptno=30  #emp.bak
 *
 * 规则：
 *      在一个需求中，只要有任意一个SQL命令无法执行的。
 *      此时应该将需求中所有SQL命令都判定为执行时效
 */
public class 事务管理 {
    public static void main(String[] args)throws Exception {
        String sql_1="delete from emp where deptno=20";
        String sql_2="delete from dept where deptno=20";

        //1.注册Driver
        Class.forName("com.mysql.jdbc.Driver");
        //2.建立通道
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode", "root", "123");
        //3.通过【连接通道】向MySql服务器发送命令 “start transaction”
        con.setAutoCommit(false);

        //4.建立交通工具
        PreparedStatement ps = con.prepareStatement("");

        //5.推送SQL命令
        try{
            ps.executeUpdate(sql_1);
            ps.executeUpdate(sql_2);
            //如果能走到第39行，说明推送的两条sql命令都能正常执行，此时通知mysql服务器将本次操作中表文件备份进行删除
            con.commit();// 向mysql服务器推送  commit;
        }catch(SQLException ex){
            //由connection通知mysql服务器将本次操作中所有表文件备份覆盖表文件，取消本次操作
            con.rollback(); //向mysql服务器推送  rollback;
        }finally{
            //6、资源销毁
            if(ps!=null){
                ps.close();
            }
            if(con!=null){
                con.close();
            }
        }
    }
}
