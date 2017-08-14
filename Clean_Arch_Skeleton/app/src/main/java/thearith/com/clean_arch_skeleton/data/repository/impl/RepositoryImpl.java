package thearith.com.clean_arch_skeleton.data.repository.impl;

import javax.inject.Inject;

import io.reactivex.Observable;
import thearith.com.clean_arch_skeleton.data.db.DbDataManager;
import thearith.com.clean_arch_skeleton.data.local.LocalDataManager;
import thearith.com.clean_arch_skeleton.data.network.CloudDataManager;
import thearith.com.clean_arch_skeleton.data.repository.Repository;

/**
 * Created by Thearith on 8/14/17.
 */

public class RepositoryImpl implements Repository {

    private LocalDataManager mLocalManager;
    private DbDataManager mDbManager;
    private CloudDataManager mCloudManager;

    @Inject
    RepositoryImpl(LocalDataManager localManager, DbDataManager dbManager, CloudDataManager cloudManager) {
        mLocalManager = localManager;
        mDbManager = dbManager;
        mCloudManager = cloudManager;
    }


    @Override
    public Observable<String> getData() {
        return Observable
                .concat(memory(), diskWithSave(), networkWithSave())
                .firstElement()
                .toObservable();
    }

    private Observable<String> memory() {
        return mLocalManager.getData();
    }

    private Observable<String> diskWithSave() {
        return mDbManager
                .getData()
                .doOnNext(mLocalManager::persist);
    }

    private Observable<String> networkWithSave() {
        return mCloudManager
                .getData()
                .doOnNext(data -> {
                    mDbManager.persist(data);
                    mLocalManager.persist(data);
                });
    }
}
