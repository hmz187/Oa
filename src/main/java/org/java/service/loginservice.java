package org.java.service;

import java.util.List;
import java.util.Map;

public interface loginservice {
    //    <!--用户名密码登陆验证-->
    public Map CheckUser(String username);
//    查询父菜单
    public List<Map> loadMenu(String userid);
    //权限查询
    public List<String> loadPermission(String userid);
}
