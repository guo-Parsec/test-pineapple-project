package org.pineapple.core.facade;

import org.pineapple.common.entity.SystemDictEntity;

/**
 * <p>数据字典Facade</p>
 *
 * @author guocq
 * @since 2023/2/8
 */
public interface DictionaryFacade {
    /**
     * <p>根据{@code typeCode}和{@code dictVal}查询单条数据字典数据</p>
     *
     * @param typeCode 数据字典类型码
     * @param dictCode 数据字典值
     * @return {@link SystemDictEntity }
     * @author guocq
     * @date 2023/2/8 14:30
     */
    SystemDictEntity findSingleDictionary(String typeCode, String dictCode);
}
