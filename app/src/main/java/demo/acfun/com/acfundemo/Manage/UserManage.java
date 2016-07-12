package demo.acfun.com.acfundemo.Manage;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import demo.acfun.com.acfundemo.model.WelComeEntity;
import demo.acfun.com.acfundemo.utils.BitmapUtils;
import demo.acfun.com.acfundemo.utils.SPUtils;

/**
 * Created by chen on 16/7/12.
 */
public class UserManage {
    public static final String WELCOME_ENTITY = "welcome_entity";

    private static UserManage userManage;

    public static UserManage getInstance() {
        if (userManage == null) {
            userManage = new UserManage();
        }
        return userManage;
    }

    public void saveWelcomeEntity(final Context context, final WelComeEntity newWelComeEntity) {

        WelComeEntity oldWelcomeEntity = (WelComeEntity) SPUtils.readObject(context, WELCOME_ENTITY);
        if (oldWelcomeEntity == null || !oldWelcomeEntity.getData().getPic().equals(newWelComeEntity.getData().getPic())) {
            SPUtils.put(context, WELCOME_ENTITY, newWelComeEntity);
            ImageLoader.getInstance().displayImage(newWelComeEntity.getData().getPic(), new ImageView(context),
                    new ImageLoadingListener() {

                        @Override
                        public void onLoadingStarted(String arg0, View arg1) {
                            // TODO Auto-generated method stub

                        }

                        @Override
                        public void onLoadingFailed(String arg0, View arg1,
                                                    FailReason arg2) {
                            // TODO Auto-generated method stub

                        }

                        @Override
                        public void onLoadingComplete(String arg0, View arg1,
                                                      Bitmap arg2) {
                            // TODO Auto-generated method stub
                            newWelComeEntity.getData().setBase64pic(BitmapUtils.bitmapToBase64(arg2));
                            SPUtils.saveObject(context, WELCOME_ENTITY, newWelComeEntity);
                        }

                        @Override
                        public void onLoadingCancelled(String arg0, View arg1) {
                            // TODO Auto-generated method stub

                        }
                    });

        }
    }
}
