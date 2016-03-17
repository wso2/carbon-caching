/*
 *  Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.wso2.carbon.caching.osgi.utils;

import org.ops4j.pax.exam.Option;
import org.wso2.carbon.kernel.Constants;
import org.wso2.carbon.osgi.test.util.CarbonSysPropConfiguration;
import org.wso2.carbon.osgi.test.util.OSGiTestConfigurationUtils;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.ops4j.pax.exam.CoreOptions.mavenBundle;

/**
 * This class contains Utility methods to configure PAX-EXAM container.
 *
 * @since 5.0.0
 */
public class OSGiTestUtils {

    /**
     * Setup the test environment.
     * <p>
     * Includes setting the carbon.home system property, setting the required system properties,
     * setting the maven local repo directory, etc.
     */
    public static void setupOSGiTestEnvironment() {
        OSGiTestUtils.setCarbonHome();
        OSGiTestUtils.setStartupTime();
    }

    /**
     * Returns an array of default PAX-EXAM options.
     *
     * @return array of Options
     */
    public static Option[] getDefaultPaxOptions() {
        List<Option> optionList = new ArrayList<>();
        optionList.add(
                mavenBundle().artifactId("org.wso2.carbon.caching").groupId("org.wso2.carbon.caching").
                        versionAsInProject());

        String currentDir = Paths.get("").toAbsolutePath().toString();
        Path carbonHome = Paths.get(currentDir, "target", "carbon-home");

        CarbonSysPropConfiguration sysPropConfiguration = new CarbonSysPropConfiguration();
        sysPropConfiguration.setCarbonHome(carbonHome.toString());
        sysPropConfiguration.setServerKey("carbon-caching");
        sysPropConfiguration.setServerName("WSO2 Carbon Caching Server");
        sysPropConfiguration.setServerVersion("1.0.0");

        optionList = OSGiTestConfigurationUtils.getConfiguration(optionList, sysPropConfiguration);
        return optionList.toArray(new Option[optionList.size()]);
    }


    /**
     * Set the carbon home for execute tests.
     * Carbon home is set to /carbon-kernel/tests/osgi-tests/target/carbon-home
     */
    private static void setCarbonHome() {
        String currentDir = Paths.get("").toAbsolutePath().toString();
        Path carbonHome = Paths.get(currentDir, "target", "carbon-home");
        System.setProperty("carbon.home", carbonHome.toString());
    }

    /**
     * Set the startup time to calculate the server startup time.
     */
    private static void setStartupTime() {
        if (System.getProperty(Constants.START_TIME) == null) {
            System.setProperty(Constants.START_TIME, System.currentTimeMillis() + "");
        }
    }
}
