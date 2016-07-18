package com.bandou.library.util;

/**
 * Singleton helper class for lazily initialization.
 *
 * @param <T> the type parameter
 */
public abstract class SingletonUtils<T> {

    private T instance;

    /**
     * New instance t.
     *
     * @return the t
     */
    protected abstract T newInstance();

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public final T getInstance() {
        if (instance == null) {
            synchronized (SingletonUtils.class) {
                if (instance == null) {
                    instance = newInstance();
                }
            }
        }
        return instance;
    }
}
