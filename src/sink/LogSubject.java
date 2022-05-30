package sink;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogSubject {

    Map<Integer, List<LogObserver>> observerMap = new HashMap<>();

    public void addObserver(int level, LogObserver observer) {
        List<LogObserver> observerList = observerMap.getOrDefault(level, new ArrayList<>());
        observerList.add(observer);
        observerMap.put(level, observerList);
    }

    public void notifyAllObserver(int level, String msg) {
        for (Map.Entry<Integer, List<LogObserver>> entry : observerMap.entrySet()) {
            if (entry.getKey() == level) {
                entry.getValue().forEach(observer -> {
                    observer.log(msg);
                });
            }
        }
    }
}
