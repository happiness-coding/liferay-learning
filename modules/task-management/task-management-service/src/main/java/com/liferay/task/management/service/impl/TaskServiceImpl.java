/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.task.management.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.task.management.service.base.TaskServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=taskmanagement",
		"json.web.service.context.path=Task"
	},
	service = AopService.class
)
public class TaskServiceImpl extends TaskServiceBaseImpl {
}