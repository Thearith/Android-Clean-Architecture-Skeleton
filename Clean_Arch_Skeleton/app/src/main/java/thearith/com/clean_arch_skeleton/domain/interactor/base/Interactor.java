package thearith.com.clean_arch_skeleton.domain.interactor.base;

import io.reactivex.Observable;

/**
 * Interactor.java
 *
 * A generic interface for UseCase
 */

public interface Interactor<T> {
    Observable<T> execute();
    Observable<T> execute(Object... params);
}
