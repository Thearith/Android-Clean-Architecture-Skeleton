package thearith.com.clean_arch_skeleton.domain.internal.di.modules;

import dagger.Module;
import dagger.Provides;
import thearith.com.clean_arch_skeleton.domain.executor.PostExecutionThread;
import thearith.com.clean_arch_skeleton.domain.executor.ThreadExecutor;
import thearith.com.clean_arch_skeleton.domain.executor.impl.JobExecutor;
import thearith.com.clean_arch_skeleton.domain.executor.impl.UIThread;
import thearith.com.clean_arch_skeleton.presentation.internal.di.ApplicationScope;
import thearith.com.clean_arch_skeleton.presentation.internal.di.modules.ApplicationModule;


/**
 * A module that controls all dependencies of Domain
 */

@Module(includes = {ApplicationModule.class})
public class DomainModule {

    @Provides
    @ApplicationScope
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @ApplicationScope
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }


    // ---------------------------------------------------------
    // @Provide Dependency methods related to Domain layer
    // should be provided here
    // ---------------------------------------------------------

}
