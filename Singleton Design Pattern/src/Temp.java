public class Temp {

    public String getRedisConfig() {
        RedisConfig rc = RedisConfig.getInstance();
        return rc.getUser();
    }

}
