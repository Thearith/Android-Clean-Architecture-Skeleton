package thearith.com.clean_arch_skeleton.data.internal.di.modules;

import dagger.Module;
import dagger.Provides;
import thearith.com.clean_arch_skeleton.data.db.DbDataManager;
import thearith.com.clean_arch_skeleton.presentation.internal.di.ApplicationScope;
import thearith.com.clean_arch_skeleton.presentation.internal.di.modules.ApplicationModule;

/**
 * Module that controls dependencies for Data
 */

@Module(includes = {ApplicationModule.class})
public class DataModule {

    // ---------------------------------------------------------
    // @Provide Dependency methods related to DOMAIN layer
    // should be provided here
    // ---------------------------------------------------------

}
