package thearith.com.clean_arch_skeleton.presentation.presenter.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * {@link Presenter} that controls communication between views and models of the presentation
 * layer.
 *
 * This class should be the super class of all {@link Presenter} classes.
 */
public class BasePresenter {

    protected final CompositeDisposable mDisposables;


    public BasePresenter() {
        mDisposables = new CompositeDisposable();
    }

    protected void addToDisposable(Disposable disposable) {
        mDisposables.add(disposable);
    }

    public void destroy() {
        if(!mDisposables.isDisposed()) {
            mDisposables.dispose();
        }
    }

}
