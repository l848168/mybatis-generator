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
package com.lee.mybatisplus.generator.core;

import org.apache.ibatis.builder.annotation.MapperAnnotationBuilder;
import org.apache.ibatis.builder.annotation.MethodResolver;

import java.lang.reflect.Method;

/**
 * 继承 {@link MethodResolver}
 *
 * @author miemie
 * @since 2019-01-05
 */
public class MybatisMethodResolver extends MethodResolver {

    private final MybatisMapperAnnotationBuilder annotationBuilder;
    private final Method method;

    public MybatisMethodResolver(MapperAnnotationBuilder annotationBuilder, Method method) {
        super(annotationBuilder, method);
        this.annotationBuilder = (MybatisMapperAnnotationBuilder) annotationBuilder;
        this.method = method;
    }

    @Override
    public void resolve() {
        annotationBuilder.parseStatement(method);
    }
}
