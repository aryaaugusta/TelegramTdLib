package com.edts.tdlib;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class Client implements Runnable {
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock readLock;
    private final Lock writeLock;
    private volatile boolean stopFlag;
    private volatile boolean isClientDestroyed;
    private final long nativeClientId;
    private final ConcurrentHashMap<Long, Handler> handlers;
    private final AtomicLong currentQueryId;
    private volatile Client.ExceptionHandler defaultExceptionHandler;
    private static final int MAX_EVENTS = 1000;
    private final long[] eventIds;
    private final TdApi.Object[] events;

    public void send(TdApi.Function var1, Client.ResultHandler var2, Client.ExceptionHandler var3) {
        if (var1 == null) {
            throw new NullPointerException("query is null");
        } else {
            this.readLock.lock();

            try {
                if (this.isClientDestroyed) {
                    if (var2 != null) {
                        this.handleResult(new TdApi.Error(500, "Client is closed"), var2, var3);
                    }

                    return;
                }

                long var4 = this.currentQueryId.incrementAndGet();
                this.handlers.put(var4, new Client.Handler(var2, var3));
                nativeClientSend(this.nativeClientId, var4, var1);
            } finally {
                this.readLock.unlock();
            }

        }
    }

    public void send(TdApi.Function var1, Client.ResultHandler var2) {
        this.send(var1, var2, (Client.ExceptionHandler)null);
    }

    public static TdApi.Object execute(TdApi.Function var0) {
        if (var0 == null) {
            throw new NullPointerException("query is null");
        } else {
            return nativeClientExecute(var0);
        }
    }

    public void setUpdatesHandler(Client.ResultHandler var1, Client.ExceptionHandler var2) {
        this.handlers.put(0L, new Client.Handler(var1, var2));
    }

    public void setUpdatesHandler(Client.ResultHandler var1) {
        this.setUpdatesHandler(var1, (Client.ExceptionHandler)null);
    }

    public void setDefaultExceptionHandler(Client.ExceptionHandler var1) {
        this.defaultExceptionHandler = var1;
    }

    public void run() {
        while(!this.stopFlag) {
            this.receiveQueries(300.0D);
        }

    }

    public static Client create(Client.ResultHandler var0, Client.ExceptionHandler var1, Client.ExceptionHandler var2) {
        Client var3 = new Client(var0, var1, var2);
        (new Thread(var3, "TDLib thread")).start();
        return var3;
    }

    public void close() {
        this.writeLock.lock();

        try {
            if (!this.isClientDestroyed) {
                if (!this.stopFlag) {
                    this.send(new TdApi.Close(), (Client.ResultHandler)null);
                }

                this.isClientDestroyed = true;

                while(!this.stopFlag) {
                    Thread.yield();
                }

                while(this.handlers.size() != 1) {
                    this.receiveQueries(300.0D);
                }

                destroyNativeClient(this.nativeClientId);
                return;
            }
        } finally {
            this.writeLock.unlock();
        }

    }

    private Client(Client.ResultHandler var1, Client.ExceptionHandler var2, Client.ExceptionHandler var3) {
        this.readLock = this.readWriteLock.readLock();
        this.writeLock = this.readWriteLock.writeLock();
        this.stopFlag = false;
        this.isClientDestroyed = false;
        this.handlers = new ConcurrentHashMap();
        this.currentQueryId = new AtomicLong();
        this.defaultExceptionHandler = null;
        this.eventIds = new long[1000];
        this.events = new TdApi.Object[1000];
        this.nativeClientId = createNativeClient();
        this.handlers.put(0L, new Client.Handler(var1, var2));
        this.defaultExceptionHandler = var3;
    }

    protected void finalize() throws Throwable {
        try {
            this.close();
        } finally {
            super.finalize();
        }

    }

    private void processResult(long var1, TdApi.Object var3) {
        if (var3 instanceof TdApi.UpdateAuthorizationState && ((TdApi.UpdateAuthorizationState)var3).authorizationState instanceof TdApi.AuthorizationStateClosed) {
            this.stopFlag = true;
        }

        Client.Handler var4;
        if (var1 == 0L) {
            var4 = (Client.Handler)this.handlers.get(var1);
        } else {
            var4 = (Client.Handler)this.handlers.remove(var1);
        }

        if (var4 != null) {
            this.handleResult(var3, var4.resultHandler, var4.exceptionHandler);
        }
    }

    private void handleResult(TdApi.Object var1, Client.ResultHandler var2, Client.ExceptionHandler var3) {
        if (var2 != null) {
            try {
                var2.onResult(var1);
            } catch (Throwable var7) {
                Throwable var4 = var7;
                if (var3 == null) {
                    var3 = this.defaultExceptionHandler;
                }

                if (var3 != null) {
                    try {
                        var3.onException(var4);
                    } catch (Throwable var6) {
                    }
                }
            }

        }
    }

    private void receiveQueries(double var1) {
        int var3 = nativeClientReceive(this.nativeClientId, this.eventIds, this.events, var1);

        for(int var4 = 0; var4 < var3; ++var4) {
            this.processResult(this.eventIds[var4], this.events[var4]);
            this.events[var4] = null;
        }

    }

    private static native long createNativeClient();

    private static native void nativeClientSend(long var0, long var2, TdApi.Function var4);

    private static native int nativeClientReceive(long var0, long[] var2, TdApi.Object[] var3, double var4);

    private static native TdApi.Object nativeClientExecute(TdApi.Function var0);

    private static native void destroyNativeClient(long var0);

    private static class Handler {
        final Client.ResultHandler resultHandler;
        final Client.ExceptionHandler exceptionHandler;

        Handler(Client.ResultHandler var1, Client.ExceptionHandler var2) {
            this.resultHandler = var1;
            this.exceptionHandler = var2;
        }
    }

    public interface ExceptionHandler {
        void onException(Throwable var1);
    }

    public interface ResultHandler {
        void onResult(TdApi.Object var1);
    }
}
