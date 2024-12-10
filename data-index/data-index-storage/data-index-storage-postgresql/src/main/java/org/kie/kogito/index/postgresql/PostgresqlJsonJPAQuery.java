/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.kie.kogito.index.postgresql;

import java.util.function.Function;

import org.kie.kogito.index.jpa.model.AbstractEntity;
import org.kie.kogito.index.jpa.storage.JPAQuery;
import org.kie.kogito.persistence.api.query.AttributeFilter;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class PostgresqlJsonJPAQuery<K, E extends AbstractEntity, T> extends JPAQuery<K, E, T> {

    public PostgresqlJsonJPAQuery(PanacheRepositoryBase<E, K> repository, Function<E, T> mapper, Class<E> entityClass) {
        super(repository, mapper, entityClass);
    }

    protected Function<AttributeFilter<?>, Predicate> filterPredicateFunction(Root<E> root, CriteriaBuilder builder) {
        return filter -> filter.isJson() ? PostgresqlJsonNavigator.buildPredicate(filter, root, builder) : buildPredicateFunction(filter, root, builder);
    }
}
