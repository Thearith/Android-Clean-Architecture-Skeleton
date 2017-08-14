package thearith.com.clean_arch_skeleton.data.repository;

import io.reactivex.Observable;

/**
 * A repository created to show Repository Pattern in Data Layer
 */

public interface Repository {
    Observable<String> getData();
}
