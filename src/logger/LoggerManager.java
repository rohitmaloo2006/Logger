package logger;

import logcategory.*;
import sink.ConsoleLogObserver;
import sink.FileLogObserver;
import sink.LogSubject;

public class LoggerManager {

    protected static AbstractLogger buildChainOfLogger() {
        AbstractLogger infoLogger = new InfoLogger(LogCategoryEnum.INFO.getLevel());
        AbstractLogger errorLogger = new ErrorLogger(LogCategoryEnum.ERROR.getLevel());
        AbstractLogger debugLogger = new DebugLogger(LogCategoryEnum.DEBUG.getLevel());
        infoLogger.setNextLoggingLevel(errorLogger);
        errorLogger.setNextLoggingLevel(debugLogger);
        return infoLogger;
    }

    protected static LogSubject buildLogSubject() {
        LogSubject logSubject = new LogSubject();
        ConsoleLogObserver consoleLogObserver = new ConsoleLogObserver();
        FileLogObserver fileLogObserver = new FileLogObserver();

        logSubject.addObserver(LogCategoryEnum.INFO.getLevel(), consoleLogObserver);
        logSubject.addObserver(LogCategoryEnum.INFO.getLevel(), fileLogObserver);
        logSubject.addObserver(LogCategoryEnum.ERROR.getLevel(), consoleLogObserver);

        return logSubject;
    }
}
