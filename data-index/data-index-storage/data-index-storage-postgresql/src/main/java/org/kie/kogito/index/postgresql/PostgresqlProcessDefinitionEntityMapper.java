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

import java.util.Map;

import org.kie.kogito.index.jpa.mapper.AbstractProcessDefinitionEntityMapper;
import org.kie.kogito.index.model.ProcessDefinition;
import org.kie.kogito.jackson.utils.JsonObjectUtils;

import com.fasterxml.jackson.databind.node.ObjectNode;

public class PostgresqlProcessDefinitionEntityMapper extends AbstractProcessDefinitionEntityMapper<PostgresqlProcessDefinitionEntity> {

    @Override
    protected PostgresqlProcessDefinitionEntity create() {
        return new PostgresqlProcessDefinitionEntity();
    }

    @Override
    protected void fillModel(ProcessDefinition model, PostgresqlProcessDefinitionEntity entity) {
        if (entity.getMetadata() != null) {
            model.setMetadata((Map<String, Object>) JsonObjectUtils.toJavaValue(entity.getMetadata()));
        }

    }

    @Override
    protected void fillEntity(PostgresqlProcessDefinitionEntity entity, ProcessDefinition model) {
        if (model.getMetadata() != null) {
            entity.setMetadata((ObjectNode) JsonObjectUtils.fromValue(model.getMetadata()));
        }

    }

}
