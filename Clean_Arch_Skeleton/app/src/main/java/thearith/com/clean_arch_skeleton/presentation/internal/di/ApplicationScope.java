package thearith.com.clean_arch_skeleton.presentation.internal.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * A scoping annotation to permit objects whose lifetime should
 * conform to the life of the application to be memorized in the
 * correct component.
 *
 * Its concept is similar to a Singleton instance
 */
@Scope
@Retention(RetentionPolicy.CLASS)
public @interface ApplicationScope {
}
