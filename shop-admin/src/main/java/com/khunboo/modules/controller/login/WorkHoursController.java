package com.khunboo.modules.controller.login;

import com.khunboo.Base.BaseController;
import com.khunboo.dto.WorkHoursDto;
import com.khunboo.modules.service.WorkHoursService;
import com.khunboo.utils.Result;
import com.khunboo.utils.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/workhours")
public class WorkHoursController extends BaseController {

    @Autowired
    private WorkHoursService workHoursService;

    @PostMapping("/save")
    public Result save(@RequestBody WorkHoursDto workHoursDto){
        /**
         * 数据检验
         */
        ValidatorUtils.validateEntity(workHoursDto);
        workHoursService.save(workHoursDto);

        return new Result().success(200, "保存成功");

    }

}
