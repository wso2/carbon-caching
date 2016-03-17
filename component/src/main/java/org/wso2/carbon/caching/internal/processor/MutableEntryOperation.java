/*
 *  Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.wso2.carbon.caching.internal.processor;

/**
 * The operation to perform on a {@link org.wso2.carbon.caching.internal.CarbonCachedValue} as a result of
 * actions performed on a {@link javax.cache.processor.MutableEntry}.
 */
public enum MutableEntryOperation {
    /**
     * Don't perform any operations on the {@link org.wso2.carbon.caching.internal.CarbonCachedValue}.
     */
    NONE,

    /**
     * Access an existing {@link org.wso2.carbon.caching.internal.CarbonCachedValue}.
     */
    ACCESS,

    /**
     * Create a new {@link org.wso2.carbon.caching.internal.CarbonCachedValue}.
     */
    CREATE,

    /**
     * Loaded a new {@link org.wso2.carbon.caching.internal.CarbonCachedValue}.
     */
    LOAD,

    /**
     * Remove the {@link org.wso2.carbon.caching.internal.CarbonCachedValue} (and thus the Cache Entry).
     */
    REMOVE,

    /**
     * Update the {@link org.wso2.carbon.caching.internal.CarbonCachedValue}.
     */
    UPDATE;
}
