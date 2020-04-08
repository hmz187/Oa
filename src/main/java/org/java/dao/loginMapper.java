package org.java.dao;

import java.util.List;
import java.util.Map;

public interface loginMapper {
//    <!--用户名密码登陆验证-->
    public List<Map> CheckUser(String username);
//    跟据用户id查询他有那些菜单
    public List<Map> loadMenu(String userid);
    public List<String> loadPermission(String userid);
}
