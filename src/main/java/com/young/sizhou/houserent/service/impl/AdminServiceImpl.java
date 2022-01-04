package com.young.sizhou.houserent.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.young.sizhou.houserent.dao.AdminDao;
import com.young.sizhou.houserent.entity.AdminEntity;
import com.young.sizhou.houserent.service.AdminService;
import com.young.sizhou.houserent.utils.PageUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("adminService")
public class AdminServiceImpl extends ServiceImpl<AdminDao, AdminEntity> implements AdminService {


}