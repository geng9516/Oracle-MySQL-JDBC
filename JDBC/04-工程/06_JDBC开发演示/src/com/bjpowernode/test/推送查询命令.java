package com.bjpowernode.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 2020/4/23
 */
public class 推送查询命令 {

    public static void main(String[] args)throws Exception {
        String sql ="select * from dept";

        //1.Driver注册
        Class.forName("com.mysql.jdbc.Driver");
        //2.建立通道
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode", "root", "123");
        //3.建立交通工具
        PreparedStatement ps = con.prepareStatement("");
        //4.推送命令得到处理结果[临时表]
        ResultSet rs = ps.executeQuery(sql);

        //5.通过ResulSet对象将临时表所有数据行信息读取出来
        while(rs.next()){
            int deptNo =  rs.getInt("deptNo");
            String dname =rs.getString("dname");
            String loc = rs.getString("loc");
            System.out.println("部门编号 "+deptNo+" 部门名称 "+dname+" 部门位置 "+loc);
        }

        //6.销毁资源[1.rs   2.ps   3.con ]
        if(rs!=null){
            rs.close();
        }
        if(ps!=null){
            ps.close();
        }
        if(con!=null){
            con.close();
        }

    }
}
