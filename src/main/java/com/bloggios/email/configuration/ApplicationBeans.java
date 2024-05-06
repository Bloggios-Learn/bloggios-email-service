/*
 * Copyright © 2023-2024 Rohit Parihar and Bloggios
 * All rights reserved.
 * This software is the property of Rohit Parihar and is protected by copyright law.
 * The software, including its source code, documentation, and associated files, may not be used, copied, modified, distributed, or sublicensed without the express written consent of Rohit Parihar.
 * For licensing and usage inquiries, please contact Rohit Parihar at rohitparih@gmail.com, or you can also contact support@bloggios.com.
 * This software is provided as-is, and no warranties or guarantees are made regarding its fitness for any particular purpose or compatibility with any specific technology.
 * For license information and terms of use, please refer to the accompanying LICENSE file or visit http://www.apache.org/licenses/LICENSE-2.0.
 * Unauthorized use of this software may result in legal action and liability for damages.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bloggios.email.configuration;

import com.bloggios.email.constants.BeanNameConstants;
import com.bloggios.email.properties.ThreadPoolProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - bloggios-email-service
 * Package - com.bloggios.email.configuration
 * Created_on - 04 May-2024
 * Created_at - 20 : 07
 */

@Configuration
public class ApplicationBeans {

    private final ThreadPoolProperties threadPoolProperties;

    public ApplicationBeans(
            ThreadPoolProperties threadPoolProperties
    ) {
        this.threadPoolProperties = threadPoolProperties;
    }

    @Bean(BeanNameConstants.ASYNC_TASK_INTERNAL_POOL)
    public TaskExecutor taskExecutor() {
        ThreadPoolProperties.InternalThread internalThread = threadPoolProperties.getInternalThread();
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(internalThread.getCorePoolSize());
        executor.setMaxPoolSize(internalThread.getMaxPoolSize());
        executor.setQueueCapacity(internalThread.getQueueCapacity());
        executor.setThreadNamePrefix(internalThread.getThreadPrefix());
        executor.setAllowCoreThreadTimeOut(true);
        executor.setKeepAliveSeconds(60);
        executor.initialize();
        return executor;
    }
}
