package com.khunboo.modules.dao.login;

import com.khunboo.dao.BaseDao;
import com.khunboo.dto.WorkHoursDto;
import com.khunboo.modules.entity.WorkHoursEntity;

public interface WorkHoursDao extends BaseDao<WorkHoursEntity> {

    void save(WorkHoursDto dto);
}
