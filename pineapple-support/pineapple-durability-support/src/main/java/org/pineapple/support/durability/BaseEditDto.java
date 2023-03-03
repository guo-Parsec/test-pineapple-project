package org.pineapple.support.durability;

import org.pineapple.common.AbstractDto;

import javax.validation.constraints.NotNull;

/**
 * <p>基础修改dto</p>
 *
 * @author guocq
 * @since 2023/2/9
 */
public class BaseEditDto extends AbstractDto {
    private static final long serialVersionUID = -4219928493280820344L;

    @NotNull(message = "id不能为空")
    protected Long id;
}
