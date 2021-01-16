package com.example.muse_android.requests;

import android.os.AsyncTask;

import com.example.muse_android.adapters.CategoryAdapter;
import com.example.muse_android.fragments.CategoryFragment;
import com.example.muse_android.objects.CategoryArticle;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class fetchCategoryData extends AsyncTask {

    ArrayList<CategoryArticle> categoryArticles = new ArrayList<>();
    String categoryName;
    int pageNumber;
    CategoryFragment fragment;
    static String [][] categoryNumbers = {{"Home", "1133"}, {"Arts", "15"}, {"Entertainment", "14"}, {"Lifestyle", "17"},
            {"Fashion", "16"}, {"Music", "1132"}};

    public fetchCategoryData(String categoryName, int pageNumber, CategoryFragment fragment) {
        this.categoryName = categoryName;
        this.pageNumber = pageNumber;
        this.fragment = fragment;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        String id = "";
        String title = "";
        String imageURL = "";
        String author = "";

        try {
            String categoryNumber = "";
            int i = 0;
            while (i < this.categoryNumbers.length && categoryNumber.equals("")) {
                if (this.categoryNumbers[i][0].equals(this.categoryName)) {
                    categoryNumber = this.categoryNumbers[i][1];
                }
                i++;
            }
            URL urlT = new URL("http://www.muse-magazine.com/wp-json/wp/v2/posts?categories=" + categoryNumber + "&page=" + this.pageNumber);
            HttpURLConnection httpURLConnectionT = (HttpURLConnection) urlT.openConnection();
            InputStream inputStreamT = httpURLConnectionT.getInputStream();
            BufferedReader bufferedReaderT = new BufferedReader(new InputStreamReader(inputStreamT));
            String line = "";
            String data = "";
            while (line != null){
                line = bufferedReaderT.readLine();
                data = data + line;
            }
            JSONArray JA = new JSONArray(data);
            for (int j = 0; j < JA.length(); j++) {
                id = "" + ((JSONObject) JA.getJSONObject(j)).get("id");
                title = (android.text.Html.fromHtml("" + (((JSONObject) ((JSONObject) JA.getJSONObject(j)).get("title")).get("rendered"))).toString()).toUpperCase();
                imageURL = "" + ((JSONObject) JA.getJSONObject(j)).get("jetpack_featured_media_url");
                CategoryArticle a = new CategoryArticle(id, title, imageURL, author, this.categoryName);
                categoryArticles.add(a);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);

        if (this.pageNumber != 1) {

            for (int i = 0; i < categoryArticles.size(); i++) {
                fragment.articles.add(categoryArticles.get(i));
            }
            fragment.adapter.notifyDataSetChanged();
            fragment.canScroll = true;

        } else {

            fragment.carouselArticles.clear();
            for (int i = 0; i < categoryArticles.size(); i++) {
                fragment.carouselArticles.add(categoryArticles.get(i));
            }
            ((CategoryAdapter) fragment.adapter).viewHolderCarousel.getCarouselAdapter().notifyDataSetChanged();

        }
    }
}
