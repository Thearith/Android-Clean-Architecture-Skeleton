package thearith.com.clean_arch_skeleton.domain.interactor.base;

import io.reactivex.Observable;
import thearith.com.clean_arch_skeleton.domain.executor.PostExecutionThread;
import thearith.com.clean_arch_skeleton.domain.executor.ThreadExecutor;

/**
 * A default UseCase base class
 */

public abstract class UseCase<T> implements Interactor<T> {

    private final ThreadExecutor mThreadExecutor;
    private final PostExecutionThread mPostExecutionThread;

    public UseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        mThreadExecutor = threadExecutor;
        mPostExecutionThread = postExecutionThread;
    }


    /**
     * abstract method
     * To be implemented by individual use case
     *
     * */
    protected abstract Observable<T> createObservable(Object... params);


    private Observable<T> createObservable() {
        return createObservable(null);
    }


    @Override
    public Observable<T> execute() {
        return createObservable();
    }

    @Override
    public Observable<T> execute(Object... params) {
        return createObservable(params);
    }

}
