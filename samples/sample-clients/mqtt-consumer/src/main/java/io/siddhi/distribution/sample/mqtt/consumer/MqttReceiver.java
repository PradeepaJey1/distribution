/*
 *  Copyright (c) 2017 WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 */

package io.siddhi.distribution.sample.mqtt.consumer;

import io.siddhi.core.SiddhiAppRuntime;
import io.siddhi.core.SiddhiManager;
import org.apache.log4j.Logger;

/**
 * Test client for MQTT source.
 */
public class MqttReceiver {
    private static final Logger log = Logger.getLogger(MqttReceiver.class);

    /**
     * Main method to start the test client.
     *
     * @param args no args need to be provided
     */
    public static void main(String[] args) {
        log.info("Initialize mqtt receiver.");
        SiddhiManager siddhiManager = new SiddhiManager();
        String url = args[0];
        String topic = args[1];
        String type = args[2];
        SiddhiAppRuntime siddhiAppRuntime = siddhiManager.createSiddhiAppRuntime(
                "@App:name(\"PublishMqttInXmlFormatTest\")\n" +
                        "@source(type ='mqtt',url = '" + url + "', topic = '" + topic + "'," +
                        "@map(type='" + type + "'))" +
                        "define stream LowProducitonAlertStream (name string, amount double);\n" +
                        "@sink(type='log')\n" +
                        "define stream logStream(name string, amount double);\n" +
                        "from LowProducitonAlertStream\n" +
                        "select * \n" +
                        "insert into logStream;");
        siddhiAppRuntime.start();
        while (true) {
        }
    }
}
