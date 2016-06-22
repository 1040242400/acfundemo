package demo.acfun.com.acfundemo.network;

import android.content.Context;
import android.support.annotation.Nullable;

import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import demo.acfun.com.acfundemo.entity.TuiJianEntity;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by chen on 16/6/20.
 */
public class AppHttp {

    public interface AppHttpCallBack {
        void returnEntity(Object object, boolean isFromCache, Request request, Response response);
    }


    public static void getMainTuijian(final Context context, final AppHttpCallBack appHttpCallBack) {

        OkHttpUtils.get("http://api.aixifan.com/regions?belong=11&loadCount=-1&channelId=63")//
                .tag(context)//
                .execute(new StringCallback() {
                    @Override
                    public void onResponse(boolean isFromCache, String s, Request request, @Nullable Response response) {
                        List<TuiJianEntity> entitys = new ArrayList<TuiJianEntity>();
                        try {
                            JSONObject jsonObject = new JSONObject(getFileJson(context, "tuijian.json"));


                            JSONArray data = jsonObject.optJSONArray("data");
                            for (int i = 0; i < data.length(); i++) {
                                TuiJianEntity entity = new TuiJianEntity();
                                JSONObject itemObj = data.optJSONObject(i);
                                entity.setName(itemObj.optString("name"));
                                entity.setImage(itemObj.optString("image"));

                                JSONArray contents = itemObj.optJSONArray("contents");
                                List<TuiJianEntity.ContentsBean> contentsBeens = new ArrayList<>();
                                for (int j = 0; j < contents.length(); j++) {
                                    JSONObject itemContents = contents.getJSONObject(j);
                                    TuiJianEntity.ContentsBean contentsBean = new TuiJianEntity.ContentsBean();
                                    contentsBean.setImage(itemContents.optString("image"));
                                    contentsBean.setTitle(itemContents.optString("title"));

                                    TuiJianEntity.VisitBean visitBean = new TuiJianEntity.VisitBean();
                                    JSONObject visit = itemContents.optJSONObject("visit");
                                    if (visit != null) {
                                        visitBean.setViews(visit.optInt("views"));
                                        visitBean.setStows(visit.optInt("stows"));
                                    }
                                    contentsBean.setVisit(visitBean);
                                    contentsBeens.add(contentsBean);
                                }
                                entity.setContents(contentsBeens);

                                TuiJianEntity.TypeBean tb = new TuiJianEntity.TypeBean();
                                JSONObject type = itemObj.optJSONObject("type");
                                tb.setId(type.optInt("id"));
                                tb.setName(type.optString("name"));
                                tb.setValue(type.optString("value"));
                                entity.setType(tb);
                                entitys.add(entity);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        appHttpCallBack.returnEntity(entitys, isFromCache, request, response);
                    }
                });


    }

    public static String getFileJson(Context context, String fileName) {
         /*获取到assets文件下的TExt.json文件的数据，并以输出流形式返回。*/
        InputStream is = context.getClass().getClassLoader().getResourceAsStream("assets/" + fileName);
        InputStreamReader streamReader = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(streamReader);
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            while ((line = reader.readLine()) != null) {
                // stringBuilder.append(line);
                stringBuilder.append(line);
            }
            reader.close();
            reader.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }


}
