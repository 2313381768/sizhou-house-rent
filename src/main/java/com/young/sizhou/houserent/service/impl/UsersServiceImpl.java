package com.young.sizhou.houserent.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.young.sizhou.houserent.dao.UsersDao;
import com.young.sizhou.houserent.entity.UsersEntity;
import com.young.sizhou.houserent.service.UsersService;
import com.young.sizhou.houserent.utils.PageUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("usersService")
public class UsersServiceImpl extends ServiceImpl<UsersDao, UsersEntity> implements UsersService {

}