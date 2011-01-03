/*
 *  Licensed to the OpenXdata Foundation (OXDF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The OXDF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with the License. 
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, 
 *  software distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and limitations under the License.
 *
 *  Copyright 2010 http://www.openxdata.org.
 */
package org.openxdata.server.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openxdata.server.admin.model.exception.UnexpectedException;

/**
 * Utilities for handling files.
 * 
 * @author daniel
 * @author Angel
 * @author Jonny Heggheim
 *
 */
public class FileUtil {

    /**
     * Fetch the entire contents of the <tt>File</tt>, and return it in a String.
     *
     * @param absoluteFilePath The absolute path to the <tt>File.</tt>
     * @return <tt>File</tt> content.
     */
    public static String readFile(String absoluteFilePath) {
        File file = new File(absoluteFilePath);
        try {
            return FileUtils.readFileToString(file, "UTF-8");
        } catch (IOException e) {
            throw new UnexpectedException(e);
        }
    }

}
