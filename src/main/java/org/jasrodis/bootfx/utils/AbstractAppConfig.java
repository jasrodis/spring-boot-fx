package org.jasrodis.bootfx.utils;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public abstract class AbstractAppConfig {

    private static final Logger log = LoggerFactory.getLogger(AbstractAppConfig.class);

    /* ***************************************************************************************************/
    /* ************************ Singleton Initialization and read application.yml ************************/
    /* ***************************************************************************************************/
    private static class SingletonHolder {

        static final AppConfig INSTANCE = loadProperties();

        static AppConfig loadProperties() {
            AppConfig appConfig = null;
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            try {
                File appConfigFile = new File(AppConfig.class.getResource("/application.yml").getFile());
                appConfig = mapper.readValue(appConfigFile, AppConfig.class);
            } catch (Exception e) {
                log.error("Error in loading the configuration file (application.yml)", e);
            }
            return appConfig;
        }

        private SingletonHolder() {
        }
    }
    
    protected static AppConfig getInstance() {
        return SingletonHolder.INSTANCE;
    }

    protected AbstractAppConfig() {
    }


}
