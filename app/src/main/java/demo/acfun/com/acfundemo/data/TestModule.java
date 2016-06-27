package demo.acfun.com.acfundemo.data;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by chen on 16/6/27.
 */
@Module
public class TestModule {

    @Provides
    @Named("name")
    String provideGetName() {
        return "name";
    }

    @Provides
    @Named("msg")
    String provideGetMsg() {
        return "msg";
    }
}
