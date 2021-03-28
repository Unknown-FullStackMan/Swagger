package com.simple.swaggerlearn.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Simple
 * @data 2021/3/28 12:10
 */

@ApiModel("用户实体类")
@Data
public class User {
    @ApiModelProperty(value = "用户名")
    private String password;
    @ApiModelProperty(value = "密码")
    private String username;


}
