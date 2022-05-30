package sink;

public class FileLogObserver implements LogObserver {
    @Override
    public void log(String msg) {
        String log = "Write in file " + msg;
        System.out.println(log);
    }
}
