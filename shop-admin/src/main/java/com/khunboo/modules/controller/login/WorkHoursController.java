package com.khunboo.modules.controller.login;

import com.khunboo.Base.BaseController;
import com.khunboo.dto.WorkHoursDto;
import com.khunboo.modules.service.WorkHoursService;
import com.khunboo.page.PageData;
import com.khunboo.utils.Result;
import com.khunboo.utils.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


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


    @GetMapping("/list")
    public Result<PageData<WorkHoursDto>> getList(@RequestParam Map<String, Object> params){

        PageData<WorkHoursDto> page = workHoursService.page(params);

        return new Result<PageData<WorkHoursDto>>().success(page);
    }

}
