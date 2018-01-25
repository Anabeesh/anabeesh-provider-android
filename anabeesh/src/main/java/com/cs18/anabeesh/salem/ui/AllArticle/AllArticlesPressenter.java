package com.cs18.anabeesh.salem.ui.AllArticle;

import com.cs18.anabeesh.R;
import com.cs18.anabeesh.beshary.store.AuthRepo;
import com.cs18.anabeesh.salem.Retrofit.RetrofitClint;
import com.cs18.anabeesh.salem.Retrofit.UserService;
import com.cs18.anabeesh.salem.model.GetArticales;

import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 TODO: Add class header
 */

public class AllArticlesPressenter {
    private final AllArticlesScreen allArticlesScreen;
private final AuthRepo authRepo;
    public AllArticlesPressenter(AllArticlesScreen allArticlesScreen, AuthRepo authRepo) {this.allArticlesScreen = allArticlesScreen;
        this.authRepo = authRepo;
    }

    public void createUI() {
        allArticlesScreen.setUpToolbar();
        fetchAllArticles();
    }

    private void fetchAllArticles() {
        //Static Data
        /*st<GetArticales> fakeList = new ArrayList<>();
        fakeList.add(new GetArticales(
                "توجد الأرض في مجموعة كواكب المجموعة الشمسية، والمجموعة الشمسية نفسها واحدة من ضمن مئات المليارات من النجوم التي تشكل مجرة درب التبانة أو درب اللبانة. المنطقة التي تميز كوكب الأرض حول الشمس عن غيرها هي منطقة تعرف بأنها نطاق صالح للسكن، بمعنى أن بـُعد الأرض عن الشمس الذي يبلغ نحو 150 مليون كيلومتر ومدار الأرض حول الشمس في فلك دائري يجعل عليها درجات حرارة مناسبة ليست بالمرتفعة كثيرا وليست باردة جدا بحيث تلائم نشأة حياة واستمرارها عليها. بالإضافة إلى ذلك حجم مناسب للأرض يجعلها تحتفظ بغلافها الجوي ووجود الماء عليها، ووجود غاز الأوزون في جو الأرض الذي يحمي الأحياء عليها من الأشعة فوق البنفسجية الضارة، علاوة على مجالها المغناطيسي الذي يحميها من الجسيمات الأولية السريعة التي تأتي مع الرياح الشمسية فتهدد سلامة الأحياء على الأرض للمزيد  زوروا https://ar.wikipedia.org/wiki/%D8%A7%D9%84%D8%A3%D8%B1%D8%B6",
                "كوكب الارض", "عمر سالم", R.drawable.greenland));
        fakeList.add(new GetArticales(
                "توجد الأرض في مجموعة كواكب المجموعة الشمسية، والمجموعة الشمسية نفسها واحدة من ضمن مئات المليارات من النجوم التي تشكل مجرة درب التبانة أو درب اللبانة. المنطقة التي تميز كوكب الأرض حول الشمس عن غيرها هي منطقة تعرف بأنها نطاق صالح للسكن، بمعنى أن بـُعد الأرض عن الشمس الذي يبلغ نحو 150 مليون كيلومتر ومدار الأرض حول الشمس في فلك دائري يجعل عليها درجات حرارة مناسبة ليست بالمرتفعة كثيرا وليست باردة جدا بحيث تلائم نشأة حياة واستمرارها عليها. بالإضافة إلى ذلك حجم مناسب للأرض يجعلها تحتفظ بغلافها الجوي ووجود الماء عليها، ووجود غاز الأوزون في جو الأرض الذي يحمي الأحياء عليها من الأشعة فوق البنفسجية الضارة، علاوة على مجالها المغناطيسي الذي يحميها من الجسيمات الأولية السريعة التي تأتي مع الرياح الشمسية فتهدد سلامة الأحياء على الأرض للمزيد زوروا https://ar.wikipedia.org/wiki/%D8%A7%D9%84%D8%A3%D8%B1%D8%B6  ",
                "كوكب الارض ", "عمر سالم", R.drawable.greenland));*/
        String Userid = authRepo.getCurrentUser().getUserId();
        String Page = "1";
        String PageSize = "50";
        RetrofitClint.getInstance()
                .create(UserService.class)
                .getArticles(Userid, Page, PageSize)
                .enqueue(new Callback<List<GetArticales>>() {
                    @Override
                    public void onResponse(Call<List<GetArticales>> call, Response<List<GetArticales>> response) {

                        if (response.code() == 200) {
                            List<GetArticales> articalesList = response.body();
                            allArticlesScreen.setupRecyclerview(articalesList);
                            allArticlesScreen.ShowMassage("تم");
                        } else {
                            allArticlesScreen.ShowMassage("خطأ");
                        }
                    }

                    @Override
                    public void onFailure(Call<List<GetArticales>> call, Throwable t) {
                        allArticlesScreen.ShowMassage("خطأ في الشبكه");

                        if (t instanceof SocketTimeoutException) {
                            allArticlesScreen.ShowMassage(" تحققك من اتصال الشبكه");
                        }
                    }
                });
    }
}
