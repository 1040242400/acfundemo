package demo.acfun.com.acfundemo;

import android.content.Context;
import android.graphics.Bitmap;

import demo.acfun.com.acfundemo.utils.LogUtils;

import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.model.HttpHeaders;
import com.lzy.okhttputils.model.HttpParams;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;

/**
 * Created by chen on 16/6/15.
 */
public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.LOG_DEBUG = true;
        initOkHttp();

        initImageLoader(getApplicationContext());
    }

    private static void initImageLoader(Context context) {
        File cacheDir = StorageUtils.getOwnCacheDirectory(context,
                "/sykjqz/cache");// ����·��
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)// �������ص�ͼƬ�Ƿ񻺴����ڴ���
                .cacheOnDisk(true)// �������ص�ͼƬ�Ƿ񻺴���SD����
                .considerExifParams(true) // �Ƿ���JPEGͼ��EXIF��������ת����ת��
                .imageScaleType(ImageScaleType.EXACTLY)// ����ͼƬ����εı��뷽ʽ��ʾ
                .bitmapConfig(Bitmap.Config.RGB_565)// ����ͼƬ�Ľ�������
                .resetViewBeforeLoading(true)// ����ͼƬ������ǰ�Ƿ����ã���λ
                .displayer(new FadeInBitmapDisplayer(100))// �Ƿ�ͼƬ���غú���Ķ���ʱ��
                .build();// �������

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                context)
                .threadPoolSize(3)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new WeakMemoryCache())
                .memoryCacheSize(2 * 1024 * 1024)
                .diskCacheSize(50 * 1024 * 1024)
                .diskCacheFileNameGenerator(new HashCodeFileNameGenerator())
                .tasksProcessingOrder(QueueProcessingType
                        .LIFO)
                .diskCacheFileCount(100)
                .diskCache(new UnlimitedDiskCache(cacheDir))
                .defaultDisplayImageOptions(options)
                .imageDownloader(
                        new BaseImageDownloader(context, 5 * 1000, 30 * 1000))
                .build();
        ImageLoader.getInstance().init(config);

//        options = new DisplayImageOptions.Builder()
//                .showImageOnLoading(R.drawable.icon_stub)
//                // ���ڼ���
//                .showImageForEmptyUri(R.drawable.icon_empty)
//                // ��ͼƬ
//                .showImageOnFail(R.drawable.icon_error)
//                // ����ͼƬ
//                .cacheInMemory(true).cacheOnDisk(true).considerExifParams(true)
//                .bitmapConfig(Bitmap.Config.RGB_565).build();
    }

    private void initOkHttp() {
        HttpHeaders headers = new HttpHeaders();
        headers.put("commonHeaderKey1", "commonHeaderValue1");    //所有的 header 都 不支持 中文
        headers.put("commonHeaderKey2", "commonHeaderValue2");
        HttpParams params = new HttpParams();
        params.put("commonParamsKey1", "commonParamsValue1");     //所有的 params 都 支持 中文
        params.put("commonParamsKey2", "这里支持中文参数");

        //必须调用初始化
        OkHttpUtils.init(this);
        //以下都不是必须的，根据需要自行选择
        OkHttpUtils.getInstance()//
                .debug("OkHttpUtils")                                              //是否打开调试
                .setConnectTimeout(OkHttpUtils.DEFAULT_MILLISECONDS)               //全局的连接超时时间
                .setReadTimeOut(OkHttpUtils.DEFAULT_MILLISECONDS)                  //全局的读取超时时间
                .setWriteTimeOut(OkHttpUtils.DEFAULT_MILLISECONDS)                 //全局的写入超时时间
                //.setCookieStore(new MemoryCookieStore())                           //cookie使用内存缓存（app退出后，cookie消失）
                //.setCookieStore(new PersistentCookieStore())                       //cookie持久化存储，如果cookie不过期，则一直有效
                .addCommonHeaders(headers)                                         //设置全局公共头
                .addCommonParams(params);
    }
}
