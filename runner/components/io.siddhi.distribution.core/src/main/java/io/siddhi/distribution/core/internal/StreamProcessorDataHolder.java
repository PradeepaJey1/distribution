/*
 * Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package io.siddhi.distribution.core.internal;

import io.siddhi.core.SiddhiManager;
import io.siddhi.core.stream.input.source.SourceHandlerManager;
import io.siddhi.core.stream.output.sink.SinkHandlerManager;
import io.siddhi.core.table.record.RecordTableHandlerManager;
import io.siddhi.distribution.core.NodeInfo;
import io.siddhi.distribution.core.distribution.DistributionService;
import io.siddhi.distribution.core.internal.beans.DeploymentConfig;
import org.osgi.framework.BundleContext;
import org.wso2.carbon.analytics.permissions.PermissionProvider;
import org.wso2.carbon.config.provider.ConfigProvider;
import org.wso2.carbon.databridge.commons.ServerEventListener;
import org.wso2.carbon.datasource.core.api.DataSourceService;
import org.wso2.carbon.kernel.CarbonRuntime;

import java.util.ArrayList;
import java.util.List;

/**
 * Class which holds the OSGI Service references.
 */
public class StreamProcessorDataHolder {

    private static StreamProcessorDataHolder instance = new StreamProcessorDataHolder();
    private static SiddhiManager siddhiManager;
    private static StreamProcessorService streamProcessorService;
    private static DataSourceService dataSourceService;
    private static boolean isPersistenceEnabled;
    private static SinkHandlerManager sinkHandlerManager;
    private static SourceHandlerManager sourceHandlerManager;
    private static DeploymentConfig deploymentConfig;
    private static NodeInfo nodeInfo;
    private static DistributionService distributionService;
    private static RecordTableHandlerManager recordTableHandlerManager;
    private static PermissionProvider permissionProvider;
    /**
     * List used to hold all the registered subscribers.
     */
    private static List<ServerEventListener> serverListeners = new ArrayList<>();
    private CarbonRuntime carbonRuntime;
    private BundleContext bundleContext;
    private ConfigProvider configProvider;

    private StreamProcessorDataHolder() {

    }

    /**
     * This returns the StreamProcessorDataHolder instance.
     *
     * @return The StreamProcessorDataHolder instance of this singleton class
     */
    public static StreamProcessorDataHolder getInstance() {
        return instance;
    }

    public static SiddhiManager getSiddhiManager() {
        return siddhiManager;
    }

    public static void setSiddhiManager(SiddhiManager siddhiManager) {
        StreamProcessorDataHolder.siddhiManager = siddhiManager;
    }

    public static StreamProcessorService getStreamProcessorService() {
        return streamProcessorService;
    }

    public static void setStreamProcessorService(StreamProcessorService streamProcessorService) {
        StreamProcessorDataHolder.streamProcessorService = streamProcessorService;
    }

    public static DataSourceService getDataSourceService() {
        return StreamProcessorDataHolder.dataSourceService;
    }

    public static void setDataSourceService(DataSourceService dataSourceService) {
        StreamProcessorDataHolder.dataSourceService = dataSourceService;
    }

    public static boolean isPersistenceEnabled() {
        return isPersistenceEnabled;
    }

    public static void setIsPersistenceEnabled(Boolean isPersistenceEnabled) {
        StreamProcessorDataHolder.isPersistenceEnabled = isPersistenceEnabled;
    }

    public static SinkHandlerManager getSinkHandlerManager() {
        return StreamProcessorDataHolder.sinkHandlerManager;
    }

    public static void setSinkHandlerManager(SinkHandlerManager sinkHandlerManager) {
        StreamProcessorDataHolder.sinkHandlerManager = sinkHandlerManager;
    }

    public static SourceHandlerManager getSourceHandlerManager() {
        return StreamProcessorDataHolder.sourceHandlerManager;
    }

    public static void setSourceHandlerManager(SourceHandlerManager sourceHandlerManager) {
        StreamProcessorDataHolder.sourceHandlerManager = sourceHandlerManager;
    }

    public static DeploymentConfig getDeploymentConfig() {
        return StreamProcessorDataHolder.deploymentConfig;
    }

    public static void setDeploymentConfig(DeploymentConfig deploymentConfig) {
        StreamProcessorDataHolder.deploymentConfig = deploymentConfig;
    }

    public static NodeInfo getNodeInfo() {
        return StreamProcessorDataHolder.nodeInfo;
    }

    public static void setNodeInfo(NodeInfo nodeInfo) {
        StreamProcessorDataHolder.nodeInfo = nodeInfo;
    }

    public static RecordTableHandlerManager getRecordTableHandlerManager() {
        return recordTableHandlerManager;
    }

    public static void setRecordTableHandlerManager(RecordTableHandlerManager outputHandlerManager) {
        StreamProcessorDataHolder.recordTableHandlerManager = outputHandlerManager;
    }

    public static DistributionService getDistributionService() {
        return distributionService;
    }

    public static void setDistributionService(DistributionService distributionService) {
        StreamProcessorDataHolder.distributionService = distributionService;
    }

    public static void setServerListener(ServerEventListener serverListener) {
        serverListeners.add(serverListener);
    }

    public static void removeServerListener(ServerEventListener serverListener) {
        serverListeners.remove(serverListener);
    }

    public static List<ServerEventListener> getServerListeners() {
        return serverListeners;
    }

    public static PermissionProvider getPermissionProvider() {
        return StreamProcessorDataHolder.permissionProvider;
    }

    public static void setPermissionProvider(PermissionProvider permissionProvider) {
        StreamProcessorDataHolder.permissionProvider = permissionProvider;
    }

    /**
     * Returns the CarbonRuntime service which gets set through a service component.
     *
     * @return CarbonRuntime Service
     */
    public CarbonRuntime getCarbonRuntime() {
        return carbonRuntime;
    }

    /**
     * This method is for setting the CarbonRuntime service. This method is used by
     * ServiceComponent.
     *
     * @param carbonRuntime The reference being passed through ServiceComponent
     */
    public void setCarbonRuntime(CarbonRuntime carbonRuntime) {
        this.carbonRuntime = carbonRuntime;
    }

    public BundleContext getBundleContext() {
        return bundleContext;
    }

    public void setBundleContext(BundleContext bundleContext) {
        this.bundleContext = bundleContext;
    }

    public ConfigProvider getConfigProvider() {
        return configProvider;
    }

    public void setConfigProvider(ConfigProvider configProvider) {
        this.configProvider = configProvider;
    }
}
