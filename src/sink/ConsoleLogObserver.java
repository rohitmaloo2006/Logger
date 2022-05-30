package sink;

public class ConsoleLogObserver implements LogObserver {
    @Override
    public void log(String msg) {
        String log = "Write in Console " + msg;
        System.out.println(log);
    }
}
