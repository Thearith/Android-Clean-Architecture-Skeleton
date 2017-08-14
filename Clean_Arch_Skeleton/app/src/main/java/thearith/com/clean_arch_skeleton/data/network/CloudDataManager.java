package thearith.com.clean_arch_skeleton.data.network;

import javax.inject.Inject;

import io.reactivex.Observable;
import thearith.com.clean_arch_skeleton.data.repository.datasource.DataManager;
import thearith.com.clean_arch_skeleton.presentation.internal.di.ApplicationScope;

/**
 * Created by Thearith on 8/14/17.
 */

@ApplicationScope
public class CloudDataManager implements DataManager {

    @Inject
    CloudDataManager() {

    }

    @Override
    public Observable<String> getData() {
        return Observable.just("Hello World from Cloud");
    }
}
