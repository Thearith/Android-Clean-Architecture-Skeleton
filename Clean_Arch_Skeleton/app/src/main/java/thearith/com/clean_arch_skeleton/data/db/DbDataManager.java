package thearith.com.clean_arch_skeleton.data.db;

import javax.inject.Inject;

import io.reactivex.Observable;
import thearith.com.clean_arch_skeleton.data.repository.datasource.DataManager;
import thearith.com.clean_arch_skeleton.data.repository.datasource.Persistable;
import thearith.com.clean_arch_skeleton.presentation.internal.di.ApplicationScope;

/**
 * Created by Thearith on 8/14/17.
 */

@ApplicationScope
public class DbDataManager implements DataManager, Persistable<String> {

    @Inject
    DbDataManager() {

    }


    @Override
    public Observable<String> getData() {
        return Observable.just("Hello World from Db");
    }

    @Override
    public Observable<String> persist(String object) {
        return Observable.just(object);
    }
}
