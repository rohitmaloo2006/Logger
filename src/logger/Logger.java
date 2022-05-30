package logger;

import logcategory.AbstractLogger;
import logcategory.LogCategoryEnum;
import sink.LogSubject;

import java.io.Serializable;

import static logger.LoggerManager.buildChainOfLogger;
import static logger.LoggerManager.buildLogSubject;

public class Logger implements Cloneable, Serializable {

    private static volatile Logger loggerInstance;
    private static volatile AbstractLogger chainOfLogger;
    private static volatile LogSubject logSubject;


    private Logger() {
        if (loggerInstance != null) {
            throw new IllegalStateException("Object is already created");
        }
    }

    public static Logger getInstance() {
        if (loggerInstance == null) {
            synchronized (Logger.class) {
                if (loggerInstance == null) {
                    loggerInstance = new Logger();
                    chainOfLogger = buildChainOfLogger();
                    logSubject = buildLogSubject();
                }
            }
        }

        return loggerInstance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    protected Object readResolve() {
        return loggerInstance;
    }

    protected void createLog(int level, String msg) {
        chainOfLogger.logMessage(level, msg, logSubject);
    }

    public void infoLog(String msg) {
        createLog(LogCategoryEnum.INFO.getLevel(), msg);
    }

    public void errorLog(String msg) {
        createLog(LogCategoryEnum.ERROR.getLevel(), msg);
    }

    public void debugLog(String msg) {
        createLog(LogCategoryEnum.DEBUG.getLevel(), msg);
    }
}
