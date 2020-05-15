/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.core.io;

import org.springframework.lang.Nullable;

/**
 * 特定于协议的资源句柄得解决策略。作为 DefaultResourceLoader 的服务供给接口（Service Provider Interface），
 * 可处理自定义协议而不必不必实现 DefaultResourceLoader接口（或继承其实现类）。
 *
 * A resolution strategy for protocol-specific resource handles.
 * <p>Used as an SPI for {@link DefaultResourceLoader}, allowing for
 * custom protocols to be handled without subclassing the loader
 * implementation (or application context implementation).
 *
 * @author Juergen Hoeller
 * @since 4.3
 * @see DefaultResourceLoader#addProtocolResolver
 */
@FunctionalInterface
public interface ProtocolResolver {

	/**
	 * 若本实现的协议匹配，则根据指定的资源加载器解析指定位置的资源
	 * Resolve the given location against the given resource loader
	 * if this implementation's protocol matches.
	 * @param location the user-specified resource location 用户指定的资源路径
	 * @param resourceLoader the associated resource loader 关联的资源加载器
	 * @return a corresponding {@code Resource} handle if the given location
	 * matches this resolver's protocol, or {@code null} otherwise 若资源位置匹配解析协议，返回处理的资源，否则返回 null
	 */
	@Nullable
	Resource resolve(String location, ResourceLoader resourceLoader);

}
