/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.huawei.streaming.cql.executor.windowcreater;

import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.huawei.streaming.api.opereators.Window;
import com.huawei.streaming.api.streams.Column;
import com.huawei.streaming.api.streams.Schema;
import com.huawei.streaming.cql.exception.SemanticAnalyzerException;

/**
 * create time sort window test case
 *
 */
public class TimeSortWindowCreatorTest
{
    
    /**
     * 测试用例
     *
     */
    @Test
    public void testCreateInstance()
        throws Exception
    {
        WindowCreator creater = new TimeSortWindowCreator();
        creater.createInstance(createWindow(), initSchema(), null);
        assertTrue(true);
    }
    
    private Window createWindow()
    {
        return Window.createTimeSortWindow(1, "id");
    }
    
    private List<Schema> initSchema()
        throws SemanticAnalyzerException
    {
        List<Schema> schemas = new ArrayList<Schema>();
        Schema s1 = new Schema("S1");
        
        s1.addCol(new Column("id", Date.class));
        s1.addCol(new Column("name", String.class));
        
        schemas.add(s1);
        return schemas;
    }
}
