package demo.acfun.com.acfundemo;

import demo.acfun.com.acfundemo.Manage.UserManage;
import demo.acfun.com.acfundemo.model.WelComeEntity;
import demo.acfun.com.acfundemo.network.AppHttp;
import demo.acfun.com.acfundemo.widget.ImageLoaderUtils;
import demo.acfun.com.acfundemo.utils.LogUtils;
import rx.Observer;
import rx.schedulers.Schedulers;

/**
 * Created by chen on 16/6/15.
 */
public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.LOG_DEBUG = true;

        initWelCome();
//        initOkHttp();

        //初始化 Imageloader Fresco
        ImageLoaderUtils.initFresco(getApplicationContext());
        ImageLoaderUtils.initImageLoader(getApplicationContext());
    }

    private void initWelCome() {
        AppHttp.getInstance().getRetrofitApi().getWelCome("getFlashScreen").subscribeOn(Schedulers.newThread()).observeOn(Schedulers.io())
                .subscribe(new Observer<WelComeEntity>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(WelComeEntity welComeEntity) {
                        UserManage.getInstance().saveWelcomeEntity(getApplicationContext(), welComeEntity);
                    }
                });
    }

//    private void initOkHttp() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.put("commonHeaderKey1", "commonHeaderValue1");    //所有的 header 都 不支持 中文
//        headers.put("commonHeaderKey2", "commonHeaderValue2");
//        HttpParams params = new HttpParams();
//        params.put("commonParamsKey1", "commonParamsValue1");     //所有的 params 都 支持 中文
//        params.put("commonParamsKey2", "这里支持中文参数");
//
//        //必须调用初始化
//        OkHttpUtils.init(this);
//        //以下都不是必须的，根据需要自行选择
//        OkHttpUtils.getInstance()//
//                .debug("OkHttpUtils")                                              //是否打开调试
//                .setConnectTimeout(OkHttpUtils.DEFAULT_MILLISECONDS)               //全局的连接超时时间
//                .setReadTimeOut(OkHttpUtils.DEFAULT_MILLISECONDS)                  //全局的读取超时时间
//                .setWriteTimeOut(OkHttpUtils.DEFAULT_MILLISECONDS)                 //全局的写入超时时间
//                //.setCookieStore(new MemoryCookieStore())                           //cookie使用内存缓存（app退出后，cookie消失）
//                //.setCookieStore(new PersistentCookieStore())                       //cookie持久化存储，如果cookie不过期，则一直有效
//                .addCommonHeaders(headers)                                         //设置全局公共头
//                .addCommonParams(params);
//    }
}
