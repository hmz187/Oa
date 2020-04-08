package org.java.service.impl;

import org.java.dao.loginMapper;
import org.java.service.loginservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class loginserviceimpl implements loginservice {

    @Autowired
    private org.java.dao.loginMapper loginMapper;
    @Override
    public Map CheckUser(String username) {
        List<Map> map = loginMapper.CheckUser(username);
        if (map.isEmpty()){
            return null;
        }else {
            return map.get(0);
        }
    }

    @Override
    public List<Map> loadMenu(String userid) {
        return loginMapper.loadMenu(userid);
    }

    @Override
    public List<String> loadPermission(String userid) {

        return loginMapper.loadPermission(userid);
    }
}
