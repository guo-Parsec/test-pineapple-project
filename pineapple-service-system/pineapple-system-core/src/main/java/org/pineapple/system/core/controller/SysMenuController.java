package org.pineapple.system.core.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.pineapple.common.CommonWebApiDefineConstant;
import org.pineapple.common.annotations.RestParam;
import org.pineapple.system.api.SystemWebApiDefineConstant;
import org.pineapple.system.api.vo.SysMenuVo;
import org.pineapple.system.core.pojo.dto.SysMenuDto;
import org.pineapple.system.core.pojo.query.SysMenuPageQuery;
import org.pineapple.system.core.service.SysMenuService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public Set<String> findMenuCodeByRoleCode(@RequestParam("roleCodeSet") Set<String> roleCodeSet) {
        return service.findMenuCodeByRoleCode(roleCodeSet);
    }

    @ApiOperation(value = "新增系统菜单")
    @PostMapping(CommonWebApiDefineConstant.COMMON_CREATE_ACTION_API)
    public void createSysMenu(@Validated @RequestBody SysMenuDto dto) {
        service.createSysMenu(dto);
    }

    @ApiOperation(value = "修改系统菜单")
    @PutMapping(CommonWebApiDefineConstant.COMMON_EDIT_ACTION_API)
    public void updateSysMenu(@Validated @RequestBody SysMenuDto dto) {
        service.updateSysMenu(dto);
    }

    @ApiOperation(value = "删除系统菜单")
    @DeleteMapping(CommonWebApiDefineConstant.COMMON_SOFT_REMOVE_ACTION_API)
    public void deleteSysMenu(@RequestBody Set<Long> idSet) {
        service.deleteSysMenu(idSet);
    }

    @ApiOperation(value = "分页查询系统菜单")
    @PostMapping(CommonWebApiDefineConstant.COMMON_PAGE_ACTION_API)
    public IPage<SysMenuVo> pageQuerySysMenu(@Validated @RestParam SysMenuPageQuery pageDto) {
        return service.pageQuerySysMenu(pageDto);
    }

    @ApiOperation(value = "根据菜单编码列表获取菜单信息")
    @GetMapping("find-sys-menu/by/menu-codes")
    public Set<SysMenuVo> findSysMenuByMenuCodes(@RequestParam("menuCodeSet") Set<String> menuCodeSet) {
        return service.findSysMenuByMenuCodes(menuCodeSet);
    }

    @ApiOperation(value = "获取根据权限码值获取系统菜单树状结构")
    @GetMapping("find-sys-menu/by/permissions")
    public List<SysMenuVo> findSysMenuByPermissions(@RestParam Set<String> permissions) {
        return service.findSysMenuByPermissions(permissions);
    }
}
