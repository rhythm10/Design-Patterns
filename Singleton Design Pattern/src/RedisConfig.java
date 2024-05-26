import java.util.concurrent.locks.Lock;

public class RedisConfig {
    private String url;
    private String password;
    private int port;
    private String user;
    private static RedisConfig instance = null;

    public static Lock lock;

    /*
        private static RedisConfig runTimeInstance = new RedisConfig("localhost", "root", 8080, "newUser");
        If done using this way, then object will be created at class loading time, so all calls will take same time,
        otherwise first call will take more time as it will be created when called.
     */

    private RedisConfig(String url, String password, int port, String user) {
        this.url = url;
        this.password = password;
        this.port = port;
        this.user = user;
    }

    public static RedisConfig getInstance() {
        if (instance == null) {
            return new RedisConfig("localhost", "root", 8080, "newUser");
        }
        return instance;
    }

    //Thread Safe Case
    public static RedisConfig getThreadSafeInstance() {
        if (instance == null) {
            lock.lock();
            if(instance == null) {
                instance = new RedisConfig("localhost", "root", 8080, "newUser");
            }
            lock.unlock();
        }
        return instance;
    }

    public String getUser() {
        return user;
    }
}
