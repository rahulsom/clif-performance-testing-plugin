/*
 * CLIF is a Load Injection Framework
 * Copyright (C) 2012 France Telecom R&D
 * Copyright (C) 2016 Orange SA
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 *
 * Contact: clif@ow2.org
 */
package org.ow2.clif.jenkins.jobs;

import org.ow2.clif.jenkins.Messages;
import java.io.File;
import javax.annotation.Nonnull;
import org.ow2.clif.jenkins.ClifPlugin;
import jenkins.model.GlobalConfiguration;

/**
 * Workspace-related utility for jobs generated by the CLIF import feature.
 * 
 * @author Bruno Dillenseger
 */
public abstract class Workspaces
{
	/**
	 * Gets the absolute path to the CLIF root directory hosting all
	 * workspaces of imported CLIF projects.
	 * @return the currently configured root directory for imported
	 * CLIF test projects' workspaces
	 */
	@Nonnull
	public static File dir()
	throws RuntimeException
	{
		ClifPlugin clif = GlobalConfiguration.all().get(ClifPlugin.class);
		if (clif != null)
		{
			return clif.dir();
		}
		throw new RuntimeException(Messages.Workspaces_NoClifPluginError());
	}
}
