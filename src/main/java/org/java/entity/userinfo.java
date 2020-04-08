package org.java.entity;

import lombok.Data;

@Data
public class userinfo {
    //用户id
   private String userId;
    //用户姓名
    private String  userName;
    //用户密码
    private String userPwd;
    //用户所造部门
      private int userDepartId;
    //用户性别
      private char userSex;
    //用户角色
    private int userRoleId;
    //用户状态
    private int userState;
}
