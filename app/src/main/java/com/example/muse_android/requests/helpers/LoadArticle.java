package com.example.muse_android.requests.helpers;

import android.os.AsyncTask;
import android.widget.TextView;

import com.example.muse_android.ArticleActivity;
import com.example.muse_android.R;
import com.example.muse_android.objects.Article;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoadArticle extends AsyncTask {
    Article article;
    String id;
    TextView title;
    TextView Content;

    public LoadArticle(String s) {
        id = s;

    }

    @Override
    protected Object doInBackground(Object[] objects) {
        try {
            String temp = "http://www.muse-magazine.com/wp-json/wp/v2/posts/" + id;
            URL urlT = new URL(temp);
            HttpURLConnection httpURLConnectionT = (HttpURLConnection) urlT.openConnection();
            InputStream inputStreamT = httpURLConnectionT.getInputStream();
            BufferedReader bufferedReaderT = new BufferedReader(new InputStreamReader(inputStreamT));
            String line = "";
            String data = "";
            while (line != null) {
                line = bufferedReaderT.readLine();
                data = data + line;
            }
            JSONObject JO = new JSONObject(data);
            String title;
            String image;
            String slug;
            String content;

            title = "" + JO.get("title");
            JSONObject JO2;
            try {
                JO2 = (JSONObject) JO.get("title");
                title = "" + JO2.get("rendered");
            } catch (Exception e) {
                System.out.println(e.toString());
            }
            slug = "" + JO.get("slug");
            JO2 = (JSONObject) JO.get("content");
            content = "" + JO2.get("rendered");
            image = "" + JO.get("jetpack_featured_media_url");
            article = new Article(id, title, content, slug, image);
        } catch (Exception e) {
            System.out.println("HELOOOOOO\nHELLOOO\n" + e.toString());
            article = new Article("", "Error", "", "", "");
        }
        ArticleActivity.a = article;
        System.out.println(article.getTitle());
        return null;
    }

    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        System.out.println("HELLLOOOO\n\n\n\n\n\n");
        ArticleActivity.newArticles.add(ArticleActivity.a);
        ArticleActivity.mAdapter.notifyDataSetChanged();

    }
}
