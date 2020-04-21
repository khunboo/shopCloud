package com.khunboo.modules.service;

import com.khunboo.dto.WorkHoursDto;
import com.khunboo.modules.entity.WorkHoursEntity;
import com.khunboo.service.BaseService;

public interface WorkHoursService extends BaseService<WorkHoursEntity> {

    void save(WorkHoursDto workHoursDto);
}
