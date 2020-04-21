package com.khunboo.modules.controller.shopmanage;

import com.khunboo.Base.BaseController;
import com.khunboo.dto.ProductDetailDto;
import com.khunboo.utils.Result;
import com.khunboo.utils.ValidatorUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/shopmanage")
public class ShopManageController extends BaseController {


    @PostMapping(value = "/add")
    public Result save(@RequestBody ProductDetailDto detailDto){

        ValidatorUtils.validateEntity(detailDto);

        return new Result().success();
    }
}
