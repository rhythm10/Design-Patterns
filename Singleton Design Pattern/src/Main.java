import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        RedisConfig rc = RedisConfig.getInstance();
        System.out.println(rc.getUser());

        Temp temp = new Temp();
        System.out.println(temp.getRedisConfig());
    }
}
