package com.khunboo.modules.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.khunboo.dto.WorkHoursDto;
import com.khunboo.modules.entity.WorkHoursEntity;
import com.khunboo.page.PageData;
import com.khunboo.service.BaseService;

import java.util.Map;

public interface WorkHoursService extends BaseService<WorkHoursEntity> {

    void save(WorkHoursDto workHoursDto);

    PageData<WorkHoursDto> page(Map<String, Object> param);

    void delName(Integer id);
}
