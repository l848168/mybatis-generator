/*
 * Copyright (c) 2011-2020, baomidou (jobob@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * https://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.lee.mybatisplus.generator.extension.service.additional.update.impl;

import com.lee.mybatisplus.generator.core.conditions.update.Update;
import com.lee.mybatisplus.generator.core.conditions.update.UpdateWrapper;
import com.lee.mybatisplus.generator.core.mapper.BaseMapper;
import com.lee.mybatisplus.generator.core.toolkit.ExceptionUtils;
import com.lee.mybatisplus.generator.extension.service.additional.AbstractChainWrapper;
import com.lee.mybatisplus.generator.extension.service.additional.update.ChainUpdate;

/**
 * Update Chain Wrapper
 *
 * @author miemie
 * @since 2018-12-19
 */
@SuppressWarnings({"serial"})
public class UpdateChainWrapper<T> extends AbstractChainWrapper<T, String, UpdateChainWrapper<T>, UpdateWrapper<T>>
    implements ChainUpdate<T>, Update<UpdateChainWrapper<T>, String> {

    private BaseMapper<T> baseMapper;

    public UpdateChainWrapper(BaseMapper<T> baseMapper) {
        super();
        this.baseMapper = baseMapper;
        super.wrapperChildren = new UpdateWrapper<>();
    }

    @Override
    public UpdateChainWrapper<T> set(boolean condition, String column, Object val) {
        wrapperChildren.set(condition, column, val);
        return typedThis;
    }

    @Override
    public UpdateChainWrapper<T> setSql(boolean condition, String sql) {
        wrapperChildren.setSql(condition, sql);
        return typedThis;
    }

    @Override
    public String getSqlSet() {
        throw ExceptionUtils.mpe("can not use this method for \"%s\"", "getSqlSet");
    }

    @Override
    public BaseMapper<T> getBaseMapper() {
        return baseMapper;
    }
}
