/**
 * Copyright (C) 2017 Alfresco Software Limited.
 * <p/>
 * This file is part of the Alfresco SDK project.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package testpackage.platformsample;

import org.springframework.extensions.webscripts.Cache;
import org.springframework.extensions.webscripts.DeclarativeWebScript;
import org.springframework.extensions.webscripts.Status;
import org.springframework.extensions.webscripts.WebScriptRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * A demonstration Java controller for the Hello World Web Script.
 *
 * @author martin.bergljung@alfresco.com
 * @since 2.1.0
 */
public class HelloWorldWebScript extends DeclarativeWebScript {
    private static Log logger = LogFactory.getLog(HelloWorldWebScript.class);
    
    private static final String ADMIN_USER_NAME = "admin";
   
    protected Map<String, Object> executeImpl(
            WebScriptRequest req, Status status, Cache cache) {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("fromJava", "HelloFromJava");      
        
        logger.debug("        _____  ___  ____  _____    ");
        logger.debug("  ___  |_   _|| __|/  __||_   _|   ");
        logger.debug(" / _ |   | |  | _| \\__  \\  | |     ");
        logger.debug(" \\___|   |_|  |___||____/  |_|     ");

        model.put("fromAD", "from AD");              
        DemoComponent demo = new DemoComponent();
        //logger.debug("-- TEST1 DEMO -- "+ demo);
        
        try {
			demo.executeInternal();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        model.put("fromAlfresco",  model.get("fromJava"));        
        
        logger.debug("Your 'TEST' Web Script was called! =======================");
        
        return model;
    }
    

}