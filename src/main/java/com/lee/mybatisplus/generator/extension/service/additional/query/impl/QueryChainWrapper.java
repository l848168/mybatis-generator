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
package com.lee.mybatisplus.generator.extension.service.additional.query.impl;

import com.lee.mybatisplus.generator.core.conditions.query.Query;
import com.lee.mybatisplus.generator.core.conditions.query.QueryWrapper;
import com.lee.mybatisplus.generator.core.mapper.BaseMapper;
import com.lee.mybatisplus.generator.core.metadata.TableFieldInfo;
import com.lee.mybatisplus.generator.core.toolkit.ExceptionUtils;
import com.lee.mybatisplus.generator.extension.service.additional.AbstractChainWrapper;
import com.lee.mybatisplus.generator.extension.service.additional.query.ChainQuery;

import java.util.function.Predicate;

/**
 * Query Chain Wrapper
 *
 * @author miemie
 * @since 2018-12-19
 */
@SuppressWarnings({"serial"})
public class QueryChainWrapper<T> extends AbstractChainWrapper<T, String, QueryChainWrapper<T>, QueryWrapper<T>>
    implements ChainQuery<T>, Query<QueryChainWrapper<T>, T, String> {

    private BaseMapper<T> baseMapper;

    public QueryChainWrapper(BaseMapper<T> baseMapper) {
        super();
        this.baseMapper = baseMapper;
        super.wrapperChildren = new QueryWrapper<>();
    }

    @Override
    public QueryChainWrapper<T> select(String... columns) {
        wrapperChildren.select(columns);
        return typedThis;
    }

    @Override
    public QueryChainWrapper<T> select(Predicate<TableFieldInfo> predicate) {
        wrapperChildren.select(predicate);
        return typedThis;
    }

    @Override
    public QueryChainWrapper<T> select(Class<T> entityClass, Predicate<TableFieldInfo> predicate) {
        wrapperChildren.select(entityClass, predicate);
        return typedThis;
    }

    @Override
    public String getSqlSelect() {
        throw ExceptionUtils.mpe("can not use this method for \"%s\"", "getSqlSelect");
    }

    @Override
    public BaseMapper<T> getBaseMapper() {
        return baseMapper;
    }
}
