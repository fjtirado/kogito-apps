/*
 * Copyright 2019 Red Hat, Inc. and/or its affiliates. 
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kie.kogito.persistence.api;

import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

import org.kie.kogito.persistence.api.query.Query;

public interface Storage<K, V> {

    void addObjectCreatedListener(Consumer<V> consumer);

    void addObjectUpdatedListener(Consumer<V> consumer);

    void addObjectRemovedListener(Consumer<K> consumer);

    Query<V> query();

    V get(K key);

    V put(K key, V value);

    V remove(K key);

    boolean containsKey(K key);

    Set<Map.Entry<K, V>> entrySet();

    void clear();

    String getRootType();
}