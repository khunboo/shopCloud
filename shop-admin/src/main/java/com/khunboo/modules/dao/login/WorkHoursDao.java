package com.khunboo.modules.dao.login;

import com.khunboo.dao.BaseDao;
import com.khunboo.dto.WorkHoursDto;
import com.khunboo.modules.entity.WorkHoursEntity;

import java.util.List;
import java.util.Map;

public interface WorkHoursDao extends BaseDao<WorkHoursEntity> {

    void save(WorkHoursDto dto);

    List<WorkHoursEntity> getPageList(Map<String, Object> param);
}
