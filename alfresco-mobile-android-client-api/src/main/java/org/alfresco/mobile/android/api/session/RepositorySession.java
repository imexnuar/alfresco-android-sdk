/*******************************************************************************
 * Copyright (C) 2005-2012 Alfresco Software Limited.
 * 
 * This file is part of the Alfresco Mobile SDK.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 ******************************************************************************/
package org.alfresco.mobile.android.api.session;

import java.io.Serializable;
import java.util.Map;

import org.alfresco.mobile.android.api.exceptions.AlfrescoSessionException;
import org.alfresco.mobile.android.api.session.impl.AbstractAlfrescoSessionImpl;
import org.alfresco.mobile.android.api.session.impl.RepositorySessionImpl;
import org.alfresco.mobile.android.api.utils.messages.Messagesl18n;

/**
 * RepositorySession represents a connection to an on-premise repository as a
 * specific user.
 * 
 * @author Jean Marie Pascal
 */
public abstract class RepositorySession extends AbstractAlfrescoSessionImpl
{

    /**
     * Define the specific repository identifier. By default not necessary. <br/>
     * Value must be a String value that represents a valid repository identifier.<br/>
     * Default : null<br/>
     * <b>This parameter can't be changed after the session creation</b>.
     */
    public static final String REPOSITORY_ID = "org.alfresco.mobile.binding.repository.id";

    /**
     * Creates and authenticates a session represented by the URL using the
     * given user identifier and password. This method will use Basic HTTP
     * authentication to authorise the user.
     * 
     * @param url
     * @param username
     * @param password
     * @return
     * @throws AlfrescoSessionException
     */
    public static RepositorySession connect(String url, String username, String password,
            Map<String, Serializable> parameters)
    {
        if (url == null || url.isEmpty()) { throw new IllegalArgumentException(String.format(
                Messagesl18n.getString("ErrorCodeRegistry.GENERAL_INVALID_ARG_NULL"), "url")); }

        if (username == null || username.isEmpty()) { throw new IllegalArgumentException(String.format(
                Messagesl18n.getString("ErrorCodeRegistry.GENERAL_INVALID_ARG_NULL"), "username")); }

        return new RepositorySessionImpl(url, username, password, parameters);
    }

    /**
     * Creates a new instance of a RepositorySession representing the repository
     * specified in the url parameter. <br>
     * Authenticate and bind with a repository. Initialize all informations and
     * services associated with the repository for a specific user. This method
     * use automatically default session configuration
     * {@link org.alfresco.mobile.android.api.session.SessionSettings
     * SessionSettings}.
     * 
     * @param url : Base URL associated to the repository. For example :
     *            <i>http://hostname:port/alfresco</i>
     * @return a RepositorySession object that is not bind with the repository.
     */
    public static RepositorySession connect(String url, String username, String password)
    {
        return connect(url, username, password, null);
    }
}
