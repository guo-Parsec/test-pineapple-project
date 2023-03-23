package org.pineapple.auth.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.pineapple.auth.api.AuthWebApiDefineConstant;
import org.pineapple.auth.core.service.LoginService;
import org.pineapple.common.uniforms.UniformResultDefinition;
import org.pineapple.common.uniforms.UniformResultTool;
import org.pineapple.engine.security.entity.SecuritySignature;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>登录管理</p>
 *
 * @author guocq
 * @since 2023/3/15
 */
@Api(tags = "登录管理")
@RestController
public class LoginController {
    private final LoginService service;

    public LoginController(LoginService service) {
        this.service = service;
    }

    @ApiOperation(value = "登录操作")
    @PostMapping(value = AuthWebApiDefineConstant.WEB_API_LOGIN + ".do")
    public UniformResultDefinition<SecuritySignature> doLogin(@RequestBody String loginId,
                                                              @RequestBody String password,
                                                              @RequestBody String verifyCode) {
        return UniformResultTool.success(service.login(loginId, password, verifyCode));
    }
}
