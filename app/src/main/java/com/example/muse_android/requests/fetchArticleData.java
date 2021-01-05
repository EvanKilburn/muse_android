package com.example.muse_android.requests;

import android.os.AsyncTask;

import com.example.muse_android.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import com.example.muse_android.objects.Article;

public class fetchArticleData extends AsyncTask{
//    String titleData = "";
//    String imageData = "";
//    String imageURL = "http://www.muse-magazine.com/wp-json/wp/v2/media/";
////    URL url;
//    String page;

//    public fetchArticleData(String page) {
////        url = this.url;
//        this.page = page;
//        doInBackground(null);
//    }

    ArrayList<Article> articles = new ArrayList<>();

    @Override
    protected Object doInBackground(Object[] objects) {
        String titleData = "";
        String imageData = "";
        String imageURL = "http://www.muse-magazine.com/wp-json/wp/v2/media/";
//    URL url;
        try{
            URL urlT = new URL("http://www.muse-magazine.com/wp-json/wp/v2/posts");
            HttpURLConnection httpURLConnectionT = (HttpURLConnection) urlT.openConnection();
            InputStream inputStreamT = httpURLConnectionT.getInputStream();
            BufferedReader bufferedReaderT = new BufferedReader(new InputStreamReader(inputStreamT));
            String line = "";
            while (line != null){
                line = bufferedReaderT.readLine();
                titleData = titleData + line;
            }
            JSONArray JA = new JSONArray(titleData);
            String title;
            String image;
            String id;
            String slug;
            String content;
            //String author;
            //String date;
            for (int i = 0; i < JA.length(); i++){
                JSONObject JO = (JSONObject) JA.get(i);
                title = "" + JO.get("title");
                JSONObject JO2;
                try{
                    JO2 = (JSONObject) JO.get("title");
                    title = "" + JO2.get("rendered");
                } catch (Exception e){}
                id = "" + JO.get("id");
                slug = "" + JO.get("slug");
                JO2 = (JSONObject) JO.get("content");
                content = "" + JO2.get("rendered");
                image = "" + JO.get("jetpack_featured_media_url");
                Article a = new Article(id, title, content, slug, image);
                articles.add(a);
            }

        } catch(MalformedURLException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        } catch(JSONException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        for (int i = 0; i < articles.size(); i++){
            MainActivity.newArticles.add(articles.get(i));
            System.out.println("\n" + articles.get(i).getImage() + "\n");
        }
        MainActivity.mAdapter.notifyDataSetChanged();
    }
}
