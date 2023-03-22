package org.pineapple.system.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.pineapple.common.CommonWebApiDefineConstant;
import org.pineapple.common.uniforms.UniformResultDefinition;
import org.pineapple.common.uniforms.UniformResultTool;
import org.pineapple.system.api.SystemWebApiDefineConstant;
import org.pineapple.system.core.pojo.dto.SysMenuDto;
import org.pineapple.system.core.service.SysMenuService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * <p>系统菜单管理</p>
 *
 * @author guocq
 * @since 2023/3/14
 */
@Api(tags = "系统菜单管理")
@RestController
@RequestMapping(SystemWebApiDefineConstant.WEB_API_MENU_PREFIX)
public class SysMenuController {
    private final SysMenuService service;

    public SysMenuController(SysMenuService service) {
        this.service = service;
    }

    @ApiOperation(value = "根据角色码列表获取菜单码")
    @GetMapping("/find-menu-code/by/role-code")
    public UniformResultDefinition<Set<String>> findMenuCodeByRoleCode(@RequestParam("roleCodeSet") Set<String> roleCodeSet) {
        return UniformResultTool.success(service.findMenuCodeByRoleCode(roleCodeSet));
    }

    @ApiOperation(value = "新增系统菜单")
    @PostMapping(CommonWebApiDefineConstant.COMMON_CREATE_ACTION_API)
    public UniformResultDefinition<Void> createSysMenu(@Validated @RequestBody SysMenuDto dto) {
        service.createSysMenu(dto);
        return UniformResultTool.success();
    }

    @ApiOperation(value = "修改系统菜单")
    @PutMapping(CommonWebApiDefineConstant.COMMON_EDIT_ACTION_API)
    public UniformResultDefinition<Void> updateSysMenu(@Validated @RequestBody SysMenuDto dto) {
        service.updateSysMenu(dto);
        return UniformResultTool.success();
    }

    @ApiOperation(value = "删除系统菜单")
    @DeleteMapping(CommonWebApiDefineConstant.COMMON_SOFT_REMOVE_ACTION_API)
    public UniformResultDefinition<Void> deleteSysMenu(@RequestBody Set<Long> idSet) {
        service.deleteSysMenu(idSet);
        return UniformResultTool.success();
    }
}