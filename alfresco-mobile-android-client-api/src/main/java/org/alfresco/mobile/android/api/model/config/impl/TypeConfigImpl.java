/*******************************************************************************
 * Copyright (C) 2005-2014 Alfresco Software Limited.
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
package org.alfresco.mobile.android.api.model.config.impl;

import java.util.Map;

import org.alfresco.mobile.android.api.constants.ConfigConstants;
import org.alfresco.mobile.android.api.model.config.TypeConfig;
import org.apache.chemistry.opencmis.commons.impl.JSONConverter;

public class TypeConfigImpl extends ItemConfigImpl implements TypeConfig
{
    // ///////////////////////////////////////////////////////////////////////////
    // CONSTRUCTORS
    // ///////////////////////////////////////////////////////////////////////////
    TypeConfigImpl()
    {
    }

    static TypeConfig parse(String identifier, Map<String, Object> json, ConfigurationImpl configuration)
    {
        TypeConfigImpl typeConfig = new TypeConfigImpl();
        typeConfig.identifier = identifier;
        typeConfig.label = configuration.getString(JSONConverter.getString(json, ConfigConstants.LABEL_ID_VALUE));
        typeConfig.description = configuration.getString(JSONConverter.getString(json, ConfigConstants.DESCRIPTION_ID_VALUE));
        typeConfig.configMap = json;
        return typeConfig;
    }

    // ///////////////////////////////////////////////////////////////////////////
    // METHODS
    // ///////////////////////////////////////////////////////////////////////////
}
