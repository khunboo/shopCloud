package com.khunboo.modules.service.impl;

import com.khunboo.dto.WorkHoursDto;
import com.khunboo.modules.dao.login.WorkHoursDao;
import com.khunboo.modules.entity.WorkHoursEntity;
import com.khunboo.modules.service.WorkHoursService;
import com.khunboo.service.impl.BaseServiceImpl;
import com.khunboo.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkHoursImpl extends BaseServiceImpl<WorkHoursDao, WorkHoursEntity> implements WorkHoursService {


    @Autowired
    private WorkHoursDao workHoursDao;

    @Override
    public void save(WorkHoursDto dto){

        String allTime = DateUtils.getAllTime();

        dto.setCreateTime(allTime);
        dto.setCreateUser("duanmu");
        workHoursDao.save(dto);
    }
}
