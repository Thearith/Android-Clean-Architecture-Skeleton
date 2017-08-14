package thearith.com.clean_arch_skeleton.presentation.view.base;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Base Activity class for every Activity which needs to persist its data throughout lifecycle
 * such as configuration changes.
 *
 */
public abstract class ViewModelActivity extends BaseActivity {

    private static final String VIEW_MODEL  = ViewModelActivity.class.getSimpleName()
            + ViewModel.class.getSimpleName();


    /**
     * A lifecycle-aware class that is persisted through orientation changes
     *
     * Lifecycle-aware data that child class needs to persist must be put in {@link ViewModel}
     */
    protected abstract class ViewModel implements Parcelable {

    }


    /**
     * Initializes a lifecycle-aware object
     * This method is called in {@method onCreate()} if there is not any persisted data previously
     * */
    protected abstract void initLifecycleAwareData();

    /**
     * Returns a {@link ViewModel} object
     * */
    protected abstract ViewModel getLifecycleAwareData();

    /**
     * Sets {@link ViewModel} object
     * This method is called in {@method onCreate()}
     *
     * @param viewModel {@link ViewModel} object
     * */
    protected abstract void setLifecycleAwareData(ViewModel viewModel);


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState != null) {
            setLifecycleAwareData(parseFromBundle(savedInstanceState));
        }

        // If lifecycle-aware data is still null, initialize it
        if(getLifecycleAwareData() == null) {
            initLifecycleAwareData();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        ViewModel model = getLifecycleAwareData();
        if(model != null) {
            outState.putParcelable(VIEW_MODEL, model);
        }

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if(savedInstanceState != null) {
            setLifecycleAwareData(parseFromBundle(savedInstanceState));
        }
    }

    private ViewModel parseFromBundle(@NonNull Bundle bundle) {
        Object object = bundle.get(VIEW_MODEL);
        if(object instanceof ViewModel) {
            return (ViewModel) object;
        }

        return null;
    }

}
