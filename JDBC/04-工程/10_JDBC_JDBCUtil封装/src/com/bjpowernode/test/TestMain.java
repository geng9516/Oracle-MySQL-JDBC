package com.bjpowernode.test;

import com.bjpowernode.util.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * 2020/4/24
 */
public class TestMain {

    public static void main(String[] args)throws Exception {
         JdbcUtil util = new JdbcUtil();
         PreparedStatement ps=null;
         ResultSet rs = null;
         Scanner request = new Scanner(System.in);
         String  userName,password,deptNo,dname,loc;
         String  sql_1="select count(*) from emp where ename=? and empno=?";
         String  sql_2="insert into dept (deptNo,dname,loc) values(?,?,?)";
         int flag = 0;
         //-----登录验证-----start
        System.out.println("请输入用户名");
        userName = request.next();
        System.out.println("请输入密码");
        password = request.next();
        ps = util.createStatement(sql_1);
        ps.setString(1, userName);
        ps.setString(2, password);
        rs = ps.executeQuery();
        while(rs.next()){
            flag = rs.getInt("count(*)");
        }
        util.close(rs);
        if(flag!=1){
            System.out.println("输入信息不存在，请重新登录。。。。");
            return;
        }
        //-----登录验证-----end

        //-----具体功能页面---start
        System.out.println("******欢迎使用某某公司部门管理系统******");
        System.out.println("******1.添加部门******");
        System.out.println("******2.查询部门******");
        System.out.println("******3.删除部门******");
        System.out.println("******4.更新部门******");
        System.out.println("******请输入操作******");
        flag = request.nextInt();

        if(flag ==1){
            System.out.println("******请输入部门编号******");
            deptNo =request.next();
            System.out.println("******请输入部门名称******");
            dname =request.next();
            System.out.println("******请输入部门位置******");
            loc = request.next();

            ps = util.createStatement(sql_2);
            ps.setInt(1, Integer.valueOf(deptNo));
            ps.setString(2, dname);
            ps.setString(3, loc);
            flag = ps.executeUpdate();
            util.close();

        }else if(flag ==2){

        }else if(flag ==3){

        }else{

        }
        //-----具体功能页面---end
    }
}
