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
package com.lee.mybatisplus.generator.core.injector.methods;

import com.lee.mybatisplus.generator.core.enums.SqlMethod;
import com.lee.mybatisplus.generator.core.injector.AbstractMethod;
import com.lee.mybatisplus.generator.core.metadata.TableInfo;
import com.lee.mybatisplus.generator.core.toolkit.sql.SqlScriptUtils;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

/**
 * 根据ID集合，批量查询数据
 *
 * @author hubin
 * @since 2018-04-06
 */
public class SelectBatchByIds extends AbstractMethod {

    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        SqlMethod sqlMethod = SqlMethod.LOGIC_SELECT_BATCH_BY_IDS;
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, String.format(sqlMethod.getSql(),
            sqlSelectColumns(tableInfo, false), tableInfo.getTableName(), tableInfo.getKeyColumn(),
            SqlScriptUtils.convertForeach("#{item}", COLLECTION, null, "item", COMMA),
            tableInfo.getLogicDeleteSql(true, false)), Object.class);
        return addSelectMappedStatementForTable(mapperClass, sqlMethod.getMethod(), sqlSource, tableInfo);
    }
}
