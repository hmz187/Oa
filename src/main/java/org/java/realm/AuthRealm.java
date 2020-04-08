package org.java.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private org.java.service.loginservice loginservice;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Map map = (Map) principals.getPrimaryPrincipal();
        String userid = (String) map.get("userId");
        List<String> list = loginservice.loadPermission(userid);
        SimpleAuthorizationInfo info=new  SimpleAuthorizationInfo();
        info.addStringPermissions(list);
        return info;
    }

    //认证方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取数据
        String principal = (String) token.getPrincipal();
        Map map = loginservice.CheckUser(principal);
        if (map.isEmpty()){
            return null;
        }
        String userid = (String) map.get("userId");
        List<Map> maps = loginservice.loadMenu(userid);
        //添加父菜单
        map.put("menus",maps);
        String pwd= (String) map.get("userPwd");
        String salt="accp";
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(map,pwd, ByteSource.Util.bytes(salt),"myRealm");
        return info;
    }
}
