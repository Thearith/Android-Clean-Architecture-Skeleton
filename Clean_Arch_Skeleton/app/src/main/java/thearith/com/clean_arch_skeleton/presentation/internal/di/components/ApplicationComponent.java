package thearith.com.clean_arch_skeleton.presentation.internal.di.components;


import android.content.Context;

import dagger.Component;
import thearith.com.clean_arch_skeleton.data.internal.di.modules.DataModule;
import thearith.com.clean_arch_skeleton.domain.internal.di.modules.DomainModule;
import thearith.com.clean_arch_skeleton.presentation.internal.di.ApplicationScope;
import thearith.com.clean_arch_skeleton.presentation.internal.di.modules.ApplicationModule;

/**
 * A component whose lifetime is the life of the application.
 */

@ApplicationScope
@Component(modules = {ApplicationModule.class, DomainModule.class, DataModule.class})
public interface ApplicationComponent {

    Context context();

    // Inject your dependencies here
}
