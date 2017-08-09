package com.bizi.backend.framework;

import com.bizi.backend.permit.dao.SysUserDao;
import com.bizi.backend.permit.pojo.SysUser;
import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class EventBusListener {

    @Autowired
    private SysUserDao sysUserDao;
    @Subscribe
    public void saveLoginInfo(SysUser sysUser){
        sysUserDao.updateLoginInfo(sysUser);
    }
}
