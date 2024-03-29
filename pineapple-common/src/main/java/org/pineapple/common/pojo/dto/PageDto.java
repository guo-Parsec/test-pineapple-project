package org.pineapple.common.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.StringJoiner;

/**
 * <p>分页参数</p>
 *
 * @author guocq
 * @since 2023/3/22
 */
@Setter
@Getter
public class PageDto {
    /**
     * 当前页
     */
    @NotNull(message = "当前页不能为空")
    @Min(value = 1, message = "当前页不能小于1")
    @ApiModelProperty(value = "当前页")
    protected Integer pageIndex;

    /**
     * 页大小
     */
    @NotNull(message = "页大小不能为空")
    @Min(value = 1, message = "页大小不能小于1")
    @ApiModelProperty(value = "页大小")
    protected Integer pageSize;

    @Override
    public String toString() {
        return new StringJoiner(", ", PageDto.class.getSimpleName() + "[", "]")
                .add("pageIndex=" + pageIndex)
                .add("pageSize=" + pageSize)
                .toString();
    }
}
