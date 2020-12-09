package com.bjpowernode.test;

import com.bjpowernode.dao.DeptDao;
import com.bjpowernode.entity.Dept;

import java.util.List;
import java.util.Scanner;

/**
 * 2020/4/24
 */
public class TestMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int flag =0;
        String deptNo,dname,loc;
        DeptDao dao = new DeptDao();
        System.out.println("*****欢迎使用某某公司部门管理系统*****");
        System.out.println("*****1.添加部门*****");
        System.out.println("*****2.删除部门*****");
        System.out.println("*****3.更新部门*****");
        System.out.println("*****4.查询部门*****");
        System.out.println("请选择功能");
        flag = sc.nextInt();

        if(flag ==1){
            System.out.println("输入新部门编号");
            deptNo = sc.next();
            System.out.println("输入新部门名称");
            dname = sc.next();
            System.out.println("输入新部门地址");
            loc =sc.next();
            flag = dao.add(deptNo, dname, loc);
            if(flag ==1){
                System.out.println("部门添加成功");
            }else{
                System.out.println("部门添加失败");
            }
        }else if(flag ==2){
            System.out.println("输入需要删除部门编号");
            deptNo = sc.next();
            flag = dao.delete(deptNo);
            if(flag ==1){
                System.out.println("部门删除成功");
            }else{
                System.out.println("部门删除失败");
            }

        }else if(flag ==3){
            System.out.println("输入原始部门编号");
            deptNo = sc.next();
            System.out.println("输入新部门名称");
            dname = sc.next();
            System.out.println("输入新部门地址");
            loc =sc.next();
            flag = dao.update(deptNo, dname, loc);
            if(flag ==1){
                System.out.println("部门更新成功");
            }else{
                System.out.println("部门更新失败");
            }
        }else {
           List<Dept> deptList = dao.findAll();
           for(Dept dept:deptList){
               System.out.println("部门编号 "+dept.getDeptNo()+" 部门名称 "+dept.getDname()+" 部门位置 "+dept.getLoc());
           }
        }
    }
}
