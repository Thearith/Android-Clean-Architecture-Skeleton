package thearith.com.clean_arch_skeleton.data.local;

import javax.inject.Inject;

import io.reactivex.Observable;
import thearith.com.clean_arch_skeleton.data.repository.datasource.DataManager;
import thearith.com.clean_arch_skeleton.data.repository.datasource.Persistable;
import thearith.com.clean_arch_skeleton.presentation.internal.di.ApplicationScope;

/**
 * Created by Thearith on 8/14/17.
 */

@ApplicationScope
public class LocalDataManager implements DataManager, Persistable<String> {


    @Inject
    LocalDataManager() {

    }

    @Override
    public Observable<String> getData() {
        return Observable.just("Hello World from Local");
    }

    @Override
    public Observable<String> persist(String data) {
        return Observable.just(data);
    }
}
