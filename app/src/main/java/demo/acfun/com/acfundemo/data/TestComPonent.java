package demo.acfun.com.acfundemo.data;

import dagger.Component;
import demo.acfun.com.acfundemo.ui.MainActivity;

/**
 * Created by chen on 16/6/27.
 */
@Component(modules = {TestModule.class})
public interface TestComponent {
    void inject(MainActivity mainActivity);
}
