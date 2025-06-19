package models;

import org.aeonbits.owner.Config;


@Config.Sources({"classpath:browser.properties"})
public interface Configuration extends Config{

    @Config.Key("browser")
    String browser();
}
