package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
    "classpath:config/driver.properties"
})
public interface DriverConfig extends Config {

    @Key("web.remote.driver.url")
    String webRemoteDriverUrl();

    @Key("web.remote.driver.user")
    String webRemoteDriverUser();

    @Key("web.remote.driver.password")
    String webRemoteDriverPassword();

    @Key("video.storage")
    String videoStorage();
}
