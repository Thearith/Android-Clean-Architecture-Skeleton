package thearith.com.clean_arch_skeleton.data.repository.datasource;

import io.reactivex.Observable;

/**
 * Created by Thearith on 8/14/17.
 */

public interface Persistable<T> {

    Observable<T> persist(T object);
}
